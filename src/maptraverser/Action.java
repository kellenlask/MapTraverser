package maptraverser;

/**
 *
 * @author Kellen
 */
public class Action implements Comparable<Action> {
	//Fields
	protected Node a;
	protected Node b;
	protected int weight;
	
	
	//Constructors
	public Action(Node one, Node two) {
		a = one;
		b = two;
		weight = one.getConnectionWeight(two);
	}
	
	//Accessors
	public Node getA() {
		return a;
	}

	public Node getB() {
		return b;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public int compareTo(Action o) {
		return weight - o.getWeight();		
	}	

	//Mutators
	public void setA(Node a) {
		this.a = a;
	}

	public void setB(Node b) {
		this.b = b;
	}	
}
