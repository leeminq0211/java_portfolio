package games.chess;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Server_out implements ActionListener{
	Socket socket; String name; DataOutputStream out;ChessGui gui;
	public Server_out() {
		super();
		socket=null;
		name = null;
		out = null;
	}
	public Server_out(Socket socket, String name,ChessGui gui) {
		super();
		this.socket = socket;
		this.name = name;
		try {
			this.out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		this.gui = gui;
		gui.sendingButton.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(gui.sendingButton)) {
			try {
				gui.chatArea.append("\n"+gui.writingField.getText());
				out.writeUTF(gui.writingField.getText());
				gui.writingField.setText("");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
//	public void out_exit() {
//		try {
//			socket.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}