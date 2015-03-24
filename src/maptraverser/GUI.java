package maptraverser;

import java.util.HashMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Kellen
 */
public class GUI {

	//Fields

	private final HashMap<String, Node> map;
	private ComboBox<String> searchBox;
	private Text results;
	private Button runButton;

	//Constructor
	public GUI(HashMap<String, Node> map, Stage primaryStage) {
		this.map = map;
		primaryStage.setTitle("Map Traverser");
		primaryStage.setScene(buildGUI());
		primaryStage.show();

	} //End Constructor

	public void addRunButtonListener() {
		runButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				String selectedItem = "";
				selectedItem += searchBox.getSelectionModel().getSelectedItem(); //Get the selected Search Algorithm from the selectionBox

				switch (selectedItem) {
					case "Breadth-First Search":
						results.setText(Searches.breadthFirstSearch(map));
						break;

					case "A* Search":
						results.setText(Searches.aStar(map));
						break;

					default:
						results.setText("Please select a search algorithm.");
						break;

				} //End Switch		
			} //End public void handle(ActionEvent)
		});	//End setOnAction(...
	} //End public void addRunButtonListener()

	public Scene buildGUI() {
		runButton = new Button("Run");
		results = new Text();
		searchBox = new ComboBox<>();
		searchBox.getItems().addAll("Breadth-First Search", "A* Search");

		Image img = new Image("https://t2thompson.files.wordpress.com/2014/09/romania-graph1.png");
		ImageView imgView = new ImageView(img);
		imgView.setImage(img);
		imgView.setFitWidth(800);
		imgView.setPreserveRatio(true);

		addRunButtonListener();

		GridPane grid = new GridPane();
		grid.setVgap(4);
		grid.setHgap(10);
		grid.add(new Text("Select a search method:"), 0, 0);
		grid.add(searchBox, 1, 0);
		grid.add(runButton, 2, 0);
		grid.add(results, 0, 1, 3, 1);
		grid.add(imgView, 0, 2, 3, 1);

		Scene scene = new Scene(grid, 800, 550);

		return scene;

	} //End public Scene buildGUI()      
} //End public class GUI extends Application
