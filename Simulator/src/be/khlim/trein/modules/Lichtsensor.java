package be.khlim.trein.modules;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.net.URL;

import edu.umd.cs.piccolo.event.PBasicInputEventHandler;
import edu.umd.cs.piccolo.event.PInputEvent;
import edu.umd.cs.piccolo.nodes.PPath;
import be.khlim.trein.gui.Event;
import be.khlim.trein.modules.conf.*;

public class Lichtsensor extends Module 
{
	public Lichtsensor(ConfModule cmod)
   {
		super(cmod);
		for(Output out : getOutputs())
      {
			out.setDelay(0L);
		}
		setEventFrame(cmod);
	}
	
	public void process(Event evt)
   {
		writeOutputs(! outputs.get(0).getState(), outputs.get(0).getSignal());
	}
	
	public void initialize()
   {
		writeOutputs(true, outputs.get(0).getSignal());
	}
	
	public void addListeners()
   {
      URL   url;
      Image im;

		PPath p = new PPath();
		p.setPathToEllipse(eventX, eventY, eventWidth, eventHeight);
		p.setPaint(Color.white);
		p.setTransparency(0);

      url = this.getClass().getResource(image.replaceAll(".j", "_on.j"));
		im = Toolkit.getDefaultToolkit().getImage(url);
		setImage(im);

		setBounds(getX(),getY(),65,170);
		p.addInputEventListener(new PBasicInputEventHandler()
      {	
         URL   url;
         Image im;
 			
			public void mousePressed(PInputEvent e)
         {
				if(!outputs.get(0).getState())
            {
					//setImage(image.replaceAll(".j", "_on.j"));
               url = this.getClass().getResource(image.replaceAll(".j", "_on.j"));
               im = Toolkit.getDefaultToolkit().getImage(url);
               setImage(im);
					setBounds(getX(),getY(),65,170);
				}
				else
            {
					//setImage(image);
               url = this.getClass().getResource(image);
               im = Toolkit.getDefaultToolkit().getImage(url);
               setImage(im);
					setBounds(getX(),getY(),65,170);
				}
				process(null);
				colorNodes();
				simulate();
				//notifyAll();
				e.setHandled(true);
			}
		});
		addChild(p);
	}
}