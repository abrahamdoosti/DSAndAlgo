package com.example.datastructure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * This is BFS search for finding shortest path from root node to every other
 * node, in unweighed directional graph. YT video used for algorithm:
 * <link>https://www.youtube.com/watch?v=T_m27bhVQQQ&list=PLYFmlGZvcY1-kICI4GFY7uBOBDQaeVtHF&index=5</link>
 * 
 * @author abrah
 *
 */

public class BFSShortestPath {

	// Tracks the shortest path from the root Node to a certain node.
	private static Map<Node, ShortestPath> shortestPathMap = new HashMap<>();
	private static Queue<Node> nodesQueue = new LinkedList<>();
	private static Queue<Integer> costQueue = new LinkedList<>();
	private static List<Node> visitedNodes = new ArrayList<>();

	public static void main(String[] args) {
		List<Node> nodesList = new ArrayList<>();
		// First, generate graph.
		Node node40 = new Node(40);
		Node node10 = new Node(10);
		Node node20 = new Node(20);
		Node node30 = new Node(30);
		Node node60 = new Node(60);
		Node node50 = new Node(50);
		Node node70 = new Node(70);
		Node node80 = new Node(80);
		Node node90 = new Node(90);
		Node node100 = new Node(100);

		nodesList.addAll(Arrays.asList(node10, node20, node30, node60, node50, node70,node80,node90,node100));

		// Put entries for tracking shortest path for each node, except for root node.
		for (Node node : nodesList) {
			shortestPathMap.put(node, null);
		}

		node40.setNeighbours(Arrays.asList(node20, node10));
		node20.setNeighbours(Arrays.asList(node60, node50, node30, node10));
		node10.setNeighbours(Arrays.asList(node30,node100));
		node60.setNeighbours(Arrays.asList(node70));
		node50.setNeighbours(Arrays.asList(node70));
		node30.setNeighbours(Arrays.asList(node50,node80));
		node80.setNeighbours(Arrays.asList(node90));
		node100.setNeighbours(Arrays.asList(node90));

		doBFSSearch(node40);
		for (Node node : nodesList) {
			reconstructPathToRoot(node, node40);
		}

	}

	/**
	 * BFS guarantees that all nodes on the same level will be visited before any node at a deeper level gets visited.
	 * While BFSing a graph ,the first path we get from the root node to a target node is the shortest.
	 * @param root
	 */
	public static void doBFSSearch(Node root) {
		// track both vertices and cost to root node simultaneously.
		nodesQueue.add(root);
		costQueue.add(0);

		while (!nodesQueue.isEmpty()) {
			Node n = nodesQueue.remove();
			Integer parentCost = costQueue.remove();
			if (!visitedNodes.contains(n) && n.getNeighbours() != null && !n.getNeighbours().isEmpty()) {
				for (Node child : n.getNeighbours()) {
					System.out.println("Edge From: " + n.getId() + " To: " + child.getId());
					nodesQueue.add(child);
					costQueue.add(parentCost + 1);
					if (null == shortestPathMap.get(child)) {
						shortestPathMap.put(child, new ShortestPath(n, parentCost + 1));
					}
				}
				visitedNodes.add(n);
				System.out.println();
			}
		}
		visitedNodes.clear();

		// Print the shortest paths through nearest vertex.
		shortestPathMap.entrySet().stream()
				.forEach(entry -> System.out.println(entry.getKey().toString() + "---" + entry.getValue().toString()));

	}

	public static void reconstructPathToRoot(Node node, Node root) {
		Deque<Node> stack = new LinkedList<>();
		Node through = shortestPathMap.get(node).getThrough();
		stack.push(node);
		while (!through.getId().equals(root.getId())) {
			stack.push(through);
			through = shortestPathMap.get(through).getThrough();
		}
		stack.push(through);
		StringBuilder stringBuilder = new StringBuilder();

		while (!stack.isEmpty()) {
			stringBuilder.append(stack.pop().getId());
			if (!stack.isEmpty()) {
				stringBuilder.append(" --> ");
			}
		}
		System.out.println("Path from root node "+stringBuilder.toString());

	}

}
