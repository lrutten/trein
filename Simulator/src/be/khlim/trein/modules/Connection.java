package be.khlim.trein.modules;

import be.khlim.trein.gui.Event;
import be.khlim.trein.gui.Link;
import be.khlim.trein.gui.Run;
import edu.umd.cs.piccolo.nodes.PPath;

/**
 * This class represents an {@link Input Input} or an {@link Output Output} on a {@link Module Module}.
 * A Connection can also write {@link Event Events} to another Connection in the simulation.
 * Each Connection has an Input to Output delay.
 */
public abstract class Connection extends PPath{
	
	private float posX, posY;
	private String name;
	protected boolean state;
	protected Link link;
	protected long delay;
	
	protected Module owner;
	
	/**
	 * Constructor for a Connection
	 * @param x The x-position of the Connection on a {@link Module Module}
	 * @param y The y-position of the Connection on a {@link Module Module}
	 * @param n The name of a Connection
	 */
	public Connection(float x, float y, String n){
		posX = x;
		posY = y;
		name = n;
		state = false;
		link = null;
	}
	
	/**
	 * Gets the signalname of this Connection
	 * @return The signalname of this Connection
	 */
	public char getSignal(){
		int index = name.indexOf('g', 5);
		char sign = name.charAt(index+1);
		return sign;
	}
	
	/**
	 * Gets the x-position of this Connection on a {@link Module Module}
	 * @return The x-position
	 */
	public float getsX(){
		return posX;
	}
	
	/**
	 * Gets the y-position of this Connection on a {@link Module Module}
	 * @return The y-position
	 */
	public float getsY(){
		return posY;
	}
	
	/**
	 * Gets the name of this Connection
	 * @return The name of this Connection
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Gets the state of this Connection
	 * @return The state of this Connection
	 */
	public boolean getState(){
		return state;
	}
	
	/**
	 * Sets the State of this Connection
	 * @param b true=1, false=0
	 */
	public void setState(boolean b){
		state = b;
	}
	
	/**
	 * Sets the {@link Link Link} to which a Connection belongs
	 * With this Link it s possible to get the Connection it is mapped to.
	 * @param l The Link which contains this Connection
	 */
	public void setLink(Link l){
		link = l;
	}
	
	 /**
     * This function writes an {@link Event Event} to the
     * {@link Connection Connection} which is mapped to this Connection.
     * The Even is also added to the simulation class to be processed.
     * @param evt The {@link Event event} that needs to be written.
     */
	public void write(Event evt){
		if(mappedto()!=null && mappedto().getName().regionMatches(0, "in", 0, 2)){
			evt.setInput((Input) mappedto());
			sim().addEvent(evt, delay);
		}
	}
	
	 /**
     * This method returns the Connection
     * which is mapped to this connection.
     *
     * @return The mapped Connection.
     */
	public Connection mappedto(){
		if(link == null){
			return null;
		}else{
			return link.getOther(this);
		}
	}
	
	/**
	 * Sets to which {@link Module Module} this Connection belongs
	 * @param m The Module to which this Connection belongs
	 */
    public void setOwner(Module m){
    	owner = m;
    }

	 /**
     * This method returns a reference to the owner of the Connection.
     *
     * @return a reference to the owner {@link Module Module}.
     */
	public Module getOwner(){
		return owner;
	}
	
	/**
	 * Returns a reference to the {@link Run Run} instance
	 * @return The Run intance
	 */
	public Run sim(){
		return owner.sim();
	}
	
	/**
	 * Sets the delay of this Connection
	 * @param del The delay 
	 */
	public void setDelay(long del){
		delay = del;
	}
	
	/**
	 * Gets the delay of this Connection
	 * @return the delay of this Connection
	 */
	public long getDelay(){
		return delay;
	}
}
