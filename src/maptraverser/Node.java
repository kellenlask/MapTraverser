package maptraverser;

import java.util.ArrayList;

/**
 *
 * @author Kellen
 */
public class Node {
//Fields
	private String name;
	private ArrayList<Node> connectedNodes;
	private ArrayList<Integer> connectionWeights;
	private int heuristicWeight;
	
//Constructors
	public Node(String name) {
            this.name = name;
		
	} //End public Node(String)
	
	public Node(String name, int heuristicWeight) {
		this.name = name;
		this.heuristicWeight = heuristicWeight;
		
	} //End public Node(String, int)
        
        public Node(String name, String heuristic) {
            try {
                heuristicWeight = Integer.parseInt(heuristic);
            } catch(Exception e) {
            
            }
            
            this.name = name;
        }

//Accessors
	public String getName() {
		return name;
		
	} //End public String getName()

	public boolean equals(Node n) {
		return n.getName().equals(name);		
		
	} //End public boolean equals(Node)
	
	public Node[] getConnectedNodes() {
		return (Node[]) connectedNodes.toArray();
	
	} //End public Node[] getConnectedNodes()
	
	public boolean isConnectedNode(Node n) {
		return connectedNodes.stream().anyMatch((node) -> (node.equals(n)));
		
	} //End public boolean isConnectedNode(Node)
	
	public int getHeuristicWeight() throws NoSuchFieldException {
		return heuristicWeight;		
		
	} //End public int getHeuristicWeight(Node)
	
	public int getConnectionWeight(Node n) {
            for(int i = 0; i < connectedNodes.size(); i++) {
                if(connectedNodes.get(i).equals(n)) {
                        return connectionWeights.get(i);
                }
            }
	
            return -1;
            
	} //End public int getConnectionWeight(Node)
	
//Mutators
    public void setName(String name) {
            this.name = name;

    } //End public void setName(String)

    public void setHeuristicWeight(int heuristicWeight) {
        this.heuristicWeight = heuristicWeight;
    }        

    public void addConnectedNode(Node n, int connectWeight) {
            connectedNodes.add(n);
            connectionWeights.add(connectWeight);	

            if(!n.isConnectedNode(this)) {
                    n.addConnectedNode(this, connectWeight);
            }

    } //End public void addConnectedNode(Node)

    public void addConnectedNode(Node n, String connectedWeight) {
        try {
            int connectWeight = Integer.parseInt(connectedWeight);

            connectedNodes.add(n);
            connectionWeights.add(connectWeight);	

            if(!n.isConnectedNode(this)) {
                    n.addConnectedNode(this, connectWeight);
            }

        } catch (Exception e) {
            System.out.println("Whoops: " + e);
        }

    } //End public void addConnectedNode(Node
	
} //End public class Node
