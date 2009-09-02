package be.khlim.trein.modules;

import java.awt.Color;

import edu.umd.cs.piccolo.event.PBasicInputEventHandler;
import edu.umd.cs.piccolo.event.PInputEvent;
import edu.umd.cs.piccolo.nodes.PPath;
import edu.umd.cs.piccolo.nodes.PText;
import be.khlim.trein.gui.Event;
import be.khlim.trein.modules.conf.ConfModule;

public class Klok extends Module{
	
	private long delay;

	public Klok(ConfModule cmod){
		super(cmod);
		for(Output out : getOutputs()){
			out.setDelay(0L);
		}
		delay = 1000L;
	}

	public void initialize(){
		process(null);
	}
	
	public void process(Event evt) {
		sim().wait(!(outputs.get(0).getState()), delay, this);
	}
	
	public void writeOutputs(boolean st, char sig){
		for(Output out: outputs){
			if(out.getState() != st && out.getSignal() == sig){
				out.setState(st);
				out.write(new Event());
			}
		}
		process(null);
	}
	
	public void addListeners(){
		final PPath p1 = new PPath();
		PText pt1 = new PText();
		p1.setPathToEllipse(5, 60, 10, 10);
		p1.setPaint(Color.lightGray);
		pt1.setBounds(5, 70, 20, 10);
		pt1.setText("<1s");
		addChild(pt1);
		addChild(p1);
		final PPath p2 = new PPath();
		PText pt2 = new PText();
		p2.setPathToEllipse(5, 85, 10, 10);
		p2.setPaint(Color.green);
		pt2.setBounds(5, 95, 20, 10);
		pt2.setText("1s");
		addChild(pt2);
		addChild(p2);
		final PPath p3 = new PPath();
		PText pt3 = new PText();
		p3.setPathToEllipse(5, 110, 10, 10);
		p3.setPaint(Color.lightGray);
		pt3.setBounds(5, 120, 20, 10);
		pt3.setText(">1s");
		addChild(pt3);
		addChild(p3);
		p1.addInputEventListener(new PBasicInputEventHandler() {	
			
			public void mousePressed(PInputEvent e){
				p1.setPaint(Color.green);
				p2.setPaint(Color.lightGray);
				p3.setPaint(Color.lightGray);
				delay = 500L;
			}
		});
		p2.addInputEventListener(new PBasicInputEventHandler() {	
			
			public void mousePressed(PInputEvent e){
				p2.setPaint(Color.green);
				p1.setPaint(Color.lightGray);
				p3.setPaint(Color.lightGray);
				delay = 1000L;
			}
		});
		p3.addInputEventListener(new PBasicInputEventHandler() {	
	
			public void mousePressed(PInputEvent e){
				p3.setPaint(Color.green);
				p1.setPaint(Color.lightGray);
				p2.setPaint(Color.lightGray);
				delay = 1500L;
			}
		});
	}
	
}
