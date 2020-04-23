package portfolio.gameselect;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import games.chess.ChessGui;
import games.chess.ChessMain;
import games.chess.Server_Create;
import games.chess.Server_in;
import games.chess.Server_out;
import games.rockscissorspaper.multi.RockScissorsPaper_Gui;
import games.rockscissorspaper.multi.RockScissorsPapers;
import games.rockscissorspaper.multi.RspServer_Create;
import games.rockscissorspaper.single.RockScissorsPaper_GuiS;
import portfolio.Using;
import portfolio.Calendar.CalUsing;

public class Select implements ActionListener{
	SelectGui gui; String id;
	
	public Select(SelectGui gui) {
		super();
		this.gui = gui;
	}
	public Select(String id) {
		super();
		gui = new SelectGui();
		this.id=id;
	}
	
	public Select() {
		super();
		gui = new SelectGui();
	}
	
	public void startSelect() {
		gui.createGui();
		gui.frame.setVisible(true);
		gui.exitButton.addActionListener(this);
		for(int i=0;i<gui.button.length;i++) {
			gui.button[i].addActionListener(this);
		}
		gui.calButton.addActionListener(this);
		gui.jlabelUser.setText(id);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(gui.button[0])) {
			ChessMain chess = new ChessMain(id);
			ChessGui guiC = chess.readyChess();
			Server_Create chat = new Server_Create(guiC,id);
			chat.start();
			this.gui.frame.dispose();
		}
		else if(e.getSource().equals(gui.button[1])) {
			RockScissorsPapers rsp = new RockScissorsPapers();
			RockScissorsPaper_Gui gui = rsp.RockScissorsPapers(id);
			gui.createGui();
//			rsp.show();
			RspServer_Create chat = new RspServer_Create(gui);
			chat.start();
			this.gui.frame.dispose();
		}
		else if(e.getSource().equals(gui.button[2])) {
			ChessMain chess = new ChessMain(id);
			ChessGui guiC = chess.readyChess();
			Server_Create chat = new Server_Create(guiC,id);
			chat.start();
			this.gui.frame.dispose();
		}
		else if(e.getSource().equals(gui.button[3])) {
			RockScissorsPaper_GuiS rsp = new RockScissorsPaper_GuiS(id);
			rsp.createGui();
			
			gui.frame.dispose();
		}
		else if(e.getSource().equals(gui.exitButton)) {	
			gui.frame.dispose();
			new Using().start();
		}
		else if(e.getSource().equals(gui.calButton)) {
			new CalUsing().createGui();
		}
	}
	public static void main(String[] args) {
		new Select().startSelect();
	}
}
