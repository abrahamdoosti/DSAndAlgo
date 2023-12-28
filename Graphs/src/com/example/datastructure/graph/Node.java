package com.example.datastructure.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private Integer id;
	private List<Node> neighbours = new ArrayList<>();

	public Node(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public List<Node> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(List<Node> neighbours) {
		this.neighbours = neighbours;
	}

	public void addNeighbour(Node neighbour) {
		this.neighbours.add(neighbour);
	}

	@Override
	public String toString() {
		return "Node [id=" + id + "]";
	}
}
