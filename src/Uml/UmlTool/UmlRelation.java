package Uml.UmlTool;

import java.awt.BasicStroke;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Uml.Uml;
import UmlOption.UmlOptionCardinality;

/**
 * @author Yacine
 * *With this class, we can draw in panel center
 */   

public class UmlRelation{
  
       private Uml uml1;
       private Uml uml2;
       private PositionEntity pos= null;
       private Point endLineDraw = new Point();
       
       private JLabel cardinality1 = new JLabel("0",JLabel.CENTER);
       private JLabel cardinality2 = new JLabel("0",JLabel.CENTER);
       private final int cardinalityXPos1 = 16;
       private final int cardinalityYPos1 = 21;
       
       private EnumRelation typeRelation;
       
       public UmlRelation(Uml uml1, Uml uml2,EnumRelation type, JPanel panel) {
           this.uml1 = uml1;
           this.uml2 = uml2;
           typeRelation = type;
           cardinality2.setSize(30,15);
           cardinality1.setSize(30,15);
           
           cardinality1.setHorizontalTextPosition(JLabel.CENTER);
           cardinality2.setAlignmentX(Component.CENTER_ALIGNMENT);
           
           panel.add(cardinality1);
           panel.add(cardinality2);
           
           cardinality1.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) { 
		    	  if(e.getClickCount()==2){
		             new UmlOptionCardinality(cardinality1);  
		         }
		    }
		});
       	
       cardinality2.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) { 
		    	  if(e.getClickCount()==2){
		             new UmlOptionCardinality(cardinality2);  
		         }
		    }
		});
       }
       
      /*This fonction calcul the intersection with line and entity , use method thales for this */
       public Point calculIntersection(Uml uml1, Uml uml2,int numberCardinality)
       {        
           int x1 = uml1.getX()+(uml1.getWidth()/2);
           int x2 = uml2.getX()+(uml2.getWidth()/2);
           int y1 = uml1.getY()+(uml1.getHeight()/2);
           int y2 = uml2.getY()+(uml2.getHeight()/2);
           
           JLabel cardinality = null;
           if(numberCardinality == 0) cardinality = cardinality1;
           else cardinality = cardinality2;
           
           //left down
         if(x1 < x2 && y1 > y2){ 
        	 
        	   Line2D l2 = new Line2D.Float(uml2.getX(), uml2.getY(),uml2.getX(),+uml2.getY()+uml2.getHeight());
               Line2D l1 = new Line2D.Float(x1,y1,x2,y2);
                
             //left   
        	if(l2.intersectsLine(l1)){
        		 System.out.println("gauche bas: ");
        		 pos = PositionEntity.left;      		 
        		 
        		 double a = Math.sqrt(Math.pow(x1-x1,2) + Math.pow(y1-y2,2));     //AB
          	     double b = Math.sqrt(Math.pow(x2-(x2-uml2.getWidth()/2),2) + Math.pow(y2-y2,2));  //OE
          	     double c = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y2,2));        //OB
          	   
         	     int d = (int) ((a*b)/c); 
         	     
         	    cardinality.setLocation(uml2.getX()-cardinality.getWidth()-cardinalityXPos1,y2+d-cardinality.getHeight());
        	     return new Point (uml2.getX(),y2+d);
        	}
        	
        	//down
        	else {
        		 System.out.println("bas gauche: ");
        		 pos = PositionEntity.down;
        		 
        	     double a = Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y1,2));     //AB
        	     double b = Math.sqrt(Math.pow(x2-x2,2) + Math.pow(y2-(y2+uml2.getHeight()/2),2));  //OE
        	     double c = Math.sqrt(Math.pow(x2-x2,2) + Math.pow(y2-y1,2));        //OB
        	   
        	     int d = (int) ((a*b)/c); 
        	     
        	     cardinality.setLocation(x2-d,uml2.getHeight()+uml2.getY()+cardinalityYPos1);
        	     return new Point (x2-d,uml2.getHeight()+uml2.getY());
        	}
        	 
         }
         //top left
         else if(x1 < x2 && y1 < y2){
        	       	 
     	     Line2D l2 = new Line2D.Float(uml2.getX(), uml2.getY(),uml2.getX(),+uml2.getY()+uml2.getHeight());
             Line2D l1 = new Line2D.Float(x1,y1,x2,y2);
             
            //left
        	if(l2.intersectsLine(l1)){
        		 System.out.println( "gauche haut: ");
        		 pos = PositionEntity.left;
        		 
           	     double a = Math.sqrt(Math.pow(x1-x1,2) + Math.pow(y1-y2,2));     //AB
        	     double b = Math.sqrt(Math.pow(x2-(x2-uml2.getWidth()/2),2) + Math.pow(y2-y2,2));  //OE
        	     double c = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y2,2));        //OB
        	   
            	 int d = (int) ((a*b)/c); 
            	 
            	 cardinality.setLocation(uml2.getX()-cardinality.getWidth()-cardinalityXPos1,y2-d);
      	         return new Point (uml2.getX(),y2-d);
        	}
        	//up
        	else {
        		 System.out.println(" haut  gauche : ");
        		 pos = PositionEntity.top;
        		        		 
         		 double a = Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y1,2));     //AB
          	     double b = Math.sqrt(Math.pow(x2-x2,2) + Math.pow(y2-(y2-uml2.getHeight()/2),2));  //OE
          	     double c = Math.sqrt(Math.pow(x2-x2,2) + Math.pow(y2-y1,2));        //OB
          	   
         	     int d = (int) ((a*b)/c); 
         	     
         	     cardinality.setLocation(x2-d,uml2.getY()-cardinality.getHeight()-cardinalityYPos1);
        	     return new Point (x2-d,uml2.getY());
        	}
         }
         
         //top right
        else if(x1 > x2 && y2 > y1 ){
        	
        	   Line2D l2 = new Line2D.Float(uml2.getX(), uml2.getY(),uml2.getX()+uml2.getWidth(),+uml2.getY());
               Line2D l1 = new Line2D.Float(x1,y1,x2,y2);
               
               //up
           	if(l2.intersectsLine(l1)){
             	 System.out.println("haut droite : ");
             	 pos = PositionEntity.top;
           	   		 
		         double a = Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y1,2));     //AB
	             double b = Math.sqrt(Math.pow(x2-x2,2) + Math.pow(y2-(y2-uml2.getHeight()/2),2));  //OE
	             double c = Math.sqrt(Math.pow(x2-x2,2) + Math.pow(y2-y1,2));        //OB
	   
	             int d = (int) ((a*b)/c); 
	             
	            cardinality.setLocation(x2+d-cardinality.getWidth(),uml2.getY()-cardinality.getHeight()-cardinalityYPos1);
                 return new Point (x2+d,uml2.getY());
             }
           	//right
           	else {
              	 System.out.println("droite haut: ");
              	 pos = PositionEntity.right;
           	 
                double a = Math.sqrt(Math.pow(x1-x1,2) + Math.pow(y1-y2,2));     //AB
                double b = Math.sqrt(Math.pow(x2-(x2+uml2.getWidth()/2),2) + Math.pow(y2-y2,2));  //OE
                double c = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y2,2));        //OB
   
                int d = (int) ((a*b)/c); 
                
                cardinality.setLocation(uml2.getX()+uml2.getWidth()+cardinalityXPos1,y2-d);
                return new Point (uml2.getX()+uml2.getWidth(),y2-d);
           	}
         }
         
         //down right
         else if( x1 > x2 && y1 > y2){
        	   Line2D l2 = new Line2D.Float(uml2.getX()+uml2.getWidth(), uml2.getY(),uml2.getX()+uml2.getWidth(),uml2.getY()+uml2.getHeight());
        	   Line2D l1 = new Line2D.Float(x1,y1,x2,y2);
     
               //right
           	if(l2.intersectsLine(l1)){
           	     System.out.println("droite bas");
           	  pos = PositionEntity.right;
           	 
                 double a = Math.sqrt(Math.pow(x1-x1,2) + Math.pow(y1-y2,2));     //AB
                 double b = Math.sqrt(Math.pow(x2-(x2+uml2.getWidth()/2),2) + Math.pow(y2-y2,2));  //OE
                 double c = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y2,2));        //OB

                 int d = (int) ((a*b)/c); 
                 
                 cardinality.setLocation(uml2.getX()+uml2.getWidth()+cardinalityXPos1,y2+d-cardinality.getHeight());
                 return new Point (uml2.getX()+uml2.getWidth(),y2+d);
           	}
           	//down
           	else {
            	 System.out.println("bas droite : ");
            	 pos = PositionEntity.down;
           	 
                 double a = Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y1,2));     //AB
    	         double b = Math.sqrt(Math.pow(x2-x2,2) + Math.pow(y2-(y2+uml2.getHeight()/2),2));  //OE
    	         double c = Math.sqrt(Math.pow(x2-x2,2) + Math.pow(y2-y1,2));        //OB
    	   
    	         int d = (int) ((a*b)/c); 
    	         
    	         cardinality.setLocation(x2+d-cardinality.getWidth(),uml2.getHeight()+uml2.getY()+cardinalityYPos1);
    	         return new Point (x2+d,uml2.getHeight()+uml2.getY());
           	}
         }
         
         // center top
         else if(x1 == x2 && y1 < y2 ){
        	 pos = PositionEntity.top;
        	  cardinality.setLocation((uml2.getX()+uml2.getWidth()/2),uml2.getY()-cardinality.getHeight()-cardinalityYPos1);
        	  return new Point (x2,y2-uml2.getHeight()/2);
         }
         // center right
         else if(x2 < x1 && y1 == y2){
        	 pos = PositionEntity.right;
        	 cardinality.setLocation(uml2.getX()+uml2.getWidth()+cardinalityXPos1,uml2.getY()+uml2.getHeight()/2-cardinality.getHeight());
        	 return new Point (uml2.getX()+uml2.getWidth(),y2);
         }
         //center down
         else if (x1 == x2 && y2 < y1){
        	 pos = PositionEntity.down;
        	 cardinality.setLocation(uml2.getX()+uml2.getWidth()/2,uml2.getY()+uml2.getHeight()+cardinalityYPos1);
        	 return new Point (x2,uml2.getY()+uml2.getHeight());
         } 
         //center left
         else if(x1 < x2 && y1 == y2 ){
        	 pos = PositionEntity.left;
        	 cardinality.setLocation(uml2.getX()-cardinality.getWidth()-cardinalityXPos1,uml2.getY()+uml2.getHeight()/2-cardinality.getHeight());
        	 return new Point (uml2.getX(),y2);
         }
		return null;
  }
  
       public void calculationPolygon(Point p1, Point p2, Point p3, Point p4, Point intersection){
    	  
       	  if(pos==PositionEntity.down){
     		 p1.setLocation(intersection.x-7, intersection.y+10);
     		 p2.setLocation(intersection.x, intersection.y);
     		 p3.setLocation(intersection.x+7,intersection.y+10);
     		 p4.setLocation(intersection.x, intersection.y+20); 
     		 
        	 endLineDraw.setLocation(intersection.x,intersection.y+20);
       		}       	 
     	 
     	  
     	  else if(pos==PositionEntity.left){ 
      		 p1.setLocation(intersection.x-14, intersection.y);
      		 p2.setLocation(intersection.x-7, intersection.y-10);
      		 p3.setLocation(intersection.x,intersection.y);
      		 p4.setLocation(intersection.x-7, intersection.y+10);
      		 
      		 endLineDraw.setLocation(intersection.x-14,intersection.y);
     		 }
 
      	 
     	  
     	  else if(pos==PositionEntity.top){
       		 p1.setLocation(intersection.x-7, intersection.y-10);
       		 p2.setLocation(intersection.x, intersection.y-20);
       		 p3.setLocation(intersection.x+7,intersection.y-10);
       		 p4.setLocation(intersection.x, intersection.y);
       		 
       		 endLineDraw.setLocation(intersection.x,intersection.y-20);
       	 }
     	         	  
     	  else if(pos==PositionEntity.right){
      		 p1.setLocation(intersection.x, intersection.y);
       		 p2.setLocation(intersection.x+7, intersection.y-10);
      		 p3.setLocation(intersection.x+14,intersection.y);
       		 p4.setLocation(intersection.x+7, intersection.y+10);
       		 
       		 endLineDraw.setLocation(intersection.x+14,intersection.y);
       	 }
       }
       
       public void calculationTriangle(Point p1, Point p2, Point p3,Point p4, Point intersection){
     	  
        	  if(pos==PositionEntity.down){
      		 p1.setLocation(intersection.x-7, intersection.y+10);
      		 p2.setLocation(intersection.x, intersection.y);
      		 p3.setLocation(intersection.x+7,intersection.y+10);
      		 p4.setLocation(intersection.x,intersection.y+10);
      		 
         	 endLineDraw.setLocation(intersection.x,intersection.y+10);
        		}       	 
      	      	  
      	  else if(pos==PositionEntity.left){ 
       		 p1.setLocation(intersection.x-10, intersection.y+7);
       		 p2.setLocation(intersection.x-10, intersection.y-7);
       		 p3.setLocation(intersection.x,intersection.y);
       		 p4.setLocation(intersection.x-10, intersection.y+7);
      		 
       		 endLineDraw.setLocation(intersection.x-10,intersection.y);
      		 }
        	    	  
      	  else if(pos==PositionEntity.top){
      		 p1.setLocation(intersection.x-7, intersection.y-10);
      		 p2.setLocation(intersection.x, intersection.y);
      		 p3.setLocation(intersection.x+7,intersection.y-10);
      		 p4.setLocation(intersection.x,intersection.y);
      		 
         	 endLineDraw.setLocation(intersection.x,intersection.y-10);
        	 }
      	         	  
      	  else if(pos==PositionEntity.right){
     		 p1.setLocation(intersection.x, intersection.y);
       		 p2.setLocation(intersection.x+10, intersection.y-7);
       		 p3.setLocation(intersection.x+10,intersection.y+7);
       		 p4.setLocation(intersection.x+10, intersection.y+7);
      		 
       		 endLineDraw.setLocation(intersection.x+10,intersection.y);
        	 }
        }
      

       public void draw(Graphics g) {
    	   
           Point p1 = uml1.getLocation();
           Point p2 =uml2.getLocation();
           
           Point intersection2 = calculIntersection(uml2,uml1,0);
           Point intersection1 = calculIntersection(uml1,uml2,1);
        
           
      //     if(p1.getX()+uml1.getWidth()< p2.x)
        	   
     /*      else if(p1.x+uml1.getHeight()<p2.x){}
        	   
           else if(p2.x < p1.x)   
           g.setColor(Color.darkGray);*/
           
           if(typeRelation == EnumRelation.association)
      	      g.drawLine(p1.x+uml1.getWidth()/2, p1.y+uml1.getHeight()/2,intersection1.x,intersection1.y);
           
           else if(typeRelation == EnumRelation.aggregation){
        		 Point p11 = new Point() ;
            	 Point p12 = new Point() ;
            	 Point p13 = new Point() ;
            	 Point p14 = new Point() ;
            	 
            	 calculationPolygon(p11,p12,p13,p14,intersection1);
            	 
            	    int [] polx = {p11.x,p12.x,p13.x,p14.x};
            	    int [] poly = {p11.y,p12.y,p13.y,p14.y};
            	                   	   
            	    g.drawLine(p1.x+uml1.getWidth()/2, p1.y+uml1.getHeight()/2, endLineDraw.x, endLineDraw.y); 
                    g.drawPolygon(polx,poly,4);
           }
               
           
           else if(typeRelation == EnumRelation.dependance){
        	   Graphics2D g2d = (Graphics2D) g.create();
        	   Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{10}, 0);
               g2d.setStroke(dashed);
               g2d.drawLine(p1.x+uml1.getWidth()/2, p1.y+uml1.getHeight()/2,intersection1.x,intersection1.y);

              if(pos == PositionEntity.left){
            	  g.drawLine(intersection1.x-10, intersection1.y-10, intersection1.x, intersection1.y);
            	  g.drawLine(intersection1.x-10, intersection1.y+10, intersection1.x, intersection1.y);
              }
              else if(pos == PositionEntity.right){
            	  g.drawLine(intersection1.x, intersection1.y, intersection1.x+10, intersection1.y-10);
            	  g.drawLine(intersection1.x, intersection1.y, intersection1.x+10, intersection1.y+10);
              }
              if(pos == PositionEntity.top){
            	  g.drawLine(intersection1.x-10, intersection1.y-10, intersection1.x, intersection1.y);
            	  g.drawLine(intersection1.x+10, intersection1.y-10, intersection1.x, intersection1.y);
              }
              if(pos == PositionEntity.down){
            	  g.drawLine(intersection1.x-10, intersection1.y-10, intersection1.x, intersection1.y);
            	  g.drawLine(intersection1.x-10, intersection1.y-10, intersection1.x, intersection1.y);
              }
           }
             
           
           else if(typeRelation == EnumRelation.composition)
           {
        	 Point p11 = new Point() ;
        	 Point p12 = new Point() ;
        	 Point p13 = new Point() ;
        	 Point p14 = new Point() ;
        	 
        	 calculationPolygon(p11,p12,p13,p14,intersection1);
        	 
        	    int [] polx = {p11.x,p12.x,p13.x,p14.x};
        	    int [] poly = {p11.y,p12.y,p13.y,p14.y};
        	    
        	    Polygon pol = new Polygon(polx,poly,4);       
        	    g.fillPolygon(pol);
                g.drawLine(p1.x+uml1.getWidth()/2, p1.y+uml1.getHeight()/2, endLineDraw.x, endLineDraw.y);      
           }   
          
           else   if(typeRelation == EnumRelation.heritage){
        	   
        	  	 Point p11 = new Point() ;
            	 Point p12 = new Point() ;
            	 Point p13 = new Point() ;
            	 Point p14 = new Point() ;
            	 
            	 calculationTriangle(p11,p12,p13,p14,intersection1);
            	 
            	    int [] polx = {p11.x,p12.x,p13.x};
            	    int [] poly = {p11.y,p12.y,p13.y};

                    g.drawLine(p1.x+uml1.getWidth()/2, p1.y+uml1.getHeight()/2, endLineDraw.x, endLineDraw.y); 
                    g.drawPolygon(polx,poly,3);
           }
        
     
       }
       
  }
