package be.khlim.trein.modules.conf;

/**
 * This is the Configuration file of an {@link be.khlim.trein.modules.Output Output} and is only used to read 
 * the parameters of an XML file. 
 */
public class ConfOutput {
	
	private float posX, posY;
	private String name;
	
	public ConfOutput(){
		
		
	}
	
	/**
	 * Gets the x-position of the Output.
	 * @return The x-position.
	 */
	public float getX(){
		return posX;
	}
	
	/**
	 * Gets the y-position of the Output.
	 * @return The y-position.
	 */
	public float getY(){
		return posY;
	}
	
	/**
	 * Gets the name of the Output.
	 * @return The name.
	 */
	public String getName(){
		return name;
	}
}