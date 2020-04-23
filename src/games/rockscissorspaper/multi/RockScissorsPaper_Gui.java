package games.rockscissorspaper.multi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import portfolio.gameselect.Select;

public class RockScissorsPaper_Gui extends RockScissorsPaper {
	JFrame frame;
	JLabel score, user, com, vs, checkLabel,scoreLabel,userLabel,comLabel;
	JButton rock_button, scissors_button, paper_button,exitButton;
	JToggleButton readyButton;
	ImageIcon rock, scissors, paper, smallRock, smallScissors, smallPaper, userEmpty, comEmpty;
	List list;
	Panel finalPanel, userPanel, comPanel, panel4, buttonPanel,checkPanel,showPanel;
	String id;
	///////////////chating
	TextArea chatArea; JPanel botPanel,chatPanel;
	
	public static void main(String[] args) {
		new RockScissorsPaper_Gui(null).createGui();
	}
	public RockScissorsPaper_Gui(String id) {
		this.id = id;
		frame = new JFrame("COMPONENTS");
		exitButton = new JButton("X");
		smallRock = new ImageIcon(Toolkit.getDefaultToolkit()
				.getImage(
						getClass().getClassLoader().getResource("small_Rock.png")));
		smallScissors = new ImageIcon(Toolkit.getDefaultToolkit()
				.getImage(
						getClass().getClassLoader().getResource("small_Scissors.png")));
		smallPaper = new ImageIcon(Toolkit.getDefaultToolkit()
				.getImage(
						getClass().getClassLoader().getResource("small_Paper.png")));
//		userEmpty = new ImageIcon(Toolkit.getDefaultToolkit()
//				.getImage(
//						getClass().getClassLoader().getResource("USERS_EMPTY.png")));
//		comEmpty = new ImageIcon(Toolkit.getDefaultToolkit()
//				.getImage(
//						getClass().getClassLoader().getResource("COMPUTERS_EMPTY.png")));
		rock = new ImageIcon(Toolkit.getDefaultToolkit()
				.getImage(
						getClass().getClassLoader().getResource("Rock.png")));
		scissors = new ImageIcon(Toolkit.getDefaultToolkit()
				.getImage(
						getClass().getClassLoader().getResource("Scissors.png")));
		paper = new ImageIcon(Toolkit.getDefaultToolkit()
				.getImage(
						getClass().getClassLoader().getResource("Paper.png")));
		rock_button = new JButton(smallRock);
		scissors_button = new JButton(smallScissors);
		paper_button = new JButton(smallPaper);
		readyButton = new JToggleButton("준비완료");
		score = new JLabel(win + "승 " + loose + "패 " + draw + "무승부");
		finalPanel = new Panel();
		showPanel = new Panel();
		userPanel = new Panel();
		comPanel = new Panel();
		scoreLabel = new JLabel(s);
		user = new JLabel(rock);
		com = new JLabel(rock);
		userLabel = new JLabel("USER");
		comLabel = new JLabel("COM");
		vs = new JLabel("VS");
		buttonPanel = new Panel();
		panel4 = new Panel();
		checkPanel = new Panel();
		
		chatArea = new TextArea();
		botPanel = new JPanel();
		chatPanel  = new JPanel();
	}

	public void createGui() {
		frame.setLayout(null);
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(Color.white);
		frame.add(exitButton);
		exitButton.setBounds(850, 0, 50, 50); //(1200,1020);
		exitButton.setBorder(null);
		exitButton.setContentAreaFilled(false);
		exitButton.setForeground(Color.BLACK);
		frame.add(finalPanel);
		finalPanel.setBounds(0, 0, 900, 950);
		finalPanel.setLayout(null);
		finalPanel.add(chatArea);
		finalPanel.add(score);
		finalPanel.add(showPanel);
		finalPanel.add(scoreLabel);
		finalPanel.add(buttonPanel);
		finalPanel.add(readyButton);
		
		
		score.setBounds(0, 0, 900, 100);
		score.setHorizontalAlignment(0);
		score.setVerticalAlignment(0);
		score.setOpaque(true);
		score.setBackground(new Color(244, 201, 177));
		score.setForeground(Color.white);
		
		showPanel.setBounds(0, 100, 900, 450); //400
		showPanel.setLayout(new FlowLayout(0,32,0));
		showPanel.add(userPanel);
		
		userPanel.setLayout(new BorderLayout(0,10));
		userPanel.add(userLabel,BorderLayout.NORTH);
		userLabel.setHorizontalAlignment(0);
		userLabel.setVerticalAlignment(0);
		userLabel.setFont(new Font(null, Font.BOLD, 20));
		userPanel.add(user,BorderLayout.SOUTH);
		
		showPanel.add(vs);
		vs.setFont(new Font(null, Font.BOLD, 40));
		vs.setHorizontalAlignment(0);
		vs.setVerticalAlignment(0);
		
		showPanel.add(comPanel);
		
		comPanel.setLayout(new BorderLayout(0,10));
		comPanel.add(comLabel,BorderLayout.NORTH);
		comLabel.setHorizontalAlignment(0);
		comLabel.setVerticalAlignment(0);
		comLabel.setFont(new Font(null, Font.BOLD, 30));
		comPanel.add(com,BorderLayout.SOUTH);
		
		scoreLabel.setBounds(0, 550, 900, 100);
		scoreLabel.setFont(new Font(null, Font.BOLD, 40));
		scoreLabel.setHorizontalAlignment(0);
		scoreLabel.setVerticalAlignment(0);
		
		buttonPanel.setBounds(0, 650, 900, 200); //200
		buttonPanel.setLayout(new GridLayout(0,3,10,10));
		buttonPanel.add(rock_button);
		buttonPanel.add(scissors_button);
		buttonPanel.add(paper_button);
		
		rock_button.setBorder(null);
		rock_button.setContentAreaFilled(false);
		scissors_button.setBorder(null);
		scissors_button.setContentAreaFilled(false);
		paper_button.setBorder(null);
		paper_button.setContentAreaFilled(false);
		
		readyButton.setBounds(0, 850, 900, 100); //200
		readyButton.setHorizontalAlignment(0);
		readyButton.setVerticalAlignment(0);
		readyButton.setBackground(new Color(247, 202, 201));
		readyButton.setFont(new Font(null, Font.BOLD, 60));
		readyButton.setBorder(null);
		
		score.setFont(new Font(null, Font.BOLD, 60));
		
		chatArea.setBounds(650, 540, 220, 100);
		chatArea.setBackground(Color.PINK);
		chatArea.setEditable(false);
//		chatArea.setLineWrap(true);
//		chatArea.setAutoscrolls(true);

		frame.setVisible(true);
		frame.setSize(900,950);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}