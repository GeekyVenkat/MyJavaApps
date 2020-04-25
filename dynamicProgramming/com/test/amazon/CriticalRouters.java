package com.test.amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class CriticalRouters {
	
	
	static boolean[] nodesVisited;
    static Node[] nodes;
    static int count = 0;
    
    
    public static void deapthFirstSearch(int u) {

        nodesVisited[u] = true;
        count++;
        for (int v : nodes[u].neighbors) {

            if (!nodesVisited[v]) {
                deapthFirstSearch(v);

            }
        }

    }
	
	public static List<Integer> criticalRouters(int numRouters, int numLinks, 
								ArrayList<ArrayList<Integer>> links) {
		
		// Initialize a network
		Graph g = new Graph(numRouters+1);
		
		ArrayList<Integer> criticalEdges = new ArrayList<Integer>();
		
		// Add edges 
		for(int i=0; i<numLinks; i++){
			ArrayList<Integer> link = links.get(i);
			g.addEdge(link.get(0), link.get(1));
        }
		
		nodes= g.getNodes();
		
		for (int i = 1; i <= numRouters; i++) {
			nodesVisited = new boolean[numRouters + 1];
			nodesVisited[i] = true;
			Object[] neighborRouters = (Object[]) nodes[i].neighbors.toArray();
			count = 0;
			for (int j = 0; j < neighborRouters.length; j++) {
			
				Integer val = (Integer) neighborRouters[j];
				g.removeEdge(i, val);
				
			}
			deapthFirstSearch( (i+1)%numRouters);
			if(count != numRouters-1){
				criticalEdges .add(i);
			}
			for (int j = 0; j < neighborRouters.length; j++) {
				Integer val = (Integer) neighborRouters[j];
				g.addEdge(i, val);
			}
		}
		return criticalEdges;
	}
	
	public static void main(String[] args) {
		
		int[][] routerInfo = { {1,2}, {1,3}, {2, 4}, {3, 4}, {3, 6}, {6, 7}, {4, 5} };
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for (int[] array : routerInfo) {

			ArrayList<Integer> link = new ArrayList<Integer>();
			for (int e : array) {
				link.add(e);
			}
			list.add(link);

		}
		
		criticalRouters(7, 7 , list);
	}

}

class Graph {

    private Node[] nodes;

    public Graph(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node();
            nodes[i].iD = i;

        }
    }

    public void addEdge(int first, int second) {
        nodes[first].neighbors.add(second);
        nodes[second].neighbors.add(first);
    }

   public void removeEdge(int u, int v) {

            nodes[u].neighbors.remove(v);
             nodes[v].neighbors.remove(u);
      
    }

    public Node[] getNodes() {
        return nodes;
    }
    
    @Override
    public String toString(){
    	
    	StringBuilder builder = new StringBuilder("");
    	for(Node node : nodes) {
    		builder.append(""+node.iD+"--->");
    		for(int n : node.neighbors){
    			builder.append(""+n+" ");
    		}
    		builder.append("\n");
    	}
    	return builder.toString();
    }

}

class Node { 
    HashSet<Integer> neighbors;
    int iD;
    public Node(){
        neighbors = new HashSet<Integer>();
    }
    
}