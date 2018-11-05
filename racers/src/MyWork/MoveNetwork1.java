/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MyWork;

/**
 *
 * @author Gyanu
 */
/////////////////////////////////// this code will run cars in each clients according to key pressed in different client////////////
//////////// Here we just pass keys values and apply the effects in remote computers///////////////////////////////////////////////
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MoveNetwork1 extends CarRacing{
    
    double angle=0; double y=0, x=0; double a=30,b=30; 
    String str1="images/carimages/";   // give correct path to remote computer 
    int count=0; double accln=0; int score=0;
    
    MoveNetwork1(){}
    
   public void moveMe(String a1){
                   if(a1==Integer.toString(KeyEvent.VK_RIGHT))
                     {
                     angle-=22.5;
                     if(angle<-360) angle=0;
                     count++;
                     
                     if(count>16){count=1;}
                     String str= str1+"carb"+count+".png";
                     label[12].setIcon(new ImageIcon(getClass().getResource(str)));
                    
                     label[10].paint(label[12].getGraphics());
                 
                     x=2*Math.cos(angle);
                     y=2*Math.sin(angle);
                     
                     if(angle<0&& angle>-90){
                     a=label[12].getX()+ Math.abs(x);
                     b=label[12].getY()+ Math.abs(y);
                     }
                     if(angle<0 && angle>-90){
                     a=label[12].getX()- Math.abs(x);
                     b=label[12].getY()+ Math.abs(y);
                     }
                     if(angle>-180 && angle<-90){
                     a=label[12].getX()- Math.abs(x);
                     b=label[12].getY()- Math.abs(y);
                     }
                     if(angle<-270 && angle>-360){
                     a=label[12].getX()+ Math.abs(x);
                     b=label[12].getY()- Math.abs(y);
                     }  
                 }
                 if(a1==Integer.toString(KeyEvent.VK_LEFT))
                     {
                     angle+=22.5;
                     if(angle>360) angle=0;
                     count--; 
                     
                     if(count<0) {count=16;}
                     String str=str1+"carb"+count+".png";
                     label[12].setIcon(new ImageIcon(getClass().getResource(str)));
                     
                     label[10].paint(label[12].getGraphics());
                     
                     x=2*Math.cos(angle);
                     y=2*Math.sin(angle);
                    
                     if(angle>0 && angle<90){
                     a=label[12].getX()+ Math.abs(x);
                     b=label[12].getY()+ Math.abs(y);
                     }
                     if(angle>90 && angle<180){
                     a=label[12].getX()- Math.abs(x);
                     b=label[12].getY()+ Math.abs(y);
                     }
                     if(angle>180 && angle<270){
                     a=label[12].getX()- Math.abs(x);
                     b=label[12].getY()- Math.abs(y);
                     }
                     if(angle>270 && angle<360){
                     a=label[12].getX()+ Math.abs(x);
                     b=label[12].getY()- Math.abs(y);
                     } 
                                                        
                     
                 }
                 if(a1==Integer.toString(KeyEvent.VK_DOWN))
                     {
                        
                     score+=5;
                     if (count==0 || count==8)
                     label[12].setLocation(label[12].getX()-1,label[12].getY());
                     else
                     label[12].setLocation((int)a,(int)b); //a=a-accln*Math.abs(x);b=b-accln*Math.abs(y); 
                     a=a-1;b=b-1;
                     
                     label[10].paint(label[12].getGraphics());
                     
                 }
                 if(a1==Integer.toString(KeyEvent.VK_UP))
                     {
                     
                     score+=5;
                     if(count==0 || count==8)
                     label[12].setLocation(label[12].getX()+1,label[12].getY());
                     else
                     { 
                     label[12].setLocation((int)a,(int)b); // a=label[12].getX()+(int)accln; b=label[12].getY()+(int)accln;
                     a=a+1;b=b+1;}
                     label[10].paint(label[12].getGraphics());
                     }
                 
    }
}
