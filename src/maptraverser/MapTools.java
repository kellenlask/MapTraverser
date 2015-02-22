package maptraverser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Kellen
 */
public class MapTools {
	
	
	
	//This method parses the .csv file
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
