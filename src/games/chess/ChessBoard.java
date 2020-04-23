package games.chess;

import java.util.Arrays;

public class ChessBoard {
	private String[][] chessBoard= new String[8][8];

	public ChessBoard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChessBoard(String[][] chessBoard) {
		super();
		this.chessBoard = chessBoard;
	}
	public String[][] getChessBoard() {
		return chessBoard;
	}
	public void setChessBoard(String[][] chessBoard) {
		this.chessBoard = chessBoard;
	}
	public void startBoard(){
		for(int i=0; i<chessBoard.length;i++) {
			for(int j=0;j<chessBoard[i].length;j++) {
				if(j%2==0) {
					chessBoard[i][j] = "";
				}
				else {
					chessBoard[i][j] = "";
				}
				if(i==1) {
					chessBoard[i][j] = "P";
				}
				if(i==6) {
					chessBoard[i][j] = "p";
				}
				if(i==0&&(j==0||j==7)) {
					chessBoard[i][j] = "R";
				}
				if(i==7&&(j==0||j==7)) {
					chessBoard[i][j] = "r";
				}
				if(i==0&&(j==1||j==6)) {
					chessBoard[i][j] = "N";
				}
				if(i==7&&(j==1||j==6)) {
					chessBoard[i][j] = "n";
				}
				if(i==0&&(j==2||j==5)) {
					chessBoard[i][j] = "B";
				}
				if(i==7&&(j==2||j==5)) {
					chessBoard[i][j] = "b";
				}
				if(i==0&&(j==3)) {
					chessBoard[i][j] = "K";
				}
				if(i==0&&(j==4)) {
					chessBoard[i][j] = "Q";
				}
				if(i==7&&(j==3)) {
					chessBoard[i][j] = "q";
				}
				if(i==7&&(j==4)) {
					chessBoard[i][j] = "k";
				}
			}
		}
	}
	public void showBoard(){
		System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7 \n");
		for(int i=0; i<8;i++) {
			for(int j=0;j<8;j++) {
				if(j==0) {
					System.out.print(i+"\t");
				}
				System.out.print(chessBoard[i][j]+"\t");
			}
			System.out.println();
		}
	}
	public void boardSet(String s, int i, int j) {
		chessBoard[i][j]=s;
	}
	@Override
	public String toString() {
		return "ChessBoard [chessBoard=" + Arrays.toString(chessBoard) + "]";
	}
	
	
}
