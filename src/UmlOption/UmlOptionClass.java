/*Part Yacine*/

/* this class show a window, to manipulate the entity, can add a entity,delete, change name of class ...*/
package UmlOption;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class UmlOptionClass extends JFrame{

	private JTabbedPane tabbedPane = new JTabbedPane();  
	
	public UmlOptionClass (){
		
    makeTab();
    add(tabbedPane);
   
	//setDefaultCloseOperation(EXIT_ON_CLOSE); 
	setSize(400,400);
	setLocationRelativeTo(null);
	setAlwaysOnTop(true);
	setVisible(true);
	}
	
	 private void makeTab(){
		tabbedPane.addTab("Classe", new OptionTab1());
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		tabbedPane.addTab("Attributs", new OptionTab2());	
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		tabbedPane.addTab("Methode", new OptionTab3());
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
	}
}

class OptionTab1 extends JPanel {
	
	private JButton validate = new JButton("Valider") ;
	private JButton close= new JButton("Fermer");
	private JLabel nameClass = new JLabel("Nom de classe : ");
	private JTextField textNameClass = new  JTextField();
	
	 OptionTab1(){
		 
		  this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		 
		  JPanel b1 = new JPanel();	  
		   b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
		   b1.add(nameClass);
		   b1.add(Box.createRigidArea(new Dimension(40,50)));
		   b1.add(textNameClass);
		   textNameClass.setMaximumSize(new Dimension(Integer.MAX_VALUE, textNameClass.getMinimumSize().height));
		   
		   JPanel b2 = new JPanel();
		   b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
		   b2.add(validate);
		   b2.add(Box.createRigidArea(new Dimension(40,50)));
		   b2.add(close);
		   
		   add(b1);
		   add(Box.createRigidArea(new Dimension(40,50)));
		   add(b2);		        		   	
	}

	//event button click validate
	  class validateListener implements ActionListener{
		    
		    public void actionPerformed(ActionEvent arg0) {
		      
		    }
		  }
	  
	  ///event button click close
	  class closeListener implements ActionListener{
		    
		    public void actionPerformed(ActionEvent arg0) {
		      
		    	
		    }
		  }

}



class OptionTab2 extends JPanel{
	
	private JButton validate=new JButton("Valider") ;
	private JButton close = new JButton("Fermer");
	
	private JButton buttonNewAttribute=new JButton("Ajouter un attribut") ;
	private JButton buttonDeleteAttribute = new JButton("Supprimer attribut") ;
	
	private JLabel labelNameAttribute = new JLabel ("Nom attribut : ");
	private JLabel labelTypeAttribute = new JLabel ("Type attribut : ");
	private JLabel labelValueAttribute = new JLabel ("Valeur attribut : ");
	
	private JTextField textNameAttribute = new  JTextField();
	private JTextField textTypeAttribute = new  JTextField();
	private JTextField textValueAttribute = new  JTextField();
	
	
	private JList list = new JList();
	
	OptionTab2(){
		
	   	this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
	       list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	       list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
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
		   
		   JPanel b3 = new JPanel();
		   b3.setLayout(new BoxLayout(b3, BoxLayout.LINE_AXIS));
		   b3.add(validate);
		   b3.add(Box.createRigidArea(new Dimension(40,50)));
		   b3.add(close);
		   
		   JPanel b4 = new JPanel();
		   b4.setLayout(new BoxLayout(b4, BoxLayout.LINE_AXIS));
		   b4.add(new JScrollPane(list));
		   b4.add(Box.createRigidArea(new Dimension(20,40)));
		   b4.add(b1);
		   
		   add(b4);
		   add(Box.createRigidArea(new Dimension(20,40)));
		   add(b2);
		   add(Box.createRigidArea(new Dimension(20,40)));
		   add(b3);
			//event button click validate
			  class validateListener implements ActionListener{
				    
				    public void actionPerformed(ActionEvent arg0) {
				      
				    }
				  }
			  
			  ///event button click close
			  class closeListener implements ActionListener{
				    
				    public void actionPerformed(ActionEvent arg0) {
				    	
				      
				    }
				  }
		        		   		 
	}
}

class OptionTab3 extends JPanel {
	
	private JButton validate = new JButton("Valider") ;
	private JButton close = new JButton("Fermer");
	
	private JButton buttonNewMethod=new JButton("Ajoute une methode") ;
	private JButton buttonDeleteMethod = new JButton("Supprimer methode") ;
	
	private JLabel labelNameMethod = new JLabel ("Nom attribut  :  ");
	private JLabel labelTypeMethod = new JLabel ("Type Methode  :  ");
	
	private JTextField textNameMethod = new  JTextField();
	private JTextField textTypeMethod = new  JTextField();
	
	private JList list = new JList();
	
	OptionTab3(){
		
	       this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	    	
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
		   
		   JPanel b3 = new JPanel();
		   b3.setLayout(new BoxLayout(b3, BoxLayout.LINE_AXIS));
		   b3.add(validate);
		   b3.add(Box.createRigidArea(new Dimension(40,50)));
		   b3.add(close);		   
		   
		   JPanel b4 = new JPanel();
		   b4.setLayout(new BoxLayout(b4, BoxLayout.LINE_AXIS));
		   b4.add(new JScrollPane(list));
		   b4.add(Box.createRigidArea(new Dimension(20,40)));
		   b4.add(b1);
		   
		   add(b4);
		   add(Box.createRigidArea(new Dimension(20,40)));
		   add(b2);
		   add(Box.createRigidArea(new Dimension(20,40)));
		   add(b3);
			//event button click validate
			  class validateListener implements ActionListener{
				    
				    public void actionPerformed(ActionEvent arg0) {
				     
				    }
				  }
			  
			  ///event button click close
			  class closeListener implements ActionListener{
				    
				    public void actionPerformed(ActionEvent arg0) {
				      
				    }
				  }
		        		   		 
	}
}
