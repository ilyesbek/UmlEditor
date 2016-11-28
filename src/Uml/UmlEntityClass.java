/*Part Yacine*/

/*This class represent a Entity for uml class*/
package Uml;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import UmlOption.UmlOptionClass;




public class UmlEntityClass extends UmlAbstractModel{

	 UmlEntityClass(){
		super();
		
		this.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) { 
		    	 if(e.getClickCount()==2){
		            UmlOptionClass windowOptionClass = new UmlOptionClass();
		            windowOptionClass.setVisible(true);
		         }
		    }
		});
		
	}
}
