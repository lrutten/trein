package be.khlim.trein.modules;
//import java.util.Calendar;

import be.khlim.trein.gui.Event;
import be.khlim.trein.gui.Wait;
import be.khlim.trein.modules.conf.*;

public class WachtLijnWait extends Module
{
	public WachtLijnWait(ConfModule cmod)
   {
		super(cmod);
		for(Output out : getOutputs())
      {
			out.setDelay(10000L);
		}
	}
	
	public void process(Event evt)
   {
      System.out.println("WachtLijn.process()");

		if(! evt.getInput().getState() == evt.getInput().mappedto().getState())
      {
			setInputs(evt.getInput());
			sim().wait(evt.getInput().getState(), outputs.get(0).getDelay(), this);
		}
	}
}