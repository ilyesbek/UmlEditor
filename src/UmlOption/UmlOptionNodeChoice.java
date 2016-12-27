package UmlOption;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Uml.EnumEntity;
import Uml.EnumRelation;
import Uml.Uml;
import Uml.UmlEntityClass;
import Uml.UmlEntityObject;
import Uml.UmlUseCase;
import Uml.UmlUseCaseActor;
import Uml.UmlUseCaseCircle;
import WindowUml.PanelCenter;

/**
 *  Author Yacine
 *  when click in Association
 */

public class UmlOptionNodeChoice extends JDialog {
	

	private static final long serialVersionUID = 1L;
	
/*Create relation object and class*/

public UmlOptionNodeChoice (PanelCenter panelCenter,ArrayList<UmlEntityObject> listUmlEntityObject,ArrayList<UmlEntityClass> listUmlEntityClass, EnumEntity enumEntity, int currentCompenent){

	JPanel panel = new JPanel (); 
	 
	 ArrayList<String>listTitleEntity = new  ArrayList<String>();
	 
	if(enumEntity==EnumEntity.Class)
	{
	 for(int i = 0; i < listUmlEntityClass.size(); ++i)
	    listTitleEntity.add(listUmlEntityClass.get(i).getTitle());
	}
	else
	{
		 for(int i = 0; i < listUmlEntityObject.size(); ++i)
			    listTitleEntity.add(listUmlEntityObject.get(i).getTitle());
	}
		
    JLabel labelClass1 = new JLabel("Entity 1 : "); 
	JLabel labelClass2 = new JLabel("Entity 2 : "); 

	JButton buttonValidate = new JButton("Valider"); 
	
     String [] array = listTitleEntity.toArray(new String[listTitleEntity.size()]);  
	 JComboBox<String>  boxClass1 = new JComboBox<String> (array);
     JComboBox<String>  boxClass2 = new JComboBox<String> (array);
  
	   JPanel b1 = new JPanel();	 
	   b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
	   b1.add(labelClass1);
	   b1.add(Box.createRigidArea(new Dimension(40,50)));
	   b1.add(boxClass1);
	   
	   JPanel b2 = new JPanel();
	   b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
	   b2.add(labelClass2);
	   b2.add(Box.createRigidArea(new Dimension(40,50)));
	   b2.add(boxClass2);
	   
	   panel.add(b1);
	   panel.add(b2);	 
	   panel.add(buttonValidate);
	   add(panel);
	   setSize(200,200);
	   setVisible(true);
	   setAlwaysOnTop(true);
	   setLocationRelativeTo(null);
		
		  buttonValidate.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent event){
				  Uml entity1 = null;
				  Uml entity2 = null;
				  if(enumEntity==EnumEntity.Class)
			    { 
				  entity1=listUmlEntityClass.get(boxClass1.getSelectedIndex());
				  entity2=listUmlEntityClass.get(boxClass2.getSelectedIndex());
			    }
				  else
				  {
					  entity1=listUmlEntityObject.get(boxClass1.getSelectedIndex());
					  entity2=listUmlEntityObject.get(boxClass2.getSelectedIndex());
				  }
				  if(currentCompenent==1)
			    	   panelCenter.addDraw(entity1,entity2,EnumRelation.aggregation);
				  if(currentCompenent==2)
			    	   panelCenter.addDraw(entity1,entity2,EnumRelation.composition);
				  if(currentCompenent==3)
			    	   panelCenter.addDraw(entity1,entity2,EnumRelation.dependance);				  
				  else if(currentCompenent==4)
		    	   panelCenter.addDraw(entity1,entity2,EnumRelation.association);
				  if(currentCompenent==5)
			    	   panelCenter.addDraw(entity1,entity2,EnumRelation.heritage);
			  }
			});
 }

/*UmlUseCase*/
public UmlOptionNodeChoice (PanelCenter panelCenter,ArrayList<UmlUseCase> listUmlUseCase, ArrayList<UmlUseCaseActor> listUmlUseCaseActor ,ArrayList<UmlUseCaseCircle> listUmlUseCaseCircle,int currentCompenent){
	 
	JPanel panel = new JPanel (); 
	 
	 ArrayList<String>listTitleUseCase = new  ArrayList<String>();
	 ArrayList<String>listTitleUseCaseCircle = new  ArrayList<String>();
	 ArrayList<String>listTitleUseCaseActor = new  ArrayList<String>();
	 
	 ArrayList<String>listTitleUseCaseAll = new  ArrayList<String>();
	 
	 for(int i = 0; i < listUmlUseCase.size(); ++i)
		 listTitleUseCase.add(listUmlUseCase.get(i).getTitle());
	 
	 for(int i = 0; i < listUmlUseCaseCircle.size();++i)
		listTitleUseCaseCircle.add(listUmlUseCaseCircle.get(i).getTitle());

	 for(int i = 0; i < listUmlUseCaseActor.size();++i)
			listTitleUseCaseActor.add(listUmlUseCaseActor.get(i).getTitle());
	 
    JLabel labelClass1 = new JLabel("Classe 1 : "); 
	JLabel labelClass2 = new JLabel("Classe 2 : "); 

	JButton buttonValidate = new JButton("Valider"); 
	
	listTitleUseCaseAll.addAll(listTitleUseCase);
	listTitleUseCaseAll.addAll(listTitleUseCaseCircle);
	listTitleUseCaseAll.addAll(listTitleUseCaseActor);
	
     String [] array = listTitleUseCaseAll.toArray(new String[listTitleUseCaseAll.size()]);  
	 JComboBox<String>  boxClass1 = new JComboBox<String> (array);
     JComboBox<String>  boxClass2 = new JComboBox<String> (array);
  
	   JPanel b1 = new JPanel();	 
	   b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
	   b1.add(labelClass1);
	   b1.add(Box.createRigidArea(new Dimension(40,50)));
	   b1.add(boxClass1);
	   
	   JPanel b2 = new JPanel();
	   b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
	   b2.add(labelClass2);
	   b2.add(Box.createRigidArea(new Dimension(40,50)));
	   b2.add(boxClass2);
	   
	   panel.add(b1);
	   panel.add(b2);	 
	   panel.add(buttonValidate);
	   add(panel);
	   setSize(200,200);
	   setVisible(true);
	   setAlwaysOnTop(true);
	   setLocationRelativeTo(null);
		
		  buttonValidate.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent event){
				  Uml umlUseCase1 = null;
				  Uml umlUseCase2 = null;
				  
				  
					 for(int i = 0; i < listUmlUseCase.size(); ++i)
						  if(listTitleUseCaseAll.get(boxClass1.getSelectedIndex())==listUmlUseCase.get(i).getTitle() || listTitleUseCaseAll.get(boxClass2.getSelectedIndex())==listUmlUseCase.get(i).getTitle())
						  {
							  if(umlUseCase1==null)
								   umlUseCase1=listUmlUseCase.get(i);
							  else if(umlUseCase2==null)
								  umlUseCase2=listUmlUseCase.get(i);
							  else break;
						  }
					 
					 for(int i = 0; i < listUmlUseCaseActor.size(); ++i)
						  if(listTitleUseCaseAll.get(boxClass1.getSelectedIndex())==listUmlUseCaseActor.get(i).getTitle() || listTitleUseCaseAll.get(boxClass2.getSelectedIndex())==listUmlUseCaseActor.get(i).getTitle() )
						  {
							  if(umlUseCase1==null)
								   umlUseCase1=listUmlUseCaseActor.get(i);
							  else if(umlUseCase2==null)
								  umlUseCase2=listUmlUseCaseActor.get(i);
							  else break;
						  }

					 for(int i = 0; i < listUmlUseCaseCircle.size(); ++i)
						  if(listTitleUseCaseAll.get(boxClass1.getSelectedIndex())==listUmlUseCaseCircle.get(i).getTitle() || listTitleUseCaseAll.get(boxClass2.getSelectedIndex())==listUmlUseCaseCircle.get(i).getTitle() )
						  {
							  if(umlUseCase1==null)
								   umlUseCase1=listUmlUseCaseCircle.get(i);
							  else if(umlUseCase2==null)
								  umlUseCase2=listUmlUseCaseCircle.get(i);
							  else break;
						  }
						 
			 // if(currentCompenent==1)
			    	//  panelCenter.addDraw(listUmlEntityClass.get(boxClass1.getSelectedIndex()),listUmlEntityClass.get(boxClass2.getSelectedIndex()),TypeRelation.aggregation);
				  if(currentCompenent==2)
			       panelCenter.addDraw(umlUseCase1,umlUseCase2,EnumRelation.association);
				/*  if(currentCompenent==3)
			    	 panelCenter.addDraw(listUmlEntityClass.get(boxClass1.getSelectedIndex()),listUmlEntityClass.get(boxClass2.getSelectedIndex()),TypeRelation.dependance);				  
				  else if(currentCompenent==4)
		    	  panelCenter.addDraw(listUmlEntityClass.get(boxClass1.getSelectedIndex()),listUmlEntityClass.get(boxClass2.getSelectedIndex()),TypeRelation.association);
				  if(currentCompenent==5)
			    	   panelCenter.addDraw(listUmlEntityClass.get(boxClass1.getSelectedIndex()),listUmlEntityClass.get(boxClass2.getSelectedIndex()),TypeRelation.heritage);*/
			  }
			});
 }
}
