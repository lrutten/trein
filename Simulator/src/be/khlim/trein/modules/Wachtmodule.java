package be.khlim.trein.modules;
//import java.util.Calendar;

import be.khlim.trein.gui.Event;
import be.khlim.trein.gui.Wait;
import be.khlim.trein.modules.conf.*;

public class Wachtmodule extends Module
{
   Event e;
   Thread wt;

	public Wachtmodule(ConfModule cmod)
   {
		super(cmod);
      
      wt = null;

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

         // timer not running and rising edge
         if (wt == null && evt.getInput().getState())
         {
            wt = new Thread()
            {
               public void run()
               {
                  try
                  {
                     boolean state = e.getInput().getState();
                     System.out.println("start " + state);

                     // output high
                     writeOutputs(true, getOutputs().get(0).getSignal());
                     colorNodes();
                     simulate();
                     sim().getLayer().repaint();

                     
                     sleep(outputs.get(0).getDelay());
   
                     System.out.println("stop");
                     wt = null;

                     // output low
                     writeOutputs(false, getOutputs().get(0).getSignal());
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
         else
         {
            System.out.println("timer already running");
         }
		}
      else
      {
         // this part will never be executed
         System.out.println("no action");
      }
	}
}