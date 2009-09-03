package be.khlim.trein.gui;


/*
  $Date$ 
  $Revision$ 
  $Author$
 */
 
//imports necessary for the modules
import be.khlim.trein.modules.*;
import be.khlim.trein.modules.conf.*;
//imports used for making the GUI
import java.util.ListIterator;
import java.util.ArrayList;
import java.net.URL;

/*import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
//imports necessary for using Piccolo
import edu.umd.cs.piccolo.PCanvas;
import edu.umd.cs.piccolo.PCamera;
import edu.umd.cs.piccolo.PNode;
import edu.umd.cs.piccolo.PLayer;
import edu.umd.cs.piccolo.event.PDragEventHandler;
import edu.umd.cs.piccolo.nodes.PPath;
import edu.umd.cs.piccolo.event.PInputEvent;
import edu.umd.cs.piccolo.event.PBasicInputEventHandler;
import edu.umd.cs.piccolo.event.PPanEventHandler;
import edu.umd.cs.piccolo.nodes.PImage;
import edu.umd.cs.piccolox.swing.PScrollPane;

/**
 * This is the class for drawing and connecting modules
 */
public class Workspace{
	
	private JInternalFrame frame;
	private PNode layer;
	private Connection n1, n2, c1, c2;
	private PPath templink;
	private PImage tempImage;
	private boolean draw=false;//variable to draw line
	private boolean pline=false;//variable to check if there already are 2 points available to draw line
	private boolean removeline=false;//variable to remove a line
	private boolean removemodule=false;//variable to remove a module
	private boolean drawmodule=false;//variable to draw a module
	private ArrayList<Link> links;
	private ArrayList<Module> modules;
	private int index = 0;
	private ArrayList<LinkSet> linksets;
	private Simulator main; //a reference to the main class
	
	private ConfModule lastselection;
	private String filename = null;
	
	public Workspace(final int i){
	
		main = Simulator.getSimulator();
		links = new ArrayList<Link>();
		modules = new ArrayList<Module>();
		linksets = new ArrayList<LinkSet>();
		frame = new JInternalFrame("Workspace " + i, true, true, false, true);

      URL url = this.getClass().getResource("/figures/logo_IR13.gif");
		ImageIcon image = new ImageIcon(Toolkit.getDefaultToolkit().getImage(url));
        frame.setFrameIcon(image);
		frame.setBounds(5*i-5, 60+(10*i-10), 700, 500);
		PCanvas canvas = new PCanvas();
		PScrollPane scrollPane = new PScrollPane(canvas, PScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, PScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		frame.setVisible(true);
		main.addFrame(frame);
		frame.toFront();
		
		canvas.removeInputEventListener(canvas.getPanEventHandler());
		canvas.removeInputEventListener(canvas.getZoomEventHandler());
		
		layer = canvas.getLayer();
		
		final PCamera camera = canvas.getCamera();
		camera.addInputEventListener(new PPanEventHandler());//eventhandler to move modules by dragging
		camera.addInputEventListener(new PBasicInputEventHandler() {	
			
			public void mouseMoved(PInputEvent e) {
				Point2D p = e.getPosition();
				if (drawmodule) updateTempImage(p);
				if(pline) updateTempLine(templink, p);
			}

			public void mouseDragged(PInputEvent e) {
				Point2D p = e.getPosition();
				if (drawmodule) updateTempImage(p);
				if(pline) updateTempLine(templink, p);
			}

			public void mousePressed(PInputEvent e){
				if ((e.getButton()==1)&&drawmodule){
				Point2D p = e.getPosition();
				index++;
				readModule(lastselection, p, index);
				drawmodule = false;
				layer.removeChild(tempImage);
				tempImage = null;
				}
				if(e.getButton()==3){
					removeActions();
				}
			}

			public void updateTempImage(Point2D p){
					tempImage.setTransparency((float)0.3);
					tempImage.setOffset(p.getX(), p.getY());
			}
		});
		//give last active workspace to the main class
		frame.addInternalFrameListener	(new InternalFrameAdapter(){
			public void internalFrameActivated(InternalFrameEvent e){
				main.setWorkspace(i-1);
			}
		});
		
		Point2D.Double p = new Point2D.Double(3,3);
		Module train = new Trein(main.getTrain());
		addListeners(train, p, index);
		p = new Point2D.Double(210,3);
		Module motherboard = new Moederbord(main.getMotherboard());
		index++;
		addListeners(motherboard, p, index);
	}
	
	public JInternalFrame getFrame(){
		return frame;
	}

   public void print()
   {
      layer.print();
   }

   /**
	 * read module according to a given configuration module
	 * and place it on point p
	 * @param cmod The {@link ConfModule configuration module}
	 * @param p The point where the module is placed
	 * @param ind The index of the module
	 */
	void readModule(ConfModule cmod, Point2D p, int ind){
		String name = cmod.getName();
		Module mod = null;
		if (name.matches("botsingssensor")){
			mod = new Botsingssensor(cmod);
		}
		else if (name.matches("drukknop")){
			mod = new Drukknop(cmod);
		}
		else if (name.matches("EN-poort")){
			mod = new EnPoort(cmod);
		}
		else if (name.matches("flip-flop")){
			mod = new FlipFlop(cmod);
		}
		else if (name.matches("lichtsensor")){
			mod = new Lichtsensor(cmod);
		}
		else if (name.matches("magneetschakelaar")){
			mod = new Magneetschakelaar(cmod);
		}
		else if (name.matches("NIET-poort")){
			mod = new NietPoort(cmod);
		}
		else if (name.matches("OF-poort")){
			mod = new OfPoort(cmod);
		}
		else if (name.matches("schakelaar")){
			mod = new Schakelaar(cmod);
		}
		else if (name.matches("wachtmodule")){
			mod = new Wachtmodule(cmod);
		}
		else if (name.matches("zoemer")){
			mod = new Zoemer(cmod);
		}
		else if (name.matches("trein")){
			mod = new Trein(cmod);
		}
		else if (name.matches("moederbord")){
			mod = new Moederbord(cmod);
		}
		else if (name.matches("klok")){
			mod = new Klok(cmod);
		}
		else if (name.matches("teller")){
			mod = new Teller(cmod);
		}
		else{
			System.out.println("deze module is nog niet geïmplemteerd in de code van workspace.java");
		}
		//add another else-if here if another module needs to be added
		if(mod!=null){
			addListeners(mod, p, ind);
		}
	}
	
	/**
	 * Adds listener to the module and it's connections
	 * @param mod The {@link Module Module}
	 * @param p The point where the module is placed on the workspace
	 * @param ind The index of the module
	 */
	void addListeners(Module mod, Point2D p, int ind){
		mod.addPropertyChangeListener(PNode.PROPERTY_FULL_BOUNDS, new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				updateLinks();
			}
		});
		if(!(mod.getName().matches("trein") || mod.getName().matches("moederbord"))){ //train and motherboard can't be removed
			mod.addInputEventListener(module(mod));
			mod.addInputEventListener(new PDragEventHandler());
		}
		for (Input in: mod.getInputs())
		{  in.addInputEventListener(connection(in));
		}
		for (Output out: mod.getOutputs())
		{  out.addInputEventListener(connection(out));
		}
		mod.setIndex(ind);
		mod.translate(p.getX(), p.getY());
		layer.addChild(mod);
		modules.add(mod);
	}
	
	/**
	 * Update all links when a module is moved
	 */
	void updateLinks() {
		double x1, x2, y1, y2;
		for(int i=0; i<links.size();i++){
			PNode node1 = links.get(i).getNode1();
			PNode node2 = links.get(i).getNode2();
			x1 = node1.getFullBoundsReference().getCenter2D().getX() + node1.getParent().getFullBounds().getOrigin().getX();
			y1 = node1.getFullBoundsReference().getCenter2D().getY() + node1.getParent().getFullBounds().getOrigin().getY();
			x2 = node2.getFullBoundsReference().getCenter2D().getX() + node2.getParent().getFullBounds().getOrigin().getX();
			y2 = node2.getFullBoundsReference().getCenter2D().getY() + node2.getParent().getFullBounds().getOrigin().getY();
			
			/*
			Line2D line = new Line2D.Double(x1,y1,x2,y2);
			links.get(i).getPPath().setPathTo(line);
       */
			setPolyLine(links.get(i).getPPath(), (float)x1, (float)y1, (float)x2, (float)y2);
			}
		}
	
	/**
	 * The eventhandler for a {@link Connection Connection}
	 * @param in The connection
	 * @return The PBasicInputEventHandler of the connection
	 */
	PBasicInputEventHandler connection(final Connection in){
       
		return new PBasicInputEventHandler() {
			// when clicked on a connection
			public void mousePressed(PInputEvent e) {
				if(e.getButton()==1){
					if(draw){ //when a line is being drawn
						if (pline){ //check if there is already a connection selected
							n2 = in;
							if(n1==n2){ //trying to connect the same connection
								templink.moveToFront();
								JOptionPane.showMessageDialog(frame, "Een connectie mag niet met zichzelf verbonden worden", "Fout",JOptionPane.ERROR_MESSAGE);
								draw = false;
								n1.setPaint(Color.lightGray);
							}
							else{
								boolean linepresent = linePresent(n2);
								Link tlink = new Link(null,n1,n2);
								if(!linepresent){//check if 2 outputs are being connected
									if(n1.getName().regionMatches(0, "uit", 0, 3) && n2.getName().regionMatches(0, "uit", 0, 3)){
										draw = false;
										//n2.setPaint(Color.lightGray);
										n1.setPaint(Color.red);
										n2.setPaint(Color.red);
										templink.moveToFront();
										layer.repaint();
										JOptionPane.showMessageDialog(null, "2 uitgangen mogen niet met elkaar verbonden worden.", "Fout",JOptionPane.ERROR_MESSAGE);
										n1.setPaint(Color.lightGray);
										n2.setPaint(Color.lightGray);
									}else if(!AllowOutputConnection(tlink)){
										n2.setPaint(Color.lightGray);
										if(c1!=null){
											c1.setPaint(Color.red);
										}
										if(c2!=null){
											c2.setPaint(Color.red);
										}
										templink.moveToFront();
										layer.repaint();
										draw = false;
										JOptionPane.showMessageDialog(null, "2 uitgangen zijn onrechtstreeks met elkaar verbonden.", "Fout",JOptionPane.ERROR_MESSAGE);
										if(c1!=null){
											c1.setPaint(Color.lightGray);
										}
										if(c2!=null){
											c2.setPaint(Color.lightGray);
										}
									}else{//not yet a line drawn and the connection isn't connected
											// to himself and there aren't 2outputs connected
										drawLine(n1, n2);
									}
								}
								else{// line is already drawn from selected connection
									draw = false;
									templink.moveToFront();
									JOptionPane.showMessageDialog(null, "Er mag maar een lijn per connectie verbonden worden.", "Fout",JOptionPane.ERROR_MESSAGE);
									n1.setPaint(Color.lightGray);
									n2.setPaint(Color.lightGray);
								}	
							}
							pline = false;
							if(templink!=null){
								layer.removeChild(templink);
								templink = null;
							}
						}
						else{// another connection is selected to draw a line
							n1 = in;
							boolean linepresent = linePresent(n1);
							if(!linepresent){
								pline = true;
								float x = (float)(n1.getFullBoundsReference().getCenter2D().getX() + n1.getParent().getFullBounds().getOrigin().getX());
								float y = (float)(n1.getFullBoundsReference().getCenter2D().getY() + n1.getParent().getFullBounds().getOrigin().getY());
								templink = PPath.createLine(x, y, x, y);//temporary line from connection to mousetip
								layer.addChild(templink);
							}
							else{
								JOptionPane.showMessageDialog(frame, "Er mag maar een lijn per connectie verbonden worden.", "Fout",JOptionPane.ERROR_MESSAGE);
								draw = false;
								n1.setPaint(Color.lightGray);
							}
						}
					}
					else if(removeline){
						for(int i=0; i<links.size();i++){
							Link l = links.get(i);
							if (in == l.getNode1() || in == l.getNode2()){
								l.getNode1().setPaint(Color.lightGray);
								l.getNode2().setPaint(Color.lightGray);
							}
						}
						removeLine(in);
						removeline = false;
					}
				}
				else if(e.getButton()==3){
					removeActions();
					if(n1!=null){
						n1.setPaint(Color.lightGray);
					}
					if(n2!=null){
						n2.setPaint(Color.lightGray);
					}
					in.setPaint(Color.lightGray);
				}
				e.setHandled(true);	
			}
			//when the mouse pointer goes over a connection, the connection will light up 
			// dependant on the current state
			public void mouseEntered(PInputEvent e) {
				if(draw){
					boolean match = false;
					if(n1!=null){
						Link tlink = new Link(null, n1, in);
						if(n1.getName().regionMatches(0, "uit", 0, 3) && in.getName().regionMatches(0, "uit", 0, 3) || !AllowOutputConnection(tlink)){
							match = true;
						}
					}
					if(linePresent(in) || in==n1 || match){
						in.setPaint(Color.RED);
					}
					else{
						in.setPaint(Color.GREEN);
					}
				}
				if(removeline){
					for(int i=0; i<links.size();i++){
						Link l = links.get(i);
						if (in == l.getNode1() || in == l.getNode2()){
							l.getNode1().setPaint(Color.GREEN);
							l.getNode2().setPaint(Color.GREEN);
							l.getPPath().setTransparency((float)0.5);
						}
					}
				}	
			}
			//connection returns to original color when the mouse pointer leaves
			public void mouseExited(PInputEvent e) {
				if (draw){
					in.setPaint(Color.lightGray);
				}
				else if(removeline){
					for(int i=0; i<links.size();i++){
						Link l = links.get(i);
						if (in == l.getNode1() || in == l.getNode2()){
							l.getNode1().setPaint(Color.lightGray);
							l.getNode2().setPaint(Color.lightGray);
							l.getPPath().setTransparency((float)1);
						}
					}
				}
			}
		};
	}
	public void setFrame(int x, int y, int w, int h){
		frame.reshape(x, y, w, h);
	}
	/**
	 * Checks if drawing a {@link Link Link} is allowed
	 * @param l The Link
	 * @return True if allowed
	 */
	public boolean AllowOutputConnection(Link l){
		boolean allow = true;
		LinkSet ls1 = null;
		LinkSet ls2 = null;
		for(LinkSet ls: linksets){
			if(ls.containsSignal(l)){
				if(ls1==null){
					ls1 = ls;
				}else ls2 = ls;
			}
		}
		if(ls1!=null){
			if(ls2==null){
				if(ls1.outputPresent()&&l.outputPresent()){
					if(ls1.getOutput().getOwner()!=l.getOutput().getOwner() || 
							(ls1.getOutput().getOwner()==l.getOutput().getOwner() && ls1.getOutput().getSignal()!=l.getOutput().getSignal())){
						allow = false;
						c1 = ls1.getOutput();
						c2 = l.getOutput();
					}
				}
			}else{
				if(ls1.outputPresent()&&ls2.outputPresent()){
					if(ls1.getOutput().getOwner()!=ls2.getOutput().getOwner() || 
							(ls1.getOutput().getOwner()==ls2.getOutput().getOwner() && ls1.getOutput().getSignal()!=ls2.getOutput().getSignal())){						allow = false;
						allow = false;
						c1 = ls1.getOutput();
						c2 = ls2.getOutput();
					}
				}
			}
		}
		return allow;
	}
	
	/**
	 * Checks if there is a line present in a given {@link Connection Connection}
	 * @param c The Connection
	 * @return True if there is a line present
	 */
	boolean linePresent(Connection c){
		boolean linep = false;
		for(int i=0; i<links.size();i++){
			Link l = links.get(i);
			if (c == l.getNode1() || c == l.getNode2()){
				linep = true;
			}
		}
		return linep;
	}
	
	/**
	 * Eventhandler for a {@link Module Module}
	 * @param mod The module
	 * @return The PBasicInputEventHandler for the module
	 */
	PBasicInputEventHandler module(final Module mod){
	       
		return new PBasicInputEventHandler() {
			// clicked on a module
			public void mousePressed(PInputEvent e) {
				if (e.getButton()==1&&removemodule){
					removeModule(mod);
					removemodule = false;
				}
				else if(e.getButton()==3){
					removeActions();
					mod.setTransparency(1);
				}
				e.setHandled(true);	
			}
			//mouse pointer over a module
			public void mouseEntered(PInputEvent e) {
				if (removemodule){
					mod.setTransparency((float)0.5);
				}	
			}
			//mouse pointer leaves the module
			public void mouseExited(PInputEvent e) {
				mod.setTransparency((float)1);
			}
		};
	}

	public void setPolyLine(PPath ppa, float x1, float y1, float x2, float y2)
	{
		float dx;
		float dy;
		if (x1 > x2)
		{
		    dx = x1 - x2;
		}
		else
		{
		    dx = x2 - x1;
		}

		if (y1 > y2)
		{
		    dy = y1 - y2;
		}
		else
		{
		    dy = y2 - y1;
		}

	  float xa;
		float ya;
		float xb;
		float yb;
		
		if (dx > dy)
		{
		    xa = (x1 + x2)/2;
		    ya = y1;
		    xb = xa;
		    yb = y2;
		}
		else
		{
		    xa = x1;
		    ya = (y1 + y2)/2;
		    xb = x2;
		    yb = ya;
		}
/*
		link.moveTo(x1, y1);
		link.lineTo(xa, ya);
		link.lineTo(xb, yb);
		link.lineTo(x2, y2);
 */
		ppa.setPaint(new Color(0,0,0,0));
		ppa.setStrokePaint(Color.black);
    float xtab[] = { x1, xa, xb, x2 };
    float ytab[] = { y1, ya, yb, y2 };
		ppa.setPathToPolyline(xtab, ytab);
	}

	/**
	 * Draws a line between two {@link Connection Connections}
	 * This method also checks if the Link need zo be put in a {@link LinkSet LinkSet}
	 * @param c1 The first connection
	 * @param c2 The second connection
	 */
	void drawLine(final Connection c1, final Connection c2){
		float x1, y1, x2, y2;
		x1 = (float)(c1.getFullBoundsReference().getCenter2D().getX() + c1.getParent().getFullBounds().getOrigin().getX());
		y1 = (float)(c1.getFullBoundsReference().getCenter2D().getY() + c1.getParent().getFullBounds().getOrigin().getY());
		x2 = (float)(c2.getFullBoundsReference().getCenter2D().getX() + c2.getParent().getFullBounds().getOrigin().getX());
		y2 = (float)(c2.getFullBoundsReference().getCenter2D().getY() + c2.getParent().getFullBounds().getOrigin().getY());
		
		//final PPath link = PPath.createLine(x1, y1, x2, y2);
		final PPath ppa = new PPath();
    setPolyLine(ppa, x1, y1, x2, y2);
    
		layer.addChild(ppa);
		Link lnk = new Link(ppa, c1, c2);
		links.add(lnk);

		LinkSet ls1 = null;
		LinkSet ls2 = null;
		for(LinkSet ls: linksets){
			if(ls.containsSignal(lnk)){
				if(ls1==null){
					ls1 = ls;
				}else ls2 = ls;
			}
		}
		if(ls1!=null){
			if(ls2!=null){//linksets should be merged
				ls1.merge(ls2);
				ls1.addLink(lnk);
				linksets.remove(ls2);
			}else{//add link to linkset 1
				ls1.addLink(lnk);
			}
		}else{//link does not belong to a linkset, create new linkset
			LinkSet ls = new LinkSet();
			ls.addLink(lnk);
			linksets.add(ls);
		}
		ppa.addInputEventListener(new PBasicInputEventHandler() {	
			
			public void mousePressed(PInputEvent e){
				if(removeline&&e.getButton()==1){
					removeLine(c1);
					removeline = false;
					e.setHandled(true);
					c1.setPaint(Color.lightGray);
					c2.setPaint(Color.lightGray);
				}
				else if(e.getButton()==3){
					ppa.setTransparency((float)1);	
					c1.setPaint(Color.lightGray);
					c2.setPaint(Color.lightGray);
				}
			}
			
			public void mouseEntered(PInputEvent e){                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
				if(removeline){
					ppa.setTransparency((float)0.5);
					c1.setPaint(Color.green);
					c2.setPaint(Color.green);
				}
			}
			
			public void mouseExited(PInputEvent e){
				if(removeline){
					ppa.setTransparency((float)1);	
					c1.setPaint(Color.lightGray);
					c2.setPaint(Color.lightGray);
				}
			}
			});
		c1.setPaint(Color.lightGray);
		c2.setPaint(Color.lightGray);
		draw=false;
	}
	
	/**
	 * Update a temporary line that is drawn while connecting two {@link Connection Connections}
	 * @param pp The PPath of the temporary line
	 * @param p The point to where the line needs to be drawn
	 */
	void updateTempLine(PPath pp, Point2D p){
		float x = (float)(n1.getFullBoundsReference().getCenter2D().getX() + n1.getParent().getFullBounds().getOrigin().getX());
		float y = (float)(n1.getFullBoundsReference().getCenter2D().getY() + n1.getParent().getFullBounds().getOrigin().getY());
		Line2D line = new Line2D.Double(x,y,p.getX(),p.getY());
		pp.setPathTo(line);
		pp.moveToBack();
	}
	
	/**
	 * Removes all the lines from a connection
	 * @param c The connection
	 */
	void removeLine(PNode c){
		LinkSet ls = null;
		Link l = null;
		LinkSet ls1 = new LinkSet();
		for(int i=0;i<linksets.size();i++){
			for(int j=0;j<linksets.get(i).getLinks().size();j++){
				if(c==linksets.get(i).getLinks().get(j).getNode1()||c==linksets.get(i).getLinks().get(j).getNode2()){
					ls = linksets.get(i);
					l = ls.getLinks().get(j);
					ls.removeLink(l);
					if(ls.getLinks().size()==0){
						linksets.remove(ls);//remove linkset if it is empty
						ls = null;
						l = null;
					}
					break;
				}
			}
		}
		if(ls!=null){
			Link tlink = null;
			for(Link lnk: ls.getLinks()){
				if(lnk.getNode1().getOwner()==l.getNode1().getOwner() && lnk.getNode1().getSignal()==l.getNode1().getSignal()
						|| lnk.getNode2().getOwner()==l.getNode1().getOwner() && lnk.getNode2().getSignal()==l.getNode1().getSignal()){
					tlink = lnk;
				}
					
			}
			if(tlink!=null){
				ls1.addLink(tlink);
				ls.removeLink(tlink);
				checkForNextLink(ls1, ls, tlink);
			}
			if(ls.getLinks().size()==0){
				linksets.remove(ls);
			}
			linksets.add(ls1);
		}
		for(int i=0; i<links.size();i++){
			Link lnk = links.get(i);
			if (c == lnk.getNode1() || c == lnk.getNode2()){
				layer.removeChild(links.get(i).getPPath());
				links.remove(i);
				removeLine(c);
			}
		}
	}
	/**
	 * Checks if there are links in a {@link LinkSet LinkSet} that are connected with a given {@link Link link} and transfers them
	 * into another {@link LinkSet LinkSet}.
	 * @param ls1 The LinkSet where the links will be put in. 
	 * @param ls2 The LinkSet of the links that need to be checked
	 * @param pl The link that needs to be checked
	 */
	public void checkForNextLink(LinkSet ls1, LinkSet ls2, Link pl){
		for(int i=0;i<ls2.getLinks().size();i++){
			Link lnk = ls2.getLinks().get(i);
			if(lnk.getNode1().getOwner()==pl.getNode1().getOwner() && lnk.getNode1().getSignal()==pl.getNode1().getSignal()
					|| lnk.getNode1().getOwner()==pl.getNode2().getOwner() && lnk.getNode1().getSignal()==pl.getNode2().getSignal()
					|| lnk.getNode2().getOwner()==pl.getNode1().getOwner() && lnk.getNode2().getSignal()==pl.getNode1().getSignal()
					|| lnk.getNode2().getOwner()==pl.getNode2().getOwner() && lnk.getNode2().getSignal()==pl.getNode2().getSignal()){
				
				ls1.addLink(lnk);
				ls2.removeLink(lnk);
				checkForNextLink(ls1, ls2, lnk);
			}
		}
	}
	
	/**
	 * Removes a {@link Module Module}
	 * @param mod The module that needs to be removed.
	 */
	public void removeModule(Module mod){
		for (int i=0; i<modules.size();i++)
		{   if (mod == modules.get(i)){
				ListIterator it =   mod.getChildrenIterator();
				while(it.hasNext()){
					removeLine((PNode)it.next());
				}
				//remove all lines connected with a certain module
				modules.get(i).removeAllChildren();
				layer.removeChild(modules.get(i));
				modules.remove(i);
			}
		}
		//index needs to be adjusted because a modules is removed
		for(int i=0;i<modules.size();i++){
			modules.get(i).setIndex(i);
		}
		index = modules.size()-1;
	}
	
	/**
	 * Sets the last selected {@link ConfModule ConfModule}
	 * @param c The ConfModule
	 */
	public void setSelection(ConfModule c){
		lastselection = c;
	}
	
	/**
	 * Sets drawmodule if a module is being drawn
	 * @param b true or false
	 */
	public void setDrawModule(boolean b){
		drawmodule = b;
	}
	
	/**
	 * Sets removemodule if a module is being removed
	 * @param b true or false
	 */
	public void setRemoveModule(boolean b){
		removemodule = true;
	}
	
	/**
	 * Sets drawline if a line is being drawn
	 * @param b true or false
	 */
	public void setDrawLine(boolean b){
		draw = b; 
	}
	
	/**
	 * Sets removeline if a module is being removed
	 * @param b true or false
	 */
	public void setRemoveLine(boolean b){
		removeline = b;
	}
	
	/**
	 * Sets the filename of this workspace
	 * @param f The filename
	 */
	public void setFilename(String f){
		filename = f;
	}
	
	/**
	 * draws a temporary image, which follows the mouse pointer when a module is being added
	 */
	public void setTempImage()
   {
      URL url = this.getClass().getResource(lastselection.getImage());
		Image image = Toolkit.getDefaultToolkit().getImage(url);
		tempImage = new PImage(image);
		tempImage.setBounds(0,0,65,170);
		tempImage.setTransparency(0);
		layer.addChild(tempImage);
	}
	
	/**
	 * Sets the index of the next modules that needs to be drawn
	 * @param ind the index
	 */
	public void setIndex(int ind){
		index = ind;
	}
	
	/**
	 * remove all actions
	 */
	public void removeActions(){
		draw = false;
		removeline = false;
		removemodule = false;
		pline = false;
		drawmodule = false;
		n1 = null;
		n2 = null;
		if(templink!=null){
			layer.removeChild(templink);
			templink = null;
		}
		if(tempImage!=null){
			layer.removeChild(tempImage);
			tempImage = null;
		}
	}
	
	/**
	 * Gets the {@link Module Modules} in this workspace
	 * @return The ArrayList of Modules
	 */
	public ArrayList<Module> getModules(){
		return modules;
	}
	
	/**
	 * Gets the {@link Link Links} in this workspace
	 * @return The ArrayList of Links
	 */
	public ArrayList<Link> getLinks(){
		return links;
	}
	
	/**
	 * Gets the index of the workspace
	 * @return The index
	 */
	public int getIndex(){
		return index;
	}
	
	/**
	 * Gets the filename of the workspace
	 * @return The filenam
	 */
	public String getFilename(){
		return filename;
	}
	
	/**
	 * Removes a module of this workspace. Can only be used if there are no Links drawn.
	 * @param name The name of the module that needs to be removed
	 */
	public void removeModule(String name){
		Module m = null;
		for(Module mod: modules){
			if(mod.getName().matches(name)){
				m = mod;
				break;
			}
		}
		if(m!=null){
			layer.removeChild(m);
			modules.remove(m);
		}
	}
	
	/**
	 * Sets this workspace selected
	 * @param b true or false
	 */
	public void setSelected(boolean b){
		try{
			frame.setSelected(b);
		}catch(PropertyVetoException pve){}
	}
	
	/**
	 * Sets the title of this workspace
	 * @param s The title
	 */
	public void setTitle(String s){
		s = s.substring(s.lastIndexOf("\\")+1,s.lastIndexOf("."));//absolute path + .txt out of string
		frame.setTitle(s);
	}
}
