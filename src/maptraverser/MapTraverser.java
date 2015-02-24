package maptraverser;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Kellen
 */
public class MapTraverser extends Application {

	public static void main(String[] args) {
		//Launch() creates an application instance 
		//which comes back around to running: public void start(Stage)
		launch(args);  
				
	} //End main
	
	
	@Override
	public void start(Stage primaryStage) {
		File selectedFile = MapTools.getCSVFile(); //Get the CSV file from the user
		
		if(selectedFile != null) {
		
			try {
				String[][] csvContents = MapTools.parseCSV(selectedFile); //Read the CSV file

				HashMap<String, Node> map = MapTools.dataToMap(csvContents); //Convert the CSV contents into a Node Map		

				new GUI(map, primaryStage); //Start the search GUI

			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Check the .csv file.");
				ex.printStackTrace();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Something unexpected occured: " + ex.getMessage());
				ex.printStackTrace();
			}
		} else {
			System.exit(0);
		}
	} //End public void start(Stage)
} //End public class MapTraverser