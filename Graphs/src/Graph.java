import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	List<Node> visitedNodes=new ArrayList<Node>();
    Queue<Node> queue;
    Stack<Node> stack;

	public Graph() {
		this.queue = new LinkedList<Node>();
		this.stack=new Stack<Node>();
	}
	
	public void breadthFirstSearch(Node node) {
		queue.add(node);
		while (!queue.isEmpty()) {
			Node n = queue.remove();
			System.out.print(n.getId() + " ");
			if (n.getNeighbours() != null && !n.getNeighbours().isEmpty()) {
				for (Node child : n.getNeighbours()) {
					if (!visitedNodes.contains(child)) {
						queue.add(child);
						visitedNodes.add(child);
					}
				}
			}

		}
		visitedNodes.clear();

	}
	public void depthFirstSearch(Node node) {
		stack.push(node);
		while(!stack.isEmpty()) {
			Node n=stack.pop();
			System.out.print(n.getId()+" ");
			if(n.getNeighbours() != null && !n.getNeighbours().isEmpty()) {
				for(Node child : n.getNeighbours()) {
					if (!child.isVisited()) {
						stack.push(child);
						child.setVisited(true);
					}
					
				}
			}
		}
		
	}
	
	public void breadthFirstSearchWithLevel(Node node) {
		List<Node> parentList=new ArrayList<Node>();
		
		queue.add(node);
		while (!queue.isEmpty()) {
			Node n = queue.remove();
			System.out.print(n.getId() + " ");
			if (n.getNeighbours() != null && !n.getNeighbours().isEmpty()) {
				if(!parentList.contains(n)) {
				    parentList=n.getNeighbours();
				}
				for (Node child : n.getNeighbours()) {
					if (!visitedNodes.contains(child)) {
						queue.add(child);
						visitedNodes.add(child);
					}
				}
			}

		}
		visitedNodes.clear();

	}

}




 

