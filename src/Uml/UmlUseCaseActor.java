package Uml;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import WindowUml.PanelCenter;

public class UmlUseCaseActor extends UmlAbstractModel{

	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JLabel labelTitlActor = new JLabel ("Acteur");	
  private   JLabel labelImageActor =new JLabel(new ImageIcon(getClass().getClassLoader()	    		   
            .getResource("image/stigman.png")));
    
       
	public UmlUseCaseActor(PanelCenter parent) {
		super(parent);
		System.out.println("sss");
		this.add(labelImageActor);
		this.add(labelImageActor);
		this.setSize(200,200);		
		
	}
	 public String getTitle()
	 {
		 return labelTitlActor.getText();
	 }
}