/*Part Yacine*/

/* this class show a window, to manipulate the entity, can add a entity,delete, change name of class ...*/
package UmlOption;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *  Author Yacine
 *  When double click in entity, this menu appear
 */

public class UmlOptionClass extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane = new JTabbedPane();  
	
	public UmlOptionClass (JLabel nameClass,DefaultListModel<String> modelAttribute, DefaultListModel<String> modelMethod){
		
    makeTab(nameClass,modelAttribute,modelMethod);
    add(tabbedPane);

	setSize(600,600);
	setLocationRelativeTo(null);
	setAlwaysOnTop(true);
	setVisible(true);
	}
	
	 private void makeTab (JLabel  nameClass, DefaultListModel<String> modelAttribute, DefaultListModel<String> modelMethod){
		tabbedPane.addTab("Classe", new OptionTabClass1(nameClass));
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		tabbedPane.addTab("Attributs", new OptionTabClass2(modelAttribute));	
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		tabbedPane.addTab("Methode", new OptionTabClass3(modelMethod));
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
	}
}

class OptionTabClass1 extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JButton validate = new JButton("Valider") ;
	private JLabel nameClass = new JLabel("Nom de classe : ");
	private JTextField textNameClass = new  JTextField();
	
	 OptionTabClass1(JLabel name){
		 
		  this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		 
		  JPanel b1 = new JPanel();	  
		   b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
		   b1.add(nameClass);
		   b1.add(Box.createRigidArea(new Dimension(40,50)));
		   b1.add(textNameClass);
		   textNameClass.setMaximumSize(new Dimension(Integer.MAX_VALUE, textNameClass.getMinimumSize().height));

		   add(b1);
		   add(Box.createRigidArea(new Dimension(40,50)));
		   add(validate);		     
		   add(Box.createRigidArea(new Dimension(40,50)));
		      		   
			  validate.addActionListener(new ActionListener(){
				  public void actionPerformed(ActionEvent event){
					if(!textNameClass.getText().isEmpty())  {
						 name.setText(textNameClass.getText());
					}
		         
				  }
				});
		   	}
 }

class OptionTabClass2 extends JPanel{
	
	private static final long serialVersionUID = 1L;

	private JButton validate=new JButton("Valider") ;
		
	private String[] stringVisibility = { "Public", "Privé", "Protégé", "Implementation"};
	private JComboBox<String>  boxVisibility = new JComboBox<String> (stringVisibility);
	
	private JButton buttonNewAttribute = new JButton("Ajouter un attribut") ;
	private JButton buttonDeleteAttribute = new JButton("Supprimer attribut") ;
	
	private JLabel labelNameAttribute = new JLabel ("Nom attribut : ");
	private JLabel labelTypeAttribute = new JLabel ("Type attribut : ");
	private JLabel labelValueAttribute = new JLabel ("Valeur attribut : ");
	
	private JTextField textNameAttribute = new  JTextField();
	private JTextField textTypeAttribute = new  JTextField();
	private JTextField textValueAttribute = new  JTextField();
	
	private DefaultListModel<String> model = new DefaultListModel<String> ();
	private JList<String>  list = new JList<String>  (model);
	
	OptionTabClass2(DefaultListModel<String> modelAttribute){		
		
	   	this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	   	
	    for(int i = 0; i < modelAttribute.getSize(); i++) 
			 model.addElement(modelAttribute.getElementAt(i));		
		
	       list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		   list.setVisibleRowCount(-1);		 
		
		   JPanel b1 = new JPanel();	 
		   b1.setLayout(new BoxLayout(b1, BoxLayout.PAGE_AXIS));
		   b1.add(buttonNewAttribute);
		   b1.add(Box.createRigidArea(new Dimension(40,50)));
		   b1.add(buttonDeleteAttribute);
		   
		   JPanel b2_1 = new JPanel();
		   b2_1.setLayout(new BoxLayout(b2_1, BoxLayout.LINE_AXIS));
		   b2_1.add(labelNameAttribute);
		   textNameAttribute.setMaximumSize(new Dimension(Integer.MAX_VALUE, textNameAttribute.getMinimumSize().height));
		   b2_1.add(textNameAttribute);
		   
		   JPanel b2_2 = new JPanel();
		   b2_2.setLayout(new BoxLayout(b2_2, BoxLayout.LINE_AXIS));
		   b2_2.add(labelTypeAttribute);
		   textTypeAttribute.setMaximumSize(new Dimension(Integer.MAX_VALUE,textTypeAttribute.getMinimumSize().height));
		   b2_2.add(textTypeAttribute);
		   
		   JPanel b2_3 = new JPanel();
		   b2_3.setLayout(new BoxLayout(b2_3, BoxLayout.LINE_AXIS));
		   b2_3.add(labelValueAttribute);
		   textValueAttribute.setMaximumSize(new Dimension(Integer.MAX_VALUE,textValueAttribute.getMinimumSize().height));
		   b2_3.add(textValueAttribute);
		   		   
		   JPanel b2 = new JPanel();
		   b2.setLayout(new BoxLayout(b2, BoxLayout.PAGE_AXIS));
		   b2.add(b2_1);
		   b2.add(Box.createRigidArea(new Dimension(40,40)));
		   b2.add(b2_2);
		   b2.add(Box.createRigidArea(new Dimension(40,40)));
		   b2.add(b2_3);
		   b2.add(Box.createRigidArea(new Dimension(40,40)));
		   b2.add(boxVisibility);
		   
		   JPanel b3 = new JPanel();
		   b3.setLayout(new BoxLayout(b3, BoxLayout.LINE_AXIS));
		   b3.add(new JScrollPane(list));
		   b3.add(Box.createRigidArea(new Dimension(20,40)));
		   b3.add(b1);
		   
		   add(b3);
		   add(Box.createRigidArea(new Dimension(20,40)));
		   add(b2);
		   add(Box.createRigidArea(new Dimension(20,40)));
		   add(validate);
		   add(Box.createRigidArea(new Dimension(20,40)));
		  
			  // event button ajouter un attribut click		  
			  buttonNewAttribute.addActionListener(new ActionListener(){
				  public void actionPerformed(ActionEvent event){
					  if(textNameAttribute.getText().isEmpty() && textTypeAttribute.getText().isEmpty()){
				    		JOptionPane.showMessageDialog(null, "Veuillez remplir les champs", "Warning",JOptionPane.WARNING_MESSAGE);
				    	}
				    	else{
			    		
				    		String row ="";
				    		
				    		switch (boxVisibility.getSelectedIndex()){
				    		case 0 : row+="+ ";
				    		break;
				    		case 1 : row+="- ";
				    		break;
				    		case 2 : row+="# ";
				    		break;
				    		case 3 : row+="~ ";
				    		break;
				    		
				    		default : break;
				    		}
				    		row+= textNameAttribute.getText()+" :  "+textTypeAttribute.getText();
				    		     if(!textValueAttribute.getText().isEmpty())
				    		    	 row+=" = "+textValueAttribute.getText();
				    	    model.addElement(row);	     
				    	}
				  }
				});
			  validate.addActionListener(new ActionListener(){
				  public void actionPerformed(ActionEvent event){
					 modelAttribute.clear();						 
					 for(int i = 0; i < model.getSize(); i++) 
						  modelAttribute.addElement(model.getElementAt(i));
				  }
				});
			  
			  buttonDeleteAttribute.addActionListener(new ActionListener(){
				  public void actionPerformed(ActionEvent event){
					      model.remove(list.getSelectedIndex());				 
				  }
				});			  
	}
}

class OptionTabClass3 extends JPanel {
	
	private static final long serialVersionUID = 1L;

	private JButton validate = new JButton("Valider") ;	

	DefaultListModel<String> model = new DefaultListModel<String> ();	
	
	String[] stringVisibility = { "Public", "Privé", "Protégé", "Implementation"};
	JComboBox<String>  boxVisibility = new JComboBox<String>  (stringVisibility);	
	
	private JButton buttonNewMethod=new JButton("Ajoute une methode") ;
	private JButton buttonDeleteMethod = new JButton("Supprimer methode") ;
	
	private JLabel labelNameMethod = new JLabel ("Nom Methode :  ");
	private JLabel labelTypeMethod = new JLabel ("Type Methode  :  ");
	
	private JTextField textNameMethod = new  JTextField();
	private JTextField textTypeMethod = new  JTextField();
	
	private JList<String>  list = new JList<String>  (model);
	
	OptionTabClass3( DefaultListModel<String>  modelMethod){
		
	       this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	    	
	       for(int i = 0; i < modelMethod.getSize(); i++) 
				 model.addElement(modelMethod.getElementAt(i));
			 
			
		   JPanel b1 = new JPanel();	
		   b1.setLayout(new BoxLayout(b1, BoxLayout.PAGE_AXIS));
		   b1.add(buttonNewMethod);
		   b1.add(Box.createRigidArea(new Dimension(40,50)));
		   b1.add(buttonDeleteMethod);
		   
		   JPanel b2_1 = new JPanel();
		   b2_1.setLayout(new BoxLayout(b2_1, BoxLayout.LINE_AXIS));	
		   b2_1.add(labelNameMethod);
		   textNameMethod.setMaximumSize(new Dimension(Integer.MAX_VALUE,textNameMethod.getMinimumSize().height));
		   b2_1.add(textNameMethod);
		   
		   JPanel b2_2 = new JPanel();
		   b2_2.setLayout(new BoxLayout(b2_2, BoxLayout.LINE_AXIS));
		   b2_2.add(labelTypeMethod);
		   textTypeMethod.setMaximumSize(new Dimension(Integer.MAX_VALUE,textTypeMethod.getMinimumSize().height));
		   b2_2.add(textTypeMethod);
		   
		   JPanel b2 = new JPanel();
		   b2.setLayout(new BoxLayout(b2, BoxLayout.PAGE_AXIS));
		   b2.add(b2_1);
		   b2.add(Box.createRigidArea(new Dimension(40,40)));
		   b2.add(b2_2);
		   b2.add(Box.createRigidArea(new Dimension(40,40)));
		   b2.add(boxVisibility);
		  	    
		   JPanel b3 = new JPanel();
		   b3.setLayout(new BoxLayout(b3, BoxLayout.LINE_AXIS));
		   b3.add(new JScrollPane(list));
		   b3.add(Box.createRigidArea(new Dimension(20,40)));
		   b3.add(b1);
		   
		   add(b3);
		   add(Box.createRigidArea(new Dimension(20,40)));
		   add(b2);
		   add(Box.createRigidArea(new Dimension(20,40)));
		   add(validate);
		   add(Box.createRigidArea(new Dimension(20,40)));
			  
			  buttonNewMethod.addActionListener(new ActionListener(){
				  public void actionPerformed(ActionEvent event){
					  if(textNameMethod.getText().isEmpty() && textTypeMethod.getText().isEmpty()){
				    		JOptionPane.showMessageDialog(null, "Veuillez remplir les champs", "Warning",JOptionPane.WARNING_MESSAGE);
				    	}
				    	else{
			    		
				    		String row ="";
				    		
				    		switch (boxVisibility.getSelectedIndex()){
				    		case 0 : row+="+ ";
				    		break;
				    		case 1 : row+="- ";
				    		break;
				    		case 2 : row+="# ";
				    		break;
				    		case 3 : row+="~ ";
				    		break;
				    		
				    		default : break;
				    		}
				    		row+= textNameMethod.getText()+" () :  "+textTypeMethod.getText();				    		     
				    	    model.addElement(row);			    	 
				    	}
				  }
				});
			  
			  validate.addActionListener(new ActionListener(){
				  public void actionPerformed(ActionEvent event){
					   modelMethod.clear();						 
						 for(int i = 0; i < model.getSize(); i++) 
							  modelMethod.addElement(model.getElementAt(i));				 
				  }
				});
			  
			  buttonDeleteMethod.addActionListener(new ActionListener(){
				  public void actionPerformed(ActionEvent event){
					      model.remove(list.getSelectedIndex());				 
				  }
				});
		       }
}
