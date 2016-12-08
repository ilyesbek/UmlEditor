/*Part Ilyes and Yacine*/

package WindowUml;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Color;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class WindowUmlClass extends JFrame {
	
	// private JFrame frame = new JFrame("Diagramme de classe");
	
	 
    private JLabel label;
    private JPanel panelLeft = new JPanel();
    private JPanel panelRight = new JPanel();
	
	public WindowUmlClass(final JMenuBar menubar){
			
		super();
		
		panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.PAGE_AXIS)); // component to bell will add in vertical

		
	    getContentPane().setBackground(Color.WHITE); // change background to white
	    panelLeft.setBackground(Color.WHITE); // change panelLeft to white
	    panelRight.setBackground(Color.WHITE); // change panelRight to white
	    	
		setSize(1000,600);
	    setVisible(true);
	    setAlwaysOnTop(true);
	    setResizable(false);
		setLocationRelativeTo(null);
		setJMenuBar(menubar);
		insertPanel(panelLeft,panelRight);
		this.add(panelLeft,BorderLayout.LINE_START); // add panel left in left jframe
		this.add(panelRight,BorderLayout.LINE_END);// add pannel right in right jframe
					
}
	

public void insertPanel(JPanel  panelLeft,JPanel panelRight)
{
	
	  try {
	       JButton buttonLeft1 =new JButton(new ImageIcon(getClass().getClassLoader()
             .getResource("image/1.jpg")));
	       JButton buttonLeft2 =new JButton(new ImageIcon(getClass().getClassLoader()
	               .getResource("image/2.jpg")));
	       JButton buttonLeft3 =new JButton(new ImageIcon(getClass().getClassLoader()
	               .getResource("image/3.png")));
	       JButton buttonLeft4 =new JButton(new ImageIcon(getClass().getClassLoader()
	               .getResource("image/4.png")));
	       
	       JButton buttonClass =new JButton(new ImageIcon(getClass().getClassLoader()	    		   
	               .getResource("image/class.png")));
	       
		  panelLeft.add(buttonLeft1);		  
		  panelLeft.add(Box.createVerticalGlue());  // add space beetwen component
		  
		  panelLeft.add(buttonLeft2);
		  panelLeft.add(Box.createVerticalGlue());
		  
		  panelLeft.add(buttonLeft3);
		  panelLeft.add(Box.createVerticalGlue());
		  
		  panelLeft.add(buttonLeft4);
		  panelLeft.add(Box.createVerticalGlue());
		 	 
		  panelRight.add(buttonClass);
		  
	  } catch (Exception ex) {
		    System.out.println(ex);
		  }
	  

}



}

