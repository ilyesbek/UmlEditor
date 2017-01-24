package UmlOption;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *  Author Yacine
 *  choose cardinality
 */

public class UmlOptionCardinality extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public UmlOptionCardinality (JLabel label){
	
		String[] stringVisibility = {"n", "0","0-1","0-n","0*","1-1","1","1-n", "1*" ,"*"};
		JComboBox<String>  boxVisibility = new JComboBox<String>  (stringVisibility);
		JButton validate = new JButton("Valider") ;	
		
		
		   JPanel b1 = new JPanel();
		   
		   b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
		   b1.add(Box.createRigidArea(new Dimension(20,20)));
		   b1.add(new JLabel("Cardinalité : "));
		   b1.add(Box.createRigidArea(new Dimension(40,50)));
	       b1.add(boxVisibility);
		   boxVisibility.setMaximumSize(new Dimension(Integer.MAX_VALUE, boxVisibility.getMinimumSize().height));

		   JPanel b2 = new JPanel();	  
		   b2.setLayout(new BoxLayout(b2, BoxLayout.PAGE_AXIS));
		   
		   b2.add(b1);
		   b2.add(validate);
		   
		   add(b2);
		   
		   validate.addActionListener(new ActionListener(){
				  public void actionPerformed(ActionEvent event){
				      label.setText(boxVisibility.getSelectedItem().toString());
					}		         				  
				});
				
		setSize(200,200);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setVisible(true);
	}

}
