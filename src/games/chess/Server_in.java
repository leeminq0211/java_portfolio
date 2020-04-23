package games.chess;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Server_in extends Thread{
	Socket socket; DataInputStream in; ChessGui gui;
	public Server_in() {
		super();
		socket=null;
		in = null;
	}
	public Server_in(Socket socket, ChessGui gui) {
		super();
		this.socket = socket;
		try {
			this.in = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.gui = gui;
	}
	@Override
	public void run() {
		while(in!=null) {
			try {
				gui.chatArea.append("\n"+in.readUTF());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			} catch (Exception e2) {
				break;
			}
		}
	}
//	public void in_exit() {
//		try {
//			socket.close();
//			System.out.println("소켓끝");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
}