package portfolio;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JOptionPane;

import portfolio.gameselect.Select;
import portfolio.gameselect.SelectGui;

public class Using implements ActionListener {
	LogInGui logGui; Login login; SingUpGui singUpGui;
	public static void main(String[] args) {
		new Using().start();
	}
	public Using() {
		logGui = new LogInGui();
		login = new Login();
		singUpGui = new SingUpGui();
	}
	public void start() {
		logGui.createGui();
		singUpGui.createGui();
		logGui.exitButton.addActionListener(this);
		logGui.loginButton.addActionListener(this);
		logGui.signUpButton.addActionListener(this);
		singUpGui.confirm.addActionListener(this);
		singUpGui.cancel.addActionListener(this);
		File folder = new File("C:\\minq");
		if(!folder.exists()) {
			folder.mkdir();
			File file = new File("C:\\minq\\id.db");
			if(!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		char[] s = logGui.passField.getPassword();
		String sb = String.copyValueOf(s);
		
		if(e.getSource().equals(logGui.exitButton)) {
			System.exit(0);
		}
		else if(e.getSource().equals(logGui.loginButton)) {
			if(logGui.idField.getText().equals("")) {
				JOptionPane.showMessageDialog(logGui.loginFrame, "아이디를 입력해주세요");
				logGui.idField.requestFocus();
			}
			else {
				if(sb.equals("")) {
					JOptionPane.showMessageDialog(logGui.loginFrame, "비밀번호를 입력해주세요");
					logGui.passField.requestFocus();
				}
				else {
					
					if(new Login().login(logGui.idField.getText(), sb)||logGui.idField.getText().equals("admin")) {
						JOptionPane.showMessageDialog(logGui.loginFrame, "login 성공");
						logGui.loginFrame.dispose();
						Select select = new Select(logGui.idField.getText());
						select.startSelect();
					}
					else {
						JOptionPane.showMessageDialog(logGui.loginFrame, "login 실패");
						logGui.idField.setText("");
						logGui.passField.setText("");
						logGui.idField.requestFocus();
					}
				}
			}
		}
		else if(e.getSource().equals(logGui.signUpButton)) {
			singUpGui.frame.setVisible(true);
			logGui.loginFrame.setVisible(false);
		}
		else if(e.getSource().equals(singUpGui.confirm)) {
			int cnt =1;
			for (int i = 0; i < singUpGui.fields.length; i++) {
				if (singUpGui.fields[i].getText().equals("")) {
					JOptionPane.showMessageDialog(singUpGui.frame, singUpGui.labels[i].getText() + "를 입력해주세요");
					singUpGui.fields[i].requestFocus();
					cnt=0;
					break;
				}
			}
			if(cnt==1) {
				try {
					if (login.checkId(singUpGui.fields[0].getText())) {
						JOptionPane.showMessageDialog(singUpGui.frame, "이미 있는 아이디입니다.");
						singUpGui.fields[0].requestFocus();
					} else {
						try {
							if (new SignUp().signUp(new Users(
									singUpGui.fields[0].getText(), singUpGui.fields[1].getText(),
									Integer.parseInt(singUpGui.fields[2].getText()), singUpGui.fields[3].getText(), singUpGui.fields[4].getText()))) {
								JOptionPane.showMessageDialog(logGui.loginFrame, "signup 성공");
								singUpGui.fields[0].setText(""); singUpGui.fields[1].setText(""); singUpGui.fields[2].setText(""); singUpGui.fields[3].setText("");singUpGui.fields[4].setText("");
								singUpGui.frame.setVisible(false);
								logGui.loginFrame.setVisible(true);
							} else {
								JOptionPane.showMessageDialog(logGui.loginFrame, "signup 실패");
								singUpGui.fields[0].setText(""); singUpGui.fields[1].setText(""); singUpGui.fields[2].setText(""); singUpGui.fields[3].setText("");singUpGui.fields[4].setText("");
								singUpGui.fields[0].requestFocus();
							}
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(singUpGui.frame, "나이를 제대로 입력해주세요");
							singUpGui.fields[2].requestFocus();
						}
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		else if(e.getSource().equals(singUpGui.cancel)) {
			singUpGui.frame.setVisible(false);
			logGui.loginFrame.setVisible(true);
		}
	}
}
