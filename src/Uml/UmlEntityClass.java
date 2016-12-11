/*Part Yacine*/

/*This class represent a Entity for uml class*/
package Uml;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import UmlOption.UmlOptionClass;




public class UmlEntityClass extends UmlAbstractModel{

	 public UmlEntityClass(JPanel panel){
		super(panel);
		
		this.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) { 
		    	  if(e.getClickCount()==2){
		             UmlOptionClass windowOptionClass = new UmlOptionClass();
		         }
		    }
		});
		
	}
}
