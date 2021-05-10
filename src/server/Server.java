package server;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URISyntaxException;

import gui.IntroFrame;
import gui.MainFrame;
import thread.PreSettingThread;
import thread.ReceiveThread;

public class Server {

	public static MainFrame mainFrame;
	public static IntroFrame introFrame;

	public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
		mainFrame = new MainFrame(); // MainFrame ��ü�� �����Ѵ�. setVisible(false)�̱� ������ ������ �ʴ´�.
		introFrame = new IntroFrame(mainFrame); // ����ڷκ��� ip�� �г����� �Է¹ޱ� ���� Frame

		introFrame.getIpField().setText("ȣ��Ʈ�� �Է� ���ʿ�");

		// serverSocket = null;
		// clientSocket =null;
		try {

			ServerSocket serverSocket = new ServerSocket(8888); // ���������� ��Ʈ��ȣ�� �޾Ƽ� �ʱ�ȭ �Ѵ�.
			Socket clientSocket = serverSocket.accept(); // Ŭ���̾�Ʈ������ �������Ͽ� ������ �������� �ʱ�ȭ�Ѵ�.
			ReceiveThread reThread = new ReceiveThread(mainFrame, clientSocket); // �������� ���� ���� �޼����� ó���� ������
			PreSettingThread preSetThread = new PreSettingThread(mainFrame, clientSocket); // ���� ������ �ϰ� ���α׷��� ���������� �̾
																							// ������

			preSetThread.start();
			reThread.start();

		} catch (Exception e) {
			System.out.println(e);
			mainFrame.getChat().getTa().append("System :������� ������ ���������ϴ�.\n");
		}
	}
}