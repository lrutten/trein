package be.khlim.trein.modules;
//import java.util.Calendar;

import be.khlim.trein.gui.Event;
import be.khlim.trein.gui.Wait;
import be.khlim.trein.modules.conf.*;

public class WachtLijn extends Module
{
   Event e;

	public WachtLijn(ConfModule cmod)
   {
		super(cmod);
		for(Output out : getOutputs())
      {
			out.setDelay(10000L);
		}
	}
	
	public void process(Event evt)
   {
      System.out.println("Wachtmodule.process()");

		if(! evt.getInput().getState() == evt.getInput().mappedto().getState())
      {
			setInputs(evt.getInput());
         e = evt;

         Thread wt = new Thread()
         {
            public void run()
            {
               try
               {
                  boolean state = e.getInput().getState();
                  System.out.println("start " + state);

                  sleep(outputs.get(0).getDelay());

                  System.out.println("stop");

                  writeOutputs(state, getOutputs().get(0).getSignal());
                  colorNodes();
                  simulate();

                  sim().getLayer().repaint();
                  sim().removeThread(this);
               }
               catch(InterruptedException e)
               {
               }
            }
            
         };
			// sim().wait(evt.getInput().getState(), outputs.get(0).getDelay(), this);
			sim().wait(wt);
         
		}
	}
}