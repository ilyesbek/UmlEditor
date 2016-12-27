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

/**
 *  Author Yacine
 *  When click in rectangle diagram packet title
 */
public class UmlOptionPacket extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JButton validate = new JButton("Valider") ;
	private JLabel namePacket = new JLabel("Nom du pacquet : ");
	private JTextField textNamePacket = new  JTextField();
	
	public UmlOptionPacket(JLabel label){
		  
		setSize(400,400);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setVisible(true);
	  JPanel b1 = new JPanel();	  
	   b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
	   b1.add(namePacket);
	   b1.add(Box.createRigidArea(new Dimension(20,20)));
	   b1.add(textNamePacket);
	   textNamePacket.setMaximumSize(new Dimension(Integer.MAX_VALUE, textNamePacket.getMinimumSize().height));
       b1.add(validate);
	   add(b1);
	   
		  validate.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent event){
				if(!textNamePacket .getText().isEmpty())  {
					 label.setText("");
					 label.setText(textNamePacket .getText());
				}	         
			  }
			});
	}

}
