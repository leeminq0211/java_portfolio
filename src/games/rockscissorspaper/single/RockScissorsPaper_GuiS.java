package games.rockscissorspaper.single;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import portfolio.gameselect.Select;
class ChangeRsp extends Thread {
	RockScissorsPaper_GuiS gui;
	
	public ChangeRsp() {
		super();
	}
	public ChangeRsp(RockScissorsPaper_GuiS gui) {
		this.gui=gui;
	}
	@Override
	public void run() {
		ImageIcon[] a = new ImageIcon[3];
		a[0]=gui.rock;
		a[1]=gui.scissors;
		a[2]=gui.paper;
		
		while(!isInterrupted()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			gui.com.setIcon(a[(int)(Math.random()*3)]);
		}
		return;
	}
}

public class RockScissorsPaper_GuiS extends RockScissorsPaperS implements ActionListener {
	ChangeRsp random;
	JFrame frame;
	JLabel score, user, com, vs, checkLabel,scoreLabel,userLabel,comLabel;
	JButton rock_button, scissors_button, paper_button,exitButton;
	ImageIcon rock, scissors, paper, smallRock, smallScissors, smallPaper, userEmpty, comEmpty;
	List list;
	Panel finalPanel, userPanel, comPanel, panel4, buttonPanel,checkPanel,showPanel;
	String id;
	public static void main(String[] args) {
		new RockScissorsPaper_GuiS(null).createGui();
	}
	public RockScissorsPaper_GuiS(String id) {
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
		finalPanel.setBounds(0, 0, 900, 850);
		finalPanel.setLayout(null);
		finalPanel.add(score);
		finalPanel.add(showPanel);
		finalPanel.add(scoreLabel);
		finalPanel.add(buttonPanel);

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
		rock_button.addActionListener(this);
		scissors_button.setBorder(null);
		scissors_button.setContentAreaFilled(false);
		scissors_button.addActionListener(this);
		paper_button.setBorder(null);
		paper_button.setContentAreaFilled(false);
		paper_button.addActionListener(this);
		
		score.setFont(new Font(null, Font.BOLD, 60));
		
		
		exitButton.addActionListener(this);
		frame.setVisible(true);
		frame.setSize(900,850);
		frame.setLocationRelativeTo(null);
		random = new ChangeRsp(this);
		random.start();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int a = 0;
		if (e.getSource().equals(rock_button)) {
			random.interrupt();
			user.setIcon(rock);
			winner(1);
			
		} else if (e.getSource().equals(scissors_button)) {
			random.interrupt();
			user.setIcon(scissors);
			winner(2);
		} else if (e.getSource().equals(paper_button)) {
			random.interrupt();
			user.setIcon(paper);
			winner(3);
		}else if (e.getSource().equals(exitButton)) {
			Select select = new Select(id);
			select.startSelect();
			frame.dispose();
		}
		if (b == 1) {
			com.setIcon(rock);
		} else if (b == 2) {
			com.setIcon(scissors);
		} else {
			com.setIcon(paper);
		}
		scoreLabel.setText(s);
		score.setText(win + "승 " + loose + "패 " + draw + "무승부");
	}
}

class RockScissorsPaperS {
	int win = 0, draw = 0, loose = 0;
	String s = "대기중";
	int b;
	

	public RockScissorsPaperS() {
		super();
		
	}

	public void winner(int a) {
		b = (int) (Math.random() * 3 + 1);
		int c = 0;
		if ((a == 1 && b == 2) || (a == 2 && b == 3) || (a == 3 && b == 1)) {
			win++;
			s = "유저승";
		} else if (a == b) {
			draw++;
			s = "무승부";
		} else {
			loose++;
			s = "유저패";
		}
	}
}