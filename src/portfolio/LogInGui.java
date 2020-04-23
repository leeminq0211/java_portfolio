package portfolio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.omg.CORBA.Bounds;

public class LogInGui{
	JFrame loginFrame;JButton loginButton, signUpButton,exitButton; JTextField idField; JPasswordField passField;
	JPanel textPanel, buttonPanel, mainPanel,imagePanel;ImageIcon icon; JLabel label,imageLabel;
	JPanel backGroundPanel;
	JScrollPane backGroundScrollPane;
	ImageIcon backGroundIcon;
	JLabel backGroundLabel,mainJLabel;
	ImageIcon image;
	public LogInGui() {
		loginFrame = new JFrame("자바라자바게임");
		mainJLabel = new JLabel("");
		loginButton = new JButton("LOGIN");
		signUpButton = new JButton("SINGUP");
		exitButton = new JButton("X");
		textPanel = new JPanel();
		buttonPanel = new JPanel();
		mainPanel= new JPanel();
		idField = new JTextField();
		passField = new JPasswordField();
		backGroundPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(backGroundIcon.getImage(), 0, 0, null);
				backGroundPanel.setOpaque(false);
			}
		};
		backGroundPanel.setLayout(new FlowLayout());
		backGroundScrollPane = new JScrollPane();
		
//		backGroundIcon = new ImageIcon(Toolkit.getDefaultToolkit()
//				.getImage(
//						getClass().getClassLoader().getResource("background.png")));
		backGroundLabel = new JLabel(backGroundIcon);
		backGroundScrollPane = new JScrollPane(backGroundPanel);
		image =new ImageIcon(Toolkit.getDefaultToolkit()
				.getImage(
						getClass().getClassLoader().getResource("javajavara.png")));
		
	}
	void createGui() {
		TitledBorder tb = new TitledBorder(new LineBorder(Color.black));
		
		loginFrame.getContentPane().setBackground(Color.white);
		loginFrame.setLayout(null);
		
		loginFrame.add(backGroundScrollPane);
		
		mainJLabel.setOpaque(true); mainJLabel.setHorizontalAlignment(0); mainJLabel.setFont(new Font(null,Font.BOLD,60));
		mainJLabel.setBackground(new Color(200,0,100));
		mainJLabel.setForeground(Color.white);
		mainJLabel.setIcon(image);
		
		backGroundPanel.setBounds(0, 0, 500, 500);
		textPanel.setLayout(new GridLayout(2,0,100,20));
		textPanel.setBackground(Color.white);
		textPanel.add(idField);
		textPanel.add(passField);
		
		buttonPanel.setLayout(new GridLayout(0,2,20,100));
		buttonPanel.setBackground(Color.white);
		buttonPanel.add(loginButton);
		buttonPanel.add(signUpButton);
		buttonPanel.setBorder(tb);
		loginButton.setBackground(Color.WHITE);

		signUpButton.setBackground(Color.white);
		exitButton.setBackground(Color.white);
		loginButton.setForeground(Color.BLACK);
		signUpButton.setForeground(Color.BLACK);
		exitButton.setForeground(Color.white);
		
		mainPanel.setPreferredSize(new Dimension(300,150));
		mainPanel.setBackground(Color.white);
		mainPanel.setLayout(new BorderLayout(20,20));
		mainPanel.add(textPanel,BorderLayout.CENTER);
		mainPanel.add(buttonPanel,BorderLayout.SOUTH);
		
		exitButton.setBorder(null);
		exitButton.setContentAreaFilled(false);
		loginButton.setBorder(null);
		loginButton.setContentAreaFilled(false);
		signUpButton.setBorder(null);
		signUpButton.setContentAreaFilled(false);
		
		loginFrame.add(exitButton);
		exitButton.setBounds(450, 0, 50, 50);
		loginFrame.add(mainPanel);
		mainPanel.setBounds(100, 300, 300, 150);      
		loginFrame.add(mainJLabel);
		mainJLabel.setBounds(0, 0, 500, 250);
		
		
		loginFrame.setUndecorated(true);
		loginFrame.setSize(500,500);
		
		loginFrame.setLocationRelativeTo(null);
		loginFrame.setVisible(true);
		loginFrame.add(backGroundScrollPane);
		idField.requestFocus();
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
