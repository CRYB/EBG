
package animate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.util.ArrayList;


public class Animate {
    static double x =1;
    static double y =1;
    static double vector = 1;
    int width = 500;
    int height = 300;
    static long lastFrameTime;
    public static void main(String[] args) {
        
        
        Animate gui = new Animate();
        gui.go();
// ***
        
        
    }
    
    public void go(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyDrawP drawP = new MyDrawP();
        frame.add(drawP);
        frame.setSize(width,height);
        frame.setVisible(true);
        lastFrameTime = System.nanoTime();
            
           

    }
    
    private static void onRepaint(Graphics g){
            g.setColor(Color.white);
            g.fillRect(0, 0, 500, 250);
            g.setColor(Color.blue);
            g.fillOval((int)x, (int)y, 30, 30);
            
            long currentTime = System.nanoTime();
            float deltaTime = (currentTime - lastFrameTime)*0.000000001f;
            lastFrameTime = currentTime;
            if(y<10)vector =1;
            if(y>40)vector =-1;
            y = y + 100*deltaTime*vector;
            x = y*y/20;
        
    }
    private static class MyDrawP extends JPanel {
        @Override
        public void paintComponent (Graphics g){
            super.paintComponent(g);
            onRepaint(g);
            repaint();
        }
    }
    
    
}
