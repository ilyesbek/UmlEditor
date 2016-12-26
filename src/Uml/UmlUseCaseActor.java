package Uml;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import UmlOption.UmlOptionUseCase;
import UmlOption.UmlOptionUseCaseActor;
import WindowUml.PanelCenter;

public class UmlUseCaseActor extends Uml{

	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JLabel labelTitle = new JLabel ("Acteur");	
  private JLabel labelImageActor =new JLabel(new ImageIcon(getClass().getClassLoader()	    		   
            .getResource("image/stigman.png")));
    
       
	public UmlUseCaseActor(PanelCenter parent) {
		super(parent);
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