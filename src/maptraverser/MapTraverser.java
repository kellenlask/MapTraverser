package maptraverser;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import javax.swing.JFileChooser;

/**
 *
 * @author Kellen
 */
public class MapTraverser extends Application {

	public static void main(String[] args) {
		launch(args);
				
	} //End main
	
	@Override
	public void start(Stage primaryStage) {
		File selectedFile = getCSVFile(); //Get the CSV file from the user
		
		try {
			String[][] csvContents = MapTools.parseCSV(selectedFile); //Read the CSV file
			
			for(String[] sA : csvContents) {
				for(String s : sA) {
				
					System.out.print(s);
				}
				
				System.out.println();
			
			}
			
			HashMap<String, Node> map = MapTools.dataToMap(csvContents); //Convert the CSV contents into a Node Map		
			
			//new GUI(map, primaryStage);
			
		} catch (IOException ex) {
			//JOptionPane.showMessageDialog(null, "FileNotFoundException encountered while parsing .csv file.");
			ex.printStackTrace();
		}/* catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Something unexpected occured: " + ex.getMessage());			
		}*/
	}
	
	//Get a CSV file from the user
	public static File getCSVFile() {
		JFileChooser fileChooser = new JFileChooser();
		int returnValue = fileChooser.showOpenDialog(null);
		
		File selectedFile = null;
		
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			selectedFile = fileChooser.getSelectedFile();
		}
		
		return selectedFile;
	}
		
} //End public class MapTraverser