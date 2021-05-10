package thread;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URISyntaxException;

import javax.swing.JLabel;

import gui.MainFrame;
import question.Question;
import userState.UserState;


public class ReceiveThread extends Thread {
	private JLabel myNickName = new JLabel("");
	private JLabel yourNickName = new JLabel("");
	private Socket socket;
	private MainFrame mainFrame; //�߰�
	private int sqlwrong= 1;
	private static boolean start = false;
	
	
	public ReceiveThread(MainFrame mainFrame, Socket socket) throws FileNotFoundException, URISyntaxException{ //������ �߰�
		this.mainFrame = mainFrame;
		this.socket = socket;
	}

	@Override
	public void run() {
		super.run();

		try {
			//Ŭ���̾�Ʈ ������ ��ǲ��Ʈ������ Ŭ���̾�Ʈ ������ ���� ������ �޴´�.
			
			//����� ������ inputStream�� outputStream���� �ְ��ޱ����� ���� �ʱ�ȭ
			BufferedReader buf = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
			PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
			Question catchNull = new Question(); ////�����ڼ� �����̹����� ���� �߰��Ͽ��⿡ static�̿��� ��ü�� �������� ������ nullPoint������ �߻�	
			
			while(true) {
				String receiveString = buf.readLine(); //Ŭ���̾�Ʈ�� ���� ���ڿ���  �о receiveString�� �����Ѵ�.
				String [] receiveArray = receiveString.split("/"); // "/"�� �������� receiveString�� ����� �迭�� ����.

				switch(receiveArray[0]) { //������ ���ڿ� �� �Ǿ� ���ڿ��� �������� ������ ���ϴ��� �Ǵ��Ѵ�.
				
				case "chat": //ä��
					mainFrame.getChat().getTa().append(receiveArray[1]+"\n"); //�� ä��â�� �޾ƿ� �޽����� �߰��Ѵ�.
					break;	
					
				case "nickName" : //�г���
					mainFrame.getScore().setYourNickName(receiveArray[1]); //�޾ƿ� �г������� ��� �г��� �ʱ�ȭ
					break;
					
				case "ready" : //�غ�Ϸ� 
					if(UserState.isPlayOk()) { //���� �غ�Ϸ� �Ǿ��� ���
						System.out.println(mainFrame.getScore().getMyNickName());
						System.out.println(mainFrame.getScore().getYourNickName(receiveArray[0]));
						sqq.view.MyEmpMenu.Game(mainFrame.getScore().getMyNickName(),mainFrame.getScore().getYourNickName(receiveArray[0]));
						sqq.view.MyEmpMenu.Update_joincount(mainFrame.getScore().getMyNickName());
						writer.println("start/"); //��뿡�� start�� ������
						mainFrame.getGame().getReadyOk().setVisible(false); //�غ�Ϸ� ��ư�� ������� �Ѵ�.
						mainFrame.getGame().setATFwithEnter(); //��������� �ؽ�Ʈ�ʵ�� ��ư�� �߰�
						mainFrame.getGame().getRuleButton().setVisible(false); //���Ӽ��� ��ư�� ������� �Ѵ�.
						mainFrame.getChat().getTa().append("System :������ �����մϴ�.\n"); 
						
						SetGoalThread setGoalThread = new SetGoalThread(mainFrame, socket); //�Ѹ��� �÷��̾ ��ǥ������ �����Ѵ�.
						setGoalThread.start(); 
						break;
					}
					break;
					
				case "start" : //����
					//���۽�ȣ�� ���� ���浵 �Ȱ��� ȯ���� ������ش�.
					mainFrame.getGame().getReadyOk().setVisible(false);       
					mainFrame.getGame().setATFwithEnter(); 						
					mainFrame.getGame().getRuleButton().setVisible(false);
					mainFrame.getChat().getTa().append("System :������ �����մϴ�.\n");                                                                                         
					
					//���� �÷��̾ ��ǥ������ ������ ���� ��ٷ� �޶�� �̹����� ǥ���Ѵ�.
					mainFrame.getGame().getWaitGoalScore().setVisible(true);
					break;
					
				case "goal" ://��ǥ����
					mainFrame.getGame().getWaitGoalScore().setVisible(false); //��ǥ���� �������� ��ٷ��޶�� �̹����� �Ⱥ��̰� �Ѵ�.
					mainFrame.getGame().setGoalScore(Integer.parseInt(receiveArray[1])); //�޾ƿ� ��ǥ������ Integer�� �ٲ��� �����гο� �ʱ�ȭ�Ѵ�.
					break;
					
				case "questionList" ://�������, ���� ������ �����ֱ� ���� ���ʿ����� ���� ������ ����� �޾ƾ��Ѵ�.
					String [] questionArray = new String[receiveArray.length-1];//��������� �޾ƿ��� ���� String�� �迭
					for(int i=1; i<receiveArray.length; i++) { //receiveArray[0]�� questionList��� Ű����� ������ i=1�̴�.
						questionArray[i-1] = receiveArray[i]; // questionArray[0]���� ���� ����������� ä���.
					}
					GameThread gameThread = new GameThread(mainFrame, socket, questionArray); //�޾ƿ� ����������� ���Ӿ����带 �ʱ�ȭ�� ����
					gameThread.start();
					break;
					
				case "answer": //���� ���� , �� ������ ������ ������ �����̴�, ������ �´��� QuestionŬ������ QuestionMap�� ������ȣ�� key�� value�� ���Ѵ�. 
						receiveArray[2] = receiveArray[2].toUpperCase(); //�빮�ڷ� �ٲ㼭 �ٽ� ����
					if(Question.getQuestionMap().get(receiveArray[1]).equals(receiveArray[2])) { //�¾��� ��
						UserState.setOtherCorrect(true);; //������ �¾����� �˸���.
						mainFrame.getScore().addYourScore(); //�������� �ø���.
						mainFrame.getScore().repaint(); //���ھ �ٽñ׸���.
						TimerThread.setTimerStop(true); //Ÿ�̸Ӹ� ���� �� ���� ������ �� �ְ� �Ѵ�.
						writer.println("answerOk/"); //���濡�� ������ �´ٰ� ������.
						sqlwrong++;
						break;
					}
					else { //������ Ʋ���� ��
						writer.println("answerWrong/"); // ���濡�� ������ �ƴ϶�� ������.
						sqq.view.MyEmpMenu.Update_enemyWrong(""+sqlwrong+" ", mainFrame.getScore().getMyNickName());
						break;
					}

				case "answerOk": //������ ���� �¾��� ��
					UserState.setMyCorrect(true); //�����¾����� �˸���.
					TimerThread.setTimerStop(true); //Ÿ�̸Ӹ� ���� �� ���� ������ �� �ְ� �Ѵ�.
					mainFrame.getScore().addMyScore(); //���� ������ �ø���.
					mainFrame.getScore().repaint(); //���ھ �ٽ� �׸���.
					sqlwrong++;
					break;
				
				case "answerWrong" : //���� Ʋ���� ��
					UserState.setWrong(true); //���� Ʋ������ �˸���.
					sqq.view.MyEmpMenu.Update_wrong(""+sqlwrong+" ", mainFrame.getScore().getMyNickName());
				
					break;
					
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}