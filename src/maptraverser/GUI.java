package maptraverser;

import java.util.HashMap;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Kellen
 */
public class GUI extends Application {
    //Fields
	private final HashMap<String, Node> map;
	private ComboBox<String> searchBox;
	private Text results;
	private Button runButton;
	
	//Constructor
	public GUI(HashMap<String, Node> map, String[] args) {
	    this.map = map;

	    launch(args);
	}
	
	//Start
	@Override
	public void start(Stage stage) {
		stage.setTitle("Node Traverser");
        stage.setScene(buildGUI());
        stage.show();
	
	} 
	
	public void addBoxListener() {
	    runButton.setOnAction((ActionEvent event) -> {
			/*switch(searchBox.getSelectedIndex()) {
				case 0:
					results.setText(SearchTools.breadthFirstSearch(map));
					break;
					
				case 1:
					results.setText(SearchTools.breadthFirstSearch(map));
					break;
					
				default:
					results.setText("Ya done broke it!");
					break;
					
			} //End Switch		*/
		});	
	}
	
	
	public Scene buildGUI() {
	    runButton = new Button("Run");
		
	    searchBox = new ComboBox<>();
	    searchBox.getItems().addAll("Breadth-First Search", "Zero-Cost Search");

	    addBoxListener();

	    GridPane grid = new GridPane();
	    grid.setVgap(4);
	    grid.setHgap(10);
	    grid.add(new Text("Select a search method:"), 0, 0);
	    grid.add(searchBox, 1, 0);
	    grid.add(runButton, 1, 1);
	    grid.add(results, 3, 0);

	    Scene scene = new Scene(grid, 450, 250);
		
	    return scene;
	    
	} //End public Scene buildGUI()      
} //End public class GUI extends Application