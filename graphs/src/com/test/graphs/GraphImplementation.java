package com.test.graphs;

public class GraphImplementation {

	
	public static void main(String[] args) {
		GraphAdjList<Integer> graphAdjList = new GraphAdjList<>();
		
		
		graphAdjList.addVertex(0);
		graphAdjList.addVertex(1);
		graphAdjList.addVertex(3);
		
		graphAdjList.addEdge(0, 3);
		graphAdjList.addEdge(3, 0);
		graphAdjList.addEdge(1, 2);
		graphAdjList.addEdge(2, 0);
		
		graphAdjList.print();
		
	}
	
}
