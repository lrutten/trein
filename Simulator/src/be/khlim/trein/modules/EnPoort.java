package be.khlim.trein.modules;
import be.khlim.trein.gui.Event;
import be.khlim.trein.modules.conf.*;

public class EnPoort extends Module {
	
	
	public EnPoort(ConfModule cmod){
		super(cmod);
	}
	
	public void process(Event evt){
		if(! evt.getInput().getState() == evt.getInput().mappedto().getState()){
		
			setInputs(evt.getInput());
			boolean inA = false, inB = false;
			inA = evt.getInput().getState();
			for(Input in: inputs){
				if( !(evt.getInput().getSignal() == in.getSignal())){
					inB = in.getState();
				}
			}
			writeOutputs(inA && inB, outputs.get(0).getSignal());
		}
		
	}
	
}
