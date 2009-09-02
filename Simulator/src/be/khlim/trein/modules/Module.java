package be.khlim.trein.modules;

import be.khlim.trein.gui.Event;
import be.khlim.trein.gui.Run;
import be.khlim.trein.modules.conf.*;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
//import java.io.IOException;
import java.util.ArrayList;
import java.net.URL;
/*import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;*/

import edu.umd.cs.piccolo.nodes.PImage;

/**
 * This class is the superclass of all the Modules.
 */
public abstract class Module extends PImage
{
	protected ArrayList<Output> outputs;
	protected ArrayList<Input>  inputs;
	protected String image;
	protected String imageIcon;
	protected String name;
	private   int    index;
	protected Led    led;
	private boolean  vertical;
	protected float  eventX, eventY, eventHeight, eventWidth;

	 //A reference to the main class.
	private Run sim;
		
		public Module()
      {
		}
		/**
		 * The constructor uses a {@link ConfModule Configuration module} for it's parameters.
		 * @param cmod The configuration module
		 */
		public Module(ConfModule cmod)
      {
			
			image = cmod.getImage();	
			imageIcon = cmod.getImageIcon();
			name = cmod.getName();
			inputs = new ArrayList<Input>();
			for (int i=0;i<cmod.getInputs().size();i++)
         {
				Input in = new Input(cmod.getInputs().get(i).getX(), cmod.getInputs().get(i).getY(), cmod.getInputs().get(i).getName());
				in.setOwner(this);
				inputs.add(in);
			}
			outputs = new ArrayList<Output>();
			long random = (long) (Math.random() *10);
			for (int i=0;i<cmod.getOutputs().size();i++)
         {
				Output out = new Output((cmod.getOutputs().get(i)).getX(), (cmod.getOutputs().get(i)).getY(), cmod.getOutputs().get(i).getName(), random);
				out.setOwner(this);
				outputs.add(out);
			}
			led = new Led(cmod.getLedX(),cmod.getLedY());
			vertical = cmod.getVertical();
			createModule();
		}
		
		/**
		 * Sets the {@link Run Run} class.
		 */
		public void setSim()
      {
			sim = Run.getSim();
		}
		
		/**
		 * Draws the {@link Connection Connections} and the {@link Led Led} on this Module.
		 */
		void createModule()
      {
         System.out.println("image " + image);

         URL url = this.getClass().getResource(image);
			Image im = Toolkit.getDefaultToolkit().getImage(url);
			setImage(im);
			setBounds(0,0,65,170);
			for (Input in: inputs)
			{   in.setPathToEllipse(in.getsX(), in.getsY(), (float) 11, (float) 11);
				in.setPaint(Color.LIGHT_GRAY);
				addChild(in);
			}
			for (Output out: outputs)
			{   out.setPathToEllipse(out.getsX(), out.getsY(), (float) 11, (float) 11);
				out.setPaint(Color.LIGHT_GRAY);
				addChild(out);
			}
			if (vertical)
         {
				led.setPathToRectangle(led.getLedX(),led.getLedY(), (float)4, (float)13);
			}
         else
         { 
            led.setPathToRectangle(led.getLedX(),led.getLedY(), (float)13, (float)4);
         }
			led.setPaint(Color.red);
			led.setPickable(false);
			addChild(led);
		}
		
		/**
		 * Sets the name of this Module.
		 * @param nm The new name of this Module.
		 */
		public void setName(String nm)
      {
			name = nm;
		}
		
		/**
		 * Sets the path of the image of this Module.
		 * @param im The new imagepath of this Module
		 */
		public void setImagePath(String im)
      {
			image = im;
		}
		
		/**
		 * Sets the path of the icon of this Module.
		 * @param ic The new path for the new icon.
		 */
		public void setImageIcon(String ic)
      {
			imageIcon = ic;
		}
		
		/**
		 * Sets all the {@link Input Inputs} of the same sigalname of a given Input
		 * to the state of the {@link Connection Connection} the given Input is connected to.
		 * @param in The Input of which the state needs to be updated.
		 */
		public void setInputs(Input in)
      {
			ArrayList<Input> sig = getSignalInputs(in.getSignal());
			in.setState(in.mappedto().getState());
			for(Input sign: sig)
         {
				if(!(in == sign))
            {
					sign.setState(in.getState());
					sign.write(new Event());
				}
			}
		}
		
		/**
		 * Sets the parameters of the interactive area on the Module during the simulation. 
		 * Only needs to be implemented if there is an interactive area on the Module. 
		 * @param cmod The {@link ConfModule configuration module} belonging to this Module.
		 */
		protected void setEventFrame(ConfModule cmod)
      {
			eventX = cmod.getEventX();
			eventY = cmod.getEventY();
			eventWidth = cmod.getEventWidth();
			eventHeight = cmod.getEventHeight();
		}
		
		/**
		 * Updates the {@link Output Outputs} of this Module when it receives an {@link Event Event}.
		 * All Modules need to override this method.
		 * @param evt The Event that causes the process to be called.
		 */
		abstract public void process(Event evt);
		
		/**
		 * This method initializes the {@link Output Outputs} before the simulation starts.
		 * A subclass only needs to override this method if an initialization of the Module is necessary.
		 */
		public void initialize()
      {
			
		}
		
		/**
		 * Gets the {@link Output Outputs} of this Module. 
		 * @return The Outputs of this Module.
		 */
		public ArrayList<Output> getOutputs()
      {
			return outputs;
		}

		/**
		 * Gets the {@link Input Inputs} of this Module. 
		 * @return The Inputs of this Module.
		 */
		public ArrayList<Input> getInputs()
      {
			return inputs;
		}
		
		/**
		 * Gets all the {@link Input Inputs} of this Module with a given signalname.
		 * @param sign The signalname.
		 * @return The Inputs with the given signalname.
		 */
		public ArrayList<Input> getSignalInputs(char sign)
      {
			ArrayList<Input> signal = new ArrayList<Input>();
			for(Input in: inputs){
				if(in.getSignal() == sign)
            {
					signal.add(in);
				}
			}
			return signal;
		}
		
		/**
		 * Gets the image of this Module.
		 * @return The image of this Module.
		 */
		public String getModImage()
      {
			return image;
		}
		
		/**
		 * Gets the icon image of this Module.
		 * @return The icon image of this Module.
		 */
		public String getImageIcon()
      {
			return imageIcon;
		}
		
		/**
		 * Gets the name of this Module.
		 * @return the name of this Module.
		 */
		public String getName()
      {
			return name;
		}	
		
		/**
		 * Gets the {@link Led Led} of this Module.
		 * @return The Led of this Module.
		 */
		public Led getLed()
      {
			return led;
		}
			
		/**
		 * sets the index of this Module.
		 * @param index The new index of this Module.
		 */
		public void setIndex(int index)
      {
			this.index = index;
		}
		
		/**
		 * Gets the index of this Module
		 * @return the index of this Module
		 */
		public int getIndex()
      {
			return index;
		}
		
		/**
		 * Writes a given state to all the {@link Output Outputs} of this Module with a given signalname.
		 * These Outputs also generate a new {@link Event Event}.
		 * @param st The new state of the Output.
		 * @param sig The signalname of the Outputs.
		 */
		public void writeOutputs(boolean st, char sig)
      {
			for(Output out: outputs)
         {
				if(out.getState() != st && out.getSignal() == sig)
            {
					out.setState(st);
					out.write(new Event());
				}
			}
		}

		/**
		 * Gets the {@link Run Run} instance
		 * @return the run instance
		 */
		public Run sim()
      {	
			return sim;
		}
		
		/**
	     * Starts the simulation
	     */
		public void simulate()
      {
			sim.simulate();
		}
		
		/**
		 * Adds an interactive area to the Module. A subclass only needs to override this method if 
		 * there is an interactive area present on the Module.
		 */
		public void addListeners()
      {
			
		}
		
		/**
		 * This method colors the {@link Connection Connections} of the module. The {@link Led Led}
		 * is colored depending on the state of the Outputs.
		 * A subclass only needs to override this method if the coloring of the Connections and Led needs to be different.
		 */
		public void colorNodes()
      {
			for(Input in: inputs)
         {
				if(in.getState())
            {
					in.setPaint(Color.red);
				}
				else
            {
					in.setPaint(Color.black);
				}
			}
			for(Output out: outputs)
         {
				if(out.getState()==true)
            {
					out.setPaint(Color.red);
					led.setPaint(Color.red);
				}
				else
            {
					out.setPaint(Color.black);
					led.setPaint(Color.black);
				}
			}
		}
	}

