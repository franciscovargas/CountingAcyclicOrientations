
import java.io.*;
import java.util.*;
import java.lang.Math;

/**
 * An implementation of Algorithms for testing acylicity
 * and counting acyclic orientations of undirected graphs.
 */

public class acyclic {


    /** The method below will implement an Algorithm to
     * take a 2-dimensional square matrix representing a
     * directed graph, and determine whether that directed 
     * is acyclic. **/

    public static boolean isDAG (boolean digraph[][]) {   
	return true;   /** placeholder **/ 
    }

    /** The method below will implement a simple algorithm
     * which takes an 2 dimensional matrix representing a 
     * undirected graph, and generates and returns a random
     * uniform orientation of that graph. **/
 
    public static boolean[][] uniformOrient(boolean[][] graph) {
	return true;    /** placeholder **/
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