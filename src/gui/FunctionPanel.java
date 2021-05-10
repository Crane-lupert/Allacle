package gui;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import userState.UserState;


public class FunctionPanel extends JPanel{
	
	private JButton study = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("study.png")));
	private JButton search = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("search.png")));
	private JButton exit = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("exit.png")));
	private LearnMain lm = new LearnMain();
	private Saveconfirm sc = new Saveconfirm();
	private Control_file cf = new Control_file();
	//private ReviewMain rm = new ReviewMain();
	
	public FunctionPanel() {
		setLayout(null); //레이아웃 없음
		//패널에 추가
		add(study);
		add(search);
		add(exit);
		//레이아웃이 없기에 위치를 각자 지정해 준다.
		study.setBounds(80, 30, 300, 70);
		search.setBounds(80, 120, 300, 70);
		exit.setBounds(80, 210, 300, 70);
		
		study.addActionListener(new ActionListener(){ //레디버튼의 액션리스너 추가
			@Override 
			public void actionPerformed(ActionEvent e) { //클릭시
			lm.setVisible(true);
			}
		});
		search.addActionListener(new ActionListener(){ //레디버튼의 액션리스너 추가
			@Override 
			public void actionPerformed(ActionEvent e) { //클릭시
				
			
			cf.setVisible(true);
			
			}
		});
		exit.addActionListener(new ActionListener(){ //레디버튼의 액션리스너 추가
			@Override 
			public void actionPerformed(ActionEvent e) { //클릭시
			System.exit(0);
			}
		});

	}
}
