
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
public class Ship implements KeyListener, Runnable
{
    public int row;
    public int col;
    
    private ImageIcon myPic;
    int upKey;
    int downKey;
    
   
    public Ship(int r,int c,String fileName,int a,int b)
    {
        
        row=r;
        col=c;        
        upKey=a;
        downKey=b;
        constructImage(fileName);        
    }
     public void run() {
        System.out.println("Hello from a thread!");
        this.start();
    }
    public Image getPic(){
    return myPic.getImage();
    }
    public int getCol(){
    return col;
    }
    public int getRow(){
    return row;
    }
    
    private void constructImage(String fileName) {
        File imageFile = new File("./images/" + fileName);        
        myPic = new ImageIcon (imageFile.toString());  
        
    }
    
    public void keyPressed(KeyEvent e) {
        System.out.println(upKey);
        if (e.getKeyCode() == upKey ) {
            if(row>=3){
                row-=3;}
        }if (e.getKeyCode() == downKey ) {
            if(row<=845)
            {row+=3;}
        }//if(e.getKeyCode()==KeyEvent.VK_SPACE){
        
        //}
        
       
       
    }
     public void keyReleased(KeyEvent e) {
       
    }

    public void keyTyped(KeyEvent e) {
        
    }
   
}
