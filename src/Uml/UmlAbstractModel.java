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

public  abstract class  UmlAbstractModel extends JPanel{

  private Point initialClick;
  private int x;
  private int y;

	public UmlAbstractModel(JPanel parent){
		super();
		x=parent.getX();
		y=parent.getY();

this.setLocation(580, 200);		
		this.setBorder(BorderFactory.createLineBorder(Color.black)); // change border to black
		this.setBackground(Color.WHITE);//change background to white
		this.setSize(100,100);
	  addMouseListener(new MouseAdapter(){
		   public void mousePressed(MouseEvent e) {
			   initialClick = e.getPoint();
			   getComponentAt(initialClick);		   
		   }
	  });
	  addMouseMotionListener (new MouseMotionAdapter(){
		  @Override
		  public void mouseDragged(MouseEvent e) {
		if(e.getX() > 0 && e.getX() < parent.getWidth() && e.getY() > 0 && e.getY() < parent.getHeight())	
		{
			 //get location of Window
			  int thisX = x;
			  int thisY = y;
			  
			  //determine how much the mouse moved since the initial click
			  
			  int xMoved = (thisX + e.getX()) - (thisX + initialClick.x);
			  int yMoved =  (thisY + e.getY()) - (thisY + initialClick.y);
				System.out.println("Xmo ; "+e.getX()+" Ymo : "+e.getY());
			  //move Window to this position
			  int X = thisX +xMoved;
			   int Y = thisY + yMoved;
	           // parent.setLocation(X,Y);
			  movePanel(e.getX(),e.getY());
		  }
		  }
	  });	
	}
	
	
	
public void movePanel(int x,int y)
   {
	System.out.println("X: "+this.getX()+" Y :"+y);
	   this.setLocation(x,y);
   }

}
