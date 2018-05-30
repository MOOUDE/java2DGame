/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.*;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;

class MyFrame extends JFrame{

    public MyFrame() throws Exception {
      super("Down Game");
        Toolkit kit = Toolkit.getDefaultToolkit(); 
        this.setSize(new Dimension((int)kit.getScreenSize().getWidth()/2 + 200,
        (int)kit.getScreenSize().getHeight()/2 +130 ));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
      //  this.setLocation((int)kit.getScreenSize().getWidth()/5 ,(int) kit.getScreenSize().getHeight()/4 );
        this.setLocationRelativeTo(null);   
        this.setResizable(false);
        Container c = this.getContentPane();
        c.add(new MyPanel());
        this.setVisible(true);
    }
   
    
    int y=0 , vely = 2;
  Toolkit kit = Toolkit.getDefaultToolkit();
   
   
    
    class MyPanel extends JPanel{
        BufferedImage img,img2,background;
        public MyPanel() {
        //   this.setBackground(Color.black);
           
           try{
           img = ImageIO.read(getClass().getResourceAsStream("0.png"));
           img2 = ImageIO.read(getClass().getResourceAsStream("1.png"));
           background = ImageIO.read(getClass().getResourceAsStream("back.png"));
           
        
           }catch(Exception e){
           e.printStackTrace();
           }  
           // toolkit
           
        }
        
       
        @Override
        public void paintComponent(Graphics g){
          Toolkit kit = Toolkit.getDefaultToolkit();
          Graphics2D g2 = (Graphics2D)g;
          super.paintComponent(g2);
         
         
          g2.drawImage(background, 0, 0, 
                   (int)kit.getScreenSize().getWidth()/2 + 200 ,
                   (int)kit.getScreenSize().getHeight()/2 +100 ,null);
          Move m1 = new Move(0,2);
          Move m2 = new Move(10,1);
          
           g2.drawImage(img, 10, m1.setval(), 30 ,30,null);
           g2.drawImage(img2, 50, m2.setval(), 30 ,30,null);
          m1.start();
        } 

     class Move extends Thread {
         int var,vel;
         public Move(int var , int vel){
          this.var = var;
          this.vel = vel;
         }
     public void run(){
          try{
       if(var < 0 || var > 430 )
           vel = - vel; 
          
       var = var + vel;
       repaint();
       setval();
      
      Thread.sleep(1000); 
      
          }catch(Exception e){
          e.printStackTrace();
          }
          
      }
     public int setval(){
      
     return var;
     }
      
    }//end of thread
       
    } //end of jpanel
     
   
    
    
}
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        
     MyFrame fr = new MyFrame();   
        
        
    }
    
}
