package Uml.UmlTool;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import Uml.Uml;
import UmlOption.UmlOptionUseCase;
import WindowUml.PanelCenter;

public class UmlRectangle extends Uml {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel labelRectangle = new JLabel ("Rectangle");	
	
	public UmlRectangle(PanelCenter panel) {
		super(panel);
		this.setSize(150,110);
		this.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) { 
		    	  if(e.getClickCount()==2){
		             new UmlOptionUseCase(labelRectangle);  
		         }
		    }
		});
}
	
	  @Override
	    public void paint(Graphics g) {
		  g.drawRect (0,0, 149,109); 
		  g.drawString(labelRectangle.getText(),12,54);
	  }
	  
	  
		 public String getTitle()
		 {
			 return labelRectangle.getText();
		 }

}
