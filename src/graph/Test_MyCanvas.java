package graph;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.event.MouseInputListener;

public class Test_MyCanvas implements KeyListener, MouseInputListener {
Canvas c;// 画布
TextField tf;// 用于显示提示信息的文本框
String s; // 用于存放按键信息的字符串


public static void main(String[] args) {
// 初始化帧
Frame frame = new Frame("Canvas");
// 初始化画布
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


// 按键按下
public void keyPressed(KeyEvent e) {


}


// 按键抬起
public void keyReleased(KeyEvent e) {
tf.setText("keyReleased");
}


// 响应键盘事件
public void keyTyped(KeyEvent e) {
tf.setText("keyTyped");
s += e.getKeyChar();
c.getGraphics().drawString(s, 0, 20);
}


// 鼠标点击
public void mouseClicked(java.awt.event.MouseEvent e) {
tf.setText("mouseClicked");
// 画布取得焦点
c.requestFocus();
}


// 鼠标进入
public void mouseEntered(java.awt.event.MouseEvent e) {
tf.setText("mouseEntered");
}


// 鼠标退出
public void mouseExited(java.awt.event.MouseEvent e) {
tf.setText("mouseExited");
}


// 鼠标按下
public void mousePressed(java.awt.event.MouseEvent e) {
tf.setText("mousePressed");
}


// 鼠标松开
public void mouseReleased(java.awt.event.MouseEvent e) {
tf.setText("mouseReleased");
}


public void mouseDragged(java.awt.event.MouseEvent e) {


}


public void mouseMoved(java.awt.event.MouseEvent e) {


}


}