/**
 * 
 */
package Uml;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import UmlOption.UmlOptionUseCase;
import WindowUml.PanelCenter;

/**
 * @author Yacine
 * This  class represent a rectangle use case
 */

public class UmlUseCase extends Uml{

private static final long serialVersionUID = 1L;
private JLabel labelTitle = new JLabel ("Cas utilisation");	

	public UmlUseCase(PanelCenter parent) {
		super(parent);
				
		this.setSize(300,300);
		this.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) { 
		    	  if(e.getClickCount()==2){
		             new UmlOptionUseCase(labelTitle);  
		         }
		    }
		});
}
	
	  @Override
	    public void paint(Graphics g) {
		  g.drawRect (0,0, 299,299); 
		   g.drawString(labelTitle.getText(),110,25);
	  }
	  
	 public String getTitle()
	 {
		 return labelTitle.getText();
	 }
}
