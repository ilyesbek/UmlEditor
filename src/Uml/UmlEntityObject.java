package Uml;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import UmlOption.UmlOptionObject;
import WindowUml.PanelCenter;

/*
 * Author Yacine 
 * This class represent a entity Class
 */
public class UmlEntityObject extends Uml {
	
	private static final long serialVersionUID = 1L;

	private JLabel nameObject = new JLabel("Objet");	
	private DefaultListModel<String> modelAttribute = new DefaultListModel<String>();
	
	private JList<String> listAttribute = new JList<String>(modelAttribute);  
	
	public UmlEntityObject(PanelCenter panel) {
		super(panel);
		this.setSize(120,150);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		   
	    listAttribute.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	    listAttribute.setVisibleRowCount(-1);
	    
	    setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	    
		add(nameObject);
      //  add(new JSeparator(SwingConstants.HORIZONTAL));
		add(listAttribute,BorderLayout.LINE_START);	
		add(Box.createHorizontalGlue());
		
		
		this.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) { 
		    	  if(e.getClickCount()==2){
		             new UmlOptionObject(nameObject,modelAttribute);  
		         }
		    }
		});
	}
	
	 public String getTitle(){
		 return nameObject.getText();
	 }
}
