package kr.co.Kmarket.vo.cs;

public class CsNoticeVO {
	private int noticeNo;
	private int noticeCate;
	private String noticeTitle;
	private String noticeContent;
	private String noticeRdate;
	private String noticeRegip;
	private int noticeHit;
	
	
	public int getNoticeHit() {
		return noticeHit;
	}
	public void setNoticeHit(int noticeHit) {
		this.noticeHit = noticeHit;
	}
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public void setNoticeNo(String noticeNo) {
		this.noticeNo = Integer.parseInt(noticeNo);
	}
	public int getNoticeCate() {
		return noticeCate;
	}
	public void setNoticeCate(int noticeCate) {
		this.noticeCate = noticeCate;
	}
	public void setNoticeCate(String noticeCate) {
		this.noticeCate = Integer.parseInt(noticeCate);
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public String getNoticeRdate() {
		return noticeRdate;
	}
	public void setNoticeRdate(String noticeRdate) {
		this.noticeRdate = noticeRdate;
	}
	public String getNoticeRegip() {
		return noticeRegip;
	}
	public void setNoticeRegip(String noticeRegip) {
		this.noticeRegip = noticeRegip;
	}
}
