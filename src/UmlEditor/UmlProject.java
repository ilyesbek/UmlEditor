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

import WindowUml.WindowUmlClass;
import WindowUml.WindowUmlUseCase;

public class UmlProject extends JPanel {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame = new JFrame("Choix diagramme");
	private  JButton buttonUmlClass = new JButton();
	private  JButton buttonUmlUseCase = new JButton();
		
	private JLabel DiagramChoice;
	private JLabel DiagramType;
	
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
	    buttonUmlClass .setBounds(100, 280, 180, 20);
	    
	    buttonUmlUseCase .setText("Diagramme de Cas D'utilisation");
		buttonUmlUseCase .setBounds(450, 281, 220, 20);
		
		frame.setSize(1000,600);
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
		frame.setLocationRelativeTo(null);
		frame.setContentPane(this);
		frame.setResizable(false);
		frame.add(buttonUmlClass);
		frame.add(buttonUmlUseCase);
		
		buttonUmlClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				WindowUmlClass  windowUmlClass = new WindowUmlClass(menubar);	/*passe the parametre to Uml Class*/
				dispose();
			};});
		
		buttonUmlUseCase.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e1) {
				WindowUmlUseCase windowUmlUseCase = new WindowUmlUseCase(menubar);
				dispose();
				
			};});

	}
	
	private void dispose(){
		
		frame.setVisible(false);
	}
	
	
private void proprietesProjet(){
		
		this.setLayout(null);
		this.proprietesEtiquette();
		this.proprietesEtiquette1();
		this.proprietesEtiquette2();
	}
	
	
	private void proprietesEtiquette(){
		
		DiagramChoice = new JLabel();
		this.DiagramChoice.setBounds(400, 100, 700, 50);
		this.DiagramChoice.setText("Choisissez un type de diagramme ");
		this.add(DiagramChoice);
	}
	
	private void proprietesEtiquette1(){
		DiagramType = new JLabel();
		this.DiagramType.setBounds(125, 200, 700, 50);
		this.DiagramType.setText("Diagramme de structures");
		this.add(DiagramType);
	}
	
	private void proprietesEtiquette2(){
		DiagramType = new JLabel();
		this.DiagramType.setBounds(450, 215, 700, 20);
		this.DiagramType.setText("Diagramme de comportement");
		this.add(DiagramType);
	}
public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;
		
		g2.drawImage(this.imgFond, this.xFond, 0, null);
	}


}
