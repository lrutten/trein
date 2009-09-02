package be.khlim.trein.modules;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JOptionPane;

import edu.umd.cs.piccolo.nodes.PPath;
import edu.umd.cs.piccolo.nodes.PText;

import be.khlim.trein.gui.Event;
import be.khlim.trein.modules.conf.ConfModule;

public class Teller extends Module
{
	private int count;
	private int countstart;
	private boolean countdown = false;
	private PText pt;

	public Teller(ConfModule cmod)
   {
		super(cmod);
		for(Output out : getOutputs())
      {
			out.setDelay(0L);
		}
		pt = new PText();
	}

	public void process(Event evt)
   {
		setInputs(evt.getInput());
		if(evt.getInput().getName().endsWith("start"))
      {
			if(evt.getInput().getState())
         {
				countdown = true;
				writeOutputs(false, outputs.get(0).getSignal());
			}
		}
		else if(evt.getInput().getName().endsWith("klok"))
      {
			if(evt.getInput().getState() && countdown)
         {
				count--;
				setText();
				if(count <= 0)
            {
					countdown = false;
					count = countstart;
					setText();
					writeOutputs(true, outputs.get(0).getSignal());
				}
			}
		}
	}
	
	void setText()
   {
		if(count==15)
      {
			pt.setText("F");
		}
      else if(count==14)
      {
			pt.setText("E");
		}
      else if(count==13)
      {
			pt.setText("D");
		}
      else if(count==12)
      {
			pt.setText("C");
		}
      else if(count==11)
      {
			pt.setText("B");
		}
      else if(count==10)
      {
			pt.setText("A");
		}
      else if(count==9)
      {
			pt.setText("9");
		}
      else if(count==8)
      {
			pt.setText("8");
		}
      else if(count==7)
      {
			pt.setText("7");
		}
      else if(count==6)
      {
			pt.setText("6");
		}
      else if(count==5)
      {
			pt.setText("5");
		}
      else if(count==4)
      {
			pt.setText("4");
		}
      else if(count==3)
      {
			pt.setText("3");
		}
      else if(count==2)
      {
			pt.setText("2");
		}
      else if(count==1)
      {
			pt.setText("1");
		}
      else if(count==0)
      {
			pt.setText("0");
		}
	}
	
	public void initialize()
   {
		writeOutputs(true, outputs.get(0).getSignal());

		//setImage(getModImage().replaceAll(".j", "_sim.j"));
      URL url = this.getClass().getResource(getModImage().replaceAll(".j", "_sim.j"));
      Image im = Toolkit.getDefaultToolkit().getImage(url);
      setImage(im);

		setBounds(getX(),getY(),65,170);
		String countS = null;
		PPath p = new PPath();
		p.setPathToRectangle((float)getX(), (float)getY(), (float)65, (float)170);
		p.setPaint(Color.orange);
		p.setTransparency((float)0.2);
		addChild(p);
		count = -1;
		countS = JOptionPane.showInputDialog("Geef de waarde voor de aangeduide teller (0-F of 0-15)", 0);
		if(countS != null)
      {
			if(countS.matches("A") || countS.matches("a"))
         {
				count = 10;
			}
         else if(countS.matches("B") || countS.matches("b")){
				count = 11;
			}
         else if(countS.matches("C") || countS.matches("c")){
				count = 12;
			}
         else if(countS.matches("D") || countS.matches("d")){
				count = 13;
			}
         else if(countS.matches("E") || countS.matches("e")){
				count = 14;
			}
         else if(countS.matches("F") || countS.matches("f")){
				count = 15;
			}
         else
         {
            try
            {
				count = Integer.valueOf(countS);	
            }
            catch (NumberFormatException n)
            {
               JOptionPane.showMessageDialog(sim(), "Geen geldige waarde", "Fout", JOptionPane.ERROR_MESSAGE);
               removeChild(p);
               initialize();
            }
         }
         if(count<0 || count >15)
         {
            JOptionPane.showMessageDialog(sim(), "Geen geldige waarde", "Fout", JOptionPane.ERROR_MESSAGE);
            removeChild(p);
            initialize();
         }
         else
         {
            countstart = count;
            try
            {
               removeChild(p);
            }
            catch (ArrayIndexOutOfBoundsException a)
            {
            }
            Font f = new Font(null, Font.PLAIN, 35);
            setText();
            pt.setBounds(35, 78, 50, 50);
            pt.setFont(f);
            addChild(pt);
         }
      }
      else
      {
         JOptionPane.showMessageDialog(sim(), "Er moet een waarde toegekend worden aan de teller", "Fout", JOptionPane.ERROR_MESSAGE);
         removeChild(p);
         initialize();
      }	
   }
}
