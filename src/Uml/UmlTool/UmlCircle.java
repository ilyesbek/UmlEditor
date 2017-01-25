package Uml.UmlTool;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import Uml.Uml;
import UmlOption.UmlOptionCircle;
import WindowUml.PanelCenter;

/**
 *  Author yacine
 *  * This  class represent a Circle use case
 */
public class UmlCircle extends Uml {
		
	private static final long serialVersionUID = 1L;

	private JLabel s = new JLabel("Information");
	public UmlCircle(PanelCenter parent) {
		super(parent);
		this.setSize(150,51);
		this.setBorder(BorderFactory.createLineBorder(Color.white));

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
		 return s.getText();
	 }

}
