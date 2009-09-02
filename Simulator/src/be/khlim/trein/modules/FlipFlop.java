package be.khlim.trein.modules;
import be.khlim.trein.gui.Event;
import be.khlim.trein.modules.conf.*;

public class FlipFlop extends Module {
	
	public FlipFlop(ConfModule cmod){
		super(cmod);
	}
	
	//flipflop needs the Connection, because it is necessary to know the name of the input
	public void process(Event evt){
		if(! evt.getInput().getState() == evt.getInput().mappedto().getState()){
			setInputs(evt.getInput());
				if(evt.getInput().getName().endsWith("reset")){
					if(evt.getInput().getState()){
						writeOutputs(false, outputs.get(0).getSignal());
					}
				} else if(evt.getInput().getName().endsWith("set")){
					if(evt.getInput().getState()){
						writeOutputs(true, outputs.get(0).getSignal());
					}
				} else if(evt.getInput().getName().endsWith("flip")){
					if(evt.getInput().getState()){
						writeOutputs(! outputs.get(0).getState(), outputs.get(0).getSignal());
					}
				}
		}
	}
}
