package graph;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game_struct extends JFrame{

	static JP jp = new JP();
	public Game_struct(){
		setBounds(100,100,600,600);
		setContentPane(jp);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
class JP extends JPanel implements Runnable{
	public JP(){
		Thread thread = new Thread(this);
		thread.start();
		setFocusable(true);
	}
	@Override
	public void run() {
		while(true){
			repaint();
		}
	}
	public void paint(Graphics g){
		super.paint(g);
	}
}