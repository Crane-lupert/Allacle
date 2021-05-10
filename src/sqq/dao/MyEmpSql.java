package sqq.dao;

public interface MyEmpSql {

	String member_check = "SELECT * FROM member2 WHERE ID =? AND PW=?";
	String Nick_check = "SELECT Nick, Id, Pw FROM member2 WHERE Nick=?";
	String Id_check = "SELECT Nick FROM member2 WHERE ID=?";
	String Nick_check2 = "SELECT Nick, Id, Pw, Enemy, Score, "
			+ "Exam1, Exam2, Exam3 FROM Game WHERE Nick=? AND JOINCOUNT = ?";

	String member_insert = "insert into member2(ID,PW,NICK) values(?,?,?)";
	//String Join_Game = "insert into Game2(Nick,Id,JoinCount,LoginTime) values(?,?,?,?)";
	
	String game_Insert = "insert into Game2(Nick, Enemy) values(?,?)";
	String login_save = "insert into Connect_log(ID, LoginTime, nick)"
			+"values(?,?,?)";

	
	String Chat_save = "insert into Chatting_p2p2(Nick, Chat, Sendtitle,id) values(?,?,?,?)";
	String Find_recent_data = "select Nick, Joincount, enemy, Score, g_starttime, winlose, wrong from game2 where nick = ? and "
			+ "joincount=(select max(joincount) from game2)";
	
	
	String Update_Score = "Udpate Game2 set Score = ?"
			+ "where nick=? and joincount = (select max(joincount) from game2)";
	String Update_wl = "Update Game2 set winlose = ?"
			+ "where nick=? and joincount = (select max(joincount) from game2)";
	String Select_joinCount = "select joincount from game2"
			+ "where nick = ? and joincount = (select max(joincount) from game2)";
	String Update_JoinCount = "Update Game2 set joincount = 1+"
			+ "(select joincount from game2 where nick = ? and joincount = "
			+ 		"(select max(joincount) from game2 where nick=?))"
			+ "where nick = ? and joincount = -1";
	String Update_wrong = "Update Game2 set wrong ="
			+ 		"(select wrong from game2 where joincount = "
			+ 											"(select max(joincount) from game2))"
			+ 																			"||'/'||?"
			+ "where nick = ? and joincount = (select max(joincount) from game2)";
	String Update_enemyWrong = "Update Game2 set enemyWrong ="
			+ 		"(select enemyWrong from game2 where joincount = "
			+ 											"(select max(joincount) from game2))"
			+ 																			"||'/'||?"
			+ "where nick = ? and joincount = (select max(joincount) from game2)";
}
