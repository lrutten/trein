package be.khlim.trein.modules;
import be.khlim.trein.gui.Event;
import be.khlim.trein.modules.conf.*;

public class OfPoort extends Module {
	
	public OfPoort(ConfModule cmod){
		super(cmod);
	}
	
	public void process(Event evt){
		if(! evt.getInput().getState() == evt.getInput().mappedto().getState()){
			setInputs(evt.getInput());
			boolean outp = false;
			for(Input inp: inputs){
				outp |= inp.getState();
			}
			writeOutputs(outp, outputs.get(0).getSignal());
		}
	}
}