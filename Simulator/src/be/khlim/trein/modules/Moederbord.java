package be.khlim.trein.modules;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import be.khlim.trein.gui.Event;
import be.khlim.trein.modules.conf.ConfModule;

public class Moederbord extends Module {

	public Moederbord(ConfModule cmod) {
		super(cmod);
	}
	
	void createModule()
   {
      URL url = this.getClass().getResource(image);
		Image im = Toolkit.getDefaultToolkit().getImage(url);
		setImage(im);
		setBounds(0,0,150,50);
		for (Output out: outputs)
		{   out.setPathToEllipse(out.getsX(), out.getsY(), (float) 11, (float) 11);
			out.setPaint(Color.LIGHT_GRAY);
			addChild(out);
		}
	}
	
	public void initialize(){
		writeOutputs(true, outputs.get(0).getSignal());
	}
	
	public void process(Event evt) {
	}

	public void colorNodes(){
		for(Output out: outputs){
			if(out.getState()==true){
				out.setPaint(Color.red);
			}
			else{
				out.setPaint(Color.black);
			}
		}
	}

}
