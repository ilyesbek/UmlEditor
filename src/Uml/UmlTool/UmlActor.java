package Uml.UmlTool;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Uml.Uml;
import UmlOption.UmlOptionUseCaseActor;
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
		             new UmlOptionUseCaseActor(labelTitle);  
		         }
		    }
		});
				
			
	}
	 public String getTitle()
	 {
		 return labelTitle.getText();
	 }
}