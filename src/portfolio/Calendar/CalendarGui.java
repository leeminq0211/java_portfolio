package portfolio.Calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CalendarGui {
	JFrame frame;
	JButton[][] buttons;
	JButton[] monthButtons;
	JButton nextButton, privButton,exitbutton;
	JPanel buttonPanel, jPanel,together;
	JLabel[] date;
	JScrollPane jScrollPane;
	JTable table;
	String[] colums;
	Object[][] rowData;
	DefaultTableModel defaultTableModel;
	JLabel month;
	int year;
	int mon;
	CalendarMonth monthC;

	public CalendarGui() {
		frame = new JFrame();
		nextButton = new JButton("  다음  ");
		privButton = new JButton("  이전  ");
		buttonPanel = new JPanel();
		
		month = new JLabel();
		buttons = new JButton[6][7];
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				buttons[i][j] = new JButton("");
			}
		}
		together = new JPanel();
		jPanel = new JPanel();
		date = new JLabel[] { new JLabel("일"), new JLabel("월"), new JLabel("화"), new JLabel("수"), new JLabel("목"),
				new JLabel("금"), new JLabel("토") };
		colums = new String[] { "게임", "승패", "시간" };
		rowData = new Object[][] { };
		defaultTableModel = new DefaultTableModel(rowData, colums);
		table = new JTable(defaultTableModel);
		jScrollPane = new JScrollPane(table);
		monthC = new CalendarMonth();
		exitbutton = new JButton("X");
	}

	public void createGui() {
		defaultTableModel.getRowCount();
//		table.getsel
		frame.setLayout(new BorderLayout());
		frame.getContentPane().setBackground(Color.WHITE);
		month.setText(year + "년 " + mon + "월");
		month.setOpaque(true);
		month.setBackground(Color.WHITE);
		buttonPanel.setLayout(new BorderLayout());
		buttonPanel.setPreferredSize(new Dimension(100, 35));
		buttonPanel.setBackground(Color.white);
		buttonPanel.add(nextButton, BorderLayout.EAST);
		buttonPanel.add(month, BorderLayout.CENTER);
		month.setHorizontalAlignment(0);
		buttonPanel.add(privButton, BorderLayout.WEST);
		privButton.setPreferredSize(new Dimension(50,50));
		privButton.setBorder(null);
		privButton.setContentAreaFilled(false);
		privButton.setForeground(Color.RED);
		nextButton.setPreferredSize(new Dimension(50, 50));
		nextButton.setBorder(null);
		nextButton.setContentAreaFilled(false);
		nextButton.setForeground(Color.RED);

		exitbutton.setBorder(null);
		exitbutton.setContentAreaFilled(false);
		exitbutton.setForeground(Color.black);
		
		jPanel.setLayout(new GridLayout(0, 7, 0, 0));
		for (int i = 0; i < date.length; i++) {
			date[i].setHorizontalAlignment(0);
			jPanel.add(date[i]);
			date[i].setForeground(Color.white);
		}
		int cnt = 0;
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {

				buttons[i][j].setBackground(Color.white);
				buttons[i][j].setForeground(Color.black);
				buttons[i][j].setText(new MyCalendar().cal(year, mon)[cnt]);
				jPanel.add(buttons[i][j]);
				cnt++;
				if (buttons[i][j].getText().equals("")) {
					buttons[i][j].setEnabled(false);
					buttons[i][j].setBackground(Color.lightGray);
				}
			}
		}
		jScrollPane.setPreferredSize(new Dimension(400, 100));
		jPanel.setBackground(Color.black);
		frame.add(exitbutton,BorderLayout.SOUTH);
		frame.add(together,BorderLayout.CENTER);
	
		together.setLayout(new BorderLayout());
		together.add(buttonPanel, BorderLayout.NORTH);
		together.add(jPanel, BorderLayout.CENTER);
		together.add(jScrollPane, BorderLayout.SOUTH);
		frame.setSize(400, 300);
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
