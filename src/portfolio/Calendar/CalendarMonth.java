package portfolio.Calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

class CalendarMonth {
	JFrame frame;
	JButton[] monthButtons;
	JButton nextButton, privButton;
	JPanel buttonPanel, monthPanel;
	JLabel[] date;
	JLabel month;
	int year;
	int mon;
	public CalendarMonth() {
		frame = new JFrame();
		nextButton = new JButton("다음");
		privButton = new JButton("이전");
		buttonPanel = new JPanel();
		monthButtons = new JButton[12];
		for (int i = 0; i < monthButtons.length; i++) {
			monthButtons[i] = new JButton(i+1+"월");
		}
		monthPanel = new JPanel();
		month = new JLabel(year + "년 ");
	}
	public void createGui() {
		frame.setLayout(new BorderLayout());
		frame.getContentPane().setBackground(Color.WHITE);
		month.setOpaque(true);
		month.setBackground(Color.WHITE);
		buttonPanel.setLayout(new BorderLayout());
		buttonPanel.setPreferredSize(new Dimension(100, 35));
		buttonPanel.setBackground(Color.red);
		buttonPanel.add(nextButton, BorderLayout.EAST);
		buttonPanel.add(month, BorderLayout.CENTER);
		month.setHorizontalAlignment(0);
		buttonPanel.add(privButton, BorderLayout.WEST);
		privButton.setPreferredSize(new Dimension(50,50));
		privButton.setBorder(null);
		privButton.setContentAreaFilled(false);
		privButton.setForeground(Color.white);
		nextButton.setPreferredSize(new Dimension(50, 50));
		nextButton.setBorder(null);
		nextButton.setContentAreaFilled(false);
		nextButton.setForeground(Color.white);
		monthPanel.setLayout(new GridLayout(2,6));
		monthPanel.setBackground(Color.WHITE);
		TitledBorder tb = new TitledBorder(new LineBorder(Color.LIGHT_GRAY));
		for (int i = 0; i < monthButtons.length; i++) {
			monthPanel.add(monthButtons[i]);
			monthButtons[i].setBorder(null);
			monthButtons[i].setContentAreaFilled(false);
			monthButtons[i].setBorder(tb);
		}
		frame.add(monthPanel,BorderLayout.CENTER);
		frame.add(buttonPanel, BorderLayout.NORTH);
		
		frame.setSize(400, 300);
		frame.setUndecorated(true);
		frame.setVisible(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
