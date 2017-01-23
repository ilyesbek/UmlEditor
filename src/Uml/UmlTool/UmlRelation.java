package Uml.UmlTool;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Stroke;
import java.awt.geom.Line2D;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Uml.Uml;

/**
 * @author Yacine
 * *With this class, we can draw in panel center
 */   

public class UmlRelation extends JPanel{
  
       private Uml uml1;
       private Uml uml2;
       private PositionEntity pos= null;
       private Point endLine = new Point();
       
       private JLabel cardinality1 = new JLabel("0000");
       private JLabel cardinality2 = new JLabel("pane2");
       
       private Point cardinalityPosUml1 = new Point ();
       private Point cardinalityPosUml2 = new  Point ();
       
       private EnumRelation typeRelation;
       
       public UmlRelation(Uml uml1, Uml uml2,EnumRelation type, JPanel panel) {
           this.uml1 = uml1;
           this.uml2 = uml2;
           typeRelation = type;
           panel.add(cardinality1);
           panel.add(cardinality2);
       }
      /*This fonction calcul the intersection with line and entity , use method thales for this */
       public Point calculIntersection()
       {        
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
        		 pos = PositionEntity.left;      		 
        		 
        		 double a = Math.sqrt(Math.pow(x1-x1,2) + Math.pow(y1-y2,2));     //AB
          	     double b = Math.sqrt(Math.pow(x2-(x2-uml2.getWidth()/2),2) + Math.pow(y2-y2,2));  //OE
          	     double c = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y2,2));        //OB
          	   
         	     int d = (int) ((a*b)/c); 
         	     
         	     calculPositionCardinality(x2-uml2.getWidth()/2,y2+d,PositionEntity.left);
        	     return new Point (x2-uml2.getWidth()/2,y2+d);
        	}
        	
        	//down
        	else {
        		 System.out.println("bas gauche: ");
        		 pos = PositionEntity.down;
        		 
        	     double a = Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y1,2));     //AB
        	     double b = Math.sqrt(Math.pow(x2-x2,2) + Math.pow(y2-(y2+uml2.getHeight()/2),2));  //OE
        	     double c = Math.sqrt(Math.pow(x2-x2,2) + Math.pow(y2-y1,2));        //OB
        	   
        	     int d = (int) ((a*b)/c); 
        	     
        	     calculPositionCardinality(x2-d,y2+uml2.getHeight()/2,PositionEntity.down);
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
        		 pos = PositionEntity.left;
        		 
           	     double a = Math.sqrt(Math.pow(x1-x1,2) + Math.pow(y1-y2,2));     //AB
        	     double b = Math.sqrt(Math.pow(x2-(x2-uml2.getWidth()/2),2) + Math.pow(y2-y2,2));  //OE
        	     double c = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y2,2));        //OB
        	   
            	 int d = (int) ((a*b)/c); 
            	 
            	 calculPositionCardinality(x2-uml2.getWidth()/2,y2-d,PositionEntity.left);
      	         return new Point (x2-uml2.getWidth()/2,y2-d);
        	}
        	//up
        	else {
        		 System.out.println(" haut  gauche : ");
        		 pos = PositionEntity.top;
        		        		 
         		 double a = Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y1,2));     //AB
          	     double b = Math.sqrt(Math.pow(x2-x2,2) + Math.pow(y2-(y2-uml2.getHeight()/2),2));  //OE
          	     double c = Math.sqrt(Math.pow(x2-x2,2) + Math.pow(y2-y1,2));        //OB
          	   
         	     int d = (int) ((a*b)/c); 
         	     
         	    calculPositionCardinality(x2-d,y2-uml2.getHeight()/2,PositionEntity.top);
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
             	 pos = PositionEntity.top;
           	   		 
		         double a = Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y1,2));     //AB
	             double b = Math.sqrt(Math.pow(x2-x2,2) + Math.pow(y2-(y2-uml2.getHeight()/2),2));  //OE
	             double c = Math.sqrt(Math.pow(x2-x2,2) + Math.pow(y2-y1,2));        //OB
	   
	             int d = (int) ((a*b)/c); 
	             
	             calculPositionCardinality(x2+d,y2-uml2.getHeight()/2,PositionEntity.top);
                 return new Point (x2+d,y2-uml2.getHeight()/2);
             }
           	//right
           	else {
              	 System.out.println("droite haut: ");
              	 pos = PositionEntity.right;
           	 
                double a = Math.sqrt(Math.pow(x1-x1,2) + Math.pow(y1-y2,2));     //AB
                double b = Math.sqrt(Math.pow(x2-(x2+uml2.getWidth()/2),2) + Math.pow(y2-y2,2));  //OE
                double c = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y2,2));        //OB
   
                int d = (int) ((a*b)/c); 
                
                calculPositionCardinality(x2+uml2.getWidth()/2,y2-d,PositionEntity.right);
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
           	  pos = PositionEntity.right;
           	 
                 double a = Math.sqrt(Math.pow(x1-x1,2) + Math.pow(y1-y2,2));     //AB
                 double b = Math.sqrt(Math.pow(x2-(x2+uml2.getWidth()/2),2) + Math.pow(y2-y2,2));  //OE
                 double c = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y2,2));        //OB

                 int d = (int) ((a*b)/c); 
                 
                 calculPositionCardinality(x2+uml2.getWidth()/2,y2+d,PositionEntity.right);
                 return new Point (x2+uml2.getWidth()/2,y2+d);
           	}
           	//down
           	else {
            	 System.out.println("bas droite : ");
            	 pos = PositionEntity.down;
           	 
                 double a = Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y1,2));     //AB
    	         double b = Math.sqrt(Math.pow(x2-x2,2) + Math.pow(y2-(y2+uml2.getHeight()/2),2));  //OE
    	         double c = Math.sqrt(Math.pow(x2-x2,2) + Math.pow(y2-y1,2));        //OB
    	   
    	         int d = (int) ((a*b)/c); 
    	         
    	         calculPositionCardinality(x2+d,y2+uml2.getHeight()/2,PositionEntity.down);
    	         return new Point (x2+d,y2+uml2.getHeight()/2);
           	}
         }
         
         // center top
         else if(x1 == x2 && y1 < y2 ){
        	 pos = PositionEntity.top;
        	 calculPositionCardinality(x2,y2-uml2.getHeight()/2,PositionEntity.top);
        	  return new Point (x2,y2-uml2.getHeight()/2);
         }
         // center right
         else if(x2 < x1 && y1 == y2){
        	 pos = PositionEntity.right;
        	 calculPositionCardinality(x2+uml2.getWidth(),y2,PositionEntity.right);
        	 return new Point (x2+uml2.getWidth(),y2);
         }
         //center down
         else if (x1 == x2 && y2 < y1){
        	 pos = PositionEntity.down;
        	 calculPositionCardinality(x2,y2+uml2.getHeight()/2,PositionEntity.down);
        	 return new Point (x2,y2+uml2.getHeight()/2);
         } 
         //center left
         else if(x1 < x2 && y1 == y2 ){
        	 pos = PositionEntity.left;
        	 calculPositionCardinality(x2-uml2.getWidth()/2,y2,PositionEntity.left);
        	 return new Point (x2-uml2.getWidth()/2,y2);
         }
		return null;
  }
  
       public void calculationPolygon(Point p1, Point p2, Point p3, Point p4, Point intersection){
    	  
       	  if(pos==PositionEntity.down){
     		 p1.setLocation(intersection.x-7, intersection.y+10);
     		 p2.setLocation(intersection.x, intersection.y);
     		 p3.setLocation(intersection.x+7,intersection.y+10);
     		 p4.setLocation(intersection.x, intersection.y+20); 
     		 
        	 endLine.setLocation(intersection.x,intersection.y+20);
       		}       	 
     	 
     	  
     	  else if(pos==PositionEntity.left){ 
      		 p1.setLocation(intersection.x-14, intersection.y);
      		 p2.setLocation(intersection.x-7, intersection.y-10);
      		 p3.setLocation(intersection.x,intersection.y);
      		 p4.setLocation(intersection.x-7, intersection.y+10);
      		 
      		 endLine.setLocation(intersection.x-14,intersection.y);
     		 }
 
      	 
     	  
     	  else if(pos==PositionEntity.top){
       		 p1.setLocation(intersection.x-7, intersection.y-10);
       		 p2.setLocation(intersection.x, intersection.y-20);
       		 p3.setLocation(intersection.x+7,intersection.y-10);
       		 p4.setLocation(intersection.x, intersection.y);
       		 
       		 endLine.setLocation(intersection.x,intersection.y-20);
       	 }
     	         	  
     	  else if(pos==PositionEntity.right){
      		 p1.setLocation(intersection.x, intersection.y);
       		 p2.setLocation(intersection.x+7, intersection.y-10);
      		 p3.setLocation(intersection.x+14,intersection.y);
       		 p4.setLocation(intersection.x+7, intersection.y+10);
       		 
       		 endLine.setLocation(intersection.x+14,intersection.y);
       	 }
       }
       
       public void calculationTriangle(Point p1, Point p2, Point p3,Point p4, Point intersection){
     	  
        	  if(pos==PositionEntity.down){
      		 p1.setLocation(intersection.x-7, intersection.y+10);
      		 p2.setLocation(intersection.x, intersection.y);
      		 p3.setLocation(intersection.x+7,intersection.y+10);
      		 p4.setLocation(intersection.x,intersection.y+10);
      		 
         	 endLine.setLocation(intersection.x,intersection.y+10);
        		}       	 
      	 
      	  
      	  else if(pos==PositionEntity.left){ 
       		 p1.setLocation(intersection.x-10, intersection.y+7);
       		 p2.setLocation(intersection.x-10, intersection.y-7);
       		 p3.setLocation(intersection.x,intersection.y);
       		 p4.setLocation(intersection.x-10, intersection.y+7);
      		 
       		 endLine.setLocation(intersection.x-10,intersection.y);
      		 }
  
       	 
      	  
      	  else if(pos==PositionEntity.top){
      		 p1.setLocation(intersection.x-7, intersection.y-10);
      		 p2.setLocation(intersection.x, intersection.y);
      		 p3.setLocation(intersection.x+7,intersection.y-10);
      		 p4.setLocation(intersection.x,intersection.y);
      		 
         	 endLine.setLocation(intersection.x,intersection.y-10);
        	 }
      	         	  
      	  else if(pos==PositionEntity.right){
     		 p1.setLocation(intersection.x, intersection.y);
       		 p2.setLocation(intersection.x+10, intersection.y-7);
       		 p3.setLocation(intersection.x+10,intersection.y+7);
       		 p4.setLocation(intersection.x+10, intersection.y+7);
      		 
       		 endLine.setLocation(intersection.x+10,intersection.y);
        	 }
        }
       
       public void calculPositionCardinality(int x,int y,PositionEntity position){
    	   if(position == PositionEntity.top){
    		   
    		   cardinalityPosUml2.setLocation(x, y);
    	   }
    	   else if(position == PositionEntity.down){
    		   
    	   }
    	   else    if(position == PositionEntity.left){
	   
        	 int posX =(int) Math.sqrt(Math.pow(x-x,2) + Math.pow(uml1.getY()-y,2)); 
        	 int posY = (int) Math.sqrt(Math.pow(uml1.getX()-x,2) + Math.pow(uml1.getY()-uml1.getY(),2)); 
        	 int pos = (int) ( Math.sqrt((Math.pow(posX,2)+Math.pow(posY,2)) *0.7));
        	 
        	// cardinalityX2.setLocation(pos,y*0.7);
        	//  cardinalityPosUml2.setLocation(50,50);System.out.println(cardinalityPosUml2.x);
        	 cardinality1.setSize(100,100);
        	 cardinality1.setLocation(150,150);
         }
    	   else   if(position == PositionEntity.right){
	   
          }
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
      	      g.drawLine(p1.x+uml1.getWidth()/2, p1.y+uml1.getHeight()/2,intersection.x,intersection.y);
           
           else if(typeRelation == EnumRelation.aggregation){
        		 Point p11 = new Point() ;
            	 Point p12 = new Point() ;
            	 Point p13 = new Point() ;
            	 Point p14 = new Point() ;
            	 
            	 calculationPolygon(p11,p12,p13,p14,intersection);
            	 
            	    int [] polx = {p11.x,p12.x,p13.x,p14.x};
            	    int [] poly = {p11.y,p12.y,p13.y,p14.y};
            	                   	   
            	    g.drawLine(p1.x+uml1.getWidth()/2, p1.y+uml1.getHeight()/2, endLine.x, endLine.y); 
                    g.drawPolygon(polx,poly,4);
           }
               
           
           else if(typeRelation == EnumRelation.dependance){
        	   Graphics2D g2d = (Graphics2D) g.create();
        	   Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{10}, 0);
               g2d.setStroke(dashed);
               g2d.drawLine(p1.x+uml1.getWidth()/2, p1.y+uml1.getHeight()/2,intersection.x,intersection.y);

              if(pos == PositionEntity.left){
            	  g.drawLine(intersection.x-10, intersection.y-10, intersection.x, intersection.y);
            	  g.drawLine(intersection.x-10, intersection.y+10, intersection.x, intersection.y);
              }
              else if(pos == PositionEntity.right){
            	  g.drawLine(intersection.x, intersection.y, intersection.x+10, intersection.y-10);
            	  g.drawLine(intersection.x, intersection.y, intersection.x+10, intersection.y+10);
              }
              if(pos == PositionEntity.top){
            	  g.drawLine(intersection.x-10, intersection.y-10, intersection.x, intersection.y);
            	  g.drawLine(intersection.x+10, intersection.y-10, intersection.x, intersection.y);
              }
              if(pos == PositionEntity.down){
            	  g.drawLine(intersection.x-10, intersection.y-10, intersection.x, intersection.y);
            	  g.drawLine(intersection.x-10, intersection.y-10, intersection.x, intersection.y);
              }
           }
             
           
           else if(typeRelation == EnumRelation.composition)
           {
        	 Point p11 = new Point() ;
        	 Point p12 = new Point() ;
        	 Point p13 = new Point() ;
        	 Point p14 = new Point() ;
        	 
        	 calculationPolygon(p11,p12,p13,p14,intersection);
        	 
        	    int [] polx = {p11.x,p12.x,p13.x,p14.x};
        	    int [] poly = {p11.y,p12.y,p13.y,p14.y};
        	    
        	    Polygon pol = new Polygon(polx,poly,4);       
        	    g.fillPolygon(pol);
                g.drawLine(p1.x+uml1.getWidth()/2, p1.y+uml1.getHeight()/2, endLine.x, endLine.y);      
           }   
          
           else   if(typeRelation == EnumRelation.heritage){
        	   
        	  	 Point p11 = new Point() ;
            	 Point p12 = new Point() ;
            	 Point p13 = new Point() ;
            	 Point p14 = new Point() ;
            	 
            	 calculationTriangle(p11,p12,p13,p14,intersection);
            	 
            	    int [] polx = {p11.x,p12.x,p13.x};
            	    int [] poly = {p11.y,p12.y,p13.y};

                    g.drawLine(p1.x+uml1.getWidth()/2, p1.y+uml1.getHeight()/2, endLine.x, endLine.y); 
                    g.drawPolygon(polx,poly,3);
           }
        	   
       }
       
  }
