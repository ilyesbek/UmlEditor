/**
 * 
 */
package Uml;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import UmlOption.UmlOptionClass;
import UmlOption.UmlOptionUseCase;
import WindowUml.PanelCenter;

/**
 * @author Yacine
 *
 */

public class UmlUseCase extends Uml{
	/**
	 * 
	 */
private static final long serialVersionUID = 1L;
private JLabel labelTitle = new JLabel ("Cas utilisation");	

	public UmlUseCase(PanelCenter parent) {
		super(parent);
		
		
		labelTitle.setLocation(this.getX()+this.getWidth()/2,labelTitle.getHeight()+this.getHeight());
		this.setSize(300,300);
		this.add(labelTitle);
		this.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) { 
		    	  if(e.getClickCount()==2){
		             new UmlOptionUseCase(labelTitle);  
		         }
		    }
		});
						
	}
	 public String getTitle()
	 {
		 return labelTitle.getText();
	 }

}
