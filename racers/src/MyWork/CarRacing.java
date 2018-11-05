/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MyWork;

/**
 *
 * @author Gyanu
 * 
 */

/// this is main file to run the car game ... we call other constructors from this class//////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////

import MyWork.CarRacing;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.*;  
import javax.swing.*;  
import javax.swing.border.*;  
import javax.swing.*;
import java.lang.*;
import java.sql.Time;
import java.util.Date;
import  sun.audio.*;

public class CarRacing extends JFrame{
    
    private JLayeredPane content;
    public JLabel[] label;
    private JButton[] button;
    public JLabel temp; 
    JFrame frame= new JFrame("Enter Network data"); 
    public static String port; public static  String hostname; public String keycode="";
    //private Sound sound;
    String path="images/";
    
        CarRacing(){
            super("The Car Racers: ****");
            content= new JLayeredPane();
            label= new JLabel[14];
            button= new JButton[4];
            
             for (int i=0; i<3;i++){   // buttons on main display game 
                 button[i]=new JButton(new ImageIcon(getClass().getResource(path+"button"+i+".jpg")));
                 button[i].setBorder( BorderFactory.createBevelBorder( BevelBorder.RAISED ) );
             }
            button[3]= new JButton("ConnectServer");
            
             for (int i=0; i<3;i++){   // labels on main display game LAYERED 
                 label[i]=new JLabel(new ImageIcon(getClass().getResource(path+"label"+i+".jpg")));
                 label[i].setBorder( BorderFactory.createBevelBorder( BevelBorder.RAISED ) );
             }
             
            label[3] = new JLabel("SCORES:");
            label[3].setBorder( BorderFactory.createBevelBorder( BevelBorder.RAISED ) );
            String player1="Player 1:"; String player2="Player 2:";
            label[4] = new JLabel(player1);
            label[5] = new JLabel(player2);
            String score1="0", score2="0";
            label[6]= new JLabel(score1);
            label[7] = new JLabel(score2);
            label[8] = new JLabel("Time Elapsed:");
            
             // call method to load time 
            Date time =new Date();
            String timer = Integer.toString(time.getSeconds()); // displaying times in seconds
            label[9] = new JLabel(timer);
            label[13]= new JLabel("Click N for network Play");
            
            for(int i=10; i<13; i++){  //loading track and cars 
             if(i==11){
             	label[i]=new JLabel(new ImageIcon(getClass().getResource(path+ "carimages/cara1.png"))); 
             } else 
             if(i==12){
            	 label[i]=new JLabel(new ImageIcon(getClass().getResource(path+ "carimages/carb1.png")));    
             } else {
            	  label[i]=new JLabel(new ImageIcon(getClass().getResource(path+"label"+ i + ".jpg")));
             }
            
            }
                        
            content.setOpaque( true );
            setContentPane( content ); 
            // setting locations
            
            label[0].setBounds(0,0,1400,1000);
            button[0].setBounds(100,150,100,100);
            button[1].setBounds(100,300, 100,100);
            button[2].setBounds(100,450, 100,100);
            label[3].setBounds(1100,150, 60,20);
            label[4].setBounds(1100, 180, 100, 20);
            label[5].setBounds(1100, 200, 100, 20);
            label[6].setBounds(1160, 180, 100, 20);
            label[7].setBounds(1160, 200, 100, 20);
            label[8].setBounds(1100,500,150,20);
            label[9].setBounds(1190,500,150,20);
            label[10].setBounds(270,80, 800, 600);
            label[13].setBounds(1100,600,140,60);
            
            label[11].setBounds(530,150, 35, 35);
            label[12].setBounds(530,190,35, 35);
                         
            for(int i=0;i<14;i++){
                content.setLayer(label[i], i);  // layerizing
                content.add(label[i]);
                }
            for(int i=14;i<18;i++){
                content.setLayer(button[i-14], i); // layerizing
                content.add(button[i-14]);
            }
                        
            button[2].addActionListener(new ActionListener() {  // help button will be displayed
            public void actionPerformed(ActionEvent ev) {
                JFrame msg=new JFrame("HELP MESSAGE****");
                JLabel help= new JLabel( new ImageIcon(getClass().getResource("images/helpdata.jpg")));
                msg.add(help);
                help.setBounds(0,0,800,600);
                help.setBorder( BorderFactory.createBevelBorder( BevelBorder.RAISED ) );
                msg.setLocation(270,80);
                msg.setBackground(Color.CYAN);
                msg.setSize(800,600);
                msg.setVisible(true);
             }
            });
            // adding mouse effect on button 1, displays options
                                
           button[1].addMouseListener(new MouseListener(){
                   
            @Override
            public void mouseClicked(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
              
                  }

            @Override
            public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
               label[2].setVisible(true);
               label[2].setBounds(200,300, 300,300);
               content.setLayer(label[2],16); content.add(label[2]);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                double a= getLocation().getX(); double b= getLocation().getY();
                if((a<150 || a>500) && b<450 || b>550)
                label[2].setVisible(false);
            }
          });
       
             button[0].addMouseListener(new MouseListener(){
                   
            @Override
            public void mouseClicked(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
              
                  }

            @Override
            public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
               label[1].setVisible(true);
               label[1].setBounds(200,150, 160,200);
               content.setLayer(label[1],17); content.add(label[1]);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                double a= getLocation().getX(); double b= getLocation().getY();
                if((a<100 || a>500) && b<150 || b>550)
                label[1].setVisible(false);
            }
             });
         // adding key listener to own form... to listen while playing
             
                      
                // button[3]= new JButton("click for network play");
                 button[3].addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent ev) {
                 //frame.setVisible(false);
                 }
                }); 
           
          setVisible(true);
          setSize(1600,1000);
          setDefaultCloseOperation( EXIT_ON_CLOSE );  
          Thread t= new CarRacing.BasicThread2();
          t.run();
          
              
          label[13].addKeyListener(new KeyAdapter()
             {
                 
             public void keyPressed(KeyEvent ke)
                 {
                     String str="";
                     Requester client1 = new Requester();
                     Requester1 client2=new Requester1();  // separating hostname and port numbers here
                        label[13].setFocusable(true);
                        if(ke.getKeyCode() == KeyEvent.VK_N)
                        str= loadNetwork();
                     	hostname=str.substring(0,str.indexOf("++"));
                     	port=str.substring(str.lastIndexOf("++"),str.length());
                     	
                      if(ke.getKeyCode() == KeyEvent.VK_ESCAPE){
                    	 frame.setVisible(false);
                         setFocusable(true);            // removing frame
                         
                 
                     }
                      
                 }
             });
        
         //MoveLabel move1=new MoveLabel(label[11],label[12]);
        
         //new MoveLabel(label[11], label[12]);  // calling constructor of MoveLabel from here
        }   
        
         public String loadNetwork(){  // this will load jframe to enter hostname and port number from client
                   	 
        	 JLabel labels1= new JLabel("Enter the hostname:");
        	 JLabel labels2= new JLabel("Enter the port as 2020:");
        	 JTextField field1= new JTextField("hostname");
        	 JTextField field2= new JTextField("0000");
        	 frame.setLayout(new GridBagLayout());
        	 frame.add(labels1);frame.add(labels2);frame.add(button[3]);
        	 frame.add(field1);frame.add(field2);
        	 frame.setSize(400,400); frame.setLocation(300,300); frame.setVisible(true);
        	 frame.setDefaultCloseOperation(1);
        	 return (field1.toString()+"++"+field2.toString());
         }
         
          class BasicThread2 extends Thread {
         // This method is called when the thread runs   
          public void run() {
          //label[11].setFocusable(true);                 
          new MyWork.MoveLabel(label[11],label[12]);
          //label[12].setFocusable(true);
     }
          }
         //************************************************************************************
         // main to call this class
        public static void main( String[] arg ) {  
        CarRacing race= new CarRacing();   
        
         }    
        }
    

