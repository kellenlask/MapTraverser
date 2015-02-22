package maptraverser;

import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

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
            for(int i = 0; i < data[0].length; i++) {
                    if( !map.containsKey(data[0][i]) ) {
                            map.put(data[0][i], new Node(data[0][i], data[3][i]));
                    }	
            }	

            //Per entry, add the connection and its weight. This only works if each connection is mapped both ways (the .csv is as such)
            for(int i = 0; i < data[0].length; i++) {
                    if( !map.get(data[0][i]).isConnectedNode(map.get(data[1][i])) ) {
                            map.get(data[0][i]).addConnectedNode(map.get(data[1][i]), data[2][i]);
                    }
            }

            return map;
	
        } //End public static ArrayList<Node> dataToMap(String[][])
	
	
	
}
