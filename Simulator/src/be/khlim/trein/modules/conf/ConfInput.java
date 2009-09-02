package be.khlim.trein.modules.conf;

/**
 * This is the Configuration file of an {@link be.khlim.trein.modules.Input Input} and is only used to read 
 * the parameters of an XML file. 
 */
public class ConfInput {
	
	private float posX, posY;	
	private String name;
	
	public ConfInput(){
		
		
	}
	
	/**
	 * Gets the x-position of the Input.
	 * @return The x-position.
	 */
	public float getX(){
		return posX;
	}
	
	/**
	 * Gets the y-position of the Input.
	 * @return The y-position.
	 */
	public float getY(){
		return posY;
	}
	
	/**
	 * Gets the name of the Input.
	 * @return The name.
	 */
	public String getName(){
		return name;
	}
}
