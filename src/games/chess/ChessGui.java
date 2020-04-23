package games.chess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ChessGui{
	public JFrame frame; JPanel jPanel,allTogether; public JButton[][] buttons;public JButton exitButton;
	JLabel jLabel;ImageIcon bp,bk,bn,bq,br,bb,wp,wk,wn,wq,wr,wb;
	///////////////chating
	public JTextArea chatArea; public JButton sendingButton; TextField writingField; JPanel botPanel,chatPanel;

	public ChessGui() {
		frame = new JFrame();
		jPanel = new JPanel();
		allTogether = new JPanel();
		buttons = new JButton[8][8];
		for(int i=0;i<buttons.length;i++) {
			for(int j=0;j<buttons[i].length;j++) {
				buttons[i][j]=new JButton();
			}
		}
		bp = new ImageIcon(Toolkit.getDefaultToolkit()
				.getImage(
						getClass().getClassLoader().getResource("bp.png")));
		bk = new ImageIcon(Toolkit.getDefaultToolkit()
				.getImage(
						getClass().getClassLoader().getResource("bk.png")));
		bn = new ImageIcon(Toolkit.getDefaultToolkit()
				.getImage(
						getClass().getClassLoader().getResource("bn.png")));
		bq = new ImageIcon(Toolkit.getDefaultToolkit()
				.getImage(
						getClass().getClassLoader().getResource("bq.png")));
		br = new ImageIcon(Toolkit.getDefaultToolkit()
				.getImage(
						getClass().getClassLoader().getResource("br.png")));
		bb = new ImageIcon(Toolkit.getDefaultToolkit()
				.getImage(
						getClass().getClassLoader().getResource("bb.png")));
		wp = new ImageIcon(Toolkit.getDefaultToolkit()
				.getImage(
						getClass().getClassLoader().getResource("wp.png")));
		wk = new ImageIcon(Toolkit.getDefaultToolkit()
				.getImage(
						getClass().getClassLoader().getResource("wk.png")));
		wn = new ImageIcon(Toolkit.getDefaultToolkit()
				.getImage(
						getClass().getClassLoader().getResource("wn.png")));
		wq = new ImageIcon(Toolkit.getDefaultToolkit()
				.getImage(
						getClass().getClassLoader().getResource("wq.png")));
		wr = new ImageIcon(Toolkit.getDefaultToolkit()
				.getImage(
						getClass().getClassLoader().getResource("wr.png")));
		wb = new ImageIcon(Toolkit.getDefaultToolkit()
				.getImage(
						getClass().getClassLoader().getResource("wb.png")));
		jLabel = new JLabel("레드팀"); 
		exitButton = new JButton("X");
		
		///////////////chating
		chatArea = new JTextArea();
		sendingButton = new JButton("시작");
		writingField = new TextField();
		botPanel = new JPanel();
		chatPanel  = new JPanel();
	}
	public void createGui() {
		frame.setLayout(null);
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(Color.white);
		frame.add(allTogether);
		frame.add(chatPanel);
		allTogether.setBounds(20, 20,900,980);
		frame.add(exitButton);
		exitButton.setBounds(1150, 0, 50, 50); //(1200,1020);
		exitButton.setBorder(null);
		exitButton.setContentAreaFilled(false);
		exitButton.setForeground(Color.BLACK);
		///////////chating
		
		chatPanel.setBounds(930, 500, 250, 500);
		botPanel.setLayout(new BorderLayout());
		botPanel.add(writingField,BorderLayout.CENTER);
		botPanel.add(sendingButton,BorderLayout.EAST);
		botPanel.setBackground(Color.WHITE);
		sendingButton.setBorder(null);
		sendingButton.setContentAreaFilled(false);
		chatPanel.setLayout(new BorderLayout());
		chatPanel.add(chatArea,BorderLayout.CENTER);
		chatPanel.add(botPanel,BorderLayout.SOUTH);
		chatArea.setBackground(Color.PINK);
		chatArea.setEditable(false);
		chatArea.append("???");
		chatArea.setLineWrap(true);
		chatArea.setAutoscrolls(true);
		/////////////////////
		allTogether.setLayout(new BorderLayout());
		allTogether.add(jLabel,BorderLayout.NORTH);
		allTogether.add(jPanel,BorderLayout.CENTER);
		jPanel.setLayout(new GridLayout(8,8));
		for(int i=0;i<buttons.length;i++) {
			for(int j=0;j<buttons[i].length;j++) {
				buttons[i][j].setFont(new Font(null, Font.BOLD, 0));
				jPanel.add(buttons[i][j]);
				if(j%2==0&&i%2==0) {
					buttons[i][j].setBackground(Color.black);
				}
				else if(j%2==1&&i%2==1) {
					buttons[i][j].setBackground(Color.black);
				}
				else {
					buttons[i][j].setBackground(Color.WHITE);
				}
				if(i==1) {
					buttons[i][j].setText("P");
				}
				if(i==6) {
					buttons[i][j].setText("p"); 
				}
				if(i==0&&(j==0||j==7)) {
					buttons[i][j].setText("R");
				}
				if(i==7&&(j==0||j==7)) {
					buttons[i][j].setText("r"); 
				}
				if(i==0&&(j==1||j==6)) {
					buttons[i][j].setText("N");
				}
				if(i==7&&(j==1||j==6)) {
					buttons[i][j].setText("n"); 
				}
				if(i==0&&(j==2||j==5)) {
					buttons[i][j].setText("B");
				}
				if(i==7&&(j==2||j==5)) {
					buttons[i][j].setText("b"); 
				}
				if(i==0&&(j==3)) {
					buttons[i][j].setText("K");
				}
				if(i==0&&(j==4)) {
					buttons[i][j].setText("Q");
				}
				if(i==7&&(j==3)) {
					buttons[i][j].setText("q") ; 
				}
				if(i==7&&(j==4)) {
					buttons[i][j].setText("k"); 
				}
			}
		}
		boardimage();
		jLabel.setHorizontalAlignment(0);
		jLabel.setPreferredSize(new Dimension(1000,80));
		jLabel.setFont(new Font(null, Font.BOLD, 50));
		jLabel.setOpaque(true);
		jLabel.setForeground(Color.white);
		jLabel.setBackground(Color.red);
		
		
		
		frame.setVisible(true);
		frame.setSize(1200,1020);
		frame.setLocationRelativeTo(null);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void boardCleaner() {
		for(int i=0;i<buttons.length;i++) {
			for(int j=0;j<buttons[i].length;j++) {
				
				if(j%2==0&&i%2==0) {
					buttons[i][j].setBackground(Color.black);
				}
				else if(j%2==1&&i%2==1) {
					buttons[i][j].setBackground(Color.black);
				}
				else {
					buttons[i][j].setBackground(Color.WHITE);
				}
			}
		}
	}
	public void boardimage() {
		for(int i=0;i<buttons.length;i++) {
			for(int j=0;j<buttons[i].length;j++) {
				if(buttons[i][j].getText().equals("p")) {  buttons[i][j].setIcon(bp); }
				else if(buttons[i][j].getText().equals("r")) {  buttons[i][j].setIcon(br); }
				else if(buttons[i][j].getText().equals("n")) {  buttons[i][j].setIcon(bn); }
				else if(buttons[i][j].getText().equals("q")) {  buttons[i][j].setIcon(bq); }
				else if(buttons[i][j].getText().equals("k")) {  buttons[i][j].setIcon(bk); }
				else if(buttons[i][j].getText().equals("b")) {  buttons[i][j].setIcon(bb); }
				else if(buttons[i][j].getText().equals("P")) {  buttons[i][j].setIcon(wp); }
				else if(buttons[i][j].getText().equals("R")) {  buttons[i][j].setIcon(wr); }
				else if(buttons[i][j].getText().equals("N")) {  buttons[i][j].setIcon(wn); }
				else if(buttons[i][j].getText().equals("Q")) {  buttons[i][j].setIcon(wq); }
				else if(buttons[i][j].getText().equals("K")) {  buttons[i][j].setIcon(wk); }
				else if(buttons[i][j].getText().equals("B")) {  buttons[i][j].setIcon(wb); }
			}
		}
	}
	public void disabler(int x) {
		for(int i=0;i<buttons.length;i++) {
			for(int j=0;j<buttons[i].length;j++) {
				if(buttons[i][j].getText().equals("")) {
					buttons[i][j].setEnabled(false);
				}
				if(x==0) {
					if(buttons[i][j].getText().equals("p")) {
						buttons[i][j].setDisabledIcon(bp);
						buttons[i][j].setEnabled(false);
					}
					else if(buttons[i][j].getText().equals("r")) {
						buttons[i][j].setDisabledIcon(br);
						buttons[i][j].setEnabled(false);
					}
					else if(buttons[i][j].getText().equals("b")) {
						buttons[i][j].setDisabledIcon(bb);
						buttons[i][j].setEnabled(false);
					}
					else if(buttons[i][j].getText().equals("n")) {
						buttons[i][j].setDisabledIcon(bn);
						buttons[i][j].setEnabled(false);
					}
					else if(buttons[i][j].getText().equals("k")) {
						buttons[i][j].setDisabledIcon(bk);
						buttons[i][j].setEnabled(false);
					}
					else if(buttons[i][j].getText().equals("q")) {
						buttons[i][j].setDisabledIcon(bq);
						buttons[i][j].setEnabled(false);
					}
				}
				else {
					if(buttons[i][j].getText().equals("P")) {
						buttons[i][j].setDisabledIcon(wp);
						buttons[i][j].setEnabled(false);
					}
					else if(buttons[i][j].getText().equals("R")) {
						buttons[i][j].setDisabledIcon(wr);
						buttons[i][j].setEnabled(false);
					}
					else if(buttons[i][j].getText().equals("B")) {
						buttons[i][j].setDisabledIcon(wb);
						buttons[i][j].setEnabled(false);
					}
					else if(buttons[i][j].getText().equals("N")) {
						buttons[i][j].setDisabledIcon(wn);
						buttons[i][j].setEnabled(false);
					}
					else if(buttons[i][j].getText().equals("K")) {
						buttons[i][j].setDisabledIcon(wk);
						buttons[i][j].setEnabled(false);
					}
					else if(buttons[i][j].getText().equals("Q")) {
						buttons[i][j].setDisabledIcon(wq);
						buttons[i][j].setEnabled(false);
					}
				}
			}
		}
	}
	public void enabler() {
		for(int i=0;i<buttons.length;i++) {
			for(int j=0;j<buttons[i].length;j++) {
					buttons[i][j].setEnabled(true);
			}
		}
	}
	public static void main(String[] args) {
		new ChessGui().createGui();
	}
}
