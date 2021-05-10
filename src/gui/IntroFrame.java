package gui;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gui.MemberEnroll;

import userState.UserState;

public class IntroFrame extends JFrame{ 	
	
	static MemberEnroll obj = new MemberEnroll();
	private MainFrame mainFrame; //���������� ����
	private IntroPanel intro = new IntroPanel();
	static String chId;
	static String chPw;
	


	public IntroFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame; //MainFrame���� mainFrame �ʱ�ȭ
		setTitle("AllaCleBattle"); //Ÿ��Ʋ ����
		setLocation(new Point(700,350)); //��������� â�� ��ġ�� ����ش�.
		setPreferredSize(new Dimension(820, 645));//�������� â��ũ�� ����
		pack();//������Ʈ ũ�⸸ŭ â�� ũ�⸦ ����ش�.
		setLocationRelativeTo(null); //(null)�� �������ν� ȭ���߾ӿ� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//������â�� ������� ���μ����� ����

		setLayout(null); //���̾ƿ� ����

		add(intro); //intro�г� �߰�
		intro.setBounds(0,0,810,630); //��ġ����
		setVisible(true); //introFrame�� �����ش�.
	}

	public JTextField getIpField() { //ipField�� getter
		return intro.ipField;
	}

	class IntroPanel extends JPanel{
		
		private JPasswordField password = new JPasswordField();
		private JTextField ipField = new JTextField(); //ip�� �Է��� JTextField
		public  JTextField nickNameField = new JTextField(); //�г����� �Է��� JTextField
		private JButton ok = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("Ok.png")));; //�Է¿Ϸ�� ������ ��ư
		private JButton cu = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("cu.png")));
		
		public void paintComponent(Graphics g) { //����̹��� ����
			g.drawImage(new ImageIcon(this.getClass().getClassLoader().getResource("IntroBackGround.png")).getImage(),0,0,null);
			setOpaque(false);
			super.paintComponent(g);
		} 
		
		public IntroPanel() {
			
			this.setLayout(null); //���̾ƿ� ����

			//�� ��������� �߰�
			add(cu);
			add(password);
			add(ipField);
			add(nickNameField);
			add(ok);

			//��ġ����, ��Ʈũ��, ���Ե� �۾�ü ����
			password.setBounds(210,345,410,70);
			password.setFont(new Font("Dialog", Font.BOLD, 34));
			password.setText("");
			
			ipField.setBounds(210,145,410,70);
			ipField.setFont(new Font("Dialog", Font.BOLD, 34));
			ipField.setText(""); // �۾��� �̻ڰ� ���̱� ���� ����

			nickNameField.setBounds(210,245,410,70);
			nickNameField.setFont(new Font("Dialog", Font.BOLD, 34));
			nickNameField.setText("");
			

			ok.setBounds(450, 459, 237, 74);
			ok.setActionCommand("Login");
			ok.addActionListener(new EventHandler());
			
			cu.setBounds(100, 459, 237, 74);
			cu.setActionCommand("Enroll");
			cu.addActionListener(new EventHandler());
		
			
			
			/*ok.addActionListener(new ActionListener() { //ok ��ư�� Ŭ���� �̺�Ʈ �߰� �� ����
				public void actionPerformed(ActionEvent e) {
					mainFrame.setIp(ipField.getText().toString().trim()); //ipField���� ip�� ������ ������������ ip�ʵ忡 �����Ѵ�.
					mainFrame.getScore().setMyNickName(nickNameField.getText().toString().trim()); //mainFrame�� nickName�ʵ带 IntroFrame�� nickNameField�� �ִ� �ؽ�Ʈ�� �ʱ�ȭ
					UserState.setNickState(true); //�г��ӻ��¸� true�� �ʱ�ȭ
					dispose(); //introFrameâ�� ����.
					mainFrame.viewTrue(); //�Ⱥ��̰� �صξ��� mainFrame�� ���̰� �Ѵ�
				}
			});
			ok.addMouseListener(new MouseAdapter() { //���콺 Ŀ�� �̺�Ʈ �߰�
				@Override 
				public void mouseEntered(MouseEvent e) { // ���콺�� ��ư ���� �÷��� �� 
					ok.setCursor(new Cursor(Cursor.HAND_CURSOR));// �հ������ ���� ����
				}

				@Override 
				public void mouseExited(MouseEvent e) { // ���콺�� ��ư���� �ø��� �ʾ��� �� 
					ok.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // ����Ʈ������ ���� 
				}
			});*/
		}
	}
	class EventHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			chId = intro.nickNameField.getText();
			chPw = intro.password.getText();
			if (e.getActionCommand().equals("Enroll")) {				
				obj.setVisible(true);
			} else if (e.getActionCommand().equals("Login") && sqq.view.MyEmpMenu.CheckMember(chId, chPw) != 0) {
				mainFrame.setIp(intro.ipField.getText().toString().trim()); //ipField���� ip�� ������ ������������ ip�ʵ忡 �����Ѵ�.
				mainFrame.getScore().setMyNickName(intro.nickNameField.getText().toString().trim()); //mainFrame�� nickName�ʵ带 IntroFrame�� nickNameField�� �ִ� �ؽ�Ʈ�� �ʱ�ȭ
				UserState.setNickState(true); //�г��ӻ��¸� true�� �ʱ�ȭ
				dispose(); //introFrameâ�� ����.
				mainFrame.viewTrue(); //�Ⱥ��̰� �صξ��� mainFrame�� ���̰� �Ѵ�
			} else if (e.getActionCommand().equals("Login") && sqq.view.MyEmpMenu.CheckMember(chId, chPw) == 0) {
				N_fail nfail = new N_fail();
				nfail.setVisible(true);
			}
		}
		
		
	}
}



