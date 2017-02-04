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
 *  When click in rectangle diagram use
 */
public class UmlOptionUseCase extends JFrame{

	private static final long serialVersionUID = 1L;
	private JButton validate = new JButton("Valider") ;
	private JLabel nameUseCase = new JLabel("Nom du system : ");
	private JTextField textNameUseCase = new  JTextField();

	public	UmlOptionUseCase(JLabel label){
	 		
		setSize(400,100);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setVisible(true);
		
	  JPanel b1 = new JPanel();	  
	   b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
	   b1.add(nameUseCase);
	   b1.add(Box.createRigidArea(new Dimension(20,20)));
	   b1.add(textNameUseCase);
	   textNameUseCase.setMaximumSize(new Dimension(Integer.MAX_VALUE, textNameUseCase.getMinimumSize().height));
       b1.add(validate);
	   add(b1);
	   
		  validate.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent event){
				if(!textNameUseCase .getText().isEmpty())  {
					 label.setText("");
					 label.setText(textNameUseCase .getText());
				}	         
			  }
			});
	 	}
}
