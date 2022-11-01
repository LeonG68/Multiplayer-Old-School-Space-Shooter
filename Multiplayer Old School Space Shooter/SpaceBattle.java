import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
public class SpaceBattle extends JPanel 
{
    private int myWindowWidth = 1680;
    private int myWindowHeight = 1000;
   
    
    private String fileName3= "stars.jpg";
    
    private ImageIcon myPic3;
    private JFrame myFrame;
    Ship shipOne= new Ship(388,0,"ship.jpg",KeyEvent.VK_W,KeyEvent.VK_S);
    Ship shipTwo= new Ship(388,1513,"ship2.jpg",KeyEvent.VK_UP,KeyEvent.VK_DOWN);
    

    public SpaceBattle(){
        // initialise instance variables
        JFrame easel = new JFrame("SpaceBattle");
        addKeyListener(shipOne);
        addKeyListener(shipTwo);
        
        easel.setSize(myWindowWidth, myWindowHeight);
        easel.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        easel.add(this);
        constructImage3(fileName3);
       easel.setVisible(true);
        setFocusable(true);
        (new Thread(shipOne)).start();
        //(new Thread(shipTwo)).start();
        
        
         Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                repaint();
            }
        }, 0, 10);

    }

    public void paintComponent(Graphics g) {
        g.drawImage(myPic3.getImage(),0,0,this);
       
         g.drawImage(shipOne.getPic(), shipOne.getCol(), shipOne.getRow(), this);
         g.drawImage(shipTwo.getPic(), shipTwo.getCol(), shipTwo.getRow(), this);
    }

  

    


    private void constructImage3(String fileName) {
        File imageFile = new File("./images/" + fileName);
        // an ImageIcon is a class that contains an image and knows how to draw itself
        myPic3 = new ImageIcon (imageFile.toString());
        // sets the size of the window based on the picture loaded. 
        //myFrame.setSize(myPic.getIconWidth(), myPic.getIconHeight() );
    }

    
    

}
