package kr.co.Kmarket.vo.cs;

public class CsQnaVO {
	private int qnaNo;
	private int qnaCate1;
	private int qnaCate2;
	private String uid;
	private String qnaTitle;
	private String qnaContent;
	private String qnaAdminContent;
	private int qnaType;
	private String qnaRdate;
	private String qnaRegip;
	
	// 추가필드
	private String cate1Name;
	private String cate2Name;
	
	public int getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}
	public void setQnaNo(String qnaNo) {
		this.qnaNo = Integer.parseInt(qnaNo);
	}
	public int getQnaCate1() {
		return qnaCate1;
	}
	public void setQnaCate1(int qnaCate1) {
		this.qnaCate1 = qnaCate1;
	}
	public void setQnaCate1(String qnaCate1) {
		this.qnaCate1 = Integer.parseInt(qnaCate1);
	}
	public int getQnaCate2() {
		return qnaCate2;
	}
	public void setQnaCate2(int qnaCate2) {
		this.qnaCate2 = qnaCate2;
	}
	public void setQnaCate2(String qnaCate2) {
		this.qnaCate2 = Integer.parseInt(qnaCate2);
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public String getQnaContent() {
		return qnaContent;
	}
	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}
	public String getQnaAdminContent() {
		return qnaAdminContent;
	}
	public void setQnaAdminContent(String qnaAdminContent) {
		this.qnaAdminContent = qnaAdminContent;
	}
	public int getQnaType() {
		return qnaType;
	}
	public void setQnaType(int qnaType) {
		this.qnaType = qnaType;
	}
	public String getQnaRdate() {
		return qnaRdate;
	}
	public void setQnaRdate(String qnaRdate) {
		this.qnaRdate = qnaRdate;
	}
	public String getQnaRegip() {
		return qnaRegip;
	}
	public void setQnaRegip(String qnaRegip) {
		this.qnaRegip = qnaRegip;
	}
	
	// 추가 get set
	public String getCate1Name() {
		return cate1Name;
	}
	public void setCate1Name(String cate1Name) {
		this.cate1Name = cate1Name;
	}
	public String getCate2Name() {
		return cate2Name;
	}
	public void setCate2Name(String cate2Name) {
		this.cate2Name = cate2Name;
	}
}
