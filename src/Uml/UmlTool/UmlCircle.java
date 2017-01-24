package Uml.UmlTool;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Uml.Uml;
import UmlOption.UmlOptionActor;
import UmlOption.UmlOptionCircle;
import WindowUml.PanelCenter;

/**
 *  Author yacine
 *  * This  class represent a Circle use case
 */
public class UmlCircle extends Uml {
		
	private static final long serialVersionUID = 1L;

	private JButton circle=null;
	private JLabel s = new JLabel("Information");
	public UmlCircle(PanelCenter parent) {
		super(parent);
		this.setSize(150,150);	
		this.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) { 
		    	  if(e.getClickCount()==2){
		             new UmlOptionCircle(s);  
		         }
		    }
		});
		
	}
	  @Override
	    public void paint(Graphics g) {
		      g.drawOval(0, 0,140, 50);
		      g.drawString(s.getText(),25,25);
	  }
	  
	 public String getTitle()
	 {
		 return circle.getText();
	 }

}
