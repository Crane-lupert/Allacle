package sqq.biz;

import java.sql.*;
import java.util.*;

import sqq.dao.*;
import sqq.vo.*;

import static common.JDBCTemplate.*;

public class MyEmpBIZ {
	public int CreateMemberInsert(MyEmpVO vo) {
		Connection conn = getConnection();

		int res = new MyEmpDAO(conn).getCreateMemberInsertVO(vo);
		Close(conn);
		return res;
	}

	public int loginsaveInsert02(MyEmpVO vo) {
		Connection conn = getConnection();
		int res = new MyEmpDAO(conn).getGamesaveInsertVO02(vo);
		Close(conn);
		return res;
	}

	public int ChatsaveInsert03(MyEmpVO vo) {
		Connection conn = getConnection();

		int res = new MyEmpDAO(conn).ChatsaveInsert03(vo);
		Close(conn);
		return res;
	}

	public int bringout(MyEmpVO input_vo) {
		Connection conn = getConnection();
		int res = new MyEmpDAO(conn).bringout(input_vo);
		Close(conn);
		return res;
	}

	public int bringout2(MyEmpVO input_vo) {
		Connection conn = getConnection();
		int res = new MyEmpDAO(conn).bringout2(input_vo);
		Close(conn);
		return res;
	}

	public String ConvertToNick(String Id) {
		Connection conn = getConnection();
		String res = new MyEmpDAO(conn).ConvertToNick(Id);
		Close(conn);
		return res;
	}

	public MyEmpVO FFN(MyEmpVO input_vo) {
		Connection conn = getConnection();
		MyEmpVO res = new MyEmpDAO(conn).FFN(input_vo);
		Close(conn);
		return res;
	}
	public MyEmpVO FFNfromGame(MyEmpVO input_vo) {
		Connection conn = getConnection();
		MyEmpVO res = new MyEmpDAO(conn).FFNfromGame(input_vo);
		Close(conn);
		return res;
	}


	public int GameInsert04(MyEmpVO vo) {
		Connection conn = getConnection();
		int res = new MyEmpDAO(conn).getGameInsertVO04(vo);
		Close(conn);
		return res;
	}

	public MyEmpVO Find_Recent_Data(MyEmpVO input_vo) {
		Connection conn = getConnection();
		MyEmpVO res = new MyEmpDAO(conn).Find_Recent_Data(input_vo);
		Close(conn);
		return res;
	}

	public int Update_wrong(MyEmpVO vo) {
		Connection conn = getConnection();

		int res = new MyEmpDAO(conn).Update_wrong(vo);
		Close(conn);
		return res;
	}

	public int Update_score(MyEmpVO vo) {
		Connection conn = getConnection();

		int res = new MyEmpDAO(conn).Update_score(vo);
		Close(conn);
		return res;
	}

	public int Update_wl(MyEmpVO vo) {
		Connection conn = getConnection();

		int res = new MyEmpDAO(conn).Update_wl(vo);
		Close(conn);
		return res;
	}

	public MyEmpVO Select_joincount(MyEmpVO input_vo) {
		Connection conn = getConnection();
		MyEmpVO res = new MyEmpDAO(conn).Select_joincount(input_vo);
		Close(conn);
		return res;
	}
	public int Update_joincount(MyEmpVO vo) {
		Connection conn = getConnection();

		int res = new MyEmpDAO(conn).Update_joincount(vo);
		Close(conn);
		return res;
	}

	public int Update_enemyWrong(MyEmpVO vo) {
		Connection conn = getConnection();

		int res = new MyEmpDAO(conn).Update_enemyWrong(vo);
		Close(conn);
		return res;
	}
}
