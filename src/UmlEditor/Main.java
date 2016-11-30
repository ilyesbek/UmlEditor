/*Part Ilyes*/

package UmlEditor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Main {
	
	public static MainWindow mainWindow;
	public static Project projet;
	public static ClassDiagram classDiagram;

	public static void main(String[] args) {
		JMenuBar menubar = new JMenuBar();
	
		
		
		
		
		JFrame fenetre = new JFrame("Editeur UML"); // Name of application
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		fenetre.setSize(1000, 600);// dimension of window
		fenetre.setLocationRelativeTo(null);// center window
		fenetre.setResizable(false);
		fenetre.setAlwaysOnTop(true);//So that the window remains above the other windows
		

		JMenu file = new JMenu("File");
		menubar.add(file);
		JMenu newProject = new JMenu("New");
		file.add(newProject);
		JMenuItem newUmlProject = new JMenuItem("New UML Project");
		newProject.add(newUmlProject);
		JMenuItem save = new JMenuItem("Save");
		file.add(save);
		JMenuItem exit = new JMenuItem("Exit");
		file.add(exit);
		
		JMenu edit = new JMenu("Edit");
		menubar.add(edit);
		
		JMenu view = new JMenu("View");
		menubar.add(view);
		
		JMenu help = new JMenu("Help");
		menubar.add(help);
		JMenuItem about = new JMenuItem("About");
		help.add(about);
		
		newUmlProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				projet = new Project();		
			};}
		);
		
				
	/*	button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				final JFrame diagram = new JFrame("Diagramme de Classes");
				diagram.setSize(1000,600);
				diagram.setVisible(true);
				diagram.setAlwaysOnTop(true);
				diagram.setContentPane(classDiagram);
				diagram.setJMenuBar(menubar);
				diagram.setResizable(false);
				
				
			}
			
		});*/
		
		class exitaction implements ActionListener{
			public void actionPerformed (ActionEvent e){
				System.exit(0);
			}
		}
		exit.addActionListener(new exitaction());
		
		mainWindow = new MainWindow();
		classDiagram = new ClassDiagram();
		
		  fenetre.setContentPane(mainWindow); // We associate the scene with the window of the application
	      fenetre.setVisible(true);// To make the window visible
	      fenetre.setJMenuBar(menubar);
	}

}
