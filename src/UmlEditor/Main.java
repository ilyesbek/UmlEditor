package UmlEditor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Main {
	
	public static MainWindow mainWindow;
	public static Project projet;

	public static void main(String[] args) {
		JMenuBar menubar = new JMenuBar();
		
		JFrame fenetre = new JFrame("Editeur UML"); // le nom de l'application
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //quand on ferme la fenetre, le programme s'arrete 
		fenetre.setSize(1000, 600);// dimension de la fenetre
		fenetre.setLocationRelativeTo(null);// pour que la fenetre soit centré
		fenetre.setResizable(false);// pour redimensioner la fenetre
		fenetre.setAlwaysOnTop(true);// pour que la fenetre reste au dessus des autres fenetre
		

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
				
				final JFrame frame = new JFrame("Editeur UML");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(1000,600);
				frame.setVisible(true);
				frame.setAlwaysOnTop(true);
				frame.setContentPane(projet);
				frame.setJMenuBar(menubar);
				frame.setResizable(false);
			};}
		);
		
		class exitaction implements ActionListener{
			public void actionPerformed (ActionEvent e){
				System.exit(0);
			}
		}
		exit.addActionListener(new exitaction());
		
		mainWindow = new MainWindow();
		projet = new Project();
		
		  fenetre.setContentPane(mainWindow); //on associe la scene à la fenetre de l'application
	      fenetre.setVisible(true);// pour que la fenetre soit visible
	      fenetre.setJMenuBar(menubar);
	}

}
