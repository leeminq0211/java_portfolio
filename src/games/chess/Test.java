package games.chess;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

class Test1{
	JFrame frame; JButton button; ImageIcon icon;
	public Test1() {
		frame = new JFrame();
		
		icon = new ImageIcon("images\\pb.png");
		button = new JButton(icon);
	}
	public void createGui() {
		frame.add(button);
		frame.setSize(100, 100);
		button.setEnabled(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

public class Test {
	public static void main(String[] args) {
		new Test1().createGui();
	}
}
