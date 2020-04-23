package portfolio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class SingUpGui {
	JFrame frame; JButton confirm,cancel; TextField[] fields; JLabel[] labels; JPanel fieldsPanel,buttonsPanel; TextArea area;

	public SingUpGui() {
		frame = new JFrame();
		confirm = new JButton("CONFIRM");
		cancel = new JButton("CANCEL");
		fields = new TextField[] {new TextField(),new TextField(),new TextField(),new TextField(),new TextField()};
		labels = new JLabel[] {new JLabel("   ID"),new JLabel("   PASS"),new JLabel("   AGE"),new JLabel("   E-MAIL"),new JLabel("   ADDRESS")};
		fieldsPanel = new JPanel();
		buttonsPanel = new JPanel();
	}
	void createGui() {
		TitledBorder tb = new TitledBorder(new LineBorder(Color.black));
	
		frame.setLayout(new BorderLayout(30,30));
		frame.getContentPane().setBackground(Color.white);
		fieldsPanel.setBorder(tb);
		fieldsPanel.setLayout(new GridLayout(5,0));
		fieldsPanel.setBackground(Color.white);
		for(int i=0;i<labels.length;i++) {
			fieldsPanel.add(labels[i]);
			fieldsPanel.add(fields[i]);
		}
		buttonsPanel.setLayout(new GridLayout(0,2));
		buttonsPanel.setBackground(new Color(800080));
		buttonsPanel.add(confirm);
		buttonsPanel.add(cancel);
		
		confirm.setBorder(null);
		confirm.setContentAreaFilled(false);
		confirm.setForeground(Color.white);
		cancel.setBorder(null);
		cancel.setContentAreaFilled(false);
		cancel.setForeground(Color.white);
		
		buttonsPanel.setPreferredSize(new Dimension(100, 30));
		frame.add(fieldsPanel,BorderLayout.CENTER);
		frame.add(buttonsPanel,BorderLayout.SOUTH);
		frame.setSize(400,200);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.setVisible(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new SingUpGui().createGui();
	}
}
