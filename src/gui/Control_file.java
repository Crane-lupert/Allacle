package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import a_File_transform.*;
import javax.swing.JLabel;

public class Control_file extends JFrame {
	private Saveconfirm sc = new Saveconfirm();
	private JPanel contentPane;
	CardLayout card = new CardLayout();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Control_file frame = new Control_file();
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
	public Control_file() {
		setTitle("\uC810\uC218\uC800\uC7A5");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton savefile = new JButton("\uD30C\uC77C\uC800\uC7A5(host)");
		savefile.setBounds(397, 30, 171, 67);
		contentPane.add(savefile);
		
		JButton serversend = new JButton("\uD30C\uC77C\uBCF4\uB0B4\uAE30(host)");
		serversend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ServerFile.servf();
			}
		});
		serversend.setBounds(397, 121, 171, 67);
		contentPane.add(serversend);
		
		JButton clientreceive = new JButton("\uD30C\uC77C\uBC1B\uAE30(client)");
		
		clientreceive.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			inputIpAddress.prn();
			//ClientFile.clf();
		}
	});
		clientreceive.setBounds(397, 209, 171, 67);
		contentPane.add(clientreceive);
		
		JButton back = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		back.setBounds(397, 304, 171, 67);
		contentPane.add(back);
		
JPanel panel = new JPanel();
		
		panel.setBounds(14, 30, 328, 341);
		panel.setLayout(card);
		contentPane.add(panel);
		
		 JPanel save = new JPanel() {
	         Image background = new ImageIcon(this.getClass().getClassLoader().getResource("save-file-option.png"))
	               .getImage();

	         public void paint(Graphics g) {// 그리는 함수
	            g.drawImage(background, 0, 0, null);// background를 그려줌

	         }
	      };
	      panel.add(save, "savepanel");
	      
	      JLabel lblNewLabel = new JLabel("C:/save_score/\uC5D0 \uC0DD\uC131");
	      lblNewLabel.setBounds(405, 280, 159, 18);
	      contentPane.add(lblNewLabel);
		
		savefile.addActionListener(new ActionListener(){ //레디버튼의 액션리스너 추가
			@Override 
			public void actionPerformed(ActionEvent e) { //클릭시
				
			sqq.view.MyEmpMenu.Find_Recent_DataDownload(MainFrame.getScore().getMyNickName());
			sc.setVisible(true);
			}
		});
		
		
	}
}
