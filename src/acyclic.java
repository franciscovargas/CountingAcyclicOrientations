import java.io.*;
import java.util.*;
import java.lang.Math;

/**
 * An implementation of Algorithms for testing acylicity
 * and counting acyclic orientations of undirected graphs.
 */

public class acyclic {

    /** This O(n^2) method
     *  checks if E in G(V,E) is the empty set 
     *  Complexity O(n^2) **/
    public static boolean isEmpty(boolean digraph[][]){
        for (int i =0;i < digraph.length ; i++ ) {
            for (int j = 0; j < digraph.length ; j++ ) {
                if(i!=j && digraph[i][j])
                    return false;
            }
        }
        return true;
    }

    /** Checks that a node is not 
     *  Detached from a graph in O(n) **/
    public static boolean isStronglyConnected(boolean digraph[][],
                                       int node){
        for(int i=0; i < digraph.length; i++){
            if(i!= node && digraph[i][node])
                return true;
        }
        return false;
    }

    /** The method below will implement an Algorithm to
     * take a 2-dimensional square matrix representing a
     * directed graph, and a node and determine if it
     * is a sink Computational complexity O(n)**/
    public static boolean isSink (boolean digraph[][],
                                  int node) {   
        for(int i=0; i < digraph.length; i++){
            if(digraph[node][i])
                return false;
        }
        return isStronglyConnected(digraph, node); 
    }

    /** The method below will implement an Algorithm to
     * take a 2-dimensional square matrix representing a
     * directed graph, and check for the next non removed 
     * sink Computational complexity O(n^2)
     * when sink found return the node number else return
     * -1 **/
    public static int getNearestSink(boolean digraph[][]){
        
        for (int i = 0; i < digraph.length ; i++) {
            if (isSink(digraph, i))
                return i;
        }
        return -1;
    }

    /** this method detaches a sink from a graph
     *  Complexity is O(n) **/
    public static void removeAllIncidentEdges(boolean digraph[][],
                                              int node){
        for(int i =0; i < digraph.length; i++){
            if(i != node)
                digraph[i][node] = false;
        }
    }

    /** The method below will implement an Algorithm to
     * take a 2-dimensional square matrix representing a
     * directed graph, and determine whether that directed 
     * is acyclic. **/

    public static boolean isDAG (boolean digraph[][]) {   
        int n = digraph.length;
        boolean existSink = true;
        while(existSink){
            int nextSink  = getNearestSink(digraph);
            if(nextSink != -1)
                removeAllIncidentEdges(digraph, nextSink);
            else
                existSink = false;
        }

        return isEmpty(digraph);  
    }

    /** The method below will implement a simple algorithm
     * which takes an 2 dimensional matrix representing a 
     * undirected graph, and generates and returns a random
     * uniform orientation of that graph. **/
 
    public static boolean[][] uniformOrient(boolean[][] graph) {
        return null;    /** placeholder **/
    }

    /** The method below will implement a simple algorithm
     * which takes a (positive) integer n, and a probability
     * p and return a 2-dimensional matrix for an undirected
     * graph G on n vertices, generated according to the
     * random model G_{n,p}.  **/   

    public static boolean[][] erdosRenyi(int n, double p) {
        boolean[][] graph = new boolean[n][n];
        Random generator = new Random();
        return graph;  /** placeholder **/ 
    }
     
    
    /** The method below will implement a dynamic programming 
     * algorithm to exactly evaluate the expected number of 
     * acyclic orientations in the random graph model G_{n,p}.
     * This algorithm should be based on the Robinson-Stanley
     * recurrence, and should run in O(n^2) time if possible.
     **/

    public static double expErdosRenyi(int n, double p) {
        return 0.0;  /** placeholder **/
    }

    /**
     * The following method should estimate the variance of
     * the number of AOs over k (graph, orientation) trials
     * with the graph being drawn from G_{n,p} (Erdos-Renyi) 
     * random model and the orientation being sampled 
     * uniformly at random for this graph.  
     * For calculating variance, you will probably use the
     * DP algorithm (coded up as expErdosRenyi) to get the
     * exact value of the expectation.  
     **/

    public static double estimErdosRenyi (int n, double p, int k) {
        return 0.0;  /** placeholder **/
    }

    /**
     * You should write a main method to run tests on your
     * different algorithms. 
     * 
     **/


    public static void main(String [] main) {

    }    
}
