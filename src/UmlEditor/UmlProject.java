/*Part Ilyes and Yacine*/

package UmlEditor;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import UmlOption.UmlOptionClass;
import WindowUml.WindowUmlClass;

public class UmlProject extends JPanel {
	
    private JFrame frame = new JFrame("Choix diagramme");
	private  JButton buttonUmlClass = new JButton();
	private WindowUmlClass windowUmlClass ;
		
	private JLabel DiagramChoice;
	
	private ImageIcon icoFond;
	private Image imgFond;
	
	
	private int xFond;
	
	
	public UmlProject(final JMenuBar menubar){
	
		super();
		
		this.proprietesProjet();
		
      this.xFond = -50;
		
		icoFond = new ImageIcon(getClass().getResource("/image/Background.png"));
		this.imgFond =this.icoFond.getImage();

	    buttonUmlClass .setText("Diagramme de Classes");
	    buttonUmlClass .setBounds(100, 200, 180, 20);
		
		frame.setSize(1000,600);
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
		frame.setContentPane(this);
		frame.setResizable(false);
		frame.add(buttonUmlClass);
		
		buttonUmlClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				 windowUmlClass = new WindowUmlClass(menubar);	/*passe the parametre to Uml Class*/	
			};});

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
