package portfolio.gameselect;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SelectGui{
	JFrame frame; JButton[] button;JLabel jLabel,jLabel2,jlabelUser;JButton exitButton,calButton;
	JPanel jPanel,jPanel2,buttonPanel1,buttonPanel2,fullPanel,framePanel; 
	ImageIcon[] icon;
	public SelectGui() {
		frame = new JFrame();
		framePanel = new JPanel(); fullPanel = new JPanel(); jPanel = new JPanel(); jPanel2 = new JPanel(); buttonPanel1 = new JPanel(); buttonPanel2 = new JPanel();
		jLabel = new JLabel("MULTI-GAMES");
		jLabel2 = new JLabel("SINGLE-GAMES");
		exitButton = new JButton("X");
		button = new JButton[4];
		for(int i=0;i<button.length;i++) {
			button[i] = new JButton("");
		}
		calButton = new JButton("나의 기록보기");
		jlabelUser=new JLabel("");
		icon = new ImageIcon[4];
		for(int i=0;i<button.length;i++) {
			icon[i] =new ImageIcon(Toolkit.getDefaultToolkit()
					.getImage(
							getClass().getClassLoader().getResource("icon"+(i+1)+".png")));
		}
	}
	public void createGui() {
		frame.setUndecorated(true); 
		frame.setVisible(true);
		frame.setLayout(null);
		frame.add(exitButton);
		frame.getContentPane().setBackground(Color.white);
		exitButton.setBounds(570, 0, 50, 50);
		frame.add(jlabelUser);
		jlabelUser.setBounds(350, 0, 200,50);
		exitButton.setBorder(null);
		exitButton.setContentAreaFilled(false);
		exitButton.setForeground(Color.black);
		
		frame.add(framePanel);
		framePanel.setBounds(0, 0, 620, 770);
		for(int i=0;i<button.length;i++) {
			button[i].setBorder(null);
			button[i].setContentAreaFilled(false);
			button[i].setBackground(Color.white);
			button[i].setForeground(Color.black);
			button[i].setVerticalAlignment(SwingConstants.BOTTOM);
			button[i].setIcon(icon[i]);
		}

		framePanel.setLayout(new BorderLayout(0,0));
		framePanel.add(fullPanel,BorderLayout.CENTER);
		framePanel.add(calButton,BorderLayout.SOUTH);
		framePanel.setBackground(Color.white);
		calButton.setPreferredSize(new Dimension(50, 50));
		calButton.setBorder(null);
		calButton.setContentAreaFilled(false);
		calButton.setForeground(Color.black);
		fullPanel.setLayout(new GridLayout(2,0));
		fullPanel.add(jPanel); fullPanel.add(jPanel2);
		
		jLabel.setPreferredSize(new Dimension(620, 50));
		jLabel.setOpaque(true);
		jLabel.setBackground(Color.pink);
		jLabel.setForeground(Color.white);
		jLabel.setFont(new Font(null, Font.BOLD, 30));
		jLabel2.setPreferredSize(new Dimension(620, 50));
		jLabel2.setOpaque(true);
		jLabel2.setBackground(Color.pink);
		jLabel2.setForeground(Color.white);
		jLabel2.setFont(new Font(null, Font.BOLD, 30));
		
		
		jPanel.setLayout(new FlowLayout());
		jPanel.setBackground(Color.white);
		jPanel.add(jLabel);
		buttonPanel1.setLayout(new GridLayout(0,2, 7,0));
		buttonPanel1.add(button[0]); buttonPanel1.add(button[1]);
		jPanel.add(buttonPanel1);
		
		jPanel2.setLayout(new FlowLayout());
		jPanel2.setBackground(Color.white);
		jPanel2.add(jLabel2);
		buttonPanel2.setLayout(new GridLayout(0,2,7,0));
		buttonPanel2.add(button[2]); buttonPanel2.add(button[3]);
		jPanel2.add(buttonPanel2);
		
		frame.setSize(620, 770);frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Point middle = new Point(screenSize.width / 2, screenSize.height / 2);
		Point newLocation = new Point(middle.x - (frame.getWidth() / 2), 
		                              middle.y - (frame.getHeight() / 2)-10);
		frame.setLocation(newLocation);
	}
	public static void main(String[] args) {
		new SelectGui().createGui();
	}
}
