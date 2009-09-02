package be.khlim.trein.gui;

import java.io.Serializable;

import be.khlim.trein.modules.Module;

/**
 * This class is used in a module when the module has to wait a certain time before 
 * the outputs are assigned. It creates a new thread that handles the wait.
 */
public class Wait extends Thread implements Serializable {

	long wait;
	Module module;
	boolean state;
	
	/**
	 * The constructor of the wait class.
	 * @param w The time that the wait class needs to sleep.
	 * @param st The state that the outputs need to get after the sleep.
	 * @param mod The module associated with the wait.
	 */
	public Wait(long w, boolean st, Module mod){
		wait = w;
		module = mod;
		state = st;
	}
	
	/**
	 * This method waits and then assigns the outputs of the module and repaints the layer of the 
	 * {@link Run Run} class.
	 */
	public void run()
   {
		try
      {
			System.out.println("start " + state);
			sleep(wait);
			System.out.println("stop");
			module.writeOutputs(state, module.getOutputs().get(0).getSignal());
			module.colorNodes();
			module.simulate();
			//notifyAll();
			module.sim().getLayer().repaint();
			module.sim().removeThread(this);
		}
      catch(InterruptedException e)
      {
			//System.out.println("interrupted");
		}
	}
	
}
