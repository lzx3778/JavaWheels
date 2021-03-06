package tutorials.Graphic;

import java.awt.Graphics;

import javax.swing.JFrame;

public class Wave extends JFrame implements Runnable {

	private int Time = 0;
	private int BlockAmount = 100;

	public Wave() {
		// TODO Auto-generated constructor stub
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(400, 200, 200, 100);
		setVisible(true);

		Thread thread = new Thread(this);
		thread.start();
	}

	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < BlockAmount; i++) {
			// (block position, block height(i:about white spaces
			g.drawRect(i * 2 + 10, ((int) (Math.sin((Time + i) / 10) * 100000)) / 5000 + 60, 0, 0);
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Time += 1;
			if (Time >= 360) {
				Time = 0;
			}
			System.out.println(Time);
			repaint();
		}
	}
}
