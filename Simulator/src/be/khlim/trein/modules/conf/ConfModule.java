package be.khlim.trein.modules.conf;

import java.util.ArrayList;

/**
 * This is the configuration file of a module. This class is only used to read the parameters of a 
 * module of an XML file.
 */
public class ConfModule {
		
	private ArrayList<ConfOutput> outputs; // all outputs
	private ArrayList<ConfInput> inputs; // all inputs
	private float ledx, ledy;
	private String image, imageIcon, name;
	private boolean vertical;
	private float eventX, eventY, eventHeight, eventWidth;
		
	public ConfModule(){
		
	}
	
	public void addName(String nm){
		name = nm;
	}
	
	public void addImagePath(String im){
		image = im;
	}
	
	public void addImageIcon(String ic){
		imageIcon = ic;
	}
	
	public void addVertical(boolean vert){
		vertical = vert;
	}
	
	public ArrayList<ConfOutput> getOutputs(){
		return outputs;
	}
	
	public ArrayList<ConfInput> getInputs(){
		return inputs;
	}
	
	public String getImage(){
		return image;
	}
	
	public String getImageIcon(){
		return imageIcon;
	}
	
	public String getName(){
		return name;
	}	
	
	public float getLedX(){
		return ledx;
	}
	
	public float getLedY(){
		return ledy;
	}
	
	public boolean getVertical(){
		return vertical;
	}
	
	public void setEventX(float x){
		eventX = x;
	}
	
	public void setEventY(float y){
		eventY = y;
	}
	
	public void setEventWidth(float w){
		eventWidth = w;
	}
	
	public void setEventHeight(float h){
		eventHeight = h;
	}
	
	public float getEventX(){
		return eventX;
	}
	
	public float getEventY(){
		return eventY;
	}
	
	public float getEventWidth(){
		return eventWidth;
	}
	
	public float getEventHeight(){
		return eventHeight;
	}
		
}
