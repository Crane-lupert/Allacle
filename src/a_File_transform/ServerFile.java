package a_File_transform;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile {
   
	public static void servf() {
      try (ServerSocket ss = new ServerSocket(6547)) {
         while (true) {
            try (Socket socket = ss.accept();
                  BufferedOutputStream bout = new BufferedOutputStream(socket.getOutputStream());
                  BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                  BufferedInputStream bin = new BufferedInputStream(
                        new FileInputStream(new File("result_data.txt")));) {
               byte[] buffer = new byte[1000];
               int readed = -1;
               
               while ((readed = bin.read(buffer)) > 0) {
                  bout.write(buffer, 0, readed);
               }
               bout.flush();              
               
               bin.close();
               br.close();
               bout.close();
               ss.close();
               
               // System.out.println(br.readLine());
            } catch (IOException e) {
               System.out.println("통신 오류");
            } break;
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}