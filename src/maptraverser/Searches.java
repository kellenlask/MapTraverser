package maptraverser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 *
 * @author Kellen
 */
public class Searches {
//------------------------------------------------------------------------------
//
//		Breadth-First
//
//------------------------------------------------------------------------------
	public static String breadthFirstSearch(HashMap<String, Node> map) {
		LinkedList<Node> queue = new LinkedList<>();

		Node rootNode = map.get("Arad");
		Node targetNode = map.get("Bucharest");

		TreeSet<Action> actions = new TreeSet<>();
		
		actions.add(new Action(rootNode));
		while(actions.size() > 0) {
			Action a = actions.pollFirst();
			ArrayList<Node> nodeList = a.getNodes();
			
			if(nodeList.get(nodeList.size() - 1).equals(targetNode)) {
				return a.toString();
			}
			
			for(Node n : nodeList.get(nodeList.size() - 1).getConnectedNodes()) {
				actions.add(new Action(a, n));
			}
			
		}
		
		return "";
		

	} //End public static String breadthFirstSearch(HashMap<String, Node>)

//------------------------------------------------------------------------------
//
//		Uniform Cost
//
//------------------------------------------------------------------------------	
	
	public static String uniformCostSearch(HashMap<String, Node> map) {
		Node rootNode = map.get("Arad");
		Node targetNode = map.get("Bucharest");
		
		LinkedList<Node> list = new LinkedList<>();
		rootNode.setExpanded(true);
		list.push(rootNode);
		
		while (!targetNode.isExpanded()) {
			Node tmp = list.pop();
			
			for(Node n : tmp.getConnectedNodes()) {
				if(!n.isExpanded()) {
					n.setExpandedBy(tmp);
					list.addLast(n);
				} 
			} //End For Loop			
		} //End While Loop

		return MapTools.getReturnPath(rootNode, targetNode);

	} //End public static String uniformCostSearch(HashMap<String, Node>)
} //End public class Searches
