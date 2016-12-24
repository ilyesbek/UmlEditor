/*Part Ilyes and Yacine*/

package WindowUml;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import Uml.UmlEntityClass;
import Uml.UmlNode;
import UmlOption.UmlOptionNodeChoice;

public class WindowUmlClass extends JFrame {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int currentCompenent=0; 
   
    private JPanel panelLeft = new JPanel();
    private JPanel panelRight = new JPanel();
    private PanelCenter panelCenter= new PanelCenter ();
    
    private ArrayList<UmlEntityClass> listUmlEntityClass = new ArrayList<UmlEntityClass>();
    
    
    public WindowUmlClass(final JMenuBar menubar){
			
		super();
		
		panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.PAGE_AXIS)); // component to bell will add in vertical
        panelCenter.setLayout(null);
		
	    getContentPane().setBackground(Color.WHITE); // change background to white
	    panelLeft.setBackground(Color.WHITE); // change panelLeft to white
	    panelRight.setBackground(Color.WHITE); // change panelRight to white
	    panelCenter.setBackground(Color.WHITE); // change panelCenter to white   
	
		setSize(800,600);
	    setVisible(true);
	    setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		setJMenuBar(menubar);
		insertPanel(panelLeft,panelRight);
		this.add(panelLeft,BorderLayout.LINE_START); // add panel left in left jframe
		this.add(panelCenter,BorderLayout.CENTER);// add pannel right in right jframe	
		this.add(panelRight,BorderLayout.LINE_END);// add pannel right in right jframe

		panelCenter.addMouseListener(new MouseAdapter()  
		  {  
		      public void mouseClicked(MouseEvent e)  
		      {  
		    	  
		    	  if(currentCompenent==4){
		    		  UmlOptionNodeChoice nodeUml = new UmlOptionNodeChoice(panelCenter,listUmlEntityClass);
			    		 currentCompenent=0;
		    		    /*if(posUmlClass1>0){
			           		  for(int i = 0; i<listUmlEntityClass.size();++i){
				    			  if(listUmlEntityClass.get(i).contains(e.getPoint())){
				    				posUmlClass2=i;
				    				break;
				    			  }
				    		  }
			           		 UmlNode relation = new UmlNode (listUmlEntityClass.get(posUmlClass1),listUmlEntityClass.get(posUmlClass2)); 
			               }   
		    		    else {System.out.println("ss");
		    		  for(int i = 0; i<listUmlEntityClass.size();++i){
		    			  if(listUmlEntityClass.get(i).contains(e.getPoint())){
		    				posUmlClass1=i;
		    				break;
		    			  }
		    		  }*
		    		 }*/
		    	  }
		      else if(currentCompenent==6){
		    		 UmlEntityClass umlClass = new UmlEntityClass (panelCenter);
		    		 listUmlEntityClass.add(umlClass);
		    		 panelCenter.add(umlClass);
		    		 panelCenter.revalidate();
		    	     panelCenter.repaint();
		    		 currentCompenent=0;
		    	  }
		      } 	      
		  }); 
}	

public void insertPanel(JPanel  panelLeft,JPanel panelRight)
{
		  try {
	       JLabel labelLeft1 =new JLabel(new ImageIcon(getClass().getClassLoader()
             .getResource("image/aggregation.png")));
	       
	       JLabel labelLeft2 =new JLabel(new ImageIcon(getClass().getClassLoader()
	               .getResource("image/composition.png")));
	       JLabel labelLeft3 =new JLabel(new ImageIcon(getClass().getClassLoader()
	               .getResource("image/dependance.png")));
	       JLabel labelLeft4 =new JLabel(new ImageIcon(getClass().getClassLoader()
	               .getResource("image/association.png")));
	       JLabel labelleft5 = new JLabel(new ImageIcon(getClass().getClassLoader()
	    		   .getResource("image/heritage.png")));
	       
	       JLabel labelClass =new JLabel(new ImageIcon(getClass().getClassLoader()	    		   
	               .getResource("image/class.png")));
	       
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
		  
		  panelRight.add(labelClass);
		  
		  labelClass.addMouseListener(new MouseAdapter()  
		  {  
		      public void mouseClicked(MouseEvent e)  
		      {  
		    	  currentCompenent=6;
		      }  
		  });
		  labelLeft4.addMouseListener(new MouseAdapter()  
		  {  
		      public void mouseClicked(MouseEvent e)  
		      {  
		    	  currentCompenent=4;
       	      }  
		  }); 	  
	  } catch (Exception ex) {
		    System.out.println(ex);
		  }
}  
}

