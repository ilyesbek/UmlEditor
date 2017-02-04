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

import Uml.UmlEntityObject;
import Uml.UmlTool.EnumEntity;
import Uml.UmlTool.UmlRectangle;
import UmlOption.UmlOptionRelationChoice;

/**
*Author Yacine and Ilyes
*This class represent a window for Uml Object
*/

public class WindowUmlObject extends JFrame{

	private static final long serialVersionUID = 1L;

	private int currentCompenent=0; 
	   
    private JPanel panelLeft = new JPanel();
    private JPanel panelRight = new JPanel();
    private PanelCenter panelCenter= new PanelCenter ();
    
    private ArrayList<UmlEntityObject> listUmlEntityObject = new ArrayList<UmlEntityObject>();
    private ArrayList<UmlRectangle> listUmlRectangle = new ArrayList<UmlRectangle>();
    
   public WindowUmlObject() {
	   
	   super();
		
		panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.PAGE_AXIS)); // component to bell will add in vertical
		panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.PAGE_AXIS));
       panelCenter.setLayout(null);
		
	    getContentPane().setBackground(Color.WHITE); // change background to white
	    panelLeft.setBackground(Color.WHITE); // change panelLeft to white
	    panelRight.setBackground(Color.WHITE); // change panelRight to white
	    panelCenter.setBackground(Color.WHITE); // change panelCenter to white   
	
		setTitle("Diagramme d'objet");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	    setVisible(true);
	    setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		
		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("File");
		menubar.add(file);
		JMenuItem clear = new JMenuItem("Clear");
		file.add(clear);
		setJMenuBar(menubar);
		
		  clear.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {
	              panelCenter.removeAll();
	              panelCenter.removeRelation();
	              listUmlEntityObject.clear();
	              listUmlRectangle .clear();
	              panelCenter.updateUI();
	            }
	        });

		
		insertPanel(panelLeft,panelRight);
		this.add(panelLeft,BorderLayout.LINE_START); // add panel left in left jframe
		this.add(panelCenter,BorderLayout.CENTER);// add pannel right in center jframe	
		this.add(panelRight,BorderLayout.LINE_END);// add pannel right in right jframe

		panelCenter.addMouseListener(new MouseAdapter()  
		  {  
		      public void mouseClicked(MouseEvent e)  
		      {  
		    	  
		    	  if(currentCompenent==1){
		    		  new UmlOptionRelationChoice(panelCenter,listUmlEntityObject,null, EnumEntity.Object,currentCompenent);
			    		 currentCompenent=0;
		    	  }
		    	  else if(currentCompenent==2){
			   		  new UmlOptionRelationChoice(panelCenter,listUmlEntityObject,null, EnumEntity.Object,currentCompenent);
				    		 currentCompenent=0;
			    	  } 
		    	  else if(currentCompenent==3){
			   		  new UmlOptionRelationChoice(panelCenter,listUmlEntityObject,null, EnumEntity.Object,currentCompenent);
				    		 currentCompenent=0;
			    	  } 
		    	  else if(currentCompenent==4){
		    		  new UmlOptionRelationChoice(panelCenter,listUmlEntityObject,null, EnumEntity.Object,currentCompenent);
			    		 currentCompenent=0;
		    	  }
		    	  else if(currentCompenent==5){
			   		  new UmlOptionRelationChoice(panelCenter,listUmlEntityObject,null, EnumEntity.Object,currentCompenent);
				    		 currentCompenent=0;
			    	  } 
		    		    
		      else if(currentCompenent==6){
		    		 UmlEntityObject umlObject = new UmlEntityObject (panelCenter);
		    		 listUmlEntityObject.add(umlObject);
		    		 panelCenter.add(umlObject);
		    		 panelCenter.revalidate();
		    	     panelCenter.repaint();
		    		 currentCompenent=0;
		    	  }
		    	  
		      else if(currentCompenent==8){
		    		 UmlRectangle rectangle = new  UmlRectangle  (panelCenter);
		    		 listUmlRectangle.add(rectangle);
		    		 panelCenter.add(rectangle);
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
	       JLabel labelLeft5 = new JLabel(new ImageIcon(getClass().getClassLoader()
	    		   .getResource("image/heritage.png")));
	       
	       JLabel labelClass = new JLabel(new ImageIcon(getClass().getClassLoader()	    		   
	               .getResource("image/objet.png")));
	       
	       
		  panelLeft.add(labelLeft1);	
		  panelLeft.add(Box.createVerticalGlue());  // add space beetwen component
		  
		  panelLeft.add(labelLeft2);
		  panelLeft.add(Box.createVerticalGlue());
		  
		  panelLeft.add(labelLeft3);
		  panelLeft.add(Box.createVerticalGlue());
		  
		  panelLeft.add(labelLeft4);
		  panelLeft.add(Box.createVerticalGlue());
		  
		  panelLeft.add(labelLeft5);
		  panelLeft.add(Box.createVerticalGlue());
		  
		  panelRight.add(labelClass);
		  panelRight.add(Box.createVerticalGlue());
		  
		  
		  
		  labelClass.addMouseListener(new MouseAdapter()  
		  {  
		      public void mouseClicked(MouseEvent e)  
		      {  
		    	  currentCompenent=6;
		      }  
		  });
		  labelLeft1.addMouseListener(new MouseAdapter()  
		  {  
		      public void mouseClicked(MouseEvent e)  
		      {  
		    	  currentCompenent=1;
      	      }  
		  }); 	
		  labelLeft2.addMouseListener(new MouseAdapter()  
		  {  
		      public void mouseClicked(MouseEvent e)  
		      {  
		    	  currentCompenent=2;
      	      }  
		  }); 	
		  labelLeft3.addMouseListener(new MouseAdapter()  
		  {  
		      public void mouseClicked(MouseEvent e)  
		      {  
		    	  currentCompenent=3;
      	      }  
		  }); 	
		  labelLeft4.addMouseListener(new MouseAdapter()  
		  {  
		      public void mouseClicked(MouseEvent e)  
		      {  
		    	  currentCompenent=4;
      	      }  
		  }); 	  
		  labelLeft5.addMouseListener(new MouseAdapter()  
		  {  
		      public void mouseClicked(MouseEvent e)  
		      {  
		    	  currentCompenent=5;
      	      }  
		  }); 	
		  

	  } catch (Exception ex) {
		    System.out.println(ex);
		  }
}  
}
	   


