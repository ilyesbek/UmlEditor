/*Part Yacine*/

/*This class represent a Entity for uml class*/
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

import UmlOption.UmlOptionClass;
import WindowUml.PanelCenter;




public class UmlEntityClass extends Uml{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultListModel<String> modelClass = new DefaultListModel<String>();	
	private DefaultListModel<String> modelAttribute = new DefaultListModel<String>();	
	private DefaultListModel<String> modelMethod = new DefaultListModel<String>();	
	
	private JList<String> listClass = new JList<String>(modelClass);  
	private JList<String> listAttribute = new JList<String>(modelAttribute);  
	private JList<String> listMethod = new JList<String>(modelMethod);  
	
	 public UmlEntityClass(PanelCenter panel){
		super(panel);
		this.setSize(120,150);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		listClass.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	    listClass.setVisibleRowCount(-1);
	    modelClass.addElement("Class");
		   
	    listAttribute.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	    listAttribute.setVisibleRowCount(-1);
	    
	    listMethod .setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	    listMethod .setVisibleRowCount(-1);
	    		
		add(listClass);
        add(new JSeparator(SwingConstants.HORIZONTAL));
		add(listAttribute,BorderLayout.LINE_START);	
		add(Box.createHorizontalGlue());
		add(new JSeparator(SwingConstants.HORIZONTAL));
		add(listMethod);
	    	   
		this.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) { 
		    	  if(e.getClickCount()==2){
		             new UmlOptionClass(modelClass,modelAttribute,modelMethod);  
		         }
		    }
		});
		
	}
	 public String getTitle(){
		 return modelClass.getElementAt(0);
	 }
}
