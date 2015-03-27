package maptraverser;

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
			try {				

				new GUI(primaryStage); //Start the search GUI

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Something unexpected occured: " + ex.getMessage());
				ex.printStackTrace();
				System.exit(0);
			}
		
	} //End public void start(Stage)
} //End public class MapTraverser