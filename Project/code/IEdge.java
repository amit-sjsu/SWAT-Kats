import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IEdge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public interface IEdge {
	public int getSrc();
	public void setSrc(int src);
	public int getDest();
	public void setDest(int dest);
	public int getWeight();
	public void setWeight(int weight);
	public int compareTo(IEdge compareEdge);
}
