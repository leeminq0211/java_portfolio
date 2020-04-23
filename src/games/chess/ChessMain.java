package games.chess;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import portfolio.gameselect.Select;

public class ChessMain implements ActionListener {
	private String[][] chessB;
	Color s = null;
	ChessGui gui;
	int cnt = 0, selectedI = 0, selectedj = 0;
	ChessMan man = new ChessMan();
	ChessBoard board = new ChessBoard();
	JLabel jLabel;
	Server_Create chat;
	String id;
	public ChessMain() {
		super();
		chessB = new String[8][8];
		gui = new ChessGui();
		board.startBoard();
		board.showBoard();
//		chat = new Server_Create(gui);
	}
	public ChessMain(String id) {
		this.id=id;
		chessB = new String[8][8];
		gui = new ChessGui();
		board.startBoard();
		board.showBoard();
//		chat = new Server_Create(gui);
	}
	public String[][] getChessB() {
		return chessB;
	}
	public void setChessB(String[][] chessB) {
		this.chessB = chessB;
	}
	public ChessGui readyChess() {
		gui.createGui();
		for (int i = 0; i < gui.buttons.length; i++) {
			for (int j = 0; j < gui.buttons[i].length; j++) {
				gui.buttons[i][j].addActionListener(this);
			}
		}
		gui.exitButton.addActionListener(this);
		gui.disabler(0);
//		chat.server_Start();
		return gui;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(gui.exitButton)) {
//			chat.exitChat();
//			gui.frame.dispose();
//			new Select(id).startSelect();
		}
		else {
			for (int i = 0; i < gui.buttons.length; i++) {
				for (int j = 0; j < gui.buttons[i].length; j++) {
					if (e.getSource().equals(gui.buttons[i][j])) {
						if (cnt == 0) {
							s = gui.buttons[i][j].getBackground();
							if(ChessMan.player%2==0) { gui.buttons[i][j].setBackground(Color.green); }else {gui.buttons[i][j].setBackground(Color.pink);} 
							selectedI = i;
							selectedj = j;
							cnt = 1;
							gui.enabler();
						} else if (cnt == 1) {
							cnt = 0;
							String move = selectedI + "," + selectedj + "," + i + "," + j;
							System.out.println(move);
							gui.boardCleaner();
							if (ChessMan.player % 2 == 0) {
								switch (gui.buttons[selectedI][selectedj].getText()) {
								case "P":
									System.out.println("P");
									if(man.pawn(board.getChessBoard(), move)) {
										setting(i,j);
										if(i==7) { pawnChange(JOptionPane.showInputDialog(jLabel, "1.ROOK 2.BISHOP 3.KNIGHT 4.QUEEN"),i,j); }
									}
									break;
								case "R":
									if(man.rook(board.getChessBoard(), move)) {
										setting(i,j);
									}
									break;
								case "B":
									System.out.println("B");
									if(man.bishop(board.getChessBoard(), move)) {
										setting(i,j);
									}
									break;
								case "N":
									System.out.println("N");
									if(man.knight(board.getChessBoard(), move)) {
										setting(i,j);
									}
									break;
								case "K":
									System.out.println("K");
									if(man.king(board.getChessBoard(), move)) {
										setting(i,j);
									}
									break;
								case "Q":
									System.out.println("Q");
									if(man.queen(board.getChessBoard(), move)) {
										setting(i,j);
									}
									break;
								default:
									System.out.println("다시선택해주세요");
									break;
								}
							} else {
								
								switch (gui.buttons[selectedI][selectedj].getText()) {
								case "p":
									if(man.pawn(board.getChessBoard(), move)) {
										setting(i,j);
										if(i==0) { pawnChange(JOptionPane.showInputDialog(jLabel, "1.ROOK 2.BISHOP 3.KNIGHT 4.QUEEN"),i,j); }
									}
									break;
								case "r":
									if(man.rook(board.getChessBoard(), move)) {
										setting(i,j);
									}
									break;
								case "b":
									if(man.bishop(board.getChessBoard(), move)) {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
										setting(i,j);
									}
									break;
								case "n":
									if(man.knight(board.getChessBoard(), move)) {
										setting(i,j);
									}
									break;
								case "k":
									if(man.king(board.getChessBoard(), move)) {
										setting(i,j);
									}
									break;
								case "q":
									if(man.queen(board.getChessBoard(), move)) {
										setting(i,j);
									}
									break;
								default:
									System.out.println("다시선택해주세요");
									break;
								}
							}
							gui.disabler(ChessMan.player%2);
						}
					}
				}
			}
			if(ChessMan.player%2==0) {
				gui.jLabel.setText("레드팀"); 
				gui.jLabel.setBackground(Color.red);
			}
			else {
				gui.jLabel.setText("블루팀"); 
				gui.jLabel.setBackground(Color.blue);
			}
			if(!(Arrays.deepToString(board.getChessBoard()).contains("k"))){
				JOptionPane.showMessageDialog(gui.frame, "레드팀승");
				gui.jLabel.setText("레드팀승"); 
				for (int i = 0; i < gui.buttons.length; i++) {
					for (int j = 0; j < gui.buttons[i].length; j++) {
						gui.buttons[i][j].setEnabled(false);
					}
				}
				for(;;) {
					try {
						Thread.sleep(1000);
						if(gui.jLabel.getBackground().equals(Color.blue)) {
							gui.jLabel.setBackground(Color.red);
						}
						else {
							gui.jLabel.setBackground(Color.blue);
						}
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}else if(!(Arrays.deepToString(board.getChessBoard()).contains("K"))){
				
				gui.jLabel.setText("블루팀승"); 
				gui.jLabel.setBackground(Color.blue);
				for (int i = 0; i < gui.buttons.length; i++) {
					for (int j = 0; j < gui.buttons[i].length; j++) {
						gui.buttons[i][j].setEnabled(false);
					}
				}
				for(;;) {
					try {
						Thread.sleep(1000);
						if(gui.jLabel.getBackground().equals(Color.blue)) {
							gui.jLabel.setBackground(Color.red);
						}
						else {
							gui.jLabel.setBackground(Color.blue);
						}
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
//			if(man.check(board.getChessBoard())) {
//				JOptionPane.showMessageDialog(gui.frame, "체크");
//			}
//			gui.disabler(ChessMan.player % 2);
		}
	}
		

	private void pawnChange(Object s2,int i,int j) {
		if(s2.equals("1")) {
			if(gui.buttons[i][j].getText().equals("P")) { gui.buttons[i][j].setText("R");gui.buttons[i][j].setIcon(gui.wr); }
			else { gui.buttons[i][j].setText("r"); gui.buttons[i][j].setIcon(gui.br); }
		}
		else if(s2.equals("2")) {
			if(gui.buttons[i][j].getText().equals("P")) { gui.buttons[i][j].setText("B"); board.boardSet("B",i,j); gui.buttons[i][j].setIcon(gui.wb); }
			else { gui.buttons[i][j].setText("b"); board.boardSet("b",i,j);  gui.buttons[i][j].setIcon(gui.bb); }
		}
		else if(s2.equals("3")) {
			if(gui.buttons[i][j].getText().equals("P")) { gui.buttons[i][j].setText("N"); board.boardSet("N",i,j);  gui.buttons[i][j].setIcon(gui.wn); }
			else { gui.buttons[i][j].setText("n"); board.boardSet("n",i,j);  gui.buttons[i][j].setIcon(gui.bn); }
		}
		else {
			if(gui.buttons[i][j].getText().equals("P")) { gui.buttons[i][j].setText("Q"); board.boardSet("Q",i,j);  gui.buttons[i][j].setIcon(gui.wq); }
			else { gui.buttons[i][j].setText("q"); board.boardSet("q",i,j);  gui.buttons[i][j].setIcon(gui.bq); }
		}
	}

	private void setting(int i,int j) {
		gui.buttons[i][j].setText(gui.buttons[selectedI][selectedj].getText());
		gui.buttons[selectedI][selectedj].setText("");
		gui.buttons[i][j].setIcon(gui.buttons[selectedI][selectedj].getIcon());
		gui.buttons[selectedI][selectedj].setIcon(null);
	}
	public static void main(String[] args) {
		new ChessMain(null).readyChess();
	}
	public void exitButton() {
		gui.exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.frame.dispose();
				new Select(id).startSelect();
			}
		});
	}
}

