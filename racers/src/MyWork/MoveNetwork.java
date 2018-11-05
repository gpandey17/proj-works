/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MyWork;

/**
 *
 * @author Gyanu
 */

///////////////////////////////////////This will move cars in networked computeres ///////////////////////////////
///when one key is pressed it is passed to other computer and according to key value other car will run///////////

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MoveNetwork extends CarRacing{ // extending data from CarRacing
    
    double angle=0; double y=0, x=0; double a=30,b=30; 
    String str1="images/carimages/";   // give correct path to remote computer 
    int count=0; double accln=0; int score=0;
    
    MoveNetwork(){}
    
   public void moveMe(String a1){
                   if(a1==Integer.toString(KeyEvent.VK_RIGHT))
                     {
                     angle-=22.5;
                     if(angle<-360) angle=0;
                     count++;
                     
                     if(count>16){count=1;}
                     String str= str1+"cara"+count+".png";
                     label[11].setIcon(new ImageIcon(getClass().getResource(str)));
                    
                     label[10].paint(label[11].getGraphics()); // painting in label[10]
                 
                     x=2*Math.cos(angle); // finding slopes
                     y=2*Math.sin(angle);
                     
                     if(angle<0&& angle>-90){
                     a=label[11].getX()+ Math.abs(x);
                     b=label[11].getY()+ Math.abs(y);
                     }
                     if(angle<0 && angle>-90){
                     a=label[11].getX()- Math.abs(x);
                     b=label[11].getY()+ Math.abs(y);
                     }
                     if(angle>-180 && angle<-90){
                     a=label[11].getX()- Math.abs(x);
                     b=label[11].getY()- Math.abs(y);
                     }
                     if(angle<-270 && angle>-360){
                     a=label[11].getX()+ Math.abs(x);
                     b=label[11].getY()- Math.abs(y);
                     }  
                 }
                 if(a1==Integer.toString(KeyEvent.VK_LEFT))
                     {
                     angle+=22.5;
                     if(angle>360) angle=0;
                     count--; 
                     
                     if(count<0) {count=16;}
                     String str=str1+"cara"+count+".png";
                     label[11].setIcon(new ImageIcon(getClass().getResource(str)));
                     
                     label[10].paint(label[11].getGraphics());
                     
                     x=2*Math.cos(angle);
                     y=2*Math.sin(angle);
                    
                     if(angle>0 && angle<90){
                     a=label[11].getX()+ Math.abs(x);
                     b=label[11].getY()+ Math.abs(y);
                     }
                     if(angle>90 && angle<180){
                     a=label[11].getX()- Math.abs(x);
                     b=label[11].getY()+ Math.abs(y);
                     }
                     if(angle>180 && angle<270){
                     a=label[11].getX()- Math.abs(x);
                     b=label[11].getY()- Math.abs(y);
                     }
                     if(angle>270 && angle<360){
                     a=label[11].getX()+ Math.abs(x);
                     b=label[11].getY()- Math.abs(y);
                     } 
                                                        
                     
                 }
                 if(a1==Integer.toString(KeyEvent.VK_DOWN))
                     {
                        
                     score+=5;
                     if (count==0 || count==8)
                     label[11].setLocation(label[11].getX()-1,label[11].getY());
                     else
                     label[11].setLocation((int)a,(int)b); //a=a-accln*Math.abs(x);b=b-accln*Math.abs(y); 
                     a=a-1;b=b-1;
                     
                     label[10].paint(label[11].getGraphics());
                     
                 }
                 if(a1==Integer.toString(KeyEvent.VK_UP))
                     {
                     
                     score+=5;
                     if(count==0 || count==8)
                     label[11].setLocation(label[11].getX()+1,label[11].getY());
                     else
                     { 
                     label[11].setLocation((int)a,(int)b); // a=label[11].getX()+(int)accln; b=label[11].getY()+(int)accln;
                     a=a+1;b=b+1;}
                     label[10].paint(label[11].getGraphics());
                     }
                 
    }
}
