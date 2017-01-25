package UmlOption;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UmlOptionCircle extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public UmlOptionCircle (JLabel s){
	JLabel labelInfo = new JLabel ("Saisir l'information : ");
          JTextField textLabel = new  JTextField();
		  JButton validate = new JButton("Valider") ;	
		
			setSize(400,400);
			setLocationRelativeTo(null);
			setAlwaysOnTop(true);
			setVisible(true);
			
		   JPanel b1 = new JPanel();	  
		   b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
		   b1.add(labelInfo );
		   b1.add(Box.createRigidArea(new Dimension(20,20)));
		   b1.add(textLabel);
		   textLabel .setMaximumSize(new Dimension(Integer.MAX_VALUE, textLabel.getMinimumSize().height));
		   
		   JPanel b2 = new JPanel();	  
		   b2.setLayout(new BoxLayout(b2, BoxLayout.PAGE_AXIS));
		   
		   b2.add(b1);
		   b2.add(validate);
		   
		   add(b2);
		   
		   validate.addActionListener(new ActionListener(){
				  public void actionPerformed(ActionEvent event){
						if(!textLabel .getText().isEmpty())  {
							 s.setText(textLabel .getText());
						}
					}		         				  
				});

}
}
