import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Graph here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


class Graph implements IGraph
{

    int V, E;    // V-> no. of vertices & E->no.of edges
    IEdge edge[]; // collection of all edges
    class subset
    {
        int parent, rank;
    };
    // Creates a graph with V vertices and E edges
    Graph(int v, int e)
    {
        V = v;
        E = e;
        edge = new Path[E];
        for (int i=0; i<e; ++i)
            edge[i] = new Path();
    }
    public void setNoOfEdges(int noOfEs){
    	E = noOfEs;
    }
    
    int index = 0;
    public void addEdges(IEdge newEdge){
    	edge[index] = newEdge;
    	index ++;
    }
    // A utility function to find set of an element i
    // (uses path compression technique)
    int find(subset subsets[], int i)
    {
        // find root and make root as parent of i (path compression)
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
 
        return subsets[i].parent;
    }
 
    // A function that does union of two sets of x and y
    // (uses union by rank)
    void Union(subset subsets[], int x, int y)
    {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
 
        // Attach smaller rank tree under root of high rank tree
        // (Union by Rank)
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
 
        // If ranks are same, then make one as root and increment
        // its rank by one
        else
        {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
 
    // The main function to construct MST using Kruskal's algorithm
    public IEdge[] GetMinimalSpanningEdges()
    {
        IEdge result[] = new Path[V-1];  // This will store the resultant MST
        Integer finalResult []  = new Integer[V-1];
        int e = 0;  // An index variable, used for result[]
        int i = 0;  // An index variable, used for sorted edges
        // Step 1:  Sort all the edges in non-decreasing order of their
        // weight.  If we are not allowed to change the given graph, we
        // can create a copy of array of edges
        Arrays.sort(edge);
 
        // Allocate memory for creating V subsets
        subset subsets[] = new subset[V];
        for(i=0; i<V; ++i){
            subsets[i]=new subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }
  
        i = 0;  // Index used to pick next edge
        
        // Number of edges to be taken is equal to V-1
        while (e < V - 1)
        {
            // Step 2: Pick the smallest edge. And increment the index
            // for next iteration
            IEdge next_edge = edge[i++];
            System.out.println(i);
            int x = find(subsets, next_edge.getSrc());
            int y = find(subsets, next_edge.getDest());
            // If including this edge does't cause cycle, include it
            // in result and increment the index of result for next edge
            if (x != y)
            {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
            // Else discard the next_edge
        }
        return result;
    }
 
}
