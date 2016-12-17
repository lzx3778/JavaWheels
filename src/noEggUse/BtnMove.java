package noEggUse;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionEvent;

public class BtnMove extends JFrame {

	private JPanel contentPane;
	private Button button = new Button("A");
	private boolean b = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BtnMove frame = new BtnMove();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void s(int i){
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public BtnMove() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		button = new Button("A");
		button.setBounds(63, 78, 50, 50);
		button.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton()==e.BUTTON1){
					M m = new M();
					contentPane.addMouseMotionListener(m);
				}else
				if (e.getButton()==e.BUTTON3){
					M m = new M();
					contentPane.removeMouseMotionListener(m);
					System.out.println("lol");
				}
			}
			public void mouseEntered(MouseEvent arg0) {
			}
			public void mouseExited(MouseEvent arg0) {
			}
			public void mousePressed(MouseEvent arg0) {
			}
			public void mouseReleased(MouseEvent arg0) {
			}
		});
		contentPane.add(button);
	}
	class M implements MouseMotionListener{
		public void mouseDragged(MouseEvent arg0) {
		}
		public void mouseMoved(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			button.setLocation(x-25, y-25);
			repaint();
			
			if(b){
				b = false;
			}else{
				b = true;
			}
		}
	}
}
