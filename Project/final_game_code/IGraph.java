import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Graph here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public interface IGraph {
	void setNoOfEdges(int noOfEs);
	void addEdges(IEdge newEdge);
	IEdge[] GetMinimalSpanningEdges();
}

