package a_File_transform;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import gui.Filesendconfirm;
import gui.inputIpAddress;
import Folder.MkDir;

public class ClientFile {
	//static inputIpAddress IPad = new inputIpAddress();
	static Filesendconfirm fsc = new Filesendconfirm();
   public static void clf() {
      String serverIp = inputIpAddress.ipInputField.getText().toString().trim();
      MkDir.mkdir();
      try (Socket socket = new Socket(serverIp, 6547);
            BufferedInputStream bin = new BufferedInputStream(socket.getInputStream());
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedOutputStream bout = new BufferedOutputStream(
                  new FileOutputStream(new File("C:/save_score/" + System.currentTimeMillis() + ".txt")));) {
         byte[] buffer = new byte[1000];
         int readed = -1;
         while ((readed = bin.read(buffer)) > 0) {
            bout.write(buffer, 0, readed);
         }
         bout.flush();
         bout.close();
         // bw.write("잘 받았습니다.");
         // bw.flush();
         
         System.out.println("파일 전송 완료!!");
         fsc.setVisible(true);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}