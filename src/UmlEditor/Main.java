/*Part Ilyes*/

package UmlEditor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Main {
	
	public static MainWindow mainWindow;
	public static UmlProject projet;


	public static void main(String[] args) {
		JMenuBar menubar = new JMenuBar();
						
		JFrame frame = new JFrame("Editeur UML"); // Name of application
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		frame.setSize(1000, 600);// dimension of window
		frame.setLocationRelativeTo(null);// center window
		frame.setResizable(false);// not reseizable
		frame.setAlwaysOnTop(true);//So that the window remains above the other windows
		

		JMenu file = new JMenu("File");
		JMenu menuHelp = new JMenu("?");
		menubar.add(file);
		menubar.add(menuHelp);
		
		JMenu newProject = new JMenu("New");
		JMenuItem help = new JMenuItem("Aide");
		
		file.add(newProject);
		menuHelp.add(help);
		
		JMenuItem newUmlProject = new JMenuItem("New UML Project");
		newProject.add(newUmlProject);
		JMenuItem exit = new JMenuItem("Exit");
		file.add(exit);
		
		
		newUmlProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				projet = new UmlProject(menubar);	 /*transfert parameteter*/	
			};}
		);
		
		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Help();
			};}
		);
		
		
		
		class exitaction implements ActionListener{
			public void actionPerformed (ActionEvent e){
				System.exit(0);
			}
		}
		exit.addActionListener(new exitaction());
		
   		mainWindow = new MainWindow();
		
   		  frame.setContentPane(mainWindow); // We associate the scene with the window of the application
   		  frame.setVisible(true);// To make the window visible
   		  frame.setJMenuBar(menubar);
	}

}
