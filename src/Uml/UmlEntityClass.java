/*Part Yacine*/

/*This class represent a Entity for uml class*/
package Uml;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import UmlOption.UmlOptionClass;




public class UmlEntityClass extends UmlAbstractModel{
	
	private DefaultListModel modelClass = new DefaultListModel();	
	private DefaultListModel modelAttribute = new DefaultListModel();	
	private DefaultListModel modelMethod = new DefaultListModel();	
	
	private JList listClass = new JList(modelClass);  
	private JList listAttribute = new JList(modelAttribute);  
	private JList listMethod = new JList(modelMethod);  
	
	 public UmlEntityClass(JPanel panel){
		super(panel);
		
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
		add(listAttribute);	
		add(new JSeparator(SwingConstants.HORIZONTAL));
		add(listMethod);
	    	   
		this.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) { 
		    	  if(e.getClickCount()==2){
		             UmlOptionClass windowOptionClass = new UmlOptionClass(modelClass,modelAttribute,modelMethod);  
		         }
		    }
		});
		
	}
}
