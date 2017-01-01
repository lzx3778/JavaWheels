package wheels.Graphic;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Draw extends JFrame {
	public Draw() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 700, 700);
	}

	public void paint(Graphics g) {
		// draw the graph
		for (int i = 0; i < 200; i++) {
			for (int j = 0; j < 100; j++) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				g.setColor(new Color(i, i, j));
				g.fill3DRect(2 * j, 2 * i, 2 * i, 2 * j, true);
			}
		}
	}
}