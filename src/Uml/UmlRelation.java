package Uml;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * @author Yacine
 * *With this class, we can draw in panel center
 */   

public class UmlRelation {
  
       private Uml uml1;
       private Uml uml2;
       
       private TypeRelation typeRelation;
       
       public UmlRelation(Uml uml1, Uml uml2,TypeRelation type) {
           this.uml1 = uml1;
           this.uml2 = uml2;
           typeRelation = type;
       }
      
       public void draw(Graphics g) {
    	   
           Point p1 = uml1.getLocation();
           Point p2 =uml2.getLocation();
           g.setColor(Color.darkGray);
           if(typeRelation == TypeRelation.association)
           g.drawLine(p1.x, p1.y, p2.x, p2.y);
           
           else if(typeRelation == TypeRelation.aggregation)
               g.drawLine(p1.x, p1.y, p2.x, p2.y);
           
           else if(typeRelation == TypeRelation.dependance)
               g.drawLine(p1.x, p1.y, p2.x, p2.y);
           
           else if(typeRelation == TypeRelation.composition)
               g.drawLine(p1.x, p1.y, p2.x, p2.y);
           else   if(typeRelation == TypeRelation.heritage)
               g.drawLine(p1.x, p1.y, p2.x, p2.y);
       
       }
}
