package maptraverser;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Kellen
 */
public class Node implements Cloneable {
//------------------------------------------------------------------------------
//
//		Fields
//
//------------------------------------------------------------------------------

	private String name;
	private HashMap<Node, Integer> connectedNodes;
	private int heuristicWeight;
	private boolean expanded;
	protected Node expandedBy;

//------------------------------------------------------------------------------
//
//		Constructors
//
//------------------------------------------------------------------------------
	public Node() {
	}
	
	public Node(String name) {
		this.name = name;
		connectedNodes = new HashMap<>();

	} //End public Node(String)

	public Node(String name, int heuristicWeight) {
		this.name = name;
		this.heuristicWeight = heuristicWeight;
		connectedNodes = new HashMap<>();

	} //End public Node(String, int)

	public Node(String name, String heuristic) {
		try {
			heuristicWeight = Integer.parseInt(heuristic);
		} catch (Exception e) {

		}

		connectedNodes = new HashMap<>();
		this.name = name;
	}
	
//------------------------------------------------------------------------------
//
//		Accessors
//
//------------------------------------------------------------------------------
	public Node getExpandedBy() {
		return expandedBy;
	}

	public String getName() {
		return name;

	} //End public String getName()

	public boolean isExpanded() {
		return expanded;
	}

	public boolean equals(Node n) {
		return n.getName().equals(name);

	} //End public boolean equals(Node)

	public Set<Node> getConnectedNodes() {
		return connectedNodes.keySet();

	} //End public Node[] getConnectedNodes()

	public boolean isConnectedNode(Node n) {
		return connectedNodes.containsKey(n);

	} //End public boolean isConnectedNode(Node)

	public int getHeuristicWeight() {
		return heuristicWeight;

	} //End public int getHeuristicWeight(Node)

	public int getConnectionWeight(Node n) {
		return connectedNodes.get(n);

	} //End public int getConnectionWeight(Node)

	public int getCombined(Node n) {
		return connectedNodes.get(n) + n.getHeuristicWeight();
	}
	
	public String toString() {
		return getName();
	}
	
//------------------------------------------------------------------------------
//
//		Mutators
//
//------------------------------------------------------------------------------
	public void setName(String name) {
		this.name = name;

	} //End public void setName(String)

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	public void setHeuristicWeight(int heuristicWeight) {
		this.heuristicWeight = heuristicWeight;
	}

	public void addConnectedNode(Node n, int connectWeight) {
		connectedNodes.put(n, connectWeight);

		if (!n.isConnectedNode(this)) {
			n.addConnectedNode(this, connectWeight);
		}

	} //End public void addConnectedNode(Node)

	public void addConnectedNode(Node n, String connectedWeight) {
		try {
			connectedNodes.put(n, Integer.parseInt(connectedWeight));

		} catch (Exception e) {
			e.printStackTrace();
		}

	} //End public void addConnectedNode(Node	

	public void setExpandedBy(Node n) {
		expanded = true;
		expandedBy = n;
	} //End public void setExpandedBy(Node)
	
} //End public class Node
