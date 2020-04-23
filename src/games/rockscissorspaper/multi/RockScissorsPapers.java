package games.rockscissorspaper.multi;

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
import javax.swing.JToggleButton;

import portfolio.gameselect.Select;

class RockScissorsPaper {
	int win = 0, draw = 0, loose = 0;
	String s = "대기중";
	int b;
	int a;
	public RockScissorsPaper() {
		super();	
	}
	public void winner() {
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
public class RockScissorsPapers {
	RockScissorsPaper_Gui gui; RspServer_Create chat; RockScissorsPaper rorks;
	String id;
	
	public RockScissorsPapers() {
		super();
	}
	public RockScissorsPaper_Gui RockScissorsPapers(String id) {
		System.out.println(id);
		this.id=id;
		gui = new RockScissorsPaper_Gui(id);
		rorks = new RockScissorsPaper();
		return gui;
	}
//	public void show() {
////		gui.rock_button.addActionListener(this);
////		gui.scissors_button.addActionListener(this);
////		gui.paper_button.addActionListener(this);
//		chat.run();
//	}

	public static void main(String[] args) {
//		new RockScissorsPapers(null).show();
	}

}// end class