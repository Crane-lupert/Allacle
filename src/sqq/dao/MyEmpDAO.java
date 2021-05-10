package sqq.dao;

import java.sql.*;
import java.util.*;

import static common.JDBCTemplate.*;
import oracle.jdbc.*;
import sqq.biz.*;
import sqq.vo.*;

public class MyEmpDAO implements MyEmpSql {

	private Connection conn;

	public MyEmpDAO(Connection conn) {
		this.conn = conn;
	}

	////// insert
	public int getCreateMemberInsertVO(MyEmpVO vo) {
		int res = 0;
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(member_insert);

			pstm.setString(1, vo.getID());
			pstm.setString(2, vo.getPW());
			pstm.setString(3, vo.getNICK());

			res = pstm.executeUpdate();
			if (res > 0) {
				Commit(conn);
			}
			System.out.println(res);
		} catch (Exception e) {
			try {
				e.printStackTrace();
				Rollback(conn);
			} finally {
				Close(pstm);
			}
		}
		return res;
	}

	public int getGamesaveInsertVO02(MyEmpVO vo) {
		int res = 0;
		CallableStatement pstm = null;
		try {
			pstm = conn.prepareCall(login_save);
			pstm.setString(1, vo.getID());
			pstm.setString(2, vo.getLoginTime());
			pstm.setString(3, vo.getNICK());
			res = pstm.executeUpdate();
			if (res > 0) {
				Commit(conn);
			}
			System.out.println(res);
		} catch (Exception e) {
			try {
				Rollback(conn);
			} finally {
				Close(pstm);
			}
		}
		return res;
	}

	public int ChatsaveInsert03(MyEmpVO vo) {
		int res = 0;
		CallableStatement pstm = null;
		try {
			pstm = conn.prepareCall(Chat_save);

			pstm.setString(1, vo.getNICK());
			pstm.setString(2, vo.getChat());
			pstm.setString(3, vo.getSendtitle());
			pstm.setString(4, vo.getID());
			res = pstm.executeUpdate();
			Commit(conn);

		} catch (Exception e) {
			try {				
				e.printStackTrace();
				Rollback(conn);
			} finally {
				Close(pstm);
			}
		}
		return res;
	}

	public int bringout(MyEmpVO input_vo) {
		CallableStatement pstm = null;
		int res = 0;
		MyEmpVO vo = null;
		try {
			pstm = conn.prepareCall(member_check);
			pstm.setString(1, input_vo.getID());
			pstm.setString(2, input_vo.getPW());
			
			res = pstm.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			Close(pstm);
		}
		return res;
	}

	public int bringout2(MyEmpVO input_vo) {
		CallableStatement pstm = null;
		int res = 0;
		try {
			pstm = conn.prepareCall(Nick_check);
			pstm.setString(1, input_vo.getNICK());
			res = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			Close(pstm);
		}
		return res;
	}

	public String ConvertToNick(String Id) {
		PreparedStatement pstm = null;
		ResultSet res = null;
		MyEmpVO vo = null;
		try {
			pstm = conn.prepareStatement(Id_check);
			pstm.setString(1, Id);
			res=pstm.executeQuery();
			if(res.next()) {//占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈뼓筌뤿슣�굲 if占쎈쐻占쎈뼢占쎈쿈占쎌굲 占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲.
				vo=new MyEmpVO(res.getString(1));
			}
		}catch(Exception e) {
			System.out.println(e.toString());
		}finally {
			Close(pstm);
		}
		return vo.getNICK();
	}

	public MyEmpVO FFN(MyEmpVO input_vo) {
		PreparedStatement pstm = null;
		ResultSet res = null;
		MyEmpVO vo = null;
		try {
			pstm = conn.prepareStatement(Nick_check);
			pstm.setString(1, input_vo.getNICK());
			res=pstm.executeQuery();
			if(res.next()) {
				vo=new MyEmpVO(res.getString(1),res.getString(2), res.getString(3));
			}
		}catch(Exception e) {
			System.out.println(e.toString());
		}finally {
			Close(pstm);
		}
		
		return vo;
	}
	public MyEmpVO FFNfromGame(MyEmpVO input_vo) {
		PreparedStatement pstm = null;
		ResultSet res = null;
		MyEmpVO vo = null;
		try {
			pstm = conn.prepareStatement(Nick_check2);
			pstm.setString(1, input_vo.getNICK());
			res=pstm.executeQuery();
			if(res.next()) {
				vo=new MyEmpVO();
				vo.setNICK(res.getString(1));
				vo.setID(res.getString(2));
				vo.setPW(res.getString(3));
				vo.setEnemy(res.getString(4));
				vo.setScore(res.getInt(5));
				}
		}catch(Exception e) {
			System.out.println(e.toString());
		}finally {
			Close(pstm);
		}
		
		return vo;
	}
	

	public int getGameInsertVO04(MyEmpVO vo) {
		int res = 0;
		CallableStatement pstm = null;
		try {
			pstm = conn.prepareCall(game_Insert);

			//pstm.setInt(1, vo.getJoinCount());
			pstm.setString(1, vo.getNICK());
			pstm.setString(2, vo.getEnemy());
			res = pstm.executeUpdate();
			if (res > 0) {
				Commit(conn);
			}
		} catch (Exception e) {
			try {
				e.printStackTrace();
				Rollback(conn);
			} finally {
				Close(pstm);
			}
		}
		return res;
	}
	public MyEmpVO Find_Recent_Data(MyEmpVO input_vo) {
		PreparedStatement pstm = null;
		ResultSet res = null;
		MyEmpVO vo = null;
		try {
			pstm = conn.prepareStatement(Find_recent_data);
			pstm.setString(1, input_vo.getNICK());
			res=pstm.executeQuery();
			if(res.next()) {
				vo=new MyEmpVO();
				vo.setNICK(res.getString(1));
				vo.setJoinCount(res.getInt(2));
				vo.setEnemy(res.getString(3));
				vo.setScore(res.getInt(4));
				vo.setG_StartTime(res.getString(5));
				vo.setWinlose(res.getInt(6));
				vo.setWrong(res.getString(7));
				}
		}catch(Exception e) {
			System.out.println(e.toString());
		}finally {
			Close(pstm);
		}
		
		return vo;
	}

	public int Update_wrong(MyEmpVO vo) {
		int res = 0;
		CallableStatement pstm = null;
		try {
			pstm = conn.prepareCall(Update_wrong);

			pstm.setString(1, vo.getWrong());
			pstm.setString(2, vo.getNICK());
			res = pstm.executeUpdate();
			if (res > 0) {
				Commit(conn);
			}
		} catch (Exception e) {
			try {
				Rollback(conn);
			} finally {
				Close(pstm);
			}
		}
		return res;
	}

	public int Update_score(MyEmpVO vo) {
		int res = 0;
		CallableStatement pstm = null;
		try {
			pstm = conn.prepareCall(Update_Score);

			pstm.setInt(1, vo.getScore());
			pstm.setString(2, vo.getNICK());
			res = pstm.executeUpdate();
			if (res > 0) {
				Commit(conn);
			}
		} catch (Exception e) {
			try {
				Rollback(conn);
			} finally {
				Close(pstm);
			}
		}
		return res;
	}

	public int Update_wl(MyEmpVO vo) {
		int res = 0;
		CallableStatement pstm = null;
		try {
			pstm = conn.prepareCall(Update_wl);

			pstm.setInt(1, vo.getWinlose());
			pstm.setString(2, vo.getNICK());
			res = pstm.executeUpdate();
			if (res > 0) {
				Commit(conn);
			}
		} catch (Exception e) {
			try {
				Rollback(conn);
			} finally {
				Close(pstm);
			}
		}
		return res;
	}

	public MyEmpVO Select_joincount(MyEmpVO input_vo) {
		PreparedStatement pstm = null;
		ResultSet res = null;
		MyEmpVO vo = null;
		try {
			pstm = conn.prepareStatement(Select_joinCount);
			pstm.setString(1, input_vo.getNICK());
			res=pstm.executeQuery();
			if(res.next()) {
				vo=new MyEmpVO();
				vo.setJoinCount(res.getInt(1));
				}
		}catch(Exception e) {
			System.out.println(e.toString());
		}finally {
			Close(pstm);
		}
		
		return vo;
	}
	public int Update_joincount(MyEmpVO vo) {
		int res = 0;
		CallableStatement pstm = null;
		try {
			pstm = conn.prepareCall(Update_JoinCount);

			pstm.setString(1, vo.getNICK());
			pstm.setString(2, vo.getNICK());
			pstm.setString(3, vo.getNICK());
			res = pstm.executeUpdate();
			if (res > 0) {
				Commit(conn);
			}
		} catch (Exception e) {
			try {
				Rollback(conn);
				e.printStackTrace();
			} finally {
				Close(pstm);
			}
		}
		return res;
	}

	public int Update_enemyWrong(MyEmpVO vo) {
		int res = 0;
		CallableStatement pstm = null;
		try {
			pstm = conn.prepareCall(Update_enemyWrong);

			pstm.setString(1, vo.getEnemyWrong());
			pstm.setString(2, vo.getNICK());
			res = pstm.executeUpdate();
			if (res > 0) {
				Commit(conn);
			}
		} catch (Exception e) {
			try {
				Rollback(conn);
				e.printStackTrace();
			} finally {
				Close(pstm);
			}
		}
		return res;
	}
}