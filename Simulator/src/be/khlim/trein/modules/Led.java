package be.khlim.trein.modules;

import edu.umd.cs.piccolo.nodes.PPath;

/**
 * This class represents the led on a modules. The led colors red if the output of the 
 * module is true.
 *
 */
public class Led extends PPath{

	private float posX, posY;
	
	/**
	 * The constructor of a led.
	 * @param x The x-position of the led on the module.
	 * @param y The y-position of the led on the module.
	 */
	public Led(float x, float y){
		posX = x;
		posY = y;
	}
	
	/**
	 * Returns the x-position of the led on the module.
	 * @return The x-position.
	 */
	public float getLedX(){
		return posX;
	}
	
	/**
	 * Returns the y-position of the led on the module.
	 * @return The y-position.
	 */
	public float getLedY(){
		return posY;
	}
}
