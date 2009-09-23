package be.khlim.trein.gui;

/*
  $Date$ 
  $Revision$ 
  $Author$
 */
 
// imports necessary to read the XML files
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PushbackInputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.reflection.PureJavaReflectionProvider;

import be.khlim.trein.modules.*;
import be.khlim.trein.modules.conf.*;
// imports for creating the GUI
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
//import javax.swing.event.InternalFrameAdapter;
//import javax.swing.event.InternalFrameEvent;
import javax.swing.filechooser.FileFilter;

/**
 * This is the main class of the program
 */
public class Simulator extends JFrame
{
	private ArrayList<ConfModule> modules = new ArrayList<ConfModule>();
	private ArrayList<Workspace> workspaces = new ArrayList<Workspace>();
	
	private JDesktopPane desk;
	private JInternalFrame frame; // internal frame to show list of modules
	private JInternalFrame frameB;// internal frame for buttons
	private int framenr=0;
	private int activeWorkspace = 0;
	private static Simulator main;
	
	private ConfModule train;
	private ConfModule motherboard;
	
	/** constructor
	 * 		create main window
	 */
	public Simulator()
   {
		main = this;
		
	// making main frame
		
		try {
			  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e) {}
		setTitle ("Simulator IR13");
		setSize(1200,600);

		// show icon
      URL url = this.getClass().getResource("/figures/logo_IR13.gif");
   	Image image = Toolkit.getDefaultToolkit().getImage(url);
      setIconImage(image);

		desk = new JDesktopPane();
		desk.setBackground(Color.LIGHT_GRAY);
		setContentPane(desk);

					//menu items
		JMenuItem open = new JMenuItem("Open");
		open.setAccelerator(KeyStroke.getKeyStroke('O', java.awt.event.InputEvent.CTRL_MASK, false));
		open.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				load();
			}
		});
		JMenuItem nieuw = new JMenuItem("Nieuw");
		nieuw.setAccelerator(KeyStroke.getKeyStroke('N', java.awt.event.InputEvent.CTRL_MASK, false));
		nieuw.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				framenr++;
				workspaces.add(new Workspace(framenr));
				workspaces.get(workspaces.size()-1).setSelected(true);
			}
		});
		JMenuItem opslaan = new JMenuItem("Opslaan");
		opslaan.setAccelerator(KeyStroke.getKeyStroke('S', java.awt.event.InputEvent.CTRL_MASK, false));
		opslaan.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				save();
			}
		});
		JMenuItem opslaanAls = new JMenuItem("Opslaan als");
		opslaanAls.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				saveAs();
			}
		});

		JMenuItem sluiten = new JMenuItem("Sluiten");
		sluiten.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{ System.exit(0); }
		});

		JMenuItem afdrukken = new JMenuItem("Afdrukken");
		afdrukken.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{ 
			   System.out.println("Afdrukken");
			   print();
			}
		});


		JMenuItem drawLM = new JMenuItem("Teken lijn");
		drawLM.setAccelerator(KeyStroke.getKeyStroke("F5"));
		drawLM.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				drawLine();
			}
		});
		JMenuItem removeLM = new JMenuItem("Verwijder lijn");
		removeLM.setAccelerator(KeyStroke.getKeyStroke("F6"));
		removeLM.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				removeLine();
			}
		});
		JMenuItem removeMM = new JMenuItem("Verwijder module");
		removeMM.setAccelerator(KeyStroke.getKeyStroke("F7"));
		removeMM.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				removeModule();
			}
		});
		JMenuItem runM = new JMenuItem("Simuleer");
		runM.setAccelerator(KeyStroke.getKeyStroke("F8"));
		runM.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				simulate();
			}
		});
		JMenuItem cascade = new JMenuItem("Trapsgewijs");
		cascade.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				cascade();
			}
		});
		JMenuItem tile = new JMenuItem("volledig scherm");
		tile.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				tile();
			}
		});
		JMenuItem horizontal = new JMenuItem("naast elkaar");
		horizontal.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				horizontal();
			}
		});
		JMenuItem vertical = new JMenuItem("onder elkaar");
		vertical.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				vertical();
			}
		});

		JMenuItem over = new JMenuItem("over Simulator IR13...");
		over.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				// actie
				JOptionPane.showMessageDialog(main, "Simulator IR13 versie 22/ 9/2009, auteurs: Wouter Rutten, Leo Rutten, Mitch Vanhelden");

			}
		});

		
				// make menubar
		JMenuBar menubar = new JMenuBar();
		
		JMenu bestand = new JMenu("Bestand");
			bestand.add(open);
			bestand.add(nieuw);
			bestand.addSeparator();
			bestand.add(opslaan);
			bestand.add(opslaanAls);
			bestand.add(afdrukken);
			bestand.addSeparator();
			bestand.add(sluiten);
		JMenu bewerken = new JMenu("Bewerken");
			bewerken.add(runM);
		JMenu workspace = new JMenu("Workspace");
			workspace.add(drawLM);
			workspace.add(removeLM);
			workspace.add(removeMM);
		JMenu rangschik = new JMenu("rangschikken");
			rangschik.add(cascade);
			rangschik.add(tile);
			rangschik.add(horizontal);
			rangschik.add(vertical);
		JMenu beeld = new JMenu("Beeld");
			beeld.add(rangschik);
			
		JMenu help = new JMenu("Help");
			help.add(over);
			
				// add to menubar
		menubar.add(bestand);
		menubar.add(bewerken);
		menubar.add(workspace);
		menubar.add(beeld);
		menubar.add(help);
		
		//internal frame for buttons
		frameB = new JInternalFrame("Werkbalk", true, false, false, false);
      
      //System.out.println("start");
         //System.out.println("start2" + getClass());
      URL url2 = this.getClass().getResource("/figures/logo_IR13.gif");
         //System.out.println("start3 " + url2);
      ImageIcon imageB = new ImageIcon(Toolkit.getDefaultToolkit().getImage(url2));
         //System.out.println("start4");
      frameB.setFrameIcon(imageB);
      //System.out.println("start5");
      frameB.setLayer(2);
		frameB.setBounds(0, 0, 500, 60);
		frameB.setVisible(true);
		JDesktopPane deskt = new JDesktopPane();
		frameB.setContentPane(deskt);
		deskt.setLayout(new GridLayout(1,4));
		JButton drawL = new JButton("Teken lijn");
		drawL.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				drawLine();
			}
		});
		JButton removeL = new JButton("Verwijder lijn");
		removeL.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				removeLine();
			}
		});
		JButton drawM = new JButton("Verwijder module");
		drawM.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				removeModule();
			}
		});
		JButton run = new JButton("Simuleer");
		run.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				simulate();
			}
		});
		frameB.add(drawL);
		frameB.add(removeL);
		frameB.add(drawM);
		frameB.add(run);
		desk.add(frameB);
				
		setJMenuBar(menubar);
		setExtendedState(JFrame.MAXIMIZED_BOTH); //maximize frame
		setVisible(true); // show main frame
		// close when clicked on cross symbol
		addWindowListener	(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				dispose();
				System.exit(0);
			}
		});
		makeModules(); // show list of possible modules in internalFrame
	}
	
	/**
	 * Sets drawline true in the active workspace
	 */
	public void drawLine(){
		workspaces.get(activeWorkspace).removeActions();
		workspaces.get(activeWorkspace).setDrawLine(true);
	}
	
	/**
	 * Sets removeline true in the active workspace
	 */
	public void removeLine(){
		workspaces.get(activeWorkspace).removeActions();
		workspaces.get(activeWorkspace).setRemoveLine(true);
	}
	
	/**
	 * Sets dremovemodule true in the active workspace
	 */
	public void removeModule(){
		workspaces.get(activeWorkspace).removeActions();
		workspaces.get(activeWorkspace).setRemoveModule(true);
	}
	
	/**
	 * Sets the number of the active workspace
	 * @param i The number of the last active workspace
	 */
	public void setWorkspace(int i)
	{
		activeWorkspace = i;
	}


   public void print()
   {
      System.out.println("workspace:" + activeWorkspace);
      Workspace active = null;

      if (workspaces.size() > 0)
      {
         active = workspaces.get(activeWorkspace);
         if (active != null)
         {
            System.out.println("print workspace");
            active.print();
         }
      }
  }

	public void cascade(){
		for(int i=0; i<workspaces.size(); i++){
			workspaces.get(i).setFrame(i*15, 60+(15*i-10), 700, 500);
		}
	}
	
	public void tile(){
		int number = desk.getAllFrames().length - 2;
		
		int sqrt = (int) (Math.sqrt(number));
		int rows = sqrt;
		int cols = sqrt;
		if(rows*cols < number){
			cols++;
			if(rows*cols < number){
				rows++;
			}
		}
		
		Dimension size = desk.getSize();
		int w = size.width/cols;
		int h = size.height/rows;
		int x = 0;
		int y = 0;

		int counter = 0;
		for(int i=0; i<rows; i++){
			for(int j=0; (j<cols) && (counter < workspaces.size()); ){
				if(! workspaces.get(counter).getFrame().isClosed()){
					workspaces.get(counter).setFrame(x, y, w, h);
					x += w;
					j++;
				}
				counter++;
			}
			y += h;
			x = 0;
		}
	}
	
	public void horizontal(){
		int number = desk.getAllFrames().length - 2;
		
		Dimension size = desk.getSize();
		int w = size.width/number;
		int h = size.height;
		int x = 0;
		int y = 0;
		
		for(int counter=0; counter < workspaces.size(); counter++){
			if(! (workspaces.get(counter).getFrame().isClosed()
					||workspaces.get(counter).getFrame().isIcon())){
				workspaces.get(counter).setFrame(x, y, w, h);
				x += w;
			}
		}
	}
	
	public void vertical(){
		int number = desk.getAllFrames().length - 2;
		
		Dimension size = desk.getSize();
		int w = size.width;
		int h = size.height/number;
		int x = 0;
		int y = 0;
		
		for(int counter=0; counter < workspaces.size(); counter++){
			if(! workspaces.get(counter).getFrame().isClosed()){
				workspaces.get(counter).setFrame(x, y, w, h);
				y += h;
			}
		}
	}
	
	/**
	 * Returns the main class
	 * @return The main class
	 */
	static public Simulator getSimulator(){
		
		if (main == null){
			System.out.println("ERROR: no new simulator is made");
			//sim = this;
		}
		
		return main;
	}
	
	/**
	 * Adds an internal frame to the JDesktopPane
	 * @param f The frame that needs to be added
	 */
	public void addFrame(JInternalFrame f){
		desk.add(f);
		f.setLayer(1);
	}
	
	/** making an internal frame
	 * 		a list will be shown of all possible modules,
	 * 		so it is possible to select one of the modules.
	 */
	public void makeModules(){
		
		frame = new JInternalFrame("modules ", true, false, false, false);

      URL url = this.getClass().getResource("/figures/logo_IR13.gif");
		ImageIcon image = new ImageIcon(Toolkit.getDefaultToolkit().getImage(url));
        frame.setFrameIcon(image);
		JDesktopPane deskt = new JDesktopPane();
		frame.setContentPane(deskt);
		frame.setLayer(2);

		XStream xstream = new XStream(new PureJavaReflectionProvider());
		//aliases for reading the XML files
		xstream.alias("module", ConfModule.class);
		xstream.alias("output", ConfOutput.class);
		xstream.alias("input", ConfInput.class);
		
		readConfModule("/XML/drukknop.xml", xstream);
		readConfModule("/XML/schakelaar.xml", xstream);
		readConfModule("/XML/NIET-poort.xml", xstream);
		readConfModule("/XML/EN-poort.xml", xstream);
		readConfModule("/XML/OF-poort.xml", xstream);
		readConfModule("/XML/lichtsensor.xml", xstream);
		readConfModule("/XML/magneetschakelaar.xml", xstream);
		readConfModule("/XML/botsingssensor.xml", xstream);
		readConfModule("/XML/wachtmodule.xml", xstream);
		readConfModule("/XML/zoemer.xml", xstream);
		readConfModule("/XML/flip-flop.xml", xstream);
		readConfModule("/XML/klok.xml", xstream);
		readConfModule("/XML/teller.xml", xstream);
		//add another readConfModule method here if a new module needs to be added
		
		try
      {
         /*
		   InputStream readIn = (InputStream) (new FileInputStream("/XML/trein.xml"));
		   train = (ConfModule)(xstream.fromXML(readIn));
		   readIn = (InputStream) (new FileInputStream("/XML/moederbord.xml"));
		   motherboard = (ConfModule)(xstream.fromXML(readIn));
         */

         InputStream is = this.getClass().getResourceAsStream("/XML/trein.xml");
		   train = (ConfModule)(xstream.fromXML(is));
         is = this.getClass().getResourceAsStream("/XML/moederbord.xml");
		   motherboard = (ConfModule)(xstream.fromXML(is));
		}
		catch(NullPointerException e){}
		//catch(IOException ioe){}
		
		deskt.setLayout(new GridLayout(modules.size(),1));
		
		///create buttons
		for(int i = 0; i < modules.size();i++){
			JButton button;

			Object o = modules.get(i).getImageIcon();
      System.out.println("o " +o + o.getClass().toString());

      Object o2 = new ImageIcon(modules.get(i).getImageIcon());
      System.out.println("o2 " + o2 + o2.getClass().toString());
      
			frame.add(button = new JButton((modules.get(i)).getName(), new ImageIcon((modules.get(i)).getImageIcon())));
			button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt)
				{	for(int j = 0; j < modules.size(); j++){
						if (evt.getActionCommand() == modules.get(j).getName()){
							// stop all active activities, so drawing is possible
							if(workspaces.size()!=0){
								for (int k = 0; k < workspaces.size(); k++){
									workspaces.get(k).removeActions();
								}
								workspaces.get(activeWorkspace).setDrawModule(true);
								workspaces.get(activeWorkspace).setSelection(modules.get(j));
								workspaces.get(activeWorkspace).setTempImage();
								for (int k = 0; k < workspaces.size(); k++){
									if(k!=activeWorkspace){
										workspaces.get(k).setDrawModule(false);
									}
								}
							}
							break;
						}
					}
				}
			});
		}
		desk.add(frame);
		frame.setBounds(800, 70, 200, 500);
		frame.setVisible(true);
	}
	
	/**
	 * Creates a {@link ConfModule ConfModule} from a given XML file using XStream.
	 * @param location The location of the XML file
	 * @param x The XStream object
	 */
	private void readConfModule(String location, XStream x){
		
		try
      {
         InputStream is = this.getClass().getResourceAsStream(location);
         System.out.println("is " + is);
			//InputStream readIn = (InputStream) (new FileInputStream(location));
			//ConfModule mod = (ConfModule)(x.fromXML(readIn));
			ConfModule mod = (ConfModule)(x.fromXML(is));
			modules.add(mod);
		}
		catch(NullPointerException e){}
		//catch(IOException ioe){}
	}
	
	/**
	 * Saves a {@link Workspace Workspace}
	 */
	public void save(){
		if (workspaces.get(activeWorkspace).getFilename() == null){
			saveAs();
		} else { write(workspaces.get(activeWorkspace).getFilename());}
	}
	
	/**
	 * Saves a {@link Workspace Workspace} and asks the path where it needs to be saved.
	 */
	public void saveAs(){
		JFileChooser chooser = new JFileChooser();
		String filename = null;
				
		FileFilter filter = new TxtFilter();
	    chooser.setFileFilter(filter);
		
		int retval = chooser.showSaveDialog(this);
		if(retval == JFileChooser.APPROVE_OPTION) {
		    File theFile = chooser.getSelectedFile();
		    if(theFile != null) {
		    	if(theFile.isDirectory()) {
		    		filename = chooser.getSelectedFile().getAbsolutePath() + "naamloos" + activeWorkspace + ".txt";
		    	} else {
		    		if (Utils.getExtension(chooser.getSelectedFile()).equals(Utils.txt)){
		    				filename = chooser.getSelectedFile().getAbsolutePath();	
		    		} else { filename = chooser.getSelectedFile().getAbsolutePath() + ".txt";}
				}
		    }
		} 	
		if (filename != null){
			workspaces.get(activeWorkspace).setFilename(filename);
			write(filename);
		}
	}

	/**
	 * Writes the active {@link Workspace Workspace} to a file
	 * @param filename The filename of the workspace
	 */
	public void write(String filename){
		FileOutputStream out; // declare a file output object
		PrintStream p; // declare a print stream object
		workspaces.get(activeWorkspace).setTitle(filename);	
		try{
			out = new FileOutputStream(filename);
			// Connect print stream to the output stream
			p = new PrintStream(out);
			double x,y;
			int index, index1, index2;
			ArrayList<Module> modules = workspaces.get(activeWorkspace).getModules();
			ArrayList<Link> links = workspaces.get(activeWorkspace).getLinks();
			for(int i=0;i<modules.size();i++){
				x = modules.get(i).getFullBoundsReference().getX();
				y = modules.get(i).getFullBoundsReference().getY();
				index = modules.get(i).getIndex();
				//name/index/x-position/y-position
				p.println (modules.get(i).getName() + " " + index + " " + x + " " + y);
			}
			p.println("links");
			for(int i=0;i<links.size();i++){
				String connection1 = ((Connection)links.get(i).getNode1()).getName();
				String connection2 = ((Connection)links.get(i).getNode2()).getName();
				index1 = ((Module)links.get(i).getNode1().getParent()).getIndex();
				index2 = ((Module)links.get(i).getNode2().getParent()).getIndex();
				//name 1st connection/index module 1st connection/name 2nd connection/index module 2nd connection
				p.println(connection1 + " " + index1 + " " + connection2 + " " + index2);
			}
			p.println("end");
			p.close();
		}
		catch (Exception e){
			System.err.println ("Error writing to file");
		}
	}
	
	/**
	 * Loads a {@link Workspace Workspace}
	 */
	public void load() {
		JFileChooser chooser = new JFileChooser();
		String filename = null;
				
		FileFilter filter = new TxtFilter();
	    chooser.setFileFilter(filter);
		
		int retval = chooser.showOpenDialog(this);
		if(retval == JFileChooser.APPROVE_OPTION) {
		    File theFile = chooser.getSelectedFile();
		    if(theFile != null) {
		    	if(theFile.isFile()) {
		    		if (Utils.getExtension(chooser.getSelectedFile()).equals(Utils.txt)){
		    				filename = chooser.getSelectedFile().getAbsolutePath();
		    				
		    				framenr++;
		    				workspaces.add(new Workspace(framenr));
		    				workspaces.get(framenr-1).setTitle(filename);
		    				workspaces.get(framenr-1).setSelected(true);
   			      		    workspaces.get(framenr-1).removeModule("trein");
   			      		    workspaces.get(framenr-1).removeModule("moederbord");
		    				workspaces.get(framenr-1).setFilename(filename);
		    				try
		    			      {  FileInputStream in = new FileInputStream(filename);
		    			      	 PushbackInputStream pbin = new PushbackInputStream(in);
		    			      	 String name1 = "";
		    			      	 int index1, index2;
		    			      	 while(name1!="links"){
		    			      		 name1 = readString(pbin);
		    			      		 if (name1.matches("links")) break;
		    			      		 ConfModule cmod = selectModule(name1);
		    			      		 index1 = readInt(pbin);
		    			      		 double x = readDouble(pbin);
		    			      		 double y = readDouble(pbin);
		    			      		 Point2D.Double p = new Point2D.Double(x,y);
		    			      		 workspaces.get(framenr-1).readModule(cmod, p, index1);
		    			      	 }
		    			      	 String name2 = "";
		    			      	 while(name1!="end"){
		    			      		name1 = readString(pbin);
		    			      		if (name1.matches("end")) break;
		    			      		index1 = readInt(pbin);
		    			      		name2 = readString(pbin);
		    			      		index2 = readInt(pbin);
		    			      		Module mod1 = null;
		    			      		Module mod2 = null;
		    			      		Connection c1 = null;
		    			      		Connection c2 = null;
		    			      		for(int i=0;i<workspaces.get(framenr-1).getModules().size();i++){
		    			      			if(index1==workspaces.get(framenr-1).getModules().get(i).getIndex()){
		    			      				mod1 = workspaces.get(framenr-1).getModules().get(i);
		    			      			}
		    			      			if(index2==workspaces.get(framenr-1).getModules().get(i).getIndex()){
		    			      				mod2 = workspaces.get(framenr-1).getModules().get(i);
		    			      			}
		    			      		}
		    			      		if (name1.regionMatches(0, "in", 0, 2)){
	    			      				for(int j=0;j<mod1.getInputs().size();j++){
	    			      					if(mod1.getInputs().get(j).getName().matches(name1)){
	    			      						c1 = mod1.getInputs().get(j);
	    			      						break;
	    			      					}
	    			      				}
	    			      			}
	    			      			else if(name1.regionMatches(0, "uit", 0, 3)){
	    			      				for(int j=0;j<mod1.getOutputs().size();j++){
	    			      					if(mod1.getOutputs().get(j).getName().matches(name1)){
	    			      						c1 = mod1.getOutputs().get(j);
	    			      						break;
	    			      					}
	    			      				}
	    			      			}
		    			      		if (name2.regionMatches(0, "in", 0, 2)){
    			      					for(int j=0;j<mod2.getInputs().size();j++){
    			      						if(mod2.getInputs().get(j).getName().matches(name2)){
    			      							c2 = mod2.getInputs().get(j);
    			      							break;
    			      						}
    			      					}
    			      				}
    			      				else if(name2.regionMatches(0, "uit", 0, 3)){
    			      					for(int j=0;j<mod2.getOutputs().size();j++){
    			      						if(mod2.getOutputs().get(j).getName().matches(name2)){
    			      							c2 = mod2.getOutputs().get(j);
    			      							break;
    			      						}
    			      					}
    			      				}
		    			      		workspaces.get(framenr-1).drawLine(c1, c2);
		    			      	 }
		    			      	 for(int i=0;i<workspaces.get(framenr-1).getModules().size();i++){
		    			      		workspaces.get(framenr-1).getModules().get(i).setIndex(i);
		    			      	 }
		    			      	 workspaces.get(framenr-1).setIndex(workspaces.get(framenr-1).getModules().size()-1);
		    			      }
		    			      catch(IOException ioe){ System.out.println("error inlezen bestand");}
		    				
		    		} 	else { 
		    				JOptionPane.showMessageDialog(this, "gekozen bestand is geen tekstbestand", "FOUT", JOptionPane.ERROR_MESSAGE ); 
		    			}
				}	
		    }
		} 	
	}
	
	/**
	 * Reads a char from a PushBackInputStream
	 * @param pbin The PushBackInputStream
	 * @return The char that is read
	 */
	public char readChar(PushbackInputStream pbin){
		int ch=0;
	    try{
	    	ch = pbin.read();
	    }
	    catch(IOException ioe){}
	    return (char)ch;
	}
	
	/**
	 * Reads a String from a PushBackInputStream
	 * @param pbin The PushBackInputStream
	 * @return The String that is read
	 */
	public String readString(PushbackInputStream pbin){
		char ch;
		String s = "";
		do 
 		{  ch = readChar(pbin);
 		}  while (Character.isWhitespace(ch));
		s = s + ch;
		for (;;){
			ch = readChar(pbin);
 		 	if (Character.isWhitespace(ch)) break;
 		 	s = s + ch;
 		 }
		return s;
	}
	
	/**
	 * Reads a double from a PushBackInputStream
	 * @param pbin The PushBackInputStream
	 * @return The double that is read
	 */
	public double readDouble(PushbackInputStream pbin){
		boolean neg = false;
		char ch;
 		do 
 		{  ch = readChar(pbin);
 		}  while (Character.isWhitespace(ch));
 		if (ch == '-'){
 			neg = true; 
 			ch = readChar(pbin);
 		}
 		double x = ch - '0';
 		int nDec = -1;
 		for (;;){
 			ch = readChar(pbin);
            if (Character.isDigit(ch)){
            	x = 10 * x + (ch - '0');
               if (nDec >= 0) nDec++;
            }
            else
       	     if (ch == '.' && nDec == -1) nDec = 0;
       	     else break;
            while (nDec > 0){
            	x *= 0.1; nDec--;
            }
        }
 		return (neg ? -x : x);
	}
	
	/**
	 * Reads a int from a PushBackInputStream
	 * @param pbin The PushBackInputStream
	 * @return The int that is read
	 */
	public int readInt(PushbackInputStream pbin){
		char ch;
		do 
 		{  ch = readChar(pbin);
 		}  while (Character.isWhitespace(ch));
 		int i = ch - '0';
 		for (;;){
 			ch = readChar(pbin);
 		 	if (!Character.isDigit(ch)) break;
 		 	i = 10 * i + (ch - '0');
 		}
 		return i;
	}
	
	/**
	 * Gets the {@link ConfModule ConfModule} of the train
	 * @return The train
	 */
	public ConfModule getTrain(){
		return train;
	}
	
	/**
	 * Gets the {@link ConfModule ConfModule} of the motherboard
	 * @return The motherboard
	 */
	public ConfModule getMotherboard(){
		return motherboard;
	}
	
	/**
	 * Searches for a {@link ConfModule ConfModule} in the ConfModules available
	 * @param name The name of the ConfModule that needs to be found
	 * @return The {@link ConfModule ConfModule} that is found, returns null if the ConfModule is not found
	 */
	public ConfModule selectModule(String name){
		ConfModule cmod = null;
		boolean error = true;
		if(name.matches("trein")){
			cmod = train;
			error = false;
		}
		else if(name.matches("moederbord")){
			cmod = motherboard;
			error = false;
		}
		else{
			for(int i=0;i<modules.size();i++){
				if (name.matches(modules.get(i).getName())){
					cmod = modules.get(i);
					error = false;
					break;
				}
			}
		}
		if (error)JOptionPane.showMessageDialog(this, "Fout inlezen bestand.", "Fout",JOptionPane.ERROR_MESSAGE);
		return cmod;
	}
	
	/**
	 * Starts the simulation of the last active workspace
	 */
	public void simulate()
   {
		new Run(workspaces.get(activeWorkspace).getModules(), workspaces.get(activeWorkspace).getLinks());
	}
	
	/**
	 * The main method
	 * @param args
	 */
	public static void main (String args[])
   {
		new Simulator();
	}
}
