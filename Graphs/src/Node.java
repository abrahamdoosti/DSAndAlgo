import java.util.ArrayList;
import java.util.List;

public class Node {
	private int id;
	private boolean visited;

	public Node(int id) {
		super();
		this.id=id;
	}

	List<Node> neighbours = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<Node> getNeighbours() {
		return this.neighbours;
	}

	public void setNeighbours(List<Node> neighbours) {
		this.neighbours = neighbours;
	}

	public void addNeighbour(Node node) {
		this.getNeighbours().add(node);
	}


}
