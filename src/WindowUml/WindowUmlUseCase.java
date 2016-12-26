package WindowUml;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import Uml.UmlUseCase;
import Uml.UmlUseCaseActor;
import Uml.UmlUseCaseCircle;
import UmlOption.UmlOptionNodeChoice;

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
	   private ArrayList<UmlUseCaseCircle> listUmlUseCaseCircle = new ArrayList<UmlUseCaseCircle>();
	   private ArrayList<UmlUseCaseActor> listUmlUseCaseActor = new ArrayList<UmlUseCaseActor>();
	   
	 private int currentCompenent=0; 
	 
	 public WindowUmlUseCase(final JMenuBar menubar){
		 
		 super();
	   
			panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.PAGE_AXIS)); // component to bell will add in vertical
			panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.PAGE_AXIS));
	        panelCenter.setLayout(null);
	        
	        getContentPane().setBackground(Color.WHITE); // change background to white
		    panelLeft.setBackground(Color.WHITE); // change panelLeft to white
		    panelRight.setBackground(Color.WHITE); // change panelRight to white
		    panelCenter.setBackground(Color.WHITE); // change panelCenter to Red
		    
			setTitle("Diagramme cas du'tilisation");
			setSize(800,600);
		    setVisible(true);
		    setAlwaysOnTop(true);
			setLocationRelativeTo(null);
			setJMenuBar(menubar);
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
				   		   new UmlOptionNodeChoice(panelCenter,listUmlUseCase,listUmlUseCaseActor,listUmlUseCaseCircle,currentCompenent);
					    		 currentCompenent=0;
				    	  } 
			    	  else if(currentCompenent==3){
				   		  //UmlOptionNodeChoice nodeUml = new UmlOptionNodeChoice(panelCenter,listUmlUseCase,currentCompenent);
					    		 currentCompenent=0;
				    	  } 
			    	  else if(currentCompenent==4){
			    		  UmlUseCaseActor umlUseCaseActor = new UmlUseCaseActor(panelCenter);
				    		 listUmlUseCaseActor.add(umlUseCaseActor);
				    		 panelCenter.add(umlUseCaseActor);
				    		 panelCenter.revalidate();
				    	     panelCenter.repaint();
				    		 currentCompenent=0;
			    	  }
			    	  else if(currentCompenent==5){
			    	 	  UmlUseCaseCircle umlUseCaseCircle = new UmlUseCaseCircle(panelCenter);
				    		 listUmlUseCaseCircle.add(umlUseCaseCircle);
				    		panelCenter.add(umlUseCaseCircle);
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
