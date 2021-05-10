package thread;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import gui.MainFrame;

import question.Question;
import userState.UserState;

public class GameThread extends Thread {
	private JLabel myNickName = new JLabel("");
	private int jc = 0;
	
	private MainFrame mainFrame; //����������
	private Socket socket; //����� ����
	private PrintWriter writer; //��� ReceiveThread�� ���� ����
	private String[] questionArray; //������� �迭
	private int questionIndex = 0; //������� �迭�� ���� �ε����� ��Ÿ�� ����
	private TimerThread timer; //Ÿ�̸� ����
	private Question catchNull = new Question(); //�����ڿ��� �����̹����� ��Ʈ�̹����� �߰��Ͽ��� ������ static�̿��� ��ü�� �������� ������ nullPoint������ �߻�	

	public GameThread(MainFrame mainFrame, Socket socket, String [] questionArray)  {
		this.mainFrame = mainFrame;
		this.socket = socket;
		this.questionArray = questionArray;
		this.timer = new TimerThread(mainFrame);
	}

	@Override
	public void run() {
		try {
			writer = new PrintWriter(socket.getOutputStream(),true); //writer�� ������ outPutStream���� �ʱ�ȭ
			mainFrame.getGame().getEnter().addActionListener(new AnswerSendEvent()); //���� �г��� ����� ������ ��ư�� ���� ������ �߰�
			mainFrame.getGame().getTf().addActionListener(new AnswerSendEvent()); //�ؽ�Ʈ�ʵ忡�� ���͸� ġ�� �����ε� ������ �� �ְ� �׼� ������ �߰�
			mainFrame.getGame().getQuiz().setVisible(true); //�����г��� quiz���� �����ش�. StratCount3.png�� setIcon�Ǿ��ִ�. 3�� �����ش�
			Thread.sleep(1000); //1�� ����
			mainFrame.getGame().getQuiz().setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("StartCount2.png")));//2�� �����ش�
			Thread.sleep(1000);//1�ʽ���
			mainFrame.getGame().getQuiz().setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("StartCount1.png"))); //1�� �����ش�
			Thread.sleep(1000); //1�ʽ���
			mainFrame.getGame().getQuiz().setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("GameStart.png"))); //������ �����Ѵٴ� �� �˸��� �̹����� �ٲ۴�.
			Thread.sleep(1000); //1�ʽ���
			mainFrame.getGame().getTimer().setVisible(true); //�����г��� Ÿ�̸� ���� �����ְ�
			timer.start(); //Ÿ�̸� �����带 ���� ��Ų��.
			
			while(true) { //���� ����
				//�׻� �̹��� ������ �� �ְ�
				mainFrame.getGame().getQuiz().setIcon
				(new ImageIcon(this.getClass().getClassLoader().getResource(questionArray[questionIndex])));
				
				if(UserState.isOtherCorrect()|| UserState.isMyCorrect()) { //������ ������ ��, ���� �� ���� ������ �� -> �� ����
					questionIndex++; //���� �ε��� +1
					if(UserState.isOtherCorrect()) { //���� ������ ������ ��
						mainFrame.getGame().getQuiz().setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("OtherCorrect.png"))); //������ ����ٴ� �̹����� �ٲ۴�
						Thread.sleep(2000);
						UserState.setOtherCorrect(false); //ReceiveThread���� �ٲ�  OhterCorrect�� false�� �ٽ� �ʱ�ȭ
						
					}
					else { //���� ������ ��
						mainFrame.getGame().getQuiz().setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("AnswerOk.png"))); //����ٴ� �̹����� �ٲ� ��
						Thread.sleep(2000);
						UserState.setMyCorrect(false); //ReceiveThread���� �ٲ� myCorrect�� false�� �ٽ� �ʱ�ȭ
						
					}
				}
				
				if(UserState.isWrong()) { //���� �� ���� ������ �ƴ� ��
					mainFrame.getGame().getQuiz().setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("AnswerWrong.png"))); //Ʋ�ȴٴ� �̹����� �����ش�.
					Thread.sleep(2000);
					UserState.setWrong(false); //ReceiveThread���� �ٲ�  wrong�� false�� �ٽ� �ʱ�ȭ
				}
				
				

				if(UserState.isTurnEnd()) { //�ð� ���� , �� ����
					questionIndex++;//�����ε��� +1
					UserState.setTurnEnd(false); //ReceiveThread���� �ٲ� turnEnd�� �ٽ� false�� �ʱ�ȭ
				}
				//���� �̱�ų�, ������ �̰��� ��
				if(mainFrame.getScore().getMyScore() == mainFrame.getGame().getGoalScore() || mainFrame.getScore().getYourScore() == mainFrame.getGame().getGoalScore()) { 
					timer.killTimer(); //Ÿ�̸� �����带 ���δ�.
					mainFrame.getGame().setYesAndNo();//�����г��� setYesAndNo�޼ҵ� ����
					mainFrame.getGame().getGoback().addActionListener(new YesOrNoEvent()); //Yes��ư�� �׼Ǹ����� �߰�
					
					if(mainFrame.getScore().getYourScore() == mainFrame.getGame().getGoalScore()){ //������ �̰��� ��
						mainFrame.getGame().getQuiz().setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("YouLose.png"))); //���ٴ� �̹����� �ٲ� ��
					sqq.view.MyEmpMenu.Update_wl(mainFrame.getScore().getMyNickName(), 0);
					}else { //���� �̰��� ��
						mainFrame.getGame().getQuiz().setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("YouWin.png"))); //�̰�ٴ� �̹����� �ٲ� ��
						sqq.view.MyEmpMenu.Update_wl(mainFrame.getScore().getMyNickName(), 1);
					}
					break;
				}
				
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		} 
	}
	
	class AnswerSendEvent implements ActionListener{ //enterŰ�� ���� ���� "����"��ư�� ������ ���� �̺�Ʈ Ŭ����
		@Override
		public void actionPerformed(ActionEvent e) { 
			String 	answer =mainFrame.getGame().getTf().getText().toString().trim(); //�ý�Ʈ �ʵ忡 �ִ� ���ڿ��� String���� answer�� �����Ѵ�.
			if(answer.length()!=0) //������ ���� �ƴ� ��
				writer.println("answer/" + questionArray[questionIndex] + "/" + answer); //Ű����� �����̸�,������ ���� ������. 
			mainFrame.getGame().getTf().setText(""); //�ؽ�Ʈ �ʵ带 �ٽ� �ƹ��͵� ���� ���·� �����.
			writer.flush(); //���۸��Ǿ� ���� ��ϵ��� ���� �����͸� ��� ��Ʈ���� ��� ����Ѵ�.			}
		}
	}
	class YesOrNoEvent implements ActionListener{ //��������� Yes��No��ư�� ������ �� �̺�Ʈ
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(mainFrame.getGame().getGoback())){ //Yes��ư�� ������ ���
				mainFrame.newGame(); //������������ newGame�޼ҵ� �����Ͽ� game�г� �� ����
				mainFrame.getScore().scoreReset(); //������������ ���ھ��г��� scoreReset()�޼ҵ带 �����Ͽ� score�� �ʱ�ȭ
				UserState.setPlayOk(false);
				PreSettingThread preSetThread = new PreSettingThread(mainFrame, socket); //�����غ�Thread�� �ٽ� ����
				preSetThread.start();
			}
			else //No��ư ������ ���
				System.exit(0); //���α׷� ���� 
		}
	}
}
