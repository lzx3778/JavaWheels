package tutorials.Graphic;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.event.MouseInputListener;

public class Test_MyCanvas implements KeyListener, MouseInputListener {
	Canvas c;// Canvas
	TextField tf;// show cautions
	String s; // store keys

	public Test_MyCanvas() {
		// init frame
		Frame frame = new Frame("Canvas");
		// init canvas
		Test_MyCanvas test_MyCanvas = new Test_MyCanvas();
		test_MyCanvas.c = new Canvas();
		test_MyCanvas.tf = new TextField();

		frame.add("South", test_MyCanvas.tf);
		frame.add("Center", test_MyCanvas.c);

		frame.setSize(300, 150);

		test_MyCanvas.c.addMouseListener(test_MyCanvas);
		test_MyCanvas.c.addKeyListener(test_MyCanvas);

		frame.setVisible(true);

	}

	// KeyPressed
	public void keyPressed(KeyEvent e) {

	}

	// keyReleased
	public void keyReleased(KeyEvent e) {
		tf.setText("keyReleased");
	}

	// answer keyboard event
	public void keyTyped(KeyEvent e) {
		tf.setText("keyTyped");
		s += e.getKeyChar();
		c.getGraphics().drawString(s, 0, 20);
	}

	// mouse click
	public void mouseClicked(java.awt.event.MouseEvent e) {
		tf.setText("mouseClicked");
		// canvas get focus
		c.requestFocus();
	}

	// ������
	public void mouseEntered(java.awt.event.MouseEvent e) {
		tf.setText("mouseEntered");
	}

	// ����˳�
	public void mouseExited(java.awt.event.MouseEvent e) {
		tf.setText("mouseExited");
	}

	// ��갴��
	public void mousePressed(java.awt.event.MouseEvent e) {
		tf.setText("mousePressed");
	}

	// ����ɿ�
	public void mouseReleased(java.awt.event.MouseEvent e) {
		tf.setText("mouseReleased");
	}

	public void mouseDragged(java.awt.event.MouseEvent e) {

	}

	public void mouseMoved(java.awt.event.MouseEvent e) {

	}

}