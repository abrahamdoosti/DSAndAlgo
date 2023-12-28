package com.example.datastructure.graph;

public class ShortestPath {
	private Node through;
	private Integer cost;

	public ShortestPath() {

	}

	public ShortestPath(Node through, Integer cost) {
		super();
		this.through = through;
		this.cost = cost;
	}

	public Node getThrough() {
		return through;
	}

	public void setThrough(Node through) {
		this.through = through;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "ShortestPath [through = " + through + ", cost=" + cost + "]";
	}
	

}
