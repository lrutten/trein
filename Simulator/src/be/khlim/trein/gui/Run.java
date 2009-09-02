package be.khlim.trein.gui;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.net.URL;

/*import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;*/

import javax.swing.JFrame;
import javax.swing.UIManager;

import edu.umd.cs.piccolo.PCanvas;
import edu.umd.cs.piccolo.PNode;
//import edu.umd.cs.piccolo.event.PBasicInputEventHandler;
//import edu.umd.cs.piccolo.event.PInputEvent;
import edu.umd.cs.piccolo.nodes.PPath;
import edu.umd.cs.piccolox.swing.PScrollPane;

import be.khlim.trein.modules.*;

/**
 * This class takes care of the simulation. 
 */
public class Run extends JFrame
{	
	private PNode layer;
	private ArrayList<Module> modules;
	private ArrayList<Thread>   waitThreads;
	static private Run sim;
	
	private long time;
	private long eventCounter;
	private TreeMap<Long, ArrayList<Event>> events;
	
	public Run(ArrayList<Module> pmodules, ArrayList<Link> plinks)
   {
      //System.out.println("Run()");

		sim = this;
		events = new TreeMap<Long, ArrayList<Event>>();
		time = 0;
		modules     = new ArrayList<Module>();
		waitThreads = new ArrayList<Thread>();
		
		for(Module mod: pmodules)
      {
			Module m = (Module)mod.clone();
			modules.add(m);
		}

      //System.out.println("Run() 2");

		for (Link link: plinks)
      {
			int ind1 = ((Module)link.getNode1().getParent()).getIndex();
			int ind2 = ((Module)link.getNode2().getParent()).getIndex();
			// geval1: beide zijn ingangen
			if (link.getNode1().getName().regionMatches(0, "in", 0, 2) && link.getNode2().getName().regionMatches(0, "in", 0, 2))
         {
				Input in1 = null;
				Input in2 = null;
				for(Input in: modules.get(ind1).getInputs())
            {
					if (in.getName().matches(link.getNode1().getName()))
               {
						in1 = in;
					}
				}
				for(Input in: modules.get(ind2).getInputs())
            {
					if (in.getName().matches(link.getNode2().getName()))
               {
						in2 = in;
					}
				}
				Link l = new Link(null, in1, in2);
				in1.setLink(l);
				in2.setLink(l);			
			} // geval2: connectie 1 = ingang en connectie 2 is uitgang
			else if(link.getNode1().getName().regionMatches(0, "in", 0, 2))
         {
				Input in1 = null;
				Output out2 = null;
				for(Input in: modules.get(ind1).getInputs())
            {
					if (in.getName().matches(link.getNode1().getName()))
               {
						in1 = in;
					}
				}
				for(Output out: modules.get(ind2).getOutputs())
            {
					if (out.getName().matches(link.getNode2().getName()))
               {
						out2 = out;
					}
				}
				Link l = new Link(null, in1, out2);
				in1.setLink(l);
				out2.setLink(l);
			} // geval3: connectie 1 is dan uitgang en connectie 2 is ingang
			else
         {
				Output out1 = null;
				Input in2 = null;
				for(Output out: modules.get(ind1).getOutputs())
            {
					if (out.getName().matches(link.getNode1().getName()))
               {
						out1 = out;
					}
				}
				for(Input in: modules.get(ind2).getInputs())
            {
					if (in.getName().matches(link.getNode2().getName())){
						in2 = in;
					}
				}
				Link l = new Link(null, out1, in2);
				out1.setLink(l);
				in2.setLink(l);
			}
			
		} 
		
		try
      {
			  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
      catch (Exception e)
      {
      }
		setTitle ("Simulator IR13");
		
      //System.out.println("Run() 3");

      URL url = this.getClass().getResource("/figures/logo_IR13.gif");
		Image image = Toolkit.getDefaultToolkit().getImage(url);
     	setIconImage(image);

      //System.out.println("Run() 4");

     	PCanvas canvas = new PCanvas();
     	PScrollPane scrollPane = new PScrollPane(canvas, PScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, PScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		setBounds(100, 200, 700, 500);
		setVisible(true); // show Run frame
		canvas.removeInputEventListener(canvas.getPanEventHandler());
		canvas.removeInputEventListener(canvas.getZoomEventHandler());
		layer = canvas.getLayer();
		for(int i=0;i<modules.size();i++)
      {
			layer.addChild(modules.get(i));
			modules.get(i).setSim();
		}
		for(int i=0;i<plinks.size();i++)
      {
			drawLine(plinks.get(i).getNode1(), plinks.get(i).getNode2());
		}
		
		// close when clicked on cross symbol
		addWindowListener	(new WindowAdapter()
      {
			public void windowClosing(WindowEvent e)
         {
				//System.out.println(waitThreads.size());
				for(Thread wait: waitThreads)
            {
					//wait.destroy();
					wait.interrupt();
				}
				//System.out.println(waitThreads.size());
				dispose();
			}
		});
		
      //System.out.println("Run() 5");
		for(Module m: modules)
      {
         //System.out.println("   m " + m);
         
			m.addListeners();
			m.initialize();
			simulate();
			m.colorNodes();
		}
      //System.out.println("Run() 6");

		//simulateLoop();
	}
	
	/**
	 * Gets the root layer of the Run frame
	 * @return The root layer
	 */
	public PNode getLayer()
   {
		return layer;
	}
	
	/**
     * Returns the Run instance
     * @return a reference to Run.
     */
	static public Run getSim()
   {
		if (sim == null)
      {
			System.out.println("ERROR: no new sim is made");
			//sim = this;
		}
		
		return sim;
	}
	
	/**
	 * This method adds an {@link Event Event} to the eventlist of this simulation
	 * with a certain delay
	 * @param ev The Event that is added
	 * @param delay The delay of the Event
	 */
	public void addEvent(Event ev, long delay)
   {
		Long key = new Long(time+delay);
		
		//System.out.println("event op: "+ ev.getInput().getName() + " van module " + ((Module) ev.getInput().getParent()).getName() + "en delay van " + delay + " op tijdstip " + time);
		
		ArrayList<Event> list = events.get(key);
		if(list == null)
      {
			list = new ArrayList<Event>();
			events.put(key, list);
		}
		list.add(ev);
	}
	
	/**
	 * Creates a new wait thread and adds it to the list of Threads.
	 * @param state The state that the output needs t get after the wait.
	 * @param delay The time that the wait needs to wait before assigning the outputs.
	 * @param m The module of which this wait is associated with.
	 */
	public void wait(boolean state, Long delay, Module m)
   {
		Wait wait = new Wait(delay, state, m);
		waitThreads.add(wait);
		wait.start();
		//simulateLoop();
	}
	
	/**
	 * Creates a new wait thread and adds it to the list of Threads.
	 * @param state The state that the output needs t get after the wait.
	 * @param delay The time that the wait needs to wait before assigning the outputs.
	 * @param m The module of which this wait is associated with.
	 */
	public void wait(Thread wait)
   {
		waitThreads.add(wait);
		wait.start();
	}
	
	/**
	 * Removes a wait thread from the threads list.
	 * @param w The wait that needs to be removed.
	 */
	public void removeThread(Thread w)
   {
		waitThreads.remove(w);
	}
	/*
	public void simulateLoop(){
		while(true){
			simulate();
			try{
				//System.out.println("test");
				wait();
			} catch(InterruptedException i){}
		}
	}*/
	
	/**
	 * This method processes the {@link Event Events} in the waiting qeue.
	 * It calls the process method of the {@link Module Modules} that receive an Event on one of it's 
	 * {@link Connection Connections}. 
	 */
	public void simulate()
   {
      //System.out.println("simulate()");
      
		boolean running = true;
		while(running)
      {
			Long fk = null;
			if(events.size() > 0 )
         {
				fk = events.firstKey();
			} 
         else
         {
				running = false;
			}
			if(fk != null)
         {
				time = fk.longValue();
				
				Map.Entry<Long, ArrayList<Event>> map = events.pollFirstEntry();
				ArrayList<Event> clist = map.getValue();
				
				for(Event ev: clist)
            {
					ev.getInput().getOwner().process(ev);
					eventCounter++;
					for(Module mod: modules)
               {
						mod.colorNodes();
					}
				}
			}
		}
      //System.out.println("simulate() einde");
	}
	
	/**
	 * Draws a line between two given {@link Connection Connections}
	 * @param c1 The first Connection
	 * @param c2 The second Connection
	 */
	public void drawLine(final Connection c1, Connection c2){
		float x1, y1, x2, y2;
		x1 = (float)(c1.getFullBoundsReference().getCenter2D().getX() + c1.getParent().getFullBounds().getOrigin().getX());
		y1 = (float)(c1.getFullBoundsReference().getCenter2D().getY() + c1.getParent().getFullBounds().getOrigin().getY());
		x2 = (float)(c2.getFullBoundsReference().getCenter2D().getX() + c2.getParent().getFullBounds().getOrigin().getX());
		y2 = (float)(c2.getFullBoundsReference().getCenter2D().getY() + c2.getParent().getFullBounds().getOrigin().getY());
		PPath line = PPath.createLine(x1, y1, x2, y2);
		layer.addChild(line);
	}
}
