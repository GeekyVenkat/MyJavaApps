package com.test.rnd;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

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

    // Complete the evenForest function below.
    static int evenForest(int t_nodes, int t_edges, List<Integer> t_from, List<Integer> t_to) {
        Graph g = new Graph(t_nodes+1);
        int edgeRemoved = 0;
        for(int i=0; i<t_edges; i++){
            g.addEdge(t_from.get(i), t_to.get(i));
        }

      
        nodes= g.getNodes();
        for (int i=1; i<=t_nodes; i++) {
            nodesVisited = new boolean[t_nodes+1];
            nodesVisited[i] = true;
            
            Object[] neighbors = (Object[]) nodes[i].neighbors.toArray(); 
            
            for(int j=0; j<neighbors.length; j++) {
                count = 0;
                Integer val = (Integer) neighbors[j];
                deapthFirstSearch(val);
                if(count %2 == 0) {
                    g.removeEdge(i, val);
                    edgeRemoved++;
                }
            }
        }
        return edgeRemoved;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] tNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int tNodes = Integer.parseInt(tNodesEdges[0]);
        int tEdges = Integer.parseInt(tNodesEdges[1]);

        List<Integer> tFrom = new ArrayList<>();
        List<Integer> tTo = new ArrayList<>();

        for (int i = 0; i < tEdges; i++) {
            String[] tFromTo = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            tFrom.add(Integer.parseInt(tFromTo[0]));
            tTo.add(Integer.parseInt(tFromTo[1]));
        }

        int res = evenForest(tNodes, tEdges, tFrom, tTo);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

class Graph {

    private Node[] nodes;

    public Graph(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node();
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

}

class Node { 
    HashSet<Integer> neighbors;
    int iD;
    public Node(){
        neighbors = new HashSet<Integer>();
    }
    
}

