package Uml;

import java.util.ArrayList;

import javax.swing.JLabel;

import WindowUml.PanelCenter;

public class UmlUseCaseCircle extends UmlAbstractModel {
	
	
	private static final long serialVersionUID = 1L;

	private JLabel labelTitlCircle = new JLabel("Information");
	public UmlUseCaseCircle(PanelCenter parent) {
		super(parent);
		this.setSize(200,200);
		
	}
	 public String getTitle()
	 {
		 return labelTitlCircle.getText();
	 }
}
