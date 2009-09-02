package be.khlim.trein.gui;

import java.io.Serializable;

import be.khlim.trein.modules.*;
import edu.umd.cs.piccolo.nodes.PPath;

/**
 * This class is represents the link that is made between two connections
 */
public class Link implements Serializable{
	
	private Connection c1;
	private Connection c2;
	private PPath p;
	private LinkSet ls;
	
	public Link(PPath p, Connection c1, Connection c2){
		this.p = p;
		this.c1 = c1;
		this.c2 = c2;
	}
	
	/**
	 * Gets the first {@link Connection Connection} of this Link
	 * @return The first Connection
	 */
	public Connection getNode1(){
		return c1;
	}
	
	/**
	 * Get the other {@link Connection Connection} in this Link if one Connection is given
	 * @param c The given Connection
	 * @return The other Connection
	 */
	public Connection getOther(Connection c){
		if(c == c1){
			return c2;
		}else{
			return c1;
		}
	}
	
	/**
	 * Gets the second {@link Connection Connection} of this Link
	 * @return The second Connection
	 */
	public Connection getNode2(){
		return c2;
	}
	
	/**
	 * Gets the PPath of this Link
	 * @return The PPath of this Link
	 */
	public PPath getPPath(){
		return p;
	}
	
	/**
	 * Clones the Link
	 * @return A copy of this Link
	 */
	public Link clone(){
		Link l = new Link(getPPath(), getNode1(), getNode2());
		return l;
	}
	
	/**
	 * Sets to which {@link LinkSet LinkSet} this Link belongs
	 * @param l The LinkSet to which this Link belongs
	 */
	public void setLinkSet(LinkSet l){
		ls = l;
	}
	
	/**
	 * Gets the {@link LinkSet LinkSet} to which this Link belongs
	 * @return The LinkSet of this Link
	 */
	public LinkSet getLinkSet(){
		return ls;
	}
	
	/**
	 * Checks if there is an {@link Output Output} present in this Link
	 * @return True if the Link contains an Output, else false
	 */
	public boolean outputPresent(){
		boolean present = false;
		if(c1.getName().regionMatches(0, "uit", 0, 3)||c2.getName().regionMatches(0, "uit", 0, 3)){
			present =  true;
		}
		
		return present;
	}
	
	/**
	 * Gets the {@link Output Output} in this Link
	 * @return The Output of this Link, null if the Link doesn't contain an Output
	 */
	public Connection getOutput(){
		if(c1.getName().regionMatches(0, "uit", 0, 3)){
			return c1;
		}else if(c2.getName().regionMatches(0, "uit", 0, 3)){
			return c2;
		}else return null;
	}

}
