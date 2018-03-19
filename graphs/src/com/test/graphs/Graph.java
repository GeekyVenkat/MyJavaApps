package com.test.graphs;

public abstract class Graph<T> {
	
	private int numOfEdges;
	private int numOfVertices;
	
	public abstract void addEdge(T v, T w);
	
	public abstract void addVertex(T v);
	
	/**
	 * @return the numOfEdges
	 */
	public int getNumOfEdges() {
		return numOfEdges;
	}
	/**
	 * @param numOfEdges the numOfEdges to set
	 */
	public void setNumOfEdges(int numOfEdges) {
		this.numOfEdges = numOfEdges;
	}
	/**
	 * @return the numOfVertices
	 */
	public int getNumOfVertices() {
		return numOfVertices;
	}
	/**
	 * @param numOfVertices the numOfVertices to set
	 */
	public void setNumOfVertices(int numOfVertices) {
		this.numOfVertices = numOfVertices;
	}
	
	

}
