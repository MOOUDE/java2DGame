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
import java.util.ArrayList;
import java.util.Random;

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
   

  Toolkit kit = Toolkit.getDefaultToolkit();
  private static float getRandf(float min, float max) {

    Random rand = new Random();

    float result = rand.nextFloat() * (max - min) + min;

    return result;

}
  public static int change;
  private static int getRand(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	} 
     double var[] = new double[10];
     double vel[] = new double[10];
    class MyPanel extends JPanel{
       BufferedImage imgs[] = new BufferedImage[10];
        BufferedImage b;
        BufferedImage background;
         int M[] = new int[10];
         
   public  void change(int i ){
   M[i] = getRand(0,9);
    
   }   
public  int getChanged(int i){

return change;
}   
        public MyPanel()throws Exception {
        //   this.setBackground(Color.black);
         for(int i=0;i<10;i++){
           var[i] = getRand(1,10);
           vel[i] = 1;
          }
           
                
        
           imgs [0] = (ImageIO.read(getClass().getResourceAsStream(M[1]+".png")));
           imgs [1] = (ImageIO.read(getClass().getResourceAsStream(getRand(0,9)+".png")));
           imgs [2] = (ImageIO.read(getClass().getResourceAsStream(getRand(0,9)+".png")));
           imgs [3] = (ImageIO.read(getClass().getResourceAsStream(getRand(0,9)+".png")));
           imgs [4] = (ImageIO.read(getClass().getResourceAsStream(getRand(0,9)+".png")));
           imgs [5] = (ImageIO.read(getClass().getResourceAsStream(getRand(0,9)+".png")));
           imgs [6] = (ImageIO.read(getClass().getResourceAsStream(getRand(0,9)+".png")));
           imgs [7] = (ImageIO.read(getClass().getResourceAsStream(getRand(0,9)+".png")));
           imgs [8] = (ImageIO.read(getClass().getResourceAsStream(getRand(0,9)+".png")));
           imgs [9] = (ImageIO.read(getClass().getResourceAsStream(getRand(0,9)+".png")));
           
           background = ImageIO.read(getClass().getResourceAsStream("back.png"));
           
          
          for(int i=0 ; i< 9 ; i++){
            M[i] = getRand(0,9);   
    
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
          
          
          
          
          Move  m0 = new Move(0,2);
          Move2 m1 = new Move2(10,1);
          Move3  m2 = new Move3(0,2);
          Move4 m3 = new Move4(10,1);
          Move5  m4 = new Move5(0,2);
          Move m5 = new Move(10,1);
          Move2  m6 = new Move2(0,2);
          Move3 m7 = new Move3(10,1);
          Move4  m8 = new Move4(0,2);
          Move5 m9 = new Move5(10,1);
          
          int yPos[] = {10,80,160,230,320,400,480,560,640,720,800,880};
          
           g2.drawImage(imgs[M[0]], 10,  m1.setval(), 40 ,40,null);
           g2.drawImage(imgs[M[1]], 80,  m2.setval(), 40 ,40,null);
           g2.drawImage(imgs[M[2]], 160, m3.setval(), 40 ,40,null);
           g2.drawImage(imgs[M[3]], 230, m4.setval(), 40 ,40,null);
           g2.drawImage(imgs[M[4]], 320, (int)m5.setval(), 40 ,40,null);
           g2.drawImage(imgs[M[5]], 400, m6.setval(), 40 ,40,null);
           g2.drawImage(imgs[M[6]], 480, m7.setval(), 40 ,40,null);
           g2.drawImage(imgs[M[7]], 560, m8.setval(), 40 ,40,null);
           g2.drawImage(imgs[M[8]], 640, m9.setval(), 40 ,40,null);
           g2.drawImage(imgs[M[9]], 720, m1.setval(), 40 ,40,null);
      //     g2.drawImage(imgs[M[1]], 800, m2.setval(), 40 ,40,null);
     //      g2.drawImage(imgs[M[2]], 880, m1.setval(), 40 ,40,null);
         
           
           
          m0.start(); 
          m1.start();
          m2.start();
          m3.start();
          m4.start();
          m5.start();
          m6.start();
          m7.start();
          m8.start();
          m9.start();
        
         
        } 
        
       
        
 //Mving obj threads 1        

     class Move extends Thread {
         
         public Move(int x , int y){
         }
         
     public void run(){
        
         try{
         
       if( var[1] > 430 ){
           change(1);
            vel[1] = 0.7;  
            var[1] = getRand(-200,-50); 
            Thread.sleep(2000);
       }
       var[1] = var[1] + vel[1];    
      
             
       repaint();
       setval();
      
      Thread.sleep(5000); 
      
          }catch(Exception e){
          e.printStackTrace();
          }
         
      }
     public double setval(){
      
     return var[1];
     }
      
    }//end of thread
     

     class Move2 extends Thread {
         
         public Move2(int x , int y){
         }
     public void run(){
          try{
         
       if( var[2] > 430 ){
           change(2);
           
           var[2] = getRand(-100,0); 
            vel[2] = 0.7;
            Thread.sleep(2000);
       }
          
       var[2] = var[2] + vel[2];    
       
            
       repaint();
       setval();
      
      Thread.sleep(5000); 
      
          }catch(Exception e){
          e.printStackTrace();
          }
          
      }
     public int setval(){
      
     return (int)var[2];
     }
      
    }//end of thread     
     

     
     //Mving obj threads 3        

     class Move3 extends Thread {
         
         public Move3(int x , int y){
         }
     public void run(){
          try{
         
       if( var[3] > 430 ){
            change(3);
           
           var[3] = getRand(-100,0); 
            vel[3] = 0.7;
             Thread.sleep(2000);
       }
       var[3] = var[3] + vel[3];    
      
             
       repaint();
       setval();
      
      Thread.sleep(5000); 
      
          }catch(Exception e){
          e.printStackTrace();
          }
          
      }
     public int setval(){
      
     return (int)var[3];
     }
      
    }//end of thread
     
     //Mving obj threads 1        

     class Move4 extends Thread {
         
         public Move4(int x , int y){
         }
     public void run(){
          try{
         
     if( var[4] > 430 ){
          change(4);
        
           var[4] = getRand(-100,0); 
            vel[4] = 0.7;
            Thread.sleep(2000);
       }
          
       var[4] = var[4] + vel[4];    
      
              
       repaint();
       setval();
      
      Thread.sleep(4000); 
      
          }catch(Exception e){
          e.printStackTrace();
          }
          
      }
     public int setval(){
      
     return (int)var[4];
     }
      
    }//end of thread
     
     //Mving obj threads 1        

     class Move5 extends Thread {
         
         public Move5(int x , int y){
         }
     public void run(){
          try{
         
       if( var[5] > 430 ){
           change(5);
           var[5] = getRand(-100,0); 
            vel[5] = 0.7;
            Thread.sleep(2000);  
       }
          
       var[5] = var[5] + vel[5];    
      
       
       repaint();
       setval();
      
      Thread.sleep(4000); 
      
          }catch(Exception e){
          e.printStackTrace();
          }
          
      }
     public int setval(){
      
     return (int)var[5];
     }
      
    }//end of thread
     
          
     
 ///////////////      
     
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
