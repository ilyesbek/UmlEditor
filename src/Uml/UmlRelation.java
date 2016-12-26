package Uml;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


public class UmlRelation {

	   private UmlEntityClass n1;
       private UmlEntityClass n2;
       
       private UmlUse useCase1;
       private UmlUse useCase2;
       
       private TypeRelation typeRelation;
       
       public UmlRelation(UmlEntityClass n1, UmlEntityClass n2,TypeRelation type) {
           this.n1 = n1;
           this.n2 = n2;
           typeRelation = type;
       }
       
       public UmlRelation(UmlUse umlUseCase1, UmlUse umlUseCase2,TypeRelation  type) {
           this.useCase1 = umlUseCase1;
           this.useCase2 = umlUseCase2;
           typeRelation = type;
       }
       
       
       public void draw(Graphics g) {
    	   
           Point p1 = useCase1.getLocation();
           Point p2 =useCase2.getLocation();
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
