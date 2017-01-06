package WindowUml;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import Uml.Uml;
import Uml.UmlTool.EnumRelation;
import Uml.UmlTool.UmlRelation;

/**
*Author Yacine
*This class represent a Panel center, in this, we can add a component Uml etc ... , and be dragged it
*/
public class PanelCenter extends JPanel{
	
	private static final long serialVersionUID = 1L;
public ArrayList<UmlRelation> relation = new ArrayList<UmlRelation>();

	public PanelCenter(){
		super();
		
		this.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) { 
		    	  if(e.getClickCount()==2){ 
		    	   Component panel = (Component)e.getSource();
		    	   System.out.println(panel.getName());
		              if(relation != null){
		            	  System.out.println("sss");
		              }
		         }
		    }
		});
	}
	
	public  void addDraw(Uml uml1, Uml uml2,EnumRelation typeRelation) {
		relation.add(new UmlRelation(uml1,uml2,typeRelation));
        repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		  super.paintComponent(g);
		   for (UmlRelation e : relation) {
	            e.draw(g);
	        }
		}
}



