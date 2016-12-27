package Uml;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import UmlOption.UmlOptionObject;
import WindowUml.PanelCenter;

/*
 * Author Yacine 
 * This class represent a entity Class
 */
public class UmlEntityObject extends Uml {
	
	private static final long serialVersionUID = 1L;

	private DefaultListModel<String> modelObject = new DefaultListModel<String>();	
	private DefaultListModel<String> modelAttribute = new DefaultListModel<String>();
	
	private JList<String> listObject = new JList<String>(modelObject);  
	private JList<String> listAttribute = new JList<String>(modelAttribute);  
	
	public UmlEntityObject(PanelCenter panel) {
		super(panel);
		this.setSize(120,150);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		listObject.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	    listObject.setVisibleRowCount(-1);
	    modelObject.addElement(": Objet");
		   
	    listAttribute.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	    listAttribute.setVisibleRowCount(-1);
	    
		add(listObject);
        add(new JSeparator(SwingConstants.HORIZONTAL));
		add(listAttribute,BorderLayout.LINE_START);	
		add(Box.createHorizontalGlue());
		
		
		this.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) { 
		    	  if(e.getClickCount()==2){
		             new UmlOptionObject(modelObject,modelAttribute);  
		         }
		    }
		});
	}
	
	 public String getTitle(){
		 return modelObject.getElementAt(0);
	 }
}
