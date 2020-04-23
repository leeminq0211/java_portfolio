package games.chess;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import games.chess.ChessGui;
import portfolio.gameselect.Select;

public class Server_Create extends Thread{
	ChessGui gui;Server_out a;Server_in b;
	ServerSocket serverSocket = null;
	Server_in in;
	Socket socket = null;
	public Server_Create() {
		super();
	}
	public Server_Create(ChessGui gui,String id) {
		super();
		this.gui = gui;
		gui.exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					serverSocket.close();
					socket.close();
					System.out.println(3333);
					gui.frame.dispose();
					in.interrupt();
					new Select(id).startSelect();
				} catch (Exception e2) {
					try {
						socket.close();
						System.out.println(22222);
						gui.frame.dispose();
						new Select(id).startSelect();
					} catch (Exception e1) {
						gui.frame.dispose();
						System.out.println(111);
						new Select(id).startSelect();
					}
					return;
				}	
			}
		});
			
	}
	@Override
	public void run() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			gui.chatArea.setText("접속중...");
			socket = new Socket("127.0.0.1", 4222);
			String name = "";
			a = new Server_out(socket,name,gui);
			b = new Server_in(socket,gui);b.start();
			gui.chatArea.append("\n방입장");
		} catch (IOException e) {
			try {
				e.printStackTrace();
//				while(true) {
				System.out.println(socket);
				socket = null;
				System.out.println(1);
				gui.chatArea.append("\n방이없음");
				gui.chatArea.append("\n방생성중....");
				serverSocket = new ServerSocket(4222);
				gui.chatArea.append("\n방생성 완료");
				gui.chatArea.append("\n대기중....");
				socket = serverSocket.accept();
				gui.chatArea.append("\n연결성공");
				String name = "";
				new Server_out(socket,name,gui);
				in = new Server_in(socket,gui);
				in.start();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
		
//	public void exitChat() {
//		a.out_exit();
//		b.in_exit();
//	}
	public static void main(String[] args) {
//		new Server_Create().server_Start();
	}
}
