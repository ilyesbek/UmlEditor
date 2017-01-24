package WindowUml;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import Uml.UmlUseCase;
import Uml.UmlTool.UmlActor;
import Uml.UmlTool.UmlCircle;
import UmlOption.UmlOptionRelationChoice;

/**
 * Author Yacine and Ilyes
 * This class represent a window for Uml Use Case
 */

public class WindowUmlUseCase extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelLeft = new JPanel();
	 private JPanel panelRight = new JPanel();
	 private PanelCenter panelCenter= new PanelCenter();
	 
	   private ArrayList<UmlUseCase> listUmlUseCase = new ArrayList<UmlUseCase>();
	   private ArrayList<UmlCircle> listUmlCircle = new ArrayList<UmlCircle>();
	   private ArrayList<UmlActor> listUmlActor = new ArrayList<UmlActor>();
	   
	 private int currentCompenent=0; 
	 
	 public WindowUmlUseCase(){
		 
		 super();
	   
			panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.PAGE_AXIS)); // component to bell will add in vertical
			panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.PAGE_AXIS));
	        panelCenter.setLayout(null);
	        
	        getContentPane().setBackground(Color.WHITE); // change background to white
		    panelLeft.setBackground(Color.WHITE); // change panelLeft to white
		    panelRight.setBackground(Color.WHITE); // change panelRight to white
		    panelCenter.setBackground(Color.WHITE); // change panelCenter to Red
		    
			setTitle("Diagramme cas d'Utilisation");
			setSize(800,600);
		    setVisible(true);
		    setAlwaysOnTop(true);
			setLocationRelativeTo(null);
			
			insertPanel(panelLeft,panelRight);
			this.add(panelLeft,BorderLayout.LINE_START); // add panel left in left jframe
			this.add(panelCenter,BorderLayout.CENTER);// add pannel right in center jframe	
			this.add(panelRight,BorderLayout.LINE_END);// add pannel right in right jframe

			panelCenter.addMouseListener(new MouseAdapter()  
			  {  
			      public void mouseClicked(MouseEvent e)  
			      {  
			    	  
			    	  if(currentCompenent==1){
			    		//  UmlOptionNodeChoice nodeUml = new UmlOptionNodeChoice(panelCenter,listUmlUseCase,currentCompenent);
				    		 currentCompenent=0;
			    	  }
			    	  else if(currentCompenent==2){
				   		   new UmlOptionRelationChoice(panelCenter,listUmlUseCase,listUmlActor,listUmlCircle,currentCompenent);
					    		 currentCompenent=0;
				    	  } 
			    	  else if(currentCompenent==3){
				   		  //UmlOptionNodeChoice nodeUml = new UmlOptionNodeChoice(panelCenter,listUmlUseCase,currentCompenent);
					    		 currentCompenent=0;
				    	  } 
			    	  else if(currentCompenent==4){
			    		  UmlActor umlActor = new UmlActor(panelCenter);
				    		 listUmlActor.add(umlActor);
				    		 panelCenter.add(umlActor);
				    		 panelCenter.revalidate();
				    	     panelCenter.repaint();
				    		 currentCompenent=0;
			    	  }
			    	  else if(currentCompenent==5){
			    	 	  UmlCircle umlCircle = new UmlCircle(panelCenter);
				    		 listUmlCircle.add(umlCircle);
				    		panelCenter.add(umlCircle);
				    		 panelCenter.revalidate();
				    	     panelCenter.repaint();
				    		 currentCompenent=0;
				    	  } 
			    		    
			      else if(currentCompenent==6){
			    	  UmlUseCase umlUseCase= new UmlUseCase (panelCenter);
			    		 listUmlUseCase.add(umlUseCase);
			    		 panelCenter.add(umlUseCase);
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
			  
			 
			  
			  labelLeft2.addMouseListener(new MouseAdapter()  
			  {  
			      public void mouseClicked(MouseEvent e)  
			      {  
			    	  currentCompenent=2;
	       	      }  
			  }); 
			  
			  labelStigMan.addMouseListener(new MouseAdapter()  
			  {  
			      public void mouseClicked(MouseEvent e)  
			      {  
			    	  currentCompenent=4;
	       	      }  
			  }); 	
			  
			  
			  labelNode.addMouseListener(new MouseAdapter()  
			  {  
			      public void mouseClicked(MouseEvent e)  
			      {  
			    	  currentCompenent=6;
	       	      }  
			  }); 	
			  
		  } catch (Exception ex) {
			    System.out.println(ex);
			  }

	 }
}
