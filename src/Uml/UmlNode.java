package Uml;

import java.awt.Graphics2D;

import javax.swing.JPanel;

/*public class UmlNode extends UmlAbstractNode{

	public UmlNode(JPanel panelCenter,UmlEntityClass umlClass1, UmlEntityClass umlClass2){
		super(panelCenter,umlClass1,umlClass2);
	}
}*/

public class UmlNode {

	
	public static void addDraw(JPanel panelCenter, UmlEntityClass umlClass1, UmlEntityClass umlClass2) {
		// TODO Auto-generated method stub
		Graphics2D g = (Graphics2D) panelCenter.getGraphics();
		g.drawLine(0,0,500,500);System.out.println("sss");
		panelCenter.repaint();
		panelCenter.revalidate();
	}


}
