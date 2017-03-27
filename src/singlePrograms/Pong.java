package singlePrograms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * Created by lenovo on 2017-1-31.
 */
public class Pong extends JFrame implements Runnable{
    private double BallSpeedX;
    private double BallSpeedY;
    private int BallCenterX;
    private int BallCenterY;
    private int BallSizeX;
    private int BallSizeY;

    private int BoardSizeX;
    private int BoardSizeY;

    private double B1SpeedX;
    private double B2SpeedX;
    private int B1CenterX;
    private int B2CenterX;

    private int B1Score;
    private int B2Score;

    Random random = new Random();

    public Pong() {
        //random initial position
        BallCenterX = 25 + random.nextInt(250);
        BallCenterY = 300;

        BallSizeX = 10;
        BallSizeY = 10;
        BallSpeedX = 3;
        BallSpeedY = 4;

        BoardSizeX = 100;
        BoardSizeY = 20;

        B1CenterX = 150;
        B2CenterX = 150;

        B1SpeedX = 2;
        B2SpeedX = 2;

        B1Score = 0;
        B2Score = 0;

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 610);
        setResizable(false);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
            if(GetBoard2CollideWall()){
                return;
            }
            super.keyPressed(e);
            int key = e.getKeyCode();
            switch (key){
                case 65:
                    B2CenterX -= B2SpeedX;
                    break;
                case 68:
                    B2CenterX += B2SpeedX;
                    break;
                default:
                    break;
            }
            }
        });

    }

    public static void main(String[] args) {
        Pong pong = new Pong();

        Thread thread = new Thread(pong);
        thread.start();

    }

    public void run(){
        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            BallMove();
            AutoBoardMove();

            int Winner = GetBallCollideBoard();
            if (Winner == 1){
                B1Score ++;
            }
            if (Winner == 2){
                B2Score ++;
            }
            repaint();
        }
    }

    private void BallMove() {

        if(GetBallCollideWall()){
            BallSpeedX = -BallSpeedX;
        }
        BallCenterX += BallSpeedX;
        BallCenterY += BallSpeedY;
    }

    private void AutoBoardMove(){
//
//        if (GetBoard1CollideWall()){
//            B1SpeedX = 0 - B1SpeedX;
//        }
//        B1CenterX += B1SpeedX;
        if(GetBoard1CollideWall()){
            return;
        }
        if (B1CenterX > BallCenterX + B1SpeedX / 2) {
            B1CenterX -= B1SpeedX;
            return;
        }
        if (B1CenterX < BallCenterX - B1SpeedX / 2) {
            B1CenterX += B1SpeedX;
            return;
        }
    }

    private int GetBallCollideBoard(){
        if((BallCenterY - BallSizeY / 2) <= 80 - (BoardSizeY / 2)) {

            //right bound
            if ((BallCenterX - BallSizeX / 2) <= B1CenterX + BoardSizeX / 2) {
                //left bound
                if ((BallCenterX + BallSizeX / 2) >= B1CenterX - BoardSizeX / 2) {
                    return 1;
                }
            }
        }

        if((BallCenterY + BallSizeY / 2) >= 570 - (BoardSizeY / 2)) {

            //right bound
            if ((BallCenterX - BallSizeX / 2) <= B2CenterX + BoardSizeX / 2) {
                //left bound
                if ((BallCenterX + BallSizeX / 2) >= B2CenterX - BoardSizeX / 2) {
                    return 2;
                }
            }
        }

        return 0;
    }

    private boolean GetBallCollideWall(){
        if((BallCenterY - BallSizeY / 2) <= 80 - (BoardSizeY / 2)){
            BallSpeedY = 0 - BallSpeedY;
        }

        if((BallCenterY + BallSizeY / 2) >= 570 - (BoardSizeY / 2)){
            BallSpeedY = 0 - BallSpeedY;
        }
        if((BallCenterX - BallSizeX /2) <= 0){
            return true;
        }
        return (BallCenterX + BallSizeX / 2) >= 300;
    }

    private boolean GetBoard1CollideWall(){
        if((B1CenterX - BoardSizeX /2) <= 0){
            B1CenterX += 1;
            return true;
        }
        if((B1CenterX + BoardSizeX /2) >= 300){
            B1CenterX -= 1;
            return true;
        }
        return false;
    }

    private boolean GetBoard2CollideWall(){
        if((B2CenterX - BoardSizeX /2) <= 0){
            B2CenterX += 1;
            return true;
        }
        if((B2CenterX + BoardSizeX /2) >= 300){
            B2CenterX -= 1;
            return true;
        }
        return false;
    }

    public void paint(Graphics g) {
        //random background
        g.setColor(Color.black);

        // draw the graph
        super.paint(g);

        //fill background
        g.fillRect(0,0,300,610);

        //white obj
        g.setColor(Color.WHITE);

        //draw ball
        g.fillRect(BallCenterX - (BallSizeX / 2),BallCenterY - (BallSizeY / 2),BallSizeX,BallSizeY);

        //draw Board1
        g.fillRect(B1CenterX - (BoardSizeX / 2),50,BoardSizeX,BoardSizeY);

        //draw Board2
        g.fillRect(B2CenterX - (BoardSizeX / 2),600 - BoardSizeY * 2,BoardSizeX,BoardSizeY);

        //draw ScoreBoard1
        g.drawRect(10,30,20,20);

        //draw ScoreBoard2
        g.drawRect(10,580,20,20);

        //draw Score1
        g.drawString(""+B1Score,15,45);

        //draw Score2
        g.drawString(""+B2Score,15,595);

    }

}
