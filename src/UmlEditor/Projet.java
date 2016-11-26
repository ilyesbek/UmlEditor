import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Projet extends JPanel {
	
	
	private ImageIcon icoFond;
	private Image imgFond;
	
	private int xFond;
	
	
	public Projet(){
	
		super();
		
      this.xFond = -50;
		
		icoFond = new ImageIcon(getClass().getResource("/image/fondBlanc.png"));
		this.imgFond =this.icoFond.getImage();
	}
	
	
public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;
		
		g2.drawImage(this.imgFond, this.xFond, 0, null);
	}

}
