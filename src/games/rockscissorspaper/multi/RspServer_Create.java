package games.rockscissorspaper.multi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import portfolio.gameselect.Select;

class Server_out1 extends Thread implements ActionListener{
	Socket socket; String name; DataOutputStream out;RockScissorsPaper_Gui gui; RockScissorsPaper rocks; int i=0,j=0;ServerSocket serverSocket;
	public Server_out1() {
		super();
		socket=null;
		name = null;
		out = null;
	}
	public Server_out1(Socket socket, String name,RockScissorsPaper_Gui gui,RockScissorsPaper rocks,ServerSocket serverSocket) {
		super();
		this.socket = socket;
		this.name = name;
		this.rocks = rocks;
		this.serverSocket = serverSocket;
		try {
			this.out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		this.gui = gui;
		gui.rock_button.addActionListener(this);
		gui.scissors_button.addActionListener(this);
		gui.paper_button.addActionListener(this);
		gui.readyButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int a = 0;
		if (e.getSource().equals(gui.rock_button)) {
			gui.user.setIcon(gui.rock);
			rocks.a=1;
		} else if (e.getSource().equals(gui.scissors_button)) {
			gui.user.setIcon(gui.scissors);
			rocks.a=2;
		} else if (e.getSource().equals(gui.paper_button)) {
			gui.user.setIcon(gui.paper);
			rocks.a=3;
		} else if (e.getSource().equals(gui.readyButton)) {//&&gui.readyButton.getModel().isSelected()
			boolean selected = gui.readyButton.getModel().isSelected(); 
			if (selected) { try {
				out.writeInt(rocks.a);//////////////////////server_in1 sleep
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} } 
		}	
	}
}

class Server_in1 extends Thread{
	Socket socket; DataInputStream in; RockScissorsPaper_Gui gui;RockScissorsPaper rocks;
	public Server_in1() {
		super();
		socket=null;
		in = null;
	}
	public Server_in1(Socket socket, RockScissorsPaper_Gui gui,RockScissorsPaper rocks) {
		super();
		this.rocks = rocks;
		this.socket = socket;
		try {
			this.in = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.gui = gui;
	}
	@Override
	public void run() {
		while(in!=null) {			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			try {
				if (gui.readyButton.getModel().isSelected()) {
					rocks.b = in.readInt();
					System.out.println(rocks.b);
					if (Math.abs(rocks.b) == 1) {
						gui.com.setIcon(gui.rock);
						rocks.winner();
					} else if (Math.abs(rocks.b) == 2) {
						gui.com.setIcon(gui.scissors);
						rocks.winner();
					} else if (Math.abs(rocks.b) == 3){
						gui.com.setIcon(gui.paper);
						rocks.winner();
					} 
				}
			} catch (IOException e) {
				e.printStackTrace();
				gui.chatArea.append("\n상대방이 없습니다.");
			}
			gui.score.setText(rocks.win + "승 " + rocks.loose + "패 " + rocks.draw + "무승부");
			gui.readyButton.setSelected(false);
		}
	}
}
public class RspServer_Create extends Thread {
	RockScissorsPaper_Gui gui;Server_out1 a;Server_in1 b; RockScissorsPaper rocks;//Server_in2 c;
	ServerSocket serverSocket = null;
	Socket socket = null;
	public RspServer_Create() {
		super();
	}
	public RspServer_Create(RockScissorsPaper_Gui gui) {
		super();
		this.gui = gui;
//		a = new Server_out1();
//		b = new Server_in1();
		rocks = new RockScissorsPaper();
		gui.exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println(4444444);
					serverSocket.close();
					socket.close();
					gui.frame.dispose();
					new Select(gui.id).startSelect();
				} catch (Exception e2) {
					try {
						socket.close();
						gui.frame.dispose();
						new Select(gui.id).startSelect();
					} catch (Exception e1) {
						gui.frame.dispose();
						new Select(gui.id).startSelect();
					}
					return;
				}	
			}
		});
			
	}
	@Override
	public void run() {
		try {
			gui.chatArea.setText("접속중...");
			socket = new Socket("127.0.0.1", 4333);
			String name = "";
			System.out.println(111);
			a = new Server_out1(socket,name,gui,rocks,serverSocket);
			b = new Server_in1(socket,gui,rocks);b.start();
			gui.chatArea.append("\n방입장");
		} catch (IOException e) {
			e.printStackTrace();
//			while(true) {
			socket = null;
			try {
				gui.chatArea.append("\n방이없음");
				gui.chatArea.append("\n방생성중....");
				serverSocket = new ServerSocket(4333);
				gui.chatArea.append("\n방생성 완료");
				gui.chatArea.append("\n대기중....");
				socket = serverSocket.accept();
				gui.chatArea.append("\n연결성공");
				String name = "";
				new Server_out1(socket,name,gui,rocks,serverSocket);
				new Server_in1(socket,gui,rocks).start();
//				serverSocket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
//		}
	}
}
