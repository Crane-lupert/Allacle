package gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;


public class MainFrame extends JFrame{
	private Container c = this.getContentPane(); //�߰�
	private ChattingPanel chat = new ChattingPanel();
	private static ScorePanel score = new ScorePanel();
	private GamePanel game = new GamePanel();
	private String ip = new String("");
	private FunctionPanel func = new FunctionPanel();
	
	public MainFrame() {		
		setTitle("AllaCleBattle");
		setLocation(new Point(700,350)); //��������� â�� ��ġ�� ����ش�.
		setPreferredSize(new Dimension(1500, 1000));//�������� â��ũ�� ����
		setResizable(false); //â ũ�� ����
		getContentPane().setLayout(null); //���̾ƿ� ����
		
		c.add(chat); //����
		c.add(score);
		c.add(game);
		c.add(func);
		
		chat.setBounds(1020,120,450,500);
		func.setBounds(1022, 640, 450, 316);
		score.setBounds(1020, 15, 450, 100);
		game.setBounds(20, 15 , 1000, 935);
		pack();//������Ʈ ũ�⸸ŭ â�� ũ�⸦ ����ش�.
		setLocationRelativeTo(null); //(null)�� �������ν� ȭ���߾ӿ� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//������â�� ������� ���μ����� ����
		setVisible(false); //�������� �����ش�.
	}
	public FunctionPanel getFunc() { //ChattingPanel getter
		return func;
	}
	
	public ChattingPanel getChat() { //ChattingPanel getter
		return chat;
	}

	public static ScorePanel getScore() {
		return score;
	}
	
	public GamePanel getGame() {
		return game;
	}
	public void newGame() { //��������� yes��ư Ŭ����
		remove(game); //���������ӿ��� game�г��� ��������
		game = new GamePanel(); //���� �����г��� �����ϰ�
		getContentPane().add(game); //�߰��Ѵ�
		game.setBounds(20, 15 , 1000, 935); //��ġ����
		this.repaint(); //���������ӿ� �ٽ� �׷��ش�.
	}
	
	public void viewTrue() { //ȣ�� �� mainFrame�� ȭ�鿡 ��� �޼ҵ�
		setVisible(true);
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getIp() {
		return ip;
	}
	
}

