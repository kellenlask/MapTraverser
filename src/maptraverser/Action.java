package maptraverser;

import java.util.ArrayList;

/**
 *
 * @author Kellen
 */
public class Action implements Comparable<Action> {
	//Fields
	ArrayList<Node> nodes;
	protected int weight;
	
	
	//Constructors
	public Action(Node n) {
		nodes = new ArrayList<>();
		weight = 0;
		nodes.add(n);
	}
	
	public Action(Action a, Node n) {
		nodes = new ArrayList<>();
		ArrayList<Node> nodeList = a.getNodes();
		Node lastNode = nodeList.get(nodeList.size() - 1);
		weight = a.getWeight() + lastNode.getConnectionWeight(n);
		nodes.addAll(nodeList);
		nodes.add(n);
	}
	
	//Accessors
	public String toString() {
		String outputString = "";
		
		outputString += nodes.get(0).toString();
		
		for(int i = 1; i < nodes.size(); i++) {
			outputString += " -> " + nodes.get(i).toString();
		}
		
		return outputString + " Total Weight: " + weight;
	}
	
	public ArrayList<Node> getNodes() {
		return nodes;
	} 

	public int getWeight() {
		return weight;
	}

	@Override
	public int compareTo(Action o) {
		return weight - o.getWeight();		
	}		
}
