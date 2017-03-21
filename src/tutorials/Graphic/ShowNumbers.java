package tutorials.Graphic;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class ShowNumbers extends JFrame {
	private int number[] = { 100, 30, 50, 20, 70, 10, 150, 120, 200, 5, 73, 123, 210 };

	public int Normal(int i) {
		return 230 - i;
	}

	public ShowNumbers() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
	}

	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 275, 440, 2);
		g.fillRect(20, 0, 2, 300);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < number.length; i++) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.setColor(new Color(0, i * 10, i * 20));
			for (int j = 0; j < number[i]; j++) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (j < 255) {
					g.setColor(new Color(255 - j, j, j));
				}
				g.drawLine(30 + (i * 30), 274 - j, 50 + (i * 30), 274 - j);
			}
		}
	}

}