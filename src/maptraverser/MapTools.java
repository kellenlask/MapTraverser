package maptraverser;

import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import javax.swing.JFileChooser;

/**
 *
 * @author Kellen
 */
public class MapTools {
	
	//This method parses the .csv file
	public static String[][] parseCSV(File csvFile) throws IOException {
		CSVReader csvReader = new CSVReader(new FileReader(csvFile));
		List<String[]> list = csvReader.readAll();

		// Convert to 2D array
		String[][] resArray = new String[list.size()][];
		resArray = list.toArray(resArray);
		
		return resArray;
	} //End public static String[][] parseCSV(File)
	
	
	//This method converts the String[][] from the parser into a HashMap<String, Node>
	//A, B, Weight, Heurisic Weight from Bucharist
	public static HashMap<String, Node> dataToMap(String[][] data) {
		HashMap<String, Node> map = new HashMap<>();

		//Place all the nodes into the Map with their heuristic weights
		for(String[] sa : data) {
			if(!map.containsKey(sa[0])) {
				System.out.println("");
				map.put(sa[0], new Node(sa[0], sa[3]));
			}                
		}

		//Per entry, add the connection and its weight. This only works if each connection is mapped both ways (the .csv is as such)
		for(String[] sa : data) {
			if( !map.get(sa[0]).isConnectedNode(map.get(sa[1])) ) {
				map.get(sa[0]).addConnectedNode(map.get(sa[1]), sa[2]);
			}
		}

		return map;

	} //End public static ArrayList<Node> dataToMap(String[][])
	
		
	//Get a CSV file from the user
	public static File getCSVFile() {
		JFileChooser fileChooser = new JFileChooser();
		int returnValue = fileChooser.showOpenDialog(null);
		
		File selectedFile = null;
		
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			selectedFile = fileChooser.getSelectedFile();
		} else {
			return null;
		}
		
		return selectedFile;
	}
	
	public static String getReturnPath(Node start, Node end) {
		String solution = "";
		int totalCost = 0;
		Node parent = end;
		
		do {
			solution =  "  ->  " + parent.getName() + solution;
			totalCost += parent.getConnectionWeight(parent.getExpandedBy());
			
			parent = parent.getExpandedBy();
			
		} while(!parent.equals(start)); 			
		
		solution = start.getName() + solution + " Total Cost: " + totalCost;
		
		return solution;
	}
	
}
