package Folder;
import java.io.File;
public class MkDir {
    public static void mkdir() {
		
	String path = "C:/save_score/"; //���� ���
	File Folder = new File(path);

	// �ش� ���丮�� ������� ���丮�� �����մϴ�.
	if (!Folder.exists()) {
		try{
		    Folder.mkdir(); //���� �����մϴ�.
		    System.out.println("������ �����Ǿ����ϴ�.");
	        } 
	        catch(Exception e){
		    e.getStackTrace();
		}        
         }else {
		System.out.println("�̹� ������ �����Ǿ� �ֽ��ϴ�.");
	}
    }
}