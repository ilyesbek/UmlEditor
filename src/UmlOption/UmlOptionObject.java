package UmlOption;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *  Author Yacine
 *  When double click in entity, this menu appear
 */
public class UmlOptionObject extends JFrame{
 
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane = new JTabbedPane();  
	
	public UmlOptionObject(JLabel nameObject,DefaultListModel<String> modelAttribute){
		
    makeTab(nameObject,modelAttribute);
    add(tabbedPane);

	setSize(850,600);
	setLocationRelativeTo(null);
	setAlwaysOnTop(true);
	setVisible(true);
	}
	 private void makeTab (JLabel nameObject, DefaultListModel<String> modelAttribute){
		tabbedPane.addTab("Classe", new OptionTabObject1(nameObject));
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		tabbedPane.addTab("Attributs", new OptionTabObject2(modelAttribute));	
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
	}
}

class OptionTabObject1 extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JButton validate = new JButton("Valider") ;
	private JLabel nameObject = new JLabel("Nom del'objet : ");
	private JTextField textNameObject= new  JTextField();
	
	 OptionTabObject1(JLabel name ){
		 
		  this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		 
		  JPanel b1 = new JPanel();	  
		   b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
		   b1.add(nameObject );
		   b1.add(Box.createRigidArea(new Dimension(40,50)));
		   b1.add(textNameObject );
		   textNameObject .setMaximumSize(new Dimension(Integer.MAX_VALUE, textNameObject .getMinimumSize().height));

		   add(b1);
		   add(Box.createRigidArea(new Dimension(40,50)));
		   add(validate);		     
		   add(Box.createRigidArea(new Dimension(40,50)));
		      		   
			  validate.addActionListener(new ActionListener(){
				  public void actionPerformed(ActionEvent event){
					if(!textNameObject .getText().isEmpty())  {
						name.setText(textNameObject.getText());
					}		         
				  }
				});
		   	}
 }

class OptionTabObject2 extends JPanel{
	
	private static final long serialVersionUID = 1L;

	private JButton validate=new JButton("Valider") ;
		
	private JButton buttonNewAttribute = new JButton("Ajouter un attribut") ;
	private JButton buttonDeleteAttribute = new JButton("Supprimer attribut") ;
	
	private JLabel labelNameAttribute = new JLabel ("Nom attribut : ");
	private JLabel labelValueAttribute = new JLabel ("Valeur attribut : ");
	
	private JTextField textNameAttribute = new  JTextField();
	private JTextField textValueAttribute = new  JTextField();
	
	private DefaultListModel<String> model = new DefaultListModel<String> ();
	private JList<String>  list = new JList<String>  (model);
	
	OptionTabObject2(DefaultListModel<String> modelAttribute){		
		
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
		   
		   JPanel b2_3 = new JPanel();
		   b2_3.setLayout(new BoxLayout(b2_3, BoxLayout.LINE_AXIS));
		   b2_3.add(labelValueAttribute);
		   textValueAttribute.setMaximumSize(new Dimension(Integer.MAX_VALUE,textValueAttribute.getMinimumSize().height));
		   b2_3.add(textValueAttribute);
		   		   
		   JPanel b2 = new JPanel();
		   b2.setLayout(new BoxLayout(b2, BoxLayout.PAGE_AXIS));
		   b2.add(new JLabel("Pour ajouter les champs nom et type de l'attribut obligatoire, puis cliquer sur le boutton en haut a droite ajouter attribut"));
		   b2.add(Box.createRigidArea(new Dimension(40,40)));
		   
		   b2.add(b2_1);
		   b2.add(Box.createRigidArea(new Dimension(40,40)));
		   b2.add(b2_2);
		   b2.add(Box.createRigidArea(new Dimension(40,40)));
		   b2.add(b2_3);
		   b2.add(Box.createRigidArea(new Dimension(40,40)));
		   
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
					  if(textNameAttribute.getText().isEmpty() && textValueAttribute.getText().isEmpty()){
				    	
				    	}
				    	else{
			    		
				    		String row = textNameAttribute.getText()+" :  "+textValueAttribute.getText();
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
