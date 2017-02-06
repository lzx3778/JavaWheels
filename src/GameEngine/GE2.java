package GameEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by lenovo on 2017-2-5.
 */
public class GE2 extends JFrame{

    public static void main(String[] args) {
        GE2 ge2 = new GE2();
    }

    public GE2(){

        //initialize the frame
        setContentPane(new Layout());
        setVisible(true);
        setBounds(100,0,400,800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //react with the input from keyboard
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 32){
                    FallingObject.setVelocity(-30);
                }
            }
        });

    }
}
class Layout extends JPanel implements Runnable{

    private static int refreshRate;

    private static double blockHeight;
    private static double airResistnce;

    //10 < width or height < 100
    FallingObject fallingObject = new FallingObject(10,10,0,400);

    public Layout(){
        //initialize values
        //refresh rate (calculate speed) (ms/time)
        refreshRate = 5;

        //bounding box height
        blockHeight = 700;

        //0 < airR < 1
        airResistnce = 0;

        //process start
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(refreshRate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //gravity code

            //the order is extremely important!

            //displacement calculation
            FallingObject.setCenterY(FallingObject.getCenterY() + (FallingObject.getVelocity() / 10 * refreshRate));

            //air resistance calculation
            //0 < airR < 1
            airResistnce = FallingObject.getSizeX() / 140;

            //decide if the object is in air
            FallingObject.setFlying(FallingObject.getCenterY() < blockHeight - 22 * airResistnce - FallingObject.getSizeY() / 2);

            //keep falling or stop
            if (FallingObject.isFlying()){

                //gravity simulate
                FallingObject.setVelocity(FallingObject.getVelocity() + (0.1 * refreshRate));

                if (FallingObject.getVelocity() >= 0){

                    //falling
                    FallingObject.setVelocity(FallingObject.getVelocity() - airResistnce);

                    //for fun
//                    FallingObject.setSizeX(FallingObject.getSizeX() + (0.19 * refreshRate));
//                    FallingObject.setSizeY(FallingObject.getSizeY() + (0.19 * refreshRate));

                }else {

                    //jumping
                    FallingObject.setVelocity(FallingObject.getVelocity() + airResistnce);

                    //for fun
//                    FallingObject.setSizeX(FallingObject.getSizeX() - (0.2 * refreshRate));
//                    FallingObject.setSizeY(FallingObject.getSizeY() - (0.2 * refreshRate));

                }
            }else{

                //hit the ground level

                //set object height to ground
                FallingObject.setCenterY(blockHeight - (FallingObject.getSizeY() / 2));

                //bounce up
                FallingObject.setVelocity(-FallingObject.getVelocity());

            }

            //repaint the screen
            repaint(0,0,400, (int) (blockHeight + FallingObject.getSizeY()));
        }
    }

    @Override
    public void paint(Graphics graphics){

        super.paint(graphics);

        //draw the ground level
        graphics.fillRect(0, (int) (blockHeight + FallingObject.getSizeY() / 2),400,100);

        //draw a ball
        graphics.fillOval((int) (200 - FallingObject.getSizeX() / 2), (int) FallingObject.getCenterY(), (int) FallingObject.getSizeX(), (int) FallingObject.getSizeY());
    }
}
