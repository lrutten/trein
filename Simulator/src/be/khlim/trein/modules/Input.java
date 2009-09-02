package be.khlim.trein.modules;

import be.khlim.trein.gui.Event;

/**
 * The Input class represents an Input on a {@link Module Module}.
 * This is the class where an {@link Connection Connection} can write an
 * {@link Event Events} to.
 */
public class Input extends Connection{
	
	/**
	 * The constructor of an Input
	 * @param x The x-position of the Input on a {@link Module Module}
	 * @param y The y-position of the Input on a {@link Module Module}
	 * @param name The name of the Input
	 */
	public Input(float x, float y, String name){
		super(x,y,name);
		delay = 0;
	}
}
