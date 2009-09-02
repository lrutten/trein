package be.khlim.trein.modules;

import java.awt.Color;

import edu.umd.cs.piccolo.event.PBasicInputEventHandler;
import edu.umd.cs.piccolo.event.PInputEvent;
import edu.umd.cs.piccolo.nodes.PPath;
import be.khlim.trein.gui.Event;
import be.khlim.trein.modules.conf.*;

public class Drukknop extends Module {
	
	
	public Drukknop(ConfModule cmod){
		super(cmod);
		for(Output out : getOutputs()){
			out.setDelay(0L);
		}
		setEventFrame(cmod);
	}
	
	public void process(Event evt){
		writeOutputs(! outputs.get(0).getState(), outputs.get(0).getSignal());
	}
	
	public void addListeners(){
		final PPath p = new PPath();
		p.setPathToEllipse(eventX, eventY, eventWidth, eventHeight);
		p.setPaint(Color.red);
		p.setTransparency(0);
		p.addInputEventListener(new PBasicInputEventHandler() {	
			
			public void mousePressed(PInputEvent e){
				process(null);
				colorNodes();
				simulate();
				//notifyAll();
				p.setTransparency(1);
				e.setHandled(true);	
			}
			
			public void mouseReleased(PInputEvent e){
				process(null);
				colorNodes();
				simulate();
				p.setTransparency(0);
				e.setHandled(true);	
			}
		});
		addChild(p);
	}
}
