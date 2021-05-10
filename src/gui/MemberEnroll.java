package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class MemberEnroll extends JFrame {

	private JPanel contentPane;
	private JTextField textField_id;
	private JPasswordField textField_pw;
	private JTextField textField_Nickname;
	private JLabel idcheckLabel;
	private JFrame N_success;
	private JFrame N_complete;
	private JFrame N_fail;
	

	private static int x, y;

	/**
	 * Launch the application.
	 */
	public MemberEnroll() {
		setTitle("All a Cle \uD68C\uC6D0\uB4F1\uB85D");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(700, 300, 485, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 10, 0));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel.setToolTipText("");
		panel.setBounds(0, 0, 577, 93);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_11 = new JLabel("\uD68C \uC6D0 \uB4F1 \uB85D");
		lblNewLabel_11.setFont(new Font("±º∏≤", Font.BOLD, 20));
		lblNewLabel_11.setBounds(187, 34, 110, 44);
		panel.add(lblNewLabel_11);

		JLabel mID = new JLabel("\uC544\uC774\uB514");
		mID.setBounds(74, 133, 57, 15);
		contentPane.add(mID);

		textField_id = new JTextField();
		textField_id.setBounds(190, 130, 116, 21);
		contentPane.add(textField_id);
		textField_id.setColumns(10);

		JLabel mPassword = new JLabel("\uBE44\uBC00\uBC88\uD638");
		mPassword.setBounds(74, 176, 72, 15);
		contentPane.add(mPassword);

		textField_pw = new JPasswordField();
		textField_pw.setBounds(190, 173, 116, 21);
		contentPane.add(textField_pw);
		textField_pw.setColumns(10);

		JLabel mNickname = new JLabel("\uB2C9\uB124\uC784");
		mNickname.setBounds(74, 215, 57, 15);
		contentPane.add(mNickname);

		textField_Nickname = new JTextField();
		textField_Nickname.setText("");
		textField_Nickname.setBounds(190, 212, 116, 21);
		contentPane.add(textField_Nickname);
		textField_Nickname.setColumns(10);

		N_success = new JFrame();
		N_success.setTitle("º∫∞¯");
		N_success.setBounds(109, 178, 120, 70);
		N_success.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		N_success.getContentPane().setLayout(null);
		
		N_complete = new JFrame();
		N_complete.setTitle("¡ﬂ∫πæ¯¿Ω");
		N_complete.setBounds(109, 178, 120, 70);
		N_complete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		N_complete.getContentPane().setLayout(null);

		N_fail = new JFrame();
		N_fail.setTitle("¿÷¥Ÿ");
		N_fail.setBounds(109, 178, 120, 70);
		N_fail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		N_fail.getContentPane().setLayout(null);

		JButton re_bt = new JButton("\uB2E4\uC2DC\uC785\uB825");
		re_bt.setBounds(49, 267, 116, 23);
		re_bt.setActionCommand("¥ŸΩ√ Ω· ¿”∏∂");
		contentPane.add(re_bt);

		re_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String chNi = textField_Nickname.getText();
				if (e.getActionCommand().equals("¥ŸΩ√ Ω· ¿”∏∂")) {
					textField_id.setText("");
					textField_pw.setText("");
					textField_Nickname.setText("");
				} else if (e.getActionCommand().equals("∞„√∆¥Ÿ!") && sqq.view.MyEmpMenu.CheckNick(chNi) == 0) {
					System.out.println("∞°¥…");
					N_complete obj = new N_complete();
					obj.setVisible(true);
				} else if (e.getActionCommand().equals("∞„√∆¥Ÿ!") && sqq.view.MyEmpMenu.CheckNick(chNi) != 0) {

					N_fail obj = new N_fail();
					obj.setVisible(true);
				}

			}

		});

		JButton enroll_bt = new JButton("\uB4F1\uB85D\uD558\uAE30");
		/* btnNewButton_1.addActionListener(new EventHandler()); */
		enroll_bt.setBounds(190, 267, 111, 23);
		enroll_bt.setActionCommand("¿¿æ÷");
		contentPane.add(enroll_bt);
		
		enroll_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String chId = textField_id.getText();
				String chPw = textField_pw.getText();
				String chNi = textField_Nickname.getText();
				if (sqq.view.MyEmpMenu.CheckMember(chId, chPw) == 0) {
					sqq.view.MyEmpMenu.CreateMember(chId, chPw, chNi);
					N_success obj = new N_success();
					obj.setVisible(true);
				} else {
					N_fail obj = new N_fail();
					obj.setVisible(true);
				}
			}

		});

		JButton cancel_bt = new JButton("√Îº“");
		cancel_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

		JButton joongbok_bt = new JButton("¡ﬂ∫π∞ÀªÁ");

		cancel_bt.setBounds(327, 267, 97, 23);
		
		contentPane.add(cancel_bt);

		joongbok_bt.setBounds(327, 211, 105, 23);
		joongbok_bt.setActionCommand("∞„√∆¥Ÿ!");
		contentPane.add(joongbok_bt);
		
		joongbok_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String chNi = textField_Nickname.getText();
				if (e.getActionCommand().equals("∞„√∆¥Ÿ!") && sqq.view.MyEmpMenu.CheckNick(chNi) == 0) {
					N_complete obj = new N_complete();
					obj.setVisible(true);
				} else if (e.getActionCommand().equals("∞„√∆¥Ÿ!") && sqq.view.MyEmpMenu.CheckNick(chNi) != 0) {
					N_fail obj = new N_fail();
					obj.setVisible(true);
				}

			}

		});

		idcheckLabel = new JLabel("");
		idcheckLabel.setBounds(190, 155, 126, 15);
		contentPane.add(idcheckLabel);
	}
}
