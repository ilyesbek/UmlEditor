package Uml.UmlTool;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

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
      
       public Point calculIntersection()
       {    System.out.println("a");
       
           int x1 = uml1.getX()+(uml1.getWidth()/2);
           int x2 = uml2.getX()+(uml2.getWidth()/2);
           int y1 = uml1.getY()+(uml1.getHeight()/2);
           int y2 = uml2.getY()+(uml2.getHeight()/2);
           
           //left down
         if(x1 < x2 && y1 > y2){ 
        	 
        	   Line2D l2 = new Line2D.Float(uml2.getX(), uml2.getY(),uml2.getX(),+uml2.getY()+uml2.getHeight());
               Line2D l1 = new Line2D.Float(x1,y1,x2,y2);
                
             //left   
        	if(l2.intersectsLine(l1)){
        		 System.out.println("gauche bas: ");
        		 
        		 Point intersect;
          	     double a = Math.sqrt(Math.pow(x1-x1,2) + Math.pow(y1-y2,2));     //AB
          	     double b = Math.sqrt(Math.pow(x2-(x2-uml2.getWidth()/2),2) + Math.pow(y2-y2,2));  //OE
          	     double c = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y2,2));        //OB
          	   
         	     int d = (int) ((a*b)/c); 
        	     return new Point (x2-uml2.getWidth()/2,y2+d);
        	}
        	
        	//down
        	else {
        		 System.out.println("bas gauche: ");
        		 
        	     Point intersect;
        	     double a = Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y1,2));     //AB
        	     double b = Math.sqrt(Math.pow(x2-x2,2) + Math.pow(y2-(y2+uml2.getHeight()/2),2));  //OE
        	     double c = Math.sqrt(Math.pow(x2-x2,2) + Math.pow(y2-y1,2));        //OB
        	   
        	     int d = (int) ((a*b)/c); 
        	     return new Point (x2-d,y2+uml2.getHeight()/2);
        	}
        	 
         }
         //top left
         else if(x1 < x2 && y1 < y2){
        	       	 
     	     Line2D l2 = new Line2D.Float(uml2.getX(), uml2.getY(),uml2.getX(),+uml2.getY()+uml2.getHeight());
             Line2D l1 = new Line2D.Float(x1,y1,x2,y2);
             
            //left
        	if(l2.intersectsLine(l1)){
        		 System.out.println( "gauche haut: ");
        		 
           	     Point intersect;
        	     double a = Math.sqrt(Math.pow(x1-x1,2) + Math.pow(y1-y2,2));     //AB
        	     double b = Math.sqrt(Math.pow(x2-(x2-uml2.getWidth()/2),2) + Math.pow(y2-y2,2));  //OE
        	     double c = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y2,2));        //OB
        	   
            	 int d = (int) ((a*b)/c); 
      	         return new Point (x2-uml2.getWidth()/2,y2-d);
        	}
        	//up
        	else {
        		 System.out.println(" haut  gauche : ");
        		        		 
         		 Point intersect;
          	     double a = Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y1,2));     //AB
          	     double b = Math.sqrt(Math.pow(x2-x2,2) + Math.pow(y2-(y2-uml2.getHeight()/2),2));  //OE
          	     double c = Math.sqrt(Math.pow(x2-x2,2) + Math.pow(y2-y1,2));        //OB
          	   
         	     int d = (int) ((a*b)/c); 
        	     return new Point (x2-d,y2-uml2.getHeight()/2);
        	}
         }
         
         //top right
        else if(x1 > x2 && y2 > y1 ){
        	
        	   Line2D l2 = new Line2D.Float(uml2.getX(), uml2.getY(),uml2.getX()+uml2.getWidth(),+uml2.getY());
               Line2D l1 = new Line2D.Float(x1,y1,x2,y2);
               
               //up
           	if(l2.intersectsLine(l1)){
             	 System.out.println("haut droite : ");
           	   		 
		         Point intersect;
	             double a = Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y1,2));     //AB
	             double b = Math.sqrt(Math.pow(x2-x2,2) + Math.pow(y2-(y2-uml2.getHeight()/2),2));  //OE
	             double c = Math.sqrt(Math.pow(x2-x2,2) + Math.pow(y2-y1,2));        //OB
	   
	             int d = (int) ((a*b)/c); 
                 return new Point (x2+d,y2-uml2.getHeight()/2);
             }
           	//right
           	else {
              	 System.out.println("droite haut: ");
           	 
                Point intersect;
                double a = Math.sqrt(Math.pow(x1-x1,2) + Math.pow(y1-y2,2));     //AB
                double b = Math.sqrt(Math.pow(x2-(x2+uml2.getWidth()/2),2) + Math.pow(y2-y2,2));  //OE
                double c = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y2,2));        //OB
   
                int d = (int) ((a*b)/c); 
                return new Point (x2+uml2.getWidth()/2,y2-d);
           	}
         }
         
         //down right
         else if( x1 > x2 && y1 > y2){
        	   Line2D l2 = new Line2D.Float(uml2.getX()+uml2.getWidth(), uml2.getY(),uml2.getX()+uml2.getWidth(),uml2.getY()+uml2.getHeight());
        	   Line2D l1 = new Line2D.Float(x1,y1,x2,y2);
     
               //right
           	if(l2.intersectsLine(l1)){
           	     System.out.println("droite bas");
           	 
                 Point intersect;
                 double a = Math.sqrt(Math.pow(x1-x1,2) + Math.pow(y1-y2,2));     //AB
                 double b = Math.sqrt(Math.pow(x2-(x2+uml2.getWidth()/2),2) + Math.pow(y2-y2,2));  //OE
                 double c = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y2,2));        //OB

                 int d = (int) ((a*b)/c); 
                 return new Point (x2+uml2.getWidth()/2,y2+d);
           	}
           	//down
           	else {
            	 System.out.println("bas droite : ");
           	 
                 Point intersect;
    	         double a = Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y1,2));     //AB
    	         double b = Math.sqrt(Math.pow(x2-x2,2) + Math.pow(y2-(y2+uml2.getHeight()/2),2));  //OE
    	         double c = Math.sqrt(Math.pow(x2-x2,2) + Math.pow(y2-y1,2));        //OB
    	   
    	         int d = (int) ((a*b)/c); 
    	         return new Point (x2+d,y2+uml2.getHeight()/2);
           	}
         }
         
         // center top
         else if(x1 == x2 && y1 < y2 ){
        	  return new Point (x2,y2-uml2.getHeight()/2);
         }
         // center right
         else if(x2 < x1 && y1 == y2){
        	 return new Point (x2+uml2.getWidth(),y2);
         }
         //center down
         else if (x1 == x2 && y2 < y1){
        	 return new Point (x2,y2+uml2.getHeight()/2);
         } 
         //center left
         else if(x1 < x2 && y1 == y2 ){
        	 return new Point (x2-uml2.getWidth()/2,y2);
         }
		return null;
  
          }
       
       
       public void draw(Graphics g) {
    	   
           Point p1 = uml1.getLocation();
           Point p2 =uml2.getLocation();
           
           Point intersection = calculIntersection();
           
      //     if(p1.getX()+uml1.getWidth()< p2.x)
        	   
     /*      else if(p1.x+uml1.getHeight()<p2.x){}
        	   
           else if(p2.x < p1.x)   
           g.setColor(Color.darkGray);*/
           if(typeRelation == EnumRelation.association)
             //  g.drawLine(p1.x+uml1.getWidth()/2, p1.y+uml1.getHeight()/2,p2.x+uml2.getWidth()/2, p2.y+uml2.getHeight()/2);
        	   
        	   g.drawLine(p1.x+uml1.getWidth()/2, p1.y+uml1.getHeight()/2,intersection.x,intersection.y);
           else if(typeRelation == EnumRelation.aggregation)
               g.drawLine(p1.x, p1.y, p2.x, p2.y);
           
           else if(typeRelation == EnumRelation.dependance)
               g.drawLine(p1.x, p1.y, p2.x, p2.y);
           
           else if(typeRelation == EnumRelation.composition)
           {
        	   
        	   /* [] polx = {20, 30, 40, 30};
        	    int [] poly = {30, 20, 30,40};*/
        	    
        	    int [] polx = {intersection.x-10,intersection.x,intersection.x+10,intersection.x};
        	    int [] poly = {intersection.y+10,intersection.y,intersection.y+10,intersection.y+20};
        	    
        	    Polygon pol = new Polygon(polx,poly,4);   	    
        	    g.fillPolygon(pol);
               g.drawLine(p1.x+uml1.getWidth()/2, p1.y+uml1.getHeight()/2, intersection.x, intersection.y);
                           
           }   
          
           else   if(typeRelation == EnumRelation.heritage)
        	    g.drawLine(p1.x, p1.y, p2.x, p2.y);
        
      /*     int xy= uml2.getWidth()/2+p2.x;
           g.fillOval(intersection.x,intersection.y,30,30);
           System.out.println("Class 1 X  : "+xy+" intersection : "+intersection.x);*/
       }
       
       
}
