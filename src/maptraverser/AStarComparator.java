package maptraverser;

import java.util.Comparator;

/**
 *
 * @author Kellen
 */
public class AStarComparator implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
		return o1.getHeuristicWeight() - o2.getHeuristicWeight();	
		
	}
	
}
