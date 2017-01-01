package wheels.Graphic;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class arcs extends JFrame {
	public arcs() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 800);
	}

	public void paint(Graphics g) {
		for (int i = 0; i < 200; i++) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.setColor(new Color(255 - i, i, i));
			g.drawArc(10 + 2 * i, 30 + 2 * i, 100 + i, 100 + i, 0 + i, 100 + i);
		}
	}
}
