package sqq.vo;
//vo(value object) : MVC �뜝�럥�넮�뜝�럡�돇�뜝�럥�뱺 �뤆�룆占썬굦諭� �뜝�럩�쓧�뜝�럥堉롥뜝�럥由��뜝�럥裕� �뜝�럥�뿴�뜝�럥留� _beans 


public class MyEmpVO {
//EMPNO, ENAME, DEPTNO	
	private String NICK;
	private String ID;
	private String PW;
	private int JoinCount;
	private String enemy;
	private int Score;
	private String G_StartTime;
	private String Time;
	private String Chat;
	private String Sendtitle;
	private String Wrong;
	private String enemyWrong;
	private String Right;
	private String LoginTime;
	private int winlose;

	public int getWinlose() {
		return winlose;
	}

	public void setWinlose(int winlose) {
		this.winlose = winlose;
	}

	public String getLoginTime() {
		return LoginTime;
	}

	public void setLoginTime(String loginTime) {
		LoginTime = loginTime;
	}

	public MyEmpVO() {
		NICK = "121212121212";
		ID = "212121212121";
		PW = "313131313131";
	}

	

	public MyEmpVO(String nICK, String iD, String pW, String time, String chat, String sendtitle) {
		super();
		NICK = nICK;
		ID = iD;
		PW = pW;
		Time = time;
		Chat = chat;
		Sendtitle = sendtitle;
	}

	public String getNICK() {
		return NICK;
	}

	public void setNICK(String nICK) {
		NICK = nICK;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPW() {
		return PW;
	}

	public void setPW(String pW) {
		PW = pW;
	}

	public int getJoinCount() {
		return JoinCount;
	}

	public void setJoinCount(int joinCount) {
		JoinCount = joinCount;
	}

	public String getEnemy() {
		return enemy;
	}

	public void setEnemy(String enemy) {
		this.enemy = enemy;
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}
	
	public String getG_StartTime() {
		return G_StartTime;
	}

	public void setG_StartTime(String g_StartTime) {
		G_StartTime = g_StartTime;
	}



	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public String getChat() {
		return Chat;
	}

	public void setChat(String chat) {
		Chat = chat;
	}

	public String getSendtitle() {
		return Sendtitle;
	}

	public void setSendtitle(String sendtitle) {
		Sendtitle = sendtitle;
	}

	public MyEmpVO(String nICK, String iD, String pW) {
		super();
		NICK = nICK;
		ID = iD;
		PW = pW;
	}

	public MyEmpVO(String iD, String pW) {
		super();
		ID = iD;
		PW = pW;
	}

	public MyEmpVO(String nICK) {
		super();
		NICK = nICK;
	}

	public String getWrong() {
		return Wrong;
	}

	public void setWrong(String wrong) {
		Wrong = wrong;
	}

	public String getRight() {
		return Right;
	}

	public void setRight(String right) {
		Right = right;
	}

	public String getEnemyWrong() {
		return enemyWrong;
	}

	public void setEnemyWrong(String enemyWrong) {
		this.enemyWrong = enemyWrong;
	}

	@Override
	public String toString() {
		return String.format("MyEmpVO [NICK=%s, ID=%s, PW=%s, Time=%s, Chat=%s, Sendtitle=%s]", NICK, ID, PW, Time,
				Chat, Sendtitle);
	}

	

}
