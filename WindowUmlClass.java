/*Yacine and ilyes */
package UmlWindow;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WindowUmlClass extends JPanel {
	private JLabel DiagramChoice;
	
	private ImageIcon icoFond;
	private Image imgFond;
	
	JButton button = new JButton();
    JFrame frame = new JFrame();
	
	private int xFond;
	
	
	public WindowUmlClass(){
	
		super();
		
		this.proprietesProjet();
		
        this.xFond = -50;
		
		icoFond = new ImageIcon(getClass().getResource("/image/Background.png"));
		this.imgFond =this.icoFond.getImage();
		
		button.setText("Diagramme de Classes");
		button.setBounds(100, 200, 180, 20);	
		
		frame.setSize(1000,600);
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		frame.setVisible(true); 
		frame.setContentPane(this);
		frame.add(button);
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
