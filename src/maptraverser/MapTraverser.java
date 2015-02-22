package maptraverser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Kellen
 */
public class MapTraverser {

	public static void main(String[] args) {
		File selectedFile = getCSVFile();
		
		try {
			String[][] csvContents = MapTools.parseCSV(selectedFile);
			
			HashMap<String, Node> map = MapTools.dataToMap(csvContents);
			new GUI(map, args);
			
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "FileNotFoundException encountered while parsing .csv file.");
		}		
				
	} //End main
	
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