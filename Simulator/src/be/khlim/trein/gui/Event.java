package be.khlim.trein.gui;

import be.khlim.trein.modules.Input;
//import be.khlim.trein.modules.Module;

/**
 * This class represents the events that occur in the simulation.
 */ 
public class Event{
	
	private Input input;

	public Event(){
		input = null;
	}
	
	public Event(Input in){
		input = in;
	}

	/**
	 * Set the {@link Input Input} of this Event
	 * @param in The Input of this Event
	 */
	public void setInput(Input in){
		input = in;
	}
	
	/**
	 * Gets the {@link Input Input} of this Event
	 * @return This Event's Input
	 */
	public Input getInput(){
		return input;
	}
}
