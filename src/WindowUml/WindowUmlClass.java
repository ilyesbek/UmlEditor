/*Part Ilyes and Yacine*/

package WindowUml;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class WindowUmlClass extends JPanel {
	
	 private JFrame frame = new JFrame("Diagramme de classe");
	
	 
    private JLabel label;
    private ImageIcon Class;
	private ImageIcon icoFond;
	private Image imgFond;
	private int xFond;
	
	
	
	public WindowUmlClass(final JMenuBar menubar){
		
		
		
		super();
		
		
		this.proprietesDiagramme();
		
	
		
	      this.xFond = -50;
			
			icoFond = new ImageIcon(getClass().getResource("/image/Background.png"));
			this.imgFond =this.icoFond.getImage();
			
			frame.setSize(1000,600);
			frame.setVisible(true);
			frame.setAlwaysOnTop(true);
			frame.setContentPane(this);
			frame.setResizable(false);
			frame.setLocationRelativeTo(null);
			frame.setJMenuBar(menubar);
			
			
}
	
private void proprietesDiagramme() {
	this.afficheImage();
		
	}

public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;
		
		g2.drawImage(this.imgFond, this.xFond, 0, null);
		g2.drawRect(10, 10, 100, 520);
		g2.drawRect(880, 10, 100, 520);
		
	}

private void afficheImage(){
	label = new JLabel();
	Class = new ImageIcon("image/class.png");
	this.label.setBounds(100, 100, 64, 64);
	this.label.setIcon(Class);
	this.add(label);
	
	
}




}

