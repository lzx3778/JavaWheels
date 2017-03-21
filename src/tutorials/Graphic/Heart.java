package tutorials.Graphic;

import java.awt.*;

import javax.swing.*;

public class Heart {
	public Heart() {
		JFrame frame = new DrawFrame();
		frame.setTitle("DrawTest");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class DrawFrame extends JFrame {
	public DrawFrame() {
		DrawComponent D = new DrawComponent();
		add(D);
		pack();
	}
}

class DrawComponent extends JComponent {
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawLine(50, 200, 200, 400);
		g2.drawLine(200, 400, 350, 200);
		g2.drawArc(36, 60, 180, 180, 34, 180);
		g2.drawArc(185, 60, 180, 180, -34, 180);

	}

	public Dimension getPreferredSize() {
		return new Dimension(400, 400);
	}
}