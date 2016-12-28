package Uml.UmlTool;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

import Uml.Uml;

/**
 * @author Yacine
 * *With this class, we can draw in panel center
 */   

public class UmlRelation {
  
       private Uml uml1;
       private Uml uml2;
       
       private EnumRelation typeRelation;
       
       public UmlRelation(Uml uml1, Uml uml2,EnumRelation type) {
           this.uml1 = uml1;
           this.uml2 = uml2;
           typeRelation = type;
       }
      
       public void draw(Graphics g) {
    	   
           Point p1 = uml1.getLocation();
           Point p2 =uml2.getLocation();
           
           g.setColor(Color.darkGray);
           if(typeRelation == EnumRelation.association)
               g.drawLine(p1.x+uml1.getWidth()/2, p1.y+uml1.getHeight()/2,p2.x+uml2.getWidth()/2, p2.y+uml2.getHeight()/2);
           
           else if(typeRelation == EnumRelation.aggregation)
               g.drawLine(p1.x, p1.y, p2.x, p2.y);
           
           else if(typeRelation == EnumRelation.dependance)
               g.drawLine(p1.x, p1.y, p2.x, p2.y);
           
           else if(typeRelation == EnumRelation.composition)
           {
        	   
        	   /* [] polx = {20, 30, 40, 30};
        	    int [] poly = {30, 20, 30,40};*/
        	    
        	    int [] polx = {p1.x-30,p1.x-15,p1.x,p1.x-15};
        	    int [] poly = {p1.x,p1.x-15,p1.x,p1.x+15};
        	    
        	    Polygon pol = new Polygon(polx,poly,4);   	    
        	    g.fillPolygon(pol);
               g.drawLine(p1.x, p1.y, p2.x, p2.y);
                           
           }   
          
           else   if(typeRelation == EnumRelation.heritage)
        	    g.drawLine(p1.x, p1.y, p2.x, p2.y);
           
       }
}
