package Uml;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import UmlOption.UmlOptionPacket;
import WindowUml.PanelCenter;

/**
 * @author Yacine
 * This  class represent a packet uml
 */

public class UmlPacket extends Uml{

	private static final long serialVersionUID = 1L;
	
	private JPanel header = new JPanel();
	private JLabel labelTitle = new JLabel("packet");

	
	public UmlPacket(PanelCenter panel) {
		super(panel);
		this.setSize(200,200);
		
	    JPanel panelAll = new JPanel();
	   // panelAll.setLayout(new BoxLayout(panelAll, BoxLayout.PAGE_AXIS));
		
		//header.add(labelTitle);
		/*panelAll.add(header);
		panelAll.add(labelTitle);
		panelAll.add(this);*/
	    header.add(labelTitle);
	    this.add(header);
		//header.setVisible(true);header.setSize(101,140);
		
		header.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) { 
		    	  if(e.getClickCount()==2){
		             new UmlOptionPacket(labelTitle);  
		         }
		    }
		});
	}

	 public String getTitle()
	 {
		 return labelTitle.getText();
	 }
}
