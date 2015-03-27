package maptraverser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

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

		queue.push(rootNode);

		while (queue.size() > 0) {
			Node tmp = queue.pop();

			for (Node n : tmp.getConnectedNodes()) {
				if (!n.isExpanded()) {
					n.setExpanded(true);
					n.setExpandedBy(tmp);

					if (n.equals(targetNode)) {
						return MapTools.getReturnPath(rootNode, n);

					} else {
						queue.push(n);
					}
					
				} //End if node is not expanded
				
			} //End For Loop
		} //End While Loop

		return ""; //Fall-back return

	} //End public static String breadthFirstSearch(HashMap<String, Node>)

	public static String uniformCostSearch(HashMap<String, Node> map) {
		Node rootNode = map.get("Arad");
		Node targetNode = map.get("Bucharest");
		
		TreeSet<Action> frontier = new TreeSet<>();
		HashSet<Node> exploredNodes = new HashSet<>();
				
		Node selectedNode = rootNode;
		
		while (frontier.size() > 0) {
			for(Node n : selectedNode.getConnectedNodes()) {
				frontier.add(new Action(selectedNode, n));
			}
			
			Action a = frontier.pollFirst();
			
			
		}

		return "";

	} //End public static String uniformCostSearch(HashMap<String, Node>)
} //End public class Searches
