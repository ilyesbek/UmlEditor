/*Part Yacine*/
package Uml;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class UmlAbstractNode {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int x1;
private int y1;
private int x2;
private int y2;

public UmlAbstractNode(JPanel panelCenter,UmlEntityClass umlClass1, UmlEntityClass umlClass2) {
super();
Graphics2D g = (Graphics2D) panelCenter.getGraphics();
g.drawLine(0,0,500,500);
panelCenter.repaint();
panelCenter.revalidate();
/*x1 = umlClass1.getX();
y1 = umlClass1.getY();	
x2 = umlClass2.getX();	
y2 = umlClass2.getY();
setSize(panelCenter.getSize());
setEnabled(false);*/
}

/*@Override
public void paintComponent(Graphics g) {
	  super.paintComponent(g);
	  g.setColor(Color.black);System.out.println(x1);
	  g.drawLine(0,0,500,500); // g.drawRect(0, 0, 100, 100);

	}*/
}

