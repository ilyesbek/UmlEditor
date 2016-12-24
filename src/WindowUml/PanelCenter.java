package WindowUml;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import Uml.UmlEntityClass;
import Uml.UmlRelation;

public class PanelCenter extends JPanel{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public ArrayList<UmlRelation> relation = new ArrayList<UmlRelation>();

	public PanelCenter(){
		super();
	}
	
	public  void addDraw(UmlEntityClass umlClass1, UmlEntityClass umlClass2) {
		relation.add(new UmlRelation(umlClass1,umlClass2));
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



