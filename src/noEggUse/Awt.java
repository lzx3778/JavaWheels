package noEggUse;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Awt extends JFrame{
	private boolean boo = true;
	public static void main(String[] args){
		Awt a = new Awt();
		a.setVisible(true);
	}
	public Awt(){
		setBounds(50, 50, 300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		final JPanel j = new JPanel();
		j.setLayout(null);
		j.setBackground(Color.GREEN);
		setContentPane(j);
		
		Button b = new Button();
		b.setBounds(50, 50, 100, 30);
		b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (boo){
					j.setBackground(Color.RED);
					boo = false;
				}else{
					j.setBackground(Color.GREEN);
					boo = true;
				}
			}
			
		});
		j.add(b);
	}
}
