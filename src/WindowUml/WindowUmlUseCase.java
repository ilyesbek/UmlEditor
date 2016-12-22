package WindowUml;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class WindowUmlUseCase extends JFrame {

	 private JPanel panelLeft = new JPanel();
	 private JPanel panelRight = new JPanel();
	 private JPanel panelCenter= new JPanel();
	 
	 
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
	             .getResource("image/aggregation.png")));
		       
		       JLabel labelLeft2 = new JLabel(new ImageIcon(getClass().getClassLoader()
		               .getResource("image/composition.png")));
		       JLabel labelLeft3 = new JLabel(new ImageIcon(getClass().getClassLoader()
		               .getResource("image/dependance.png")));
		       JLabel labelLeft4 = new JLabel(new ImageIcon(getClass().getClassLoader()
		               .getResource("image/association.png")));
		       JLabel labelleft5 = new JLabel(new ImageIcon(getClass().getClassLoader()
		    		   .getResource("image/heritage.png")));
		       
		       JLabel labelStigMan = new JLabel(new ImageIcon(getClass().getClassLoader()	    		   
		               .getResource("image/stigman.png")));
		       JLabel labelCircle =new JLabel(new ImageIcon(getClass().getClassLoader()
		    		   .getResource("image/circle.png")));
		    		   
		       
			  panelLeft.add(labelLeft1);	
			  panelLeft.add(Box.createVerticalGlue());  // add space beetwen component
			  
			  panelLeft.add(labelLeft2);
			  panelLeft.add(Box.createVerticalGlue());
			  
			  panelLeft.add(labelLeft3);
			  panelLeft.add(Box.createVerticalGlue());
			  
			  panelLeft.add(labelLeft4);
			  panelLeft.add(Box.createVerticalGlue());
			  
			  panelLeft.add(labelleft5);
			  panelLeft.add(Box.createVerticalGlue());
			  
			  panelRight.add(labelStigMan);
			  panelRight.add(Box.createVerticalGlue());
			  
			  panelRight.add(labelCircle);
			  panelRight.add(Box.createVerticalGlue());
			  
			 

			  
		  } catch (Exception ex) {
			    System.out.println(ex);
			  }

	 }
	 
	 
	

}
