package maptraverser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Kellen
 */
public class Searches {
	public static String breadthFirstSearch(HashMap<String, Node> map) {
		LinkedList<Node> queue = new LinkedList<>();
		ArrayList<Node> solution = new ArrayList<>();
		
		Node rootNode = map.get("Arad");
		Node targetNode = map.get("Bucharest");
		
		rootNode.setExpanded(true);
		queue.push(rootNode);	
		
		while(queue.size() > 0) {
			Node tmp = queue.pop();
			
			if(tmp.equals(targetNode)) {
				

			} else {
				for(Node n : tmp.getConnectedNodes()) {
					if(!n.isExpanded()) {
						n.setExpanded(true);
						n.setExpandedBy(tmp);
						queue.push(n);
					}
				}
			}			
		} //End While Loop
		
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