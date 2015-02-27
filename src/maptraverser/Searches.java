package maptraverser;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Kellen
 */
public class Searches {
	public static String breadthFirstSearch(HashMap<String, Node> map) {
		Node rootNode = map.get("Arad");
		Node targetNode = map.get("Bucharest");
		LinkedList<Node> queue = new LinkedList<>();
		
		rootNode.setExpanded(true);
		queue.push(rootNode);
		
		while(queue.size() > 0) {
			
		}
		
		return "";
		
	} //End public static String breadthFirstSearch(HashMap<String, Node>)
	
	
	public static String aStar(HashMap<String, Node> map) {
		Node rootNode = map.get("Arad");
		Node targetNode = map.get("Bucharest");
		
		
		while(targetNode.isExpanded() == false) {
			
		}
		
		return "";
		
	} //End public static String aStar(HashMap<String, Node>)
} //End public class Searches
