package be.khlim.trein.gui;

import java.util.ArrayList;
import be.khlim.trein.modules.Connection;

/**
 * This class holds a set of {@link Link Links} which are linked together.
 */
public class LinkSet {
	
	private ArrayList<Link> links;
	boolean outputpresent;
	
	public LinkSet(){
		links = new ArrayList<Link>();
		outputpresent = false;
	}
	
	/**
	 * Adds a {@link Link link} to this Linkset
	 * @param l The link that needs to be added
	 */
	public void addLink(Link l){
		links.add(l);
		l.setLinkSet(this);
		if(!outputpresent){
			outputpresent = l.outputPresent();
		}
	}
	
	/**
	 * Adds an ArrayList of {@link Link links} to this Linkset
	 * @param al The ArrayList of links that needs to be added
	 */
	public void addLinks(ArrayList<Link> al){
		for (Link l: al){
			links.add(l);
			l.setLinkSet(this);
			if(!outputpresent){
				outputpresent = l.outputPresent();
			}
		}
	}
	
	/**
	 * Removes a {@link Link link} from this Linkset
	 * @param l The link that needs to be removed
	 */
	public void removeLink(Link l){
		links.remove(l);
		outputpresent = false;
		for(Link lnk: links){
			if(!outputpresent){
				outputpresent = lnk.outputPresent();
			}
		}
	}
	/**
	 * Returns the links in this LinkSet
	 * @return the {@link Link links} in the LinkSet
	 */
	public ArrayList<Link> getLinks(){
		return links;
	}
	
	/**
	 * Checks if there's already an {@link be.khlim.trein.modules.Output Output} present in the LinkSet
	 * @return true if there is an output present
	 */
	public boolean outputPresent(){
		return outputpresent;
	}
	
	/**
	 * Checks if the signals in a {@link Link Link} are available in this Linkset
	 * @param lnk The link 
	 * @return True if the signal is available in the LinkSet
	 */
	public boolean containsSignal(Link lnk){
		return containsSignal(lnk.getNode1(), lnk.getNode2());
	}
	
	/**
	 * Checks if the signals of any of the two {@link Connection connections} are available in this Linkset
	 * @param c1 The connection
	 * @param c2 The other connection
	 * @return True if the signal is available in the LinkSet
	 */
	public boolean containsSignal(Connection c1, Connection c2){
		boolean signalfound = false;
		for(Link l: links){
				if(c1.getOwner()==l.getNode1().getOwner() && c1.getSignal()==l.getNode1().getSignal()
						|| c1.getOwner()==l.getNode2().getOwner() && c1.getSignal()==l.getNode2().getSignal()
						|| c2.getOwner()==l.getNode1().getOwner() && c2.getSignal()==l.getNode1().getSignal()
						|| c2.getOwner()==l.getNode2().getOwner() && c2.getSignal()==l.getNode2().getSignal()){
					//connections of compared links are on the same module and are the same signal
					//System.out.println("links zelfde linkset");
					signalfound = true;
					break;
				}
				//System.out.println("Node 1 signal: " + lnk.getNode1().getSignal() + ", van module: " + lnk.getNode1().getOwner().getName());
			}
		return signalfound;
	}
	
	/**
	 * Adds a LinkSet to this LinkSet
	 * @param ls The LinkSet that needs to be added
	 */
	public void merge(LinkSet ls){
		for(Link l: ls.getLinks()){
			links.add(l);
			l.setLinkSet(this);
			if(!outputpresent){
				outputpresent = l.outputPresent();
			}
		}
	}
	
	/**
	 * Gets the {@link be.khlim.trein.modules.Output Output} in this LinkSet
	 * @return The Output, else null if there is no Output present in this LinkSet
	 */
	public Connection getOutput(){
		Connection c = null;
		if(outputpresent){
			for(Link l: links){
				if(l.getOutput()!=null)
					c = l.getOutput();
			}
		}
		return c;
	}
}
