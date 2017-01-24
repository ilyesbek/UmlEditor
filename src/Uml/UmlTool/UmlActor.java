package Uml.UmlTool;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Uml.Uml;
import UmlOption.UmlOptionActor;
import WindowUml.PanelCenter;

/**
 *  Author yacine
 *  * This  class represent a Actor use case
 */

public class UmlActor extends Uml{

	private static final long serialVersionUID = 1L;
	private JLabel labelTitle = new JLabel ("Acteur");	
  private JLabel labelImageActor =new JLabel(new ImageIcon(getClass().getClassLoader()	    		   
            .getResource("image/stigman.png")));
    
       
	public UmlActor(PanelCenter parent) {
		super(parent);
		this.setBorder(BorderFactory.createLineBorder(Color.white));
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(labelImageActor);
		this.add(labelTitle);
		this.setSize(107,110);		

		this.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) { 
		    	  if(e.getClickCount()==2){
		             new UmlOptionActor(labelTitle);  
		         }
		    }
		});
				
			
	}
	 public String getTitle()
	 {
		 return labelTitle.getText();
	 }
}