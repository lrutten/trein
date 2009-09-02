package be.khlim.trein.modules;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;


import edu.umd.cs.piccolo.nodes.PText;

import be.khlim.trein.gui.Event;
import be.khlim.trein.modules.conf.*;

public class Trein extends Module{
	
	boolean aan, snel, vooruit;
	Led aan_uit;
	Led voor_achter;
	Led traag_snel;
	Led licht;
	PText aan_uitText = new PText("Aan");
	PText voor_achterText = new PText("Vooruit");
	PText traag_snelText = new PText("Traag");
	
	
	public Trein(ConfModule cmod){
		super(cmod);
		aan = false;
		snel = false;
		vooruit = true;
	}
	
	void createModule()
   {
      URL url = this.getClass().getResource(image);
		Image im = Toolkit.getDefaultToolkit().getImage(url);
		setImage(im);
		setBounds(0,0,205,68);
		for (Input in: inputs)
		{   in.setPathToEllipse(in.getsX(), in.getsY(), (float) 11, (float) 11);
			in.setPaint(Color.LIGHT_GRAY);
			addChild(in);
		}
	}
	
	public void process(Event evt){
		setInputs(evt.getInput());
	}
	
	public void addListeners(){
		aan_uit = new Led(122,10);
		voor_achter = new Led(122,23);
		traag_snel = new Led(122,36);
		licht = new Led(12,41);
		aan_uit.setPathToRectangle((float)aan_uit.getLedX(), (float)aan_uit.getLedY(), 4, 11);
		aan_uit.setPaint(Color.red);
		voor_achter.setPathToRectangle((float)voor_achter.getLedX(), (float)voor_achter.getLedY(), 4, 11);
		voor_achter.setPaint(Color.red);
		traag_snel.setPathToRectangle((float)traag_snel.getLedX(), (float)traag_snel.getLedY(), 4, 11);
		traag_snel.setPaint(Color.red);
		licht.setPathToRectangle((float)licht.getLedX(), (float)licht.getLedY(), 27, 9);
		licht.setPaint(Color.white);

		//setImage(getModImage().replaceAll(".j", "_sim.j"));
      URL url = this.getClass().getResource(getModImage().replaceAll(".j", "_sim.j"));
      Image im = Toolkit.getDefaultToolkit().getImage(url);
      setImage(im);

		setBounds(0,0,205,68);
		addChild(aan_uit);
		addChild(voor_achter);
		addChild(traag_snel);
		addChild(licht);
		aan_uitText = new PText("Aan");
		voor_achterText = new PText("Vooruit");
		traag_snelText = new PText("Traag");
		aan_uitText.setBounds(70, 9, 20, 10);
		voor_achterText.setBounds(70, 21, 20, 10);
		traag_snelText.setBounds(70, 33, 20, 10);
		addChild(aan_uitText);
		addChild(voor_achterText);
		addChild(traag_snelText);
	}
	
	public void colorNodes(){
		for(Input in: inputs){
			if(in.getName().matches("ingangA_aan_uit")){
				if(in.getState()){ //if true =>on / false=>off
					aan_uit.setPaint(Color.red);
					in.setPaint(Color.red);
					aan_uitText.setText("Aan");
				}
				else{
					aan_uit.setPaint(Color.black);
					in.setPaint(Color.black);
					aan_uitText.setText("Uit");
				}
			}
			else if(in.getName().matches("ingangB_voor_achter")){
				if(in.getState()){ // true=>backward / false=>forward
					voor_achter.setPaint(Color.red);
					in.setPaint(Color.red);
					voor_achterText.setText("Achteruit");
				}
				else{
					voor_achter.setPaint(Color.black);
					in.setPaint(Color.black);
					voor_achterText.setText("Vooruit");
				}
			}
			else if(in.getName().matches("ingangC_traag_snel")){
				if(in.getState()){ // true=>slow / false=>fast
					traag_snel.setPaint(Color.red);
					in.setPaint(Color.red);
					traag_snelText.setText("Traag");
				}
				else{
					traag_snel.setPaint(Color.black);
					in.setPaint(Color.black);
					traag_snelText.setText("Snel");
				}
			}
			else if(in.getName().matches("ingangD_licht")){
				if(in.getState()){ // true=>on / false=>off
					licht.setPaint(Color.yellow);
					in.setPaint(Color.red);
				}
				else{
					licht.setPaint(Color.white);
					in.setPaint(Color.black);
				}
			}
		}
	}
}
