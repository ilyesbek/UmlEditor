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

import Uml.Uml;
import Uml.UmlEntityClass;
import Uml.UmlEntityObject;
import Uml.UmlUseCase;
import Uml.UmlTool.EnumEntity;
import Uml.UmlTool.EnumRelation;
import Uml.UmlTool.UmlActor;
import Uml.UmlTool.UmlCircle;
import WindowUml.PanelCenter;

/**
 *  Author Yacine
 *  when click in Association
 */

public class UmlOptionRelationChoice extends JDialog {
	
	private static final long serialVersionUID = 1L;
	
/*Create relation object and class*/

public UmlOptionRelationChoice (PanelCenter panelCenter,ArrayList<UmlEntityObject> listUmlEntityObject,ArrayList<UmlEntityClass> listUmlEntityClass, EnumEntity enumEntity, int currentCompenent){

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
			    	   panelCenter.addDraw(entity1,entity2,EnumRelation.aggregation,true);
				  if(currentCompenent==2)
			    	   panelCenter.addDraw(entity1,entity2,EnumRelation.composition,true);
				  if(currentCompenent==3)
			    	   panelCenter.addDraw(entity1,entity2,EnumRelation.dependance,true);				  
				  else if(currentCompenent==4)
		    	   panelCenter.addDraw(entity1,entity2,EnumRelation.association,true);
				  if(currentCompenent==5)
			    	   panelCenter.addDraw(entity1,entity2,EnumRelation.heritage,true);
			  }
			});
 }

/*UmlUseCase*/
public UmlOptionRelationChoice (PanelCenter panelCenter,ArrayList<UmlUseCase> listUmlUseCase, ArrayList<UmlActor> listUmlActor ,ArrayList<UmlCircle> listUmlCircle,int currentCompenent){
	 
	JPanel panel = new JPanel (); 
	 
	 ArrayList<String>listTitleUseCase = new  ArrayList<String>();
	 ArrayList<String>listTitleUmlCircle = new  ArrayList<String>();
	 ArrayList<String>listTitleUmlActor = new  ArrayList<String>();
	 
	 ArrayList<String>listTitleUseCaseAll = new  ArrayList<String>();
	 
	 for(int i = 0; i < listUmlUseCase.size(); ++i)
		 listTitleUseCase.add(listUmlUseCase.get(i).getTitle());
	 
	 for(int i = 0; i < listUmlCircle.size();++i)
		listTitleUmlCircle.add(listUmlCircle.get(i).getTitle());

	 for(int i = 0; i < listUmlActor.size();++i)
			listTitleUmlActor.add(listUmlActor.get(i).getTitle());
	 
    JLabel labelClass1 = new JLabel("Classe 1 : "); 
	JLabel labelClass2 = new JLabel("Classe 2 : "); 

	JButton buttonValidate = new JButton("Valider"); 
	
	listTitleUseCaseAll.addAll(listTitleUseCase);
	listTitleUseCaseAll.addAll(listTitleUmlCircle);
	listTitleUseCaseAll.addAll(listTitleUmlActor);
	
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
					 
					 for(int i = 0; i < listUmlActor.size(); ++i)
						  if(listTitleUseCaseAll.get(boxClass1.getSelectedIndex())==listUmlActor.get(i).getTitle() || listTitleUseCaseAll.get(boxClass2.getSelectedIndex())==listUmlActor.get(i).getTitle() )
						  {
							  if(umlUseCase1==null)
								   umlUseCase1=listUmlActor.get(i);
							  else if(umlUseCase2==null)
								  umlUseCase2=listUmlActor.get(i);
							  else break;
						  }

					 for(int i = 0; i < listUmlCircle.size(); ++i)
						  if(listTitleUseCaseAll.get(boxClass1.getSelectedIndex())==listUmlCircle.get(i).getTitle() || listTitleUseCaseAll.get(boxClass2.getSelectedIndex())==listUmlCircle.get(i).getTitle() )
						  {
							  if(umlUseCase1==null)
								   umlUseCase1=listUmlCircle.get(i);
							  else if(umlUseCase2==null)
								  umlUseCase2=listUmlCircle.get(i);
							  else break;
						  }
						 
			  if(currentCompenent==1)
			       panelCenter.addDraw(umlUseCase1,umlUseCase2,EnumRelation.dependance,false);
				  if(currentCompenent==2)
			       panelCenter.addDraw(umlUseCase1,umlUseCase2,EnumRelation.association,false);
				  if(currentCompenent==3)
			       panelCenter.addDraw(umlUseCase1,umlUseCase2,EnumRelation.heritage,false);
				  else if(currentCompenent==4)
			       panelCenter.addDraw(umlUseCase1,umlUseCase2,EnumRelation.association,false);
				  if(currentCompenent==5)
			       panelCenter.addDraw(umlUseCase1,umlUseCase2,EnumRelation.association,false);
			  }
			});
 }
}
