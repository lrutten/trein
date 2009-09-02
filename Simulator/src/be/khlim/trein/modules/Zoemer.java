package be.khlim.trein.modules;
import java.awt.Color;

import be.khlim.trein.gui.Event;
import be.khlim.trein.modules.conf.*;

public class Zoemer extends Module {
	
	public Zoemer(ConfModule cmod){
		super(cmod);
	}
	
	public void process(Event evt){
		setInputs(evt.getInput());		
	}
	
	public void colorNodes(){
		for(Input in: inputs){
			if(in.getState()){
				in.setPaint(Color.red);
				led.setPaint(Color.red);
			}
			else{
				in.setPaint(Color.black);
				led.setPaint(Color.black);
			}
		}
	}
}