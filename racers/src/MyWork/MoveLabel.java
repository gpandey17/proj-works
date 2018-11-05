//Moving label using arrow keys
package MyWork;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class MoveLabel extends JFrame
    {
    // JLabel label; 
    double angle=0; double y=0, x=0; double a=30,b=30; 
    String str1="images/carimages/";
    int count=0; double accln=0; int score=0;
    public String key;
    double angle1=0; double y1=0, x1=0; double a1=30,b1=30; 
    int count1=0; double accln1=0; int score1=0;
    
    public MoveLabel(){}
    
    
    
    public MoveLabel(final JLabel label1, final JLabel label2)
         {
        /* label1.setBounds(20,150,35,35);
         label2.setBounds(20,190,35,35);
         label1.setFocusable(true);
         label2.setFocusable(true);*/
         
         label1.addKeyListener(new KeyAdapter()
             {
                 
             public void keyPressed(KeyEvent ke)
                 {
                     label1.setFocusable(true);
                     if(ke.getKeyCode() == KeyEvent.VK_E)
                     {
                         key="E";
                     }
                     if(ke.getKeyCode() == KeyEvent.VK_RIGHT)
                     {
                     key=Integer.toString(KeyEvent.VK_RIGHT);
                     angle-=22.5;
                     if(angle<-360) angle=0;
                     count++;
                     
                     if(count>16){count=1;}
                     String str= str1+"cara"+count+".png";
                     label1.setIcon(new ImageIcon(getClass().getResource(str)));
                     //label1.repaint();
                     repaint();
                    //jj
                     x=2*Math.cos(angle);
                     y=2*Math.sin(angle);
                     
                     if(angle<0&& angle>-90){
                     a=label1.getX()+ Math.abs(x);
                     b=label1.getY()+ Math.abs(y);
                     }
                     if(angle<0 && angle>-90){
                     a=label1.getX()- Math.abs(x);
                     b=label1.getY()+ Math.abs(y);
                     }
                     if(angle>-180 && angle<-90){
                     a=label1.getX()- Math.abs(x);
                     b=label1.getY()- Math.abs(y);
                     }
                     if(angle<-270 && angle>-360){
                     a=label1.getX()+ Math.abs(x);
                     b=label1.getY()- Math.abs(y);
                     }  
                 }
                 if(ke.getKeyCode() == KeyEvent.VK_LEFT)
                     {
                     label1.setFocusable(true);
                     key=Integer.toString(KeyEvent.VK_LEFT);
                     angle+=22.5;
                     if(angle>360) angle=0;
                     count--; 
                     
                     if(count<0) {count=16;}
                     String str=str1+"cara"+count+".png";
                     label1.setIcon(new ImageIcon(getClass().getResource(str)));
                     repaint();
                     //label.paint(label1.getGraphics());
                     
                     x=2*Math.cos(angle);
                     y=2*Math.sin(angle);
                    
                     if(angle>0 && angle<90){
                     a=label1.getX()+ Math.abs(x);
                     b=label1.getY()+ Math.abs(y);
                     }
                     if(angle>90 && angle<180){
                     a=label1.getX()- Math.abs(x);
                     b=label1.getY()+ Math.abs(y);
                     }
                     if(angle>180 && angle<270){
                     a=label1.getX()- Math.abs(x);
                     b=label1.getY()- Math.abs(y);
                     }
                     if(angle>270 && angle<360){
                     a=label1.getX()+ Math.abs(x);
                     b=label1.getY()- Math.abs(y);
                     } 
                                                        
                     
                 }
                 if(ke.getKeyCode() == KeyEvent.VK_DOWN)
                     {
                        //accln-=.23;
                     label1.setFocusable(true);
                     key=Integer.toString(KeyEvent.VK_DOWN);
                     score+=5;
                     if (count==0 || count==8)
                     label1.setLocation(label1.getX()-1,label1.getY());
                     else
                     label1.setLocation((int)a,(int)b); //a=a-accln*Math.abs(x);b=b-accln*Math.abs(y); 
                     a=a-1;b=b-1;
                     repaint();
                    // label.paint(label1.getGraphics());
                     
                 }
                 if(ke.getKeyCode() == KeyEvent.VK_UP)
                     {
                     // accln
                     //accln+=.23; 
                     label1.setFocusable(true);
                     key=Integer.toString(KeyEvent.VK_UP);
                     score+=5;
                     if(count==0 || count==8)
                     label1.setLocation(label1.getX()+1,label1.getY());
                     else
                     {  label1.setLocation((int)a,(int)b);// a=label1.getX()+(int)accln; b=label1.getY()+(int)accln;
                     a=a+1;b=b+1;}
                     repaint();
                     //label.paint(label1.getGraphics());
                     }
                 }});
         
         label2.addKeyListener(new KeyAdapter()
         {
             
         public void keyPressed(KeyEvent ke)
             {
                 if(ke.getKeyCode() == KeyEvent.VK_D)
                     {
                     label2.setFocusable(true);
                     angle1-=22.5;
                     if(angle1<-360) angle1=0;
                     count1++;
                     
                     if(count1>16){count1=1;}
                     String str= str1+"carb"+count1+".png";
                     label2.setIcon(new ImageIcon(getClass().getResource(str)));
                     label2.repaint();
                     //label.paint(label2.getGraphics());
                    
                     x1=2*Math.cos(angle1);
                     y1=2*Math.sin(angle1);
                     
                     if(angle1<0&& angle1>-90){
                     a1=label2.getX()+ Math.abs(x1);
                     b1=label2.getY()+ Math.abs(y1);
                     }
                     if(angle1<0 && angle1>-90){
                     a1=label2.getX()- Math.abs(x1);
                     b1=label2.getY()+ Math.abs(y1);
                     }
                     if(angle1>-180 && angle1<-90){
                     a1=label2.getX()- Math.abs(x1);
                     b1=label2.getY()- Math.abs(y1);
                     }
                     if(angle1<-270 && angle1>-360){
                     a1=label2.getX()+ Math.abs(x1);
                     b1=label2.getY()- Math.abs(y1);
                     }  
                 }
                 if(ke.getKeyCode() == KeyEvent.VK_A)
                     {
                         label2.setFocusable(true);
                     angle1+=22.5;
                     if(angle1>360) angle1=0;
                     count1--; 
                     
                     if(count1<0) {count1=16;}
                     String str=str1+"carb"+count1+".png";
                     label2.setIcon(new ImageIcon(getClass().getResource(str)));
                     repaint();
                     //label.paint(label2.getGraphics());
                     
                     x1=2*Math.cos(angle1);
                     y1=2*Math.sin(angle1);
                    
                     if(angle1>0 && angle1<90){
                     a1=label2.getX()+ Math.abs(x1);
                     b1=label2.getY()+ Math.abs(y1);
                     }
                     if(angle1>90 && angle1<180){
                     a1=label2.getX()- Math.abs(x1);
                     b1=label2.getY()+ Math.abs(y1);
                     }
                     if(angle1>180 && angle1<270){
                     a1=label2.getX()- Math.abs(x1);
                     b1=label2.getY()- Math.abs(y1);
                     }
                     if(angle1>270 && angle1<360){
                     a1=label2.getX()+ Math.abs(x1);
                     b1=label2.getY()- Math.abs(y1);
                     } 
                                                        
                     
                 }
                 if(ke.getKeyCode() == KeyEvent.VK_X)
                     {
                        //accln-=.23;
                         label2.setFocusable(true);
                     score1+=5;
                     if (count1==0 || count1==8)
                     label2.setLocation(label2.getX()-1,label2.getY());
                     else
                     label2.setLocation((int)a1,(int)b1); //a=a-accln*Math.abs(x);b=b-accln*Math.abs(y); 
                     a1=a1-1;b1=b1-1;
                     repaint();
                     //label.paint(label2.getGraphics());
                     
                 }
                 if(ke.getKeyCode() == KeyEvent.VK_W)
                     {
                     // accln
                     //accln+=.23; 
                     score1+=5;
                     label2.setFocusable(true);
                     if(count1==0 || count1==8)
                     label2.setLocation(label2.getX()+1,label2.getY());
                     else
                     {  label2.setLocation((int)a1,(int)b1);// a=label1.getX()+(int)accln; b=label1.getY()+(int)accln;
                     a1=a1+1;b1=b1+1;}
                     }//label2
                     repaint();
                   // label.paint(label2.getGraphics());
             
             }
             
         });
       
         
         }
     public int score(){
         return score;
     }
     public String returnkey(){
     return key;
     }
}