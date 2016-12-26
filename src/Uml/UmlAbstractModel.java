
package Uml;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import WindowUml.PanelCenter;

/**
	 * Author Yacine 
	 * this class represent a abstract representation for all composant Uml
	 */
public  abstract class  UmlAbstractModel extends JPanel{

	private static final long serialVersionUID = 1L;
private Point initialClick;
  private int parentX;
  private int parentY;

	public UmlAbstractModel(PanelCenter parent){
		super();
		parentX = parent.getWidth();
		parentY = parent.getHeight();

this.setLocation(0,0);		
		this.setBorder(BorderFactory.createLineBorder(Color.black)); // change border to black
		this.setBackground(Color.WHITE);//change background to white
	
		
	  addMouseListener(new MouseAdapter(){
		   public void mousePressed(MouseEvent e) {
			   initialClick = e.getPoint();
			setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			   getComponentAt(initialClick);	
		   }
	  });
	  addMouseMotionListener (new MouseMotionAdapter(){
		  @Override
		  public void mouseDragged(MouseEvent e) {
	       
			int thisX= e.getX() -  initialClick .x;
			int thisY= e.getY() -  initialClick .y;	
  		     movePanel(thisX,thisY);//UmlNode.call=true;
  		     parent.repaint();
		  }
	  });	
	}	
	
public void movePanel(int x,int y)
   {
	int moveX=x+this.getX();
	int moveY=y+this.getY();
	
	if(moveX+this.getWidth() < this.parentX && moveX > 0  && moveY+this.getHeight() < this.parentY &&  moveY > 0 )
	   this.setLocation( moveX,moveY);
   }
}
