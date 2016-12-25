package WindowUml;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class WindowUmlUseCase extends JFrame {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelLeft = new JPanel();
	 private JPanel panelRight = new JPanel();
	 private PanelCenter panelCenter= new PanelCenter();
	 
	 
	 public WindowUmlUseCase(final JMenuBar menubar){
		 
		 super();
			
			panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.PAGE_AXIS)); // component to bell will add in vertical
			panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.PAGE_AXIS));
	        panelCenter.setLayout(null);
	        
	        getContentPane().setBackground(Color.WHITE); // change background to white
		    panelLeft.setBackground(Color.WHITE); // change panelLeft to white
		    panelRight.setBackground(Color.WHITE); // change panelRight to white
		    panelCenter.setBackground(Color.RED); // change panelCenter to Red
		    
		    
		    
			setSize(800,600);
		    setVisible(true);
		    setAlwaysOnTop(true);
			setLocationRelativeTo(null);
			setJMenuBar(menubar);
			insertPanel(panelLeft,panelRight);
			this.add(panelLeft,BorderLayout.LINE_START); // add panel left in left jframe
			this.add(panelCenter,BorderLayout.CENTER);// add pannel right in center jframe	
			this.add(panelRight,BorderLayout.LINE_END);// add pannel right in right jframe

		 
	 }
	 
	 public void insertPanel(JPanel  panelLeft,JPanel panelRight)
	 {
		 try {
		       
		       
		       
		       JLabel labelLeft1 = new JLabel(new ImageIcon(getClass().getClassLoader()
		               .getResource("image/dependance.png")));
		       JLabel labelLeft2 = new JLabel(new ImageIcon(getClass().getClassLoader()
		               .getResource("image/association.png")));
		       JLabel labelleft3 = new JLabel(new ImageIcon(getClass().getClassLoader()
		    		   .getResource("image/heritage.png")));
		       
		       JLabel labelStigMan = new JLabel(new ImageIcon(getClass().getClassLoader()	    		   
		               .getResource("image/stigman.png")));
		       JLabel labelCircle =new JLabel(new ImageIcon(getClass().getClassLoader()
		    		   .getResource("image/circle.png")));
		       JLabel labelNode = new JLabel(new ImageIcon(getClass().getClassLoader()
		    		   .getResource("image/node.png")));
		    		   
		       

			  
			  panelLeft.add(labelLeft1);
			  panelLeft.add(Box.createVerticalGlue());
			  
			  panelLeft.add(labelLeft2);
			  panelLeft.add(Box.createVerticalGlue());
			  
			  panelLeft.add(labelleft3);
			  panelLeft.add(Box.createVerticalGlue());
			  
			  panelRight.add(labelStigMan);
			  panelRight.add(Box.createVerticalGlue());
			  
			  panelRight.add(labelCircle);
			  panelRight.add(Box.createVerticalGlue());
			  
			  panelRight.add(labelNode);
			  panelRight.add(Box.createVerticalGlue());
			  
			 

			  
		  } catch (Exception ex) {
			    System.out.println(ex);
			  }

	 }
	 
	 
	

}
