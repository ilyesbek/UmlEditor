/*Part Yacine*/

/*With this class, we can creat a entity in JFrame*/
package Uml;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class  UmlAbstractModel extends JPanel{

  private Point initialClick;
  private JFrame parent;
  
	UmlAbstractModel(){
		super();
		this.setBorder(BorderFactory.createLineBorder(Color.black)); // change border to black
		this.setBackground(Color.WHITE);//change background to white
	  
	  addMouseListener(new MouseAdapter(){
		   public void mousePressed(MouseEvent e) {
			   initialClick = e.getPoint();
			   getComponentAt(initialClick);		   
		   }
	  });
	  addMouseMotionListener (new MouseMotionAdapter(){
		  @Override
		  public void mouseDragged(MouseEvent e) {
			  //get location of Window
			  int thisX = parent.getLocation().x;
			  int thisY = parent.getLocation().y;
			  
			  //determine how much the mouse moved since the initial click
			  
			  int xMoved = (thisX + e.getX()) - (thisY + initialClick.x);
			  int yMoved =  (thisY + e.getY()) - (thisY + initialClick.y);
              
			  //move Window to this position
			  int X = thisX +xMoved;
			   int Y = thisY + yMoved;
	            parent.setLocation(X,Y);
		  }
	  });
	}


}
