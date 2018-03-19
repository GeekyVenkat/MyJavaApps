package com.test.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GraphAdjList<T> extends Graph<T> {

	private Map<T, ArrayList<T>> adjListMap;
	
	GraphAdjList(){
		adjListMap = new HashMap<T, ArrayList<T>>();
	}
	
	@Override
	public void addEdge(T v, T w) {
		// TODO Auto-generated method stub
		if(adjListMap.containsKey(v)){
			adjListMap.get(v).add(w);
		}
	}

	@Override
	public void addVertex(T v) {
		// TODO Auto-generated method stub
		int numOfVertices = getNumOfVertices();
		setNumOfVertices(numOfVertices+1);
		ArrayList<T> adjList = new ArrayList<T>();
		adjListMap.put(v, adjList);
	}
	
	public void print() {
		
		adjListMap.forEach( (k,v)-> {
			 						  System.out.print(k+"---->");
									  v.forEach( (adjVertices) ->	{
									                                    System.out.print(" "+adjVertices);
									  								});
									  System.out.println();
							});
		
	}
	
	public ArrayList<T> getNeighbors(T v){
		return new ArrayList<T>(adjListMap.get(v));
		
	}

	/*public ArrayList<T> getTwoHopNeighbors(T v) {
		
	}*/
}
