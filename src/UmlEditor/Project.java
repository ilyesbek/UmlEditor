package UmlEditor;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Project extends JPanel {
	
	private JLabel DiagramChoice;
	
	private ImageIcon icoFond;
	private Image imgFond;
	
	
	private int xFond;
	
	
	public Project(){
	
		super();
		
		this.proprietesProjet();
		
      this.xFond = -50;
		
		icoFond = new ImageIcon(getClass().getResource("/image/Background.png"));
		this.imgFond =this.icoFond.getImage();

	}
	
	
private void proprietesProjet(){
		
		this.setLayout(null);
		this.proprietesEtiquette();
	}
	
	
	private void proprietesEtiquette(){
		
		DiagramChoice = new JLabel();
		this.DiagramChoice.setBounds(400, 100, 700, 50);
		this.DiagramChoice.setText("Choisissez un type de diagramme ");
		this.add(DiagramChoice);
	}
	
public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;
		
		g2.drawImage(this.imgFond, this.xFond, 0, null);
	}


}
