package noEggUse;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Label;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class Factor extends JFrame {

	private JPanel contentPane;
	private static Factor frame;
	private TextArea textArea;
	/**
	 * Create the frame.
	 */
	public Factor() {
		setVisible(true);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(20, 20, 331, 204);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(184, 134, 11));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final TextField textField = new TextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 26));
		textField.setBackground(new Color(224, 255, 255));
		textField.setBounds(10, 59, 233, 31);
		contentPane.add(textField);
		
		Button ok = new Button("\u786E\u8BA4");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pattern p = Pattern.compile("[0-9]*");
				if (p.matcher(textField.getText()).matches()){
					//set number here
					int a = Integer.parseInt(textField.getText());
					int count = 0;
					for (int i = 1;i < a;i++){
						if (a % i == 0){
							String l = String.valueOf(i)+",";
							textArea.append(l);
							String z = String.valueOf(a/i)+"\n";
							textArea.append(z);
						}
					}
				}else{
					textArea.setText("请输入正整数！！！");
				}
			}
		});
		ok.setBackground(new Color(107, 142, 35));
		ok.setBounds(249, 67, 76, 23);
		contentPane.add(ok);
		
		Label label = new Label("\u5BFB\u627E\u516C\u56E0\u6570");
		label.setForeground(new Color(0, 191, 255));
		label.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 22));
		label.setBounds(10, 10, 221, 43);
		contentPane.add(label);
		
		textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Dialog", Font.PLAIN, 25));
		textArea.setBackground(new Color(240, 248, 255));
		textArea.setBounds(10, 96, 233, 95);
		contentPane.add(textArea);
		
		Button Exit = new Button("X");
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		Exit.setBackground(new Color(255, 0, 0));
		Exit.setBounds(297, 10, 28, 23);
		contentPane.add(Exit);
		
		Button mini = new Button("\u2014");
		mini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setExtendedState(JFrame.ICONIFIED);
			}
		});
		mini.setBackground(new Color(30, 144, 255));
		mini.setBounds(263, 10, 28, 23);
		contentPane.add(mini);
		
		Button clear = new Button("\u6E05\u7A7A");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				textArea.setText("");
			}
		});
		clear.setBackground(new Color(255, 140, 0));
		clear.setBounds(249, 96, 76, 23);
		contentPane.add(clear);
		
		Button about = new Button("?");
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "该程序由Michael3778开发","致使用者", 3, null);
			}
		});
		about.setBackground(new Color(135, 206, 250));
		about.setFont(new Font("Dialog", Font.PLAIN, 45));
		about.setBounds(249, 125, 76, 66);
		contentPane.add(about);
	}
}
