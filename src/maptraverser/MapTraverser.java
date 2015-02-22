package maptraverser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Kellen
 */
public class MapTraverser {

	public static void main(String[] args) {
		JFileChooser fileChooser = new JFileChooser();
		int returnValue = fileChooser.showOpenDialog(null);
		
		File selectedFile = null;
		
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			selectedFile = fileChooser.getSelectedFile();
		}
		
		try {
			String[][] csvContents = parseCSV(selectedFile);
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "FileNotFoundException encountered while parsing .csv file.");
		}
		
		
	} //End main
	
        //A, B, Weight, Heurisic Weight from Bucharist
        public static ArrayList<Node> dataToMap(String[][] data) {
            ArrayList<Node> map = new ArrayList<>();

            //Place all the nodes into the ArrayList with their heuristic weights
            for(int i = 0; i < data[0].length; i++) {
                    if( !map.contains(data[0][i]) ) {
                            map.add(new Node(data[0][i], data[3][i]));

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
        
	public static String[][] parseCSV(File csvFile) throws FileNotFoundException {
	//Setup the Scanners with the .csv file
		Scanner csvScanner = new Scanner(csvFile);
		Scanner columnReader;
		
	//Find the number of collumns per entry in the .csv file
		int columnCount = 0;	
		if(csvScanner.hasNextLine()) {
			columnReader = new Scanner(csvScanner.nextLine());
			columnReader.useDelimiter(",");
			
			while(columnReader.hasNext()) {
				columnReader.next();
				columnCount++;
			}
			
		} else {
			throw new FileNotFoundException(); //Un-usable .csv file
		}
		
	//Find the number of rows in the .csv file	
		int lineCount = 1;
		while(csvScanner.hasNextLine()) {
			lineCount++;
			csvScanner.nextLine();			
		}
		
		csvScanner.reset();
		
	//Make our 2-D array
		String[][] resArray = new String[columnCount][lineCount];
		
	//Populate our 2-D array
		lineCount = 0;
		columnCount = 0;
		while(csvScanner.hasNextLine()) {
			columnReader = new Scanner(csvScanner.nextLine());
			columnReader.useDelimiter(",");
			
			while(columnReader.hasNext()) {
				resArray[columnCount][lineCount] = columnReader.next();
				
				columnCount++;				
			}
			
			columnCount = 0;
			lineCount++;
			
		}
		
		return resArray;
	} //End public static String[][] parseCSV(File)
	
	
	
} //End public class MapTraverser
