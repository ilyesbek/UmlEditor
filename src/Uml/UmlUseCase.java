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

public class UmlUseCase extends UmlAbstractModel {
	/**
	 * 
	 */
private static final long serialVersionUID = 1L;
private JLabel labelTitleUseCase = new JLabel ("Cas utilisation");	

	public UmlUseCase(PanelCenter parent) {
		super(parent);
		
		
		labelTitleUseCase.setLocation(this.getX()+this.getWidth()/2,labelTitleUseCase.getHeight()+this.getHeight());
		this.setSize(300,300);
		this.add(labelTitleUseCase);
		this.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) { 
		    	  if(e.getClickCount()==2){
		             new UmlOptionUseCase(labelTitleUseCase);  
		         }
		    }
		});
						
	}
	 public String getTitle()
	 {
		 return labelTitleUseCase.getText();
	 }

}
