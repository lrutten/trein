package be.khlim.trein.modules;
import be.khlim.trein.gui.Event;
import be.khlim.trein.modules.conf.*;

public class NietPoort extends Module {
	
	public NietPoort(ConfModule cmod){
		super(cmod);
	}
	
	public void initialize(){
		writeOutputs(!inputs.get(0).getState(), outputs.get(0).getSignal());
	}
	
	public void process(Event evt){
		if(! evt.getInput().getState() == evt.getInput().mappedto().getState()){
			setInputs(evt.getInput());
			writeOutputs(! evt.getInput().getState(), outputs.get(0).getSignal());
		}
	}
}