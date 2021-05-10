package sqq.view;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import sqq.biz.MyEmpBIZ;
import sqq.vo.MyEmpVO;

public class MyEmpMenu {

	public static void Chatsave(String Nick, String chat, String Sendtitle) {
		MyEmpVO vo = MyEmpMenu.FindFromNick(Nick);
		vo.setChat(chat);
		vo.setSendtitle(Sendtitle);
		vo.setID(FindFromNick(Nick).getID());
		System.out.println("aaa");
		int res = new MyEmpBIZ().ChatsaveInsert03(vo);
		if (res > 0) {
			System.out.println("we'll remember this word");
		} else {
			System.out.println("warning : CharSave Fail!");
		}

	}

	public static void Gamesave(String Nick, String loginTime) {
		MyEmpVO vo = FindFromNick(Nick);
		vo.setLoginTime(loginTime);
		int res = new MyEmpBIZ().loginsaveInsert02(vo);
	}

	public static void CreateMember(String Id, String Pw, String Nick) {
		MyEmpVO vo = new MyEmpVO(Nick, Id, Pw);
		int res = new MyEmpBIZ().CreateMemberInsert(vo);
		if (res > 0) {
			System.out.println("welcome you black-cow");
		} else {
			System.out.println("12343");
		}

	}

	public static int CheckMember(String Id, String Pw) {
		MyEmpVO vo = new MyEmpVO();
		vo.setID(Id);
		vo.setPW(Pw);
		int res = new MyEmpBIZ().bringout(vo);
		return res;

	}

	public static int CheckNick(String Nick) {
		MyEmpVO vo = new MyEmpVO();
		vo.setNICK(Nick);
		int res = new MyEmpBIZ().bringout2(vo);
		return res;
	}

	public static String ConvertToNick(String Id) {
		String res = new MyEmpBIZ().ConvertToNick(Id);
		return res;
	}

	public static MyEmpVO FindFromNick(String Nick) {
		MyEmpVO vo = new MyEmpVO();
		vo.setNICK(Nick);
		MyEmpVO res = new MyEmpBIZ().FFN(vo);
		return res;
	}

	public static void Game(String Nick, String Enemy) {
		MyEmpVO vo = new MyEmpVO();
		vo.setNICK(Nick);
		//vo.setJoinCount(JoinCount);
		vo.setEnemy(Enemy);
		
		int res = new MyEmpBIZ().GameInsert04(vo);
		if (res > 0) {
			System.out.println("game complete");
		} else {
			System.out.println("game Fail!");
		}
	}

	public static MyEmpVO FFNfromGame(String Nick, int JoinCount) {
		MyEmpVO vo = new MyEmpVO();
		vo.setNICK(Nick);
		vo.setJoinCount(JoinCount);
		MyEmpVO res = new MyEmpBIZ().FFNfromGame(vo);
		return res;
	}
	public static MyEmpVO Find_Recent_Data(String Nick) {
		MyEmpVO vo = FindFromNick(Nick);
		vo.setNICK(Nick);
		MyEmpVO res = new MyEmpBIZ().Find_Recent_Data(vo);
		return res;
	}
	public static void Update_wrong(String wrong, String Nick) {
		MyEmpVO vo = FindFromNick(Nick);
		vo.setWrong(wrong);
		
		int res = new MyEmpBIZ().Update_wrong(vo);
		if (res > 0) {
			System.out.println("Update_wrong complete");
		} else {
			System.out.println("Update_wrong Fail!");
		}
	}
	public static void Update_enemyWrong(String enemyWrong, String Nick) {
		MyEmpVO vo = FindFromNick(Nick);
		vo.setWrong(enemyWrong);
		
		int res = new MyEmpBIZ().Update_enemyWrong(vo);
		if (res > 0) {
			System.out.println("Update_enemyWrong complete");
		} else {
			System.out.println("Update_enemyWrong Fail!");
		}
	}
	public static void Update_score(String Nick, int Score) {
		MyEmpVO vo = FindFromNick(Nick);
		vo.setScore(Score);
		
		int res = new MyEmpBIZ().Update_score(vo);
		if (res > 0) {
			System.out.println("Update_score complete");
		} else {
			System.out.println("Update_score Fail!");
		}
	}
	public static void Update_wl(String Nick, int winlose) {
		MyEmpVO vo = FindFromNick(Nick);
		vo.setScore(winlose);
		
		int res = new MyEmpBIZ().Update_wl(vo);
		if (res > 0) {
			System.out.println("Update_wl complete");
		} else {
			System.out.println("Update_wl Fail!");
		}
	}
	public static MyEmpVO Select_joincount(String Nick) {
		MyEmpVO vo = FindFromNick(Nick);
		MyEmpVO res = new MyEmpBIZ().Select_joincount(vo);
		return res;
	}
	public static void Find_Recent_DataDownload(String Nick) {
	      MyEmpVO vo = FindFromNick(Nick);
	      vo.setNICK(Nick);
	      MyEmpVO res = new MyEmpBIZ().Find_Recent_Data(vo);
	      BufferedWriter fw;
	      try {
	         fw = new BufferedWriter(new FileWriter("result_data.txt", true));
	         fw.write("\n");
	         fw.write(res.getNICK());
	         fw.write(",");
	         fw.write(res.getG_StartTime());
	         fw.write(",");
	         if(res.getWinlose()!=0) {
	            fw.write(res.getEnemy());
	         }else {
	            fw.write(res.getNICK());
	         }
	         fw.write(",");
	         
	         fw.write(res.getWrong());
	         fw.write(",");
	         fw.write(res.getEnemy());
	         fw.write(",");
	         fw.write(res.getEnemyWrong());
	         fw.write("\n");
	         fw.flush();
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      
	   }
	public static void Update_joincount(String Nick) {
		MyEmpVO vo = FindFromNick(Nick);
		int res = new MyEmpBIZ().Update_joincount(vo);
		if (res > 0) {
			System.out.println("Update_joincount complete");
		} else {
			System.out.println("Update_joincount Fail!");
		}
	}
}
