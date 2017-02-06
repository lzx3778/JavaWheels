package tryPack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by lenovo on 2017-2-5.
 */
public class GravityEngine extends JFrame implements Runnable{
    private static double blockHeight;
    private static FallingObject fallingObject;

    private static double sizeX;
    private static double sizeY;
    private static double velocity;
    private static double y;

    private static boolean flying;

    private static double bounceVelocity;

    public static void main(String[] args) {
        GravityEngine testFrame = new GravityEngine();
    }

    public GravityEngine(){
        //initialize values
        blockHeight = 700;

        sizeX = 30;
        sizeY = 30;
        velocity = 0;
        y = 1;

        flying = false;

        bounceVelocity = 0;

        //initialize the frame
        setVisible(true);
        setBounds(100,0,400,800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //react with the input from keyboard
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 32){
                    velocity = -30;
                }
            }
        });

        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //gravity code
            //the order is extremely important!

            //displacement calculation
            y += velocity;

            //record highest point
            if (0.1 > velocity && velocity > -0.1 && y < blockHeight){
                //high point to velocity equation
                //suvat problem
                bounceVelocity = -Math.sqrt((blockHeight - y) * 1.5);
                System.out.println(bounceVelocity);
            }

            //decide if the object is in air
            flying = (y < blockHeight);

            //keep falling or stop
            if (flying){
                velocity ++;
            }else{
                //hit the ground level
                //set object height to ground
                y = blockHeight;

                //air resistance depends on the size
                if (bounceVelocity < 0) {
                    bounceVelocity += Math.sqrt(sizeX*sizeY) / 10;
                }

                //bounce up
                velocity = bounceVelocity;
            }

            //repaint the screen
            repaint();
        }
    }

    public void paint(Graphics graphics){
        super.paint(graphics);
        //draw a ball
        graphics.fillOval(200, (int) y, (int) sizeX, (int) sizeY);
    }
}
