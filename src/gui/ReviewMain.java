package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import gui.ScorePanel;

public class ReviewMain extends JFrame {
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReviewMain frame = new ReviewMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReviewMain() {
		
		setTitle("\uBCF5\uC2B5\uD558\uAE30");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 729, 206);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton back_bt = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		back_bt.setBounds(277, 111, 129, 29);
		back_bt.setActionCommand("Back");
		contentPane.add(back_bt);
		/*
		JTextArea textArea = new JTextArea();
		textArea.setBounds(14, 32, 87, 46);
		textArea.setText(sqq.view.MyEmpMenu.Find_Recent_Data(MainFrame.getScore().getMyNickName()).getNICK());
		contentPane.add(textArea);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(115, 32, 87, 46);
		textArea_1.setText(sqq.view.MyEmpMenu.Find_Recent_Data(mainFrame.getScore().getMyNickName()).getJoinCount() + "");
		contentPane.add(textArea_1);

		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(221, 32, 87, 46);
		textArea_2.setText(sqq.view.MyEmpMenu.Find_Recent_Data("s").getEnemy());
		contentPane.add(textArea_2);

		JTextArea textArea_2_1 = new JTextArea();
		textArea_2_1.setBounds(319, 32, 87, 46);
		textArea_2_1.setText(sqq.view.MyEmpMenu.Find_Recent_Data(mainFrame.getScore().getMyNickName()).getScore() + "");
		contentPane.add(textArea_2_1);

		JTextArea textArea_2_1_1 = new JTextArea();
		textArea_2_1_1.setBounds(420, 32, 87, 46);
		textArea_2_1_1.setText(sqq.view.MyEmpMenu.Find_Recent_Data(mainFrame.getScore().getMyNickName()).getG_StartTime());
		contentPane.add(textArea_2_1_1);

		JTextArea textArea_2_1_1_1 = new JTextArea();
		textArea_2_1_1_1.setBounds(521, 32, 87, 46);
		if (sqq.view.MyEmpMenu.Find_Recent_Data(mainFrame.getScore().getMyNickName()).getWinlose() == 1) {
			textArea_2_1_1_1.setText("win");
		} else {
			textArea_2_1_1_1.setText("lose");
		}
		contentPane.add(textArea_2_1_1_1);

		JTextArea textArea_2_1_1_1_1 = new JTextArea();
		textArea_2_1_1_1_1.setBounds(622, 32, 87, 46);
		textArea_2_1_1_1_1.setText(sqq.view.MyEmpMenu.Find_Recent_Data("s").getWrong());
		contentPane.add(textArea_2_1_1_1_1);
		*/
		back_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
	}

	class EventHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand().equals("Back")) {
				dispose();
			}
		}
	}
}
