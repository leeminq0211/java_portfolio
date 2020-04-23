package portfolio.Calendar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CalUsing implements ActionListener, MouseListener {
	int year;
	int mon;
	CalendarGui main;
	CalendarMonth monthC;
	
	public CalUsing() {
		Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		mon = c.get(Calendar.MONTH) + 1;
		main = new CalendarGui();
		monthC = new CalendarMonth();
		main.year = year;
		main.mon = mon;
		monthC.year = year;
		monthC.mon = mon;
		monthC.createGui();
		main.createGui();
		monthChang();
	}
	public void createGui() {
		for (int i = 0; i < main.buttons.length; i++) {
			for (int j = 0; j < main.buttons[i].length; j++) {
				main.buttons[i][j].addActionListener(this);
			}
		}
		main.month.addMouseListener(this);
		monthC.month.addMouseListener(this);
		main.privButton.addActionListener(this);
		main.nextButton.addActionListener(this);
		for (int i = 0; i < monthC.monthButtons.length; i++) {
			monthC.monthButtons[i].addActionListener(this);
		}
		monthC.nextButton.addActionListener(this);
		monthC.privButton.addActionListener(this);
		main.exitbutton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(main.nextButton)) { mon++; monthChang();
		}else if(e.getSource().equals(main.exitbutton)) {
			main.frame.dispose();
			monthC.frame.dispose();
		}else if (e.getSource().equals(main.privButton)) { mon--; monthChang(); 
		}else if (e.getSource().equals(monthC.nextButton)) { year++; monthC.month.setText(year+"년");
		}else if (e.getSource().equals(monthC.privButton)) { year--; monthC.month.setText(year+"년");
		}
		else {
			for (int i = 0; i < main.buttons.length; i++) {
				for (int j = 0; j < main.buttons[i].length; j++) {
					if(e.getSource().equals(main.buttons[i][j])) {
						JOptionPane.showMessageDialog(main.frame, year+"년 "+mon+"월 "+main.buttons[i][j].getText()+"일을 선택하셨네요ㅎㅎ\nDB연결해서 이쁘게 아래 출력하면 됩니다");
						DefaultTableModel a = new DefaultTableModel(new Object[][] {	{"체스","승",year+"년 "+mon+"월 "+main.buttons[i][j].getText()+"일"}
						,{"가위바위보","패",year+"년 "+mon+"월 "+main.buttons[i][j].getText()+"일"},{"테트리스","승",year+"년 "+mon+"월 "+main.buttons[i][j].getText()+"일"}}, main.colums);
						main.table.setModel(a);
					}
					
				}
			}
			for(int i =0;i<monthC.monthButtons.length;i++) {
				 if(e.getSource().equals(monthC.monthButtons[i])) {
					monthC.frame.dispose();
					mon=i+1;monthChang(); 
					main.frame.setVisible(true);
				}
			}
		}
	}

	public void monthChang() {
		if (mon < 1) {
			mon = 12;
			year--;
		} else if (mon > 12) {
			mon = 1;
			year++;
		}
		int[] month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int cnt = 0;int priv=0;int next=1;
		for (int i = 0; i < main.buttons.length; i++) {
			for (int j = 0; j < main.buttons[i].length; j++) {
				main.buttons[i][j].setBackground(Color.white);
				main.buttons[i][j].setForeground(Color.black);
				main.buttons[i][j].setText(new MyCalendar().cal(year, mon)[cnt]);
				main.jPanel.add(main.buttons[i][j]);
				cnt++;
				if (main.buttons[i][j].getText().equals("")) {
					main.buttons[i][j].setEnabled(false);
					main.buttons[i][j].setBackground(Color.lightGray);
					if(cnt<8) {
						priv++;
					}
					else {
						main.buttons[i][j].setText(Integer.toString(next++));
					}
				} else {
					main.buttons[i][j].setEnabled(true);
					main.buttons[i][j].setBackground(Color.white);
				}
			}
		}
		int privmon = mon-1;
		if (privmon < 1) {
			privmon = 12;
		} else if (privmon > 12) {
			privmon = 1;
		}
		
		int put = month[privmon-1]-priv+1;
		if(privmon==2) { if ((year % 4) == 0 && (year % 100) != 0 || (year % 400) == 0) { put=29-priv+1; } }
		for (int i = 0; i < main.buttons.length; i++) {
			for (int j = 0; j < main.buttons[i].length; j++) {
				if (main.buttons[i][j].getText().equals("")) {
					main.buttons[i][j].setText(Integer.toString(put++));
				}	
			}
		}
		main.month.setText(year + "년 " + mon + "월");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(main.month)) {
			main.frame.setVisible(false);
			monthC.frame.setVisible(true);
			monthC.month.setText(year+"년");
		}
		else if (e.getSource().equals(monthC.month)) {
			monthC.frame.setVisible(false);
			year = Calendar.getInstance().get(Calendar.YEAR);
			mon = Calendar.getInstance().get(Calendar.MONTH) + 1;
			monthChang();
			main.frame.setVisible(true);
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}


	public static void main(String[] args) {
		new CalUsing().createGui();
	}
}
