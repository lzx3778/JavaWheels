package singlePrograms;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gravity extends JFrame {
	/**
	 */
	private static final long serialVersionUID = -1593319473258847596L;

	public Gravity() {
		// start set title
		this.setTitle("Gravity");
		// end set title
		Container c = this.getContentPane();
		c.add(new TetrisPanel());
		this.setBounds(400, 200, 300, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);

		this.addWindowListener(new WindowAdapter() {
			@SuppressWarnings("unused")
			public void WindowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}

class TetrisPanel extends JPanel implements Runnable, KeyListener {
	/**
	 * @author Michael 3778
	 */
	private static final long serialVersionUID = 1L;
	// variables
	public int ypos = -80, xpos = 90;
	public int speed = 0;
	public boolean down = true;

	// thread
	public TetrisPanel() {
		Thread t = new Thread(this);
		t.start();
		setFocusable(true);
		addKeyListener(this);
	}

	@Override
	public void run() {
		// start movement design
		while (true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (ypos > 400) {
				down = false;
			}
			if (speed == 0) {
				if (ypos >= 400) {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.exit(0);
				}
				down = true;
			}
			if (down) {
				speed += 1;
				ypos += speed;
			} else {
				speed -= 0.5;
				ypos -= speed;
			}

			repaint();
		}
		// end movement design
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.clearRect(0, 0, this.getWidth(), this.getHeight());

		// start object drawing
		g.setColor(Color.black);
		g.fillOval(xpos, ypos, 40, 40);
		// end object drawing
	}

	// move sidewards
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_LEFT:
			xpos -= 10;
			break;
		case KeyEvent.VK_RIGHT:
			xpos += 10;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}
}
