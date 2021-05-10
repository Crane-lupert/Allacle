package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Panel;
import gui.Learn_sql;
import gui.Learn_util;
public class LearnMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LearnMain frame = new LearnMain();
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
	public LearnMain() {
		setTitle("\uD559\uC2B5");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 775, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton back_bt = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		back_bt.setBounds(614, 501, 129, 29);
		back_bt.setActionCommand("Back");
		contentPane.add(back_bt);

		JButton io_btn = new JButton("java.io");
		io_btn.setBounds(87, 30, 588, 59);
		contentPane.add(io_btn);

		JButton lang_btn = new JButton("java.lang");
		lang_btn.setBounds(87, 130, 588, 59);
		contentPane.add(lang_btn);

		JButton net_btn = new JButton("java.net");
		net_btn.setBounds(87, 230, 588, 59);
		contentPane.add(net_btn);

		JButton sql_btn = new JButton("java.sql");
		sql_btn.setBounds(87, 330, 588, 59);
		contentPane.add(sql_btn);

		JButton util_btn = new JButton("java.util");
		util_btn.setBounds(87, 430, 588, 59);
		contentPane.add(util_btn);

		io_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			Learn_io i = new Learn_io();
			i.setVisible(true);
			}
		});

		lang_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			Learn_lang l = new Learn_lang();	
			l.setVisible(true);
			}
		});

		net_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			Learn_net n = new Learn_net();
			n.setVisible(true);
			}
		});

		sql_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Learn_sql s = new Learn_sql();
				s.setVisible(true);
			}
		});

		util_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Learn_util u = new Learn_util();
				u.setVisible(true);
			}
		});

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

