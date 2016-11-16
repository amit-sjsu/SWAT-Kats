import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IEdge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public interface IEdge {
	public int getSrc();
	public int getDest();
	public int getWeight();
	public int compareTo(IEdge compareEdge);
	public String getId();
}
