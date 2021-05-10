package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;
import a_File_transform.ClientFile;
import javax.swing.JTextField;
import javax.swing.JButton;

public class inputIpAddress extends JFrame {

	private JPanel contentPane;
	public static JTextField ipInputField;
	String ipAddress;

	/**
	 * Launch the application.
	 */
	public static void prn() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inputIpAddress frame = new inputIpAddress();
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
	public inputIpAddress() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\uC811\uC18D\uD560 IP \uC785\uB825");
		lblNewLabel.setFont(new Font("±º∏≤", Font.PLAIN, 20));
		lblNewLabel.setBounds(145, 48, 132, 21);
		contentPane.add(lblNewLabel);

		ipInputField = new JTextField();
		ipInputField.setBounds(111, 84, 189, 27);
		contentPane.add(ipInputField);
		ipInputField.setColumns(10);

		JButton connBtn = new JButton("\uD30C\uC77C\uBC1B\uAE30");
		connBtn.addActionListener(new EventHandler());
		connBtn.setActionCommand("Conn");
		connBtn.setBounds(145, 139, 129, 29);
		contentPane.add(connBtn);
		
		JButton back = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		back.setBounds(145, 180, 132, 29);
		back.addActionListener(new EventHandler());
		back.setActionCommand("back");
		contentPane.add(back);
	}

	class EventHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Conn")) {
				ClientFile.clf();
			}
			if (e.getActionCommand().equals("back")) {
				dispose();
			}
		}
	}
	public JTextField getIpField() { //ipField¿« getter
		return ipInputField;
	}
}
