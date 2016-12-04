/*Part Ilyes and Yacine*/

package WindowUml;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class WindowUmlClass extends JPanel {
	
	 private JFrame frame = new JFrame("Diagramme de classe");
	
	private ImageIcon icoFond;
	private Image imgFond;
	private int xFond;
	
	public WindowUmlClass(final JMenuBar menubar){
		
		
		super();
		
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
	
public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;
		
		g2.drawImage(this.imgFond, this.xFond, 0, null);
		g2.drawRect(10, 10, 100, 520);
		g2.drawRect(880, 10, 100, 520);
	}


}

