package be.khlim.trein.modules;

import be.khlim.trein.gui.Event;

/**
 * This class represents an Output on a {@link Module Module}.
 */
public class Output extends Connection{

	/**
	 * The constructor of an Output
	 * @param x The x-position of the Output on a {@link Module Module}
	 * @param y The y-position of the Output on a {@link Module Module}
	 * @param name The name of the Output
	 * @param rand The random deviation on the delay of this Output
	 */
	public Output(float x, float y, String name, long rand){
		super(x,y,name);
		delay = 20 + rand;
	}
}