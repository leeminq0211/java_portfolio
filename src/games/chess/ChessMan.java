package games.chess;

import java.util.Arrays;

public class ChessMan {
	private String[] pawn = new String[8];
	private String[] rook = new String[2];
	private String[] bishop = new String[2];
	private String[] knight = new String[2];
	private String queen;
	private String king;
	static int player = 0;

//	public ChessMan() {
//		super();
//	}

	public ChessMan(String[] pawn, String[] rook, String[] bishop, String[] knight, String queen, String king) {
		super();
		this.pawn = pawn;
		this.rook = rook;
		this.bishop = bishop;
		this.knight = knight;
		this.queen = queen;
		this.king = king;
	}

	public ChessMan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String[] getPawn() {
		return pawn;
	}

	public void setPawn(String[] pawn) {
		this.pawn = pawn;
	}

	public String[] getRook() {
		return rook;
	}

	public void setRook(String[] rook) {
		this.rook = rook;
	}

	public String[] getBishop() {
		return bishop;
	}

	public void setBishop(String[] bishop) {
		this.bishop = bishop;
	}

	public String[] getKnight() {
		return knight;
	}

	public void setKnight(String[] knight) {
		this.knight = knight;
	}

	public String getQueen() {
		return queen;
	}

	public void setQueen(String queen) {
		this.queen = queen;
	}

	public String getKing() {
		return king;
	}

	public void setKing(String king) {
		this.king = king;
	}

	@Override
	public String toString() {
		return "ChessMan [pawn=" + Arrays.toString(pawn) + ", rook=" + Arrays.toString(rook) + ", bishop="
				+ Arrays.toString(bishop) + ", knight=" + Arrays.toString(knight) + ", queen=" + queen + ", king="
				+ king + "]";
	}

	public boolean pawn(String[][] chessBoard, String s) {
		int i = Character.digit(s.charAt(0), 10);
		int j = Character.digit(s.charAt(2), 10);
		int mi = Character.digit(s.charAt(4), 10);
		int mj = Character.digit(s.charAt(6), 10);
		if (chessBoard[i][j].equals("P")) {
			if (i - mi == -1 && j - mj == 0) {
				System.out.println("@1");
				if (chessBoard[mi][mj].equals("")) {
					System.out.println("@2");
					fix(chessBoard, s);
					return true;
				}
			} else if (i == 1 && i - mi == -2 && j - mj == 0) {
				System.out.println("@3");
				fix(chessBoard, s);
				return true;
			} else if (j - mj == -1 || j - mj == 1 && (i - mi == -1)) {
				System.out.println("@4");
				if (chessBoard[mi][mj].equals("p") || chessBoard[mi][mj].equals("r") || chessBoard[mi][mj].equals("n")
						|| chessBoard[mi][mj].equals("b") || chessBoard[mi][mj].equals("q")
						|| chessBoard[mi][mj].equals("k")) {
					fix(chessBoard, s);
					return true;
				}
			}
		} else {
			if (i - mi == 1 && j - mj == 0) {
				if (chessBoard[mi][mj].equals("")) {
					fix(chessBoard, s);
					return true;
				}
			} else if (i == 6 && i - mi == 2&& j - mj == 0) {
				fix(chessBoard, s);
				return true;
			} else if (j - mj == 1 || j - mj == -1 && (i - mi == 1)) {
				if (chessBoard[mi][mj].equals("P") || chessBoard[mi][mj].equals("R") || chessBoard[mi][mj].equals("N")
						|| chessBoard[mi][mj].equals("B") || chessBoard[mi][mj].equals("Q")
						|| chessBoard[mi][mj].equals("K")) {
					fix(chessBoard, s);
					return true;
				}
			}
		}
		return false;
	}

	public boolean rookCheck(String[][] chessBoard, String s) {
		int i = Character.digit(s.charAt(0), 10);
		int j = Character.digit(s.charAt(2), 10);
		int mi = Character.digit(s.charAt(4), 10);
		int mj = Character.digit(s.charAt(6), 10);
		boolean move = true;
		if ((i - mi != 0 && j - mj == 0) || (i - mi == 0 && j - mj != 0)) {
			for (int k = 1; k < (Math.abs((i - mi) - (j - mj))); k++) {
				if (i - mi < 0) {
					if (chessBoard[i + k][j].equals("")) {
						move = true;
					} else {
						move = false;
						break;
					}
				} else if (i - mi > 0) {
					if (chessBoard[i - k][j].equals("")) {
						move = true;
					} else {
						move = false;
						break;
					}
				} else if (j - mj < 0) {
					if (chessBoard[i][j + k].equals("")) {
						move = true;
					} else {
						move = false;
						break;
					}
				} else if (j - mj > 0) {
					if (chessBoard[i][j - k].equals("")) {
						move = true;
					} else {
						move = false;
						break;
					}
				} else {
					System.out.println("이동할수 없음5");
					break;
				}
			}
		} else {
			System.out.println("이동할수 없음6");
			move = false;
		}
		return move;
	}

	public boolean rook(String[][] chessBoard, String s) {
		// 1.[i][j] i만 혹은 j만 이동가능 ,
		int i = Character.digit(s.charAt(0), 10);
		int j = Character.digit(s.charAt(2), 10);
		int mi = Character.digit(s.charAt(4), 10);
		int mj = Character.digit(s.charAt(6), 10);
		boolean move = rookCheck(chessBoard, s);
		if (move && chessBoard[i][j].equals("R")) {
			if (upperTeam(chessBoard, mi, mj)) {
				System.out.println("이동할수 없음1");
			} else {
				fix(chessBoard, s);
				return true;
			}
		} else if (move && chessBoard[i][j].equals("r")) {
			if (lowerTeam(chessBoard, mi, mj)) {
				System.out.println("이동할수 없음2");
			} else {
				fix(chessBoard, s);
				return true;
			}
		} else {
			System.out.println("이동할수 없음3");
			return false;
		}
		return false;
	}

	public boolean bishopCheck(String[][] chessBoard, String s) {
		int i = Character.digit(s.charAt(0), 10);
		int j = Character.digit(s.charAt(2), 10);
		int mi = Character.digit(s.charAt(4), 10);
		int mj = Character.digit(s.charAt(6), 10);
		boolean move = true;
		if (Math.abs(i - mi) == Math.abs(j - mj)) {
			for (int k = 1; k < Math.abs((i - mi)); k++) {
				if (i - mi == j - mj && i - mi <= 0) {
					if (chessBoard[i + k][j + k].equals("")) {
						move = true;
					} else {
						move = false;
						break;
					}
				} else if (i - mi == j - mj && i - mi >= 0) {
					if (chessBoard[i - k][j - k].equals("")) {
						move = true;
					} else {
						move = false;
						break;
					}
				} else if (i - mi != j - mj && i - mi >= 0) {
					if (chessBoard[i - k][j + k].equals("")) {
						move = true;
					} else {
						move = false;
						break;
					}
				} else if (i - mi != j - mj && i - mi <= 0) {
					if (chessBoard[i + k][j - k].equals("")) {
						move = true;
					} else {
						move = false;
						break;
					}
				} else {
					System.out.println("이동할수 없음");
					break;
				}
			}
		} else {
			System.out.println("이동할수 없음3");
			move = false;
		}
		return move;
	}

	public boolean bishop(String[][] chessBoard, String s) {
		// 1.[i][j] i증가,감소&j증가,감소 둘이 같이만 이동가능
		int i = Character.digit(s.charAt(0), 10);
		int j = Character.digit(s.charAt(2), 10);
		int mi = Character.digit(s.charAt(4), 10);
		int mj = Character.digit(s.charAt(6), 10);
		boolean move = bishopCheck(chessBoard, s);
		if (move && chessBoard[i][j].equals("B")) {
			if (upperTeam(chessBoard, mi, mj)) {
				System.out.println("이동할수 없음");
			} else {
				fix(chessBoard, s);
				return true;
			}
		} else if (move && chessBoard[i][j].equals("b")) {
			if (lowerTeam(chessBoard, mi, mj)) {
				System.out.println("이동할수 없음");
			} else {
				fix(chessBoard, s);
				return true;
			}
		}
		return false;
	}

	public boolean knight(String[][] chessBoard, String s) {
		// 1.[i][j] i+2&j+1 || i+1&j+2 || i-2&j-1 || i-1&j-2
		// 2.앞이 막혀도 가능
		int i = Character.digit(s.charAt(0), 10);
		int j = Character.digit(s.charAt(2), 10);
		int mi = Character.digit(s.charAt(4), 10);
		int mj = Character.digit(s.charAt(6), 10);
		if ((mi == i + 2 && (mj == j + 1 || mj == j - 1)) || (mi == i - 2 && (mj == j + 1 || mj == j - 1))
				|| (mj == j + 2 && (mi == i + 1 || mi == i - 1)) || (mj == j - 2 && (mi == i + 1 || mi == i - 1))) {
			if (chessBoard[i][j].equals("N")) {
				if (upperTeam(chessBoard, mi, mj)) {
					System.out.println("이동할수 없음11");
				} else {
					System.out.println("#1");
					fix(chessBoard, s);
					return true;
				}
			} else if (chessBoard[i][j].equals("n")) {
				if (lowerTeam(chessBoard, mi, mj)) {
					System.out.println("이동할수 없음12");
				} else {
					System.out.println("#2");
					fix(chessBoard, s);
					return true;
				}
			} else {
				System.out.println("이동할수 없음13");
			}
		} else {
			System.out.println("이동할수 없음14");
		}
		return false;
	}

	public boolean king(String[][] chessBoard, String s) {
		// i++,-- || j++,-- || i++,--&&j++,--
		int i = Character.digit(s.charAt(0), 10);
		int j = Character.digit(s.charAt(2), 10);
		int mi = Character.digit(s.charAt(4), 10);
		int mj = Character.digit(s.charAt(6), 10);
		if ((Math.abs(mj - j) == 1 || Math.abs(mj - j) == 0) && (Math.abs(mi - i) == 1 || Math.abs(mi - i) == 0)) {
			System.out.println("king");
			if (chessBoard[i][j].equals("K")) {
				if (upperTeam(chessBoard, mi, mj)) {
					System.out.println("이동할수 없음1");
				} else {
					fix(chessBoard, s);
					return true;
				}
			} else if (chessBoard[i][j].equals("k")) {
				if (lowerTeam(chessBoard, mi, mj)) {
					System.out.println("이동할수 없음2");
				} else {
					fix(chessBoard, s);
					return true;
				}
			}
		}
		return false;
	}

	public boolean queen(String[][] chessBoard, String s) {
		// rook bishop 합체
		int i = Character.digit(s.charAt(0), 10);
		int j = Character.digit(s.charAt(2), 10);
		int mi = Character.digit(s.charAt(4), 10);
		int mj = Character.digit(s.charAt(6), 10);
		if (bishopCheck(chessBoard, s) || rookCheck(chessBoard, s)) {
			if (chessBoard[i][j].equals("Q")) {
				if (upperTeam(chessBoard, mi, mj)) {
					System.out.println("이동할수 없음");
				} else {
					fix(chessBoard, s);
					return true;
				}
			} else if (chessBoard[i][j].equals("q")) {
				if (lowerTeam(chessBoard, mi, mj)) {
					System.out.println("이동할수 없음");
				} else {
					fix(chessBoard, s);
					return true;
				}
			}
		}
		return false;
	}

	public boolean upperTeam(String[][] chessBoard, int i, int j) {
		if (chessBoard[i][j].equals("R") || chessBoard[i][j].equals("P") || chessBoard[i][j].equals("N")
				|| chessBoard[i][j].equals("B") || chessBoard[i][j].equals("K") || chessBoard[i][j].equals("Q")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean lowerTeam(String[][] chessBoard, int i, int j) {
		if (chessBoard[i][j].equals("r") || chessBoard[i][j].equals("p") || chessBoard[i][j].equals("n")
				|| chessBoard[i][j].equals("b") || chessBoard[i][j].equals("k") || chessBoard[i][j].equals("q")) {
			return true;
		} else {
			return false;
		}
	}

	public void fix(String[][] chessBoard, String s) {
		int i = Character.digit(s.charAt(0), 10);
		int j = Character.digit(s.charAt(2), 10);
		int mi = Character.digit(s.charAt(4), 10);
		int mj = Character.digit(s.charAt(6), 10);
		chessBoard[mi][mj] = chessBoard[i][j];
		if (j % 2 == 0) {
			chessBoard[i][j] = "";
		} else {
			chessBoard[i][j] = "";
		}
		player++;
		// int user++; user%2==0 이면 플레이어1 아니면 플레이어2 차래
	}
	public boolean check(String[][] chessBoard) {
		// find king first
		int wki, wkj, bki, bkj;
		for (int i = 0; i < chessBoard.length; i++) {
			for (int j = 0; j < chessBoard[i].length; j++) {
				if (chessBoard[i][j].equals("K") || chessBoard[i][j].equals("k")) {
					if (checkfront(chessBoard, i, j)) {
						return true;
					}
					else if(checkCross(chessBoard, i, j)) {
						return true;
					}
				}
			}
		}
		// find who can checkmate the king
		return false;
	}
	public boolean checkfront(String[][] chessBoard, int i, int j) {
		int cnt = 0;
		for (int x = i + 1; x < 8; x++) {
			if(	(chessBoard[i][j].equals("K") && (chessBoard[x][j].equals("r")||chessBoard[x][j].equals("q")||chessBoard[i][x].equals("r")||chessBoard[i][x].equals("q")))	||	
					(chessBoard[i][j].equals("k") && (chessBoard[x][j].equals("R")||chessBoard[x][j].equals("Q")||chessBoard[i][x].equals("R")||chessBoard[i][x].equals("Q")))	){
				cnt = 1;
			} else if (chessBoard[x][j].equals("")||chessBoard[i][x].equals("")) { 	
			} else { break; }
		}
		for (int x = i - 1; x > 0; x--) {
			if(	(chessBoard[i][j].equals("K") && (chessBoard[x][j].equals("r")||chessBoard[x][j].equals("q")||chessBoard[i][x].equals("r")||chessBoard[i][x].equals("q")))	||	
					(chessBoard[i][j].equals("k") && (chessBoard[x][j].equals("R")||chessBoard[x][j].equals("Q")||chessBoard[i][x].equals("R")||chessBoard[i][x].equals("Q")))	){
				cnt = 1;
			} else if (chessBoard[x][j].equals("")||chessBoard[i][x].equals("")) {
			} else {break;}
		}
		if (cnt == 1) { return true; }
		return false;
	}
	public boolean checkCross(String[][] chessBoard, int i, int j) {
		int cnt = 0;
		for (int x = i + 1; x < 8; x++) {
			if(	(chessBoard[i][j].equals("K") && (chessBoard[x][j+1].equals("b")||chessBoard[x][j+x].equals("q"))) || 
					(chessBoard[i][j].equals("k") && (chessBoard[x][i+x].equals("B")||chessBoard[x][j+x].equals("Q"))) ) {
				System.out.println("!!!1");
				cnt = 1;
			} else if ( chessBoard[x][x].equals("") ) { 	System.out.println("!!!2");
			} else { System.out.println("!!!3"); break; }
		}
		if (cnt == 1) { return true; }
		return false;
	}
}
	

