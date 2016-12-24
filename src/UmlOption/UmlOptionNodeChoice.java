package UmlOption;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Uml.UmlEntityClass;
import Uml.UmlNode;
import WindowUml.PanelCenter;

public class UmlOptionNodeChoice extends JDialog {
	
 public UmlOptionNodeChoice (PanelCenter panelCenter,ArrayList<UmlEntityClass> listUmlEntityClass){
	 
	JPanel panel = new JPanel (); 
	 
	 ArrayList<String>listTitleEntity = new  ArrayList<String>();
	 
	 for(int i = 0; i < listUmlEntityClass.size(); ++i)
	    listTitleEntity.add(listUmlEntityClass.get(i).getTitle());

    JLabel labelClass1 = new JLabel("Classe 1 : "); 
	JLabel labelClass2 = new JLabel("Classe 2 : "); 

	JButton buttonValidate = new JButton("Valider"); 
	
     String [] array = listTitleEntity.toArray(new String[listTitleEntity.size()]);  
	 JComboBox<String>  boxClass1 = new JComboBox<String> (array);
     JComboBox<String>  boxClass2 = new JComboBox<String> (array);
  
	   JPanel b1 = new JPanel();	 
	   b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
	   b1.add(labelClass1);
	   b1.add(Box.createRigidArea(new Dimension(40,50)));
	   b1.add(boxClass1);
	   
	   JPanel b2 = new JPanel();
	   b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
	   b2.add(labelClass2);
	   b2.add(Box.createRigidArea(new Dimension(40,50)));
	   b2.add(boxClass2);
	   
	   panel.add(b1);
	   panel.add(b2);	 
	   panel.add(buttonValidate);
	   add(panel);
	   setSize(200,200);
	   setVisible(true);
	   setAlwaysOnTop(true);
	   setLocationRelativeTo(null);
		
		  buttonValidate.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent event){
				   UmlNode.call=true;
		    	   panelCenter.addDraw(listUmlEntityClass.get(boxClass1.getSelectedIndex()),listUmlEntityClass.get(boxClass2.getSelectedIndex()));
			  }
			});
 }

}
