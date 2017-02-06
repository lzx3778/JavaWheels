package singlePrograms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * Created by lenovo on 2017-2-3.
 */
public class Jump extends JFrame{

    public Jump(){
        setBounds(100,100,800,400);
        setContentPane(new Graph());
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == 32) {
                    Graph.SetSpacePressed(true);
                }
            }
        });
    }

    public static void main(String[] args) {
        Jump jump = new Jump();
    }
}

class Graph extends JPanel implements Runnable{
    private static int score;

    private static boolean SpacePressed;

    private static int[][] positions;

    private static int BoardHeight;
    private static int BoardWidth;

    private static int CharacterSize;

    private static int PlayerY;
    private static int PlayerFallingSpeed;
    private static int PlayerJumpingSpeed;
    private static boolean PlayerOnLand;

    public static void SetSpacePressed(boolean SSP){
        SpacePressed = SSP;
    }

    public Graph(){
        score = 0;
        SpacePressed = false;

        positions = new int[5][2];
        positions = InitBlockPlaces(positions);

        BoardHeight = 20;
        BoardWidth = 200;

        CharacterSize = 20;

        PlayerY = GetClickBoxLevel(positions) - CharacterSize;
        PlayerFallingSpeed = 0;
        PlayerJumpingSpeed = 0;
        PlayerOnLand = true;

        Thread thread = new Thread(this);
        thread.start();
    }

    private static void Restart(){
        positions = InitBlockPlaces(positions);
        PlayerY = positions[0][1] - CharacterSize;
        score = 0;
    }
    private static int[][] InitBlockPlaces(int[][] positions){
        positions[0][0] = 0;
        positions[1][0] = 200;
        positions[2][0] = 400;
        positions[3][0] = 600;
        positions[4][0] = 800;

        positions[0][1] = 200;
        positions[1][1] = 300;
        positions[2][1] = 200;
        positions[3][1] = 100;
        positions[4][1] = 300;


        return positions;
    }

    //block generate algorithm
    private static int[][] SetBlockPlaces(int[][] positions){
        for (int i = 0;i < positions.length;i ++){
            positions[i][0] -= 3;
        }
        if (positions[0][0] <= -200){
            for (int i = 0;i < positions.length - 1;i ++){
                positions[i][0] = positions[i + 1][0];
                positions[i][1] = positions[i + 1][1];
            }
            positions[4][0] = 800;
            //to high
            if (positions[3][1] <= 100){
                Random random = new Random();
                positions[4][1] = positions[3][1] + 100  + 100 * (random.nextInt(100) % 2);
            }else if (positions[3][1] >= 300){
                //too low
                positions[4][1] = positions[3][1] - 100;
            }else {
                Random random = new Random();
                // 0/1 (a better way two randomly select one from two numbers)
                int UpOrDown = (random.nextInt(100) % 2);
                if (UpOrDown == 0) {
                    positions[4][1] = positions[3][1] + 100;
                }else{
                    positions[4][1] = positions[3][1] - 100;
                }
            }
        }
        return positions;
    }
    private static int GetClickBoxLevel(int[][] positions){
        int ClickBoxLevel = 0;

        for (int i = 0;i < positions.length;i ++){
            if (positions[i][0] >= 0){
                if (positions[i][0] < 200){
                    ClickBoxLevel = positions[i][1];
                    return ClickBoxLevel;
                }
            }
        }

        return ClickBoxLevel;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SetBlockPlaces(positions);
            int ClickBoxLevel = GetClickBoxLevel(positions);
            if (SpacePressed & PlayerOnLand){
                PlayerJumpingSpeed = 17;
                PlayerOnLand = false;
            }

            //jumping
            if (PlayerOnLand != true){
                PlayerY -= PlayerJumpingSpeed;
            }

            //acting with board
            if (PlayerY == ClickBoxLevel - CharacterSize){
                PlayerOnLand = true;
                PlayerJumpingSpeed = 0;
                PlayerFallingSpeed = 0;
                score = score + 1;
            }else if (PlayerY < ClickBoxLevel - CharacterSize){
                //in air & higher than board
                //using gravity acceleration
                PlayerFallingSpeed += 1;
                PlayerY += PlayerFallingSpeed;
                PlayerOnLand = false;
                if (PlayerY > ClickBoxLevel - CharacterSize){
                    PlayerY = ClickBoxLevel - CharacterSize;
                    PlayerOnLand = true;
                    PlayerJumpingSpeed = 0;
                    PlayerFallingSpeed = 0;
                }
            }else{
                //falling
                PlayerFallingSpeed += 1;
                PlayerY += PlayerFallingSpeed;
                PlayerOnLand = false;
            }

            //dead
            if (PlayerY >= 400){
                PlayerY = 400;
                PlayerFallingSpeed = 0;
                PlayerJumpingSpeed = 0;
                PlayerOnLand  = true;
                System.out.println("GameOver");
                break;
            }

            repaint();
            SpacePressed = false;

        }
    }

    public void paint(Graphics g){
        super.paint(g);
        for (int i = 0;i < positions.length;i ++){
            g.drawRect(positions[i][0],positions[i][1],BoardWidth - CharacterSize,BoardHeight);
        }
        g.setColor(Color.black);
        g.drawRect(200 - CharacterSize,PlayerY,CharacterSize,CharacterSize);
        g.drawRect(0,0,50,20);
        g.drawString(" "+ score,0,15);
    }
}