package kr.co.Kmarket.vo.cs;

public class CsFaqVO {
	private int faqNo;
	private int faqCate1;
	private int faqCate2;
	private String faqTitle;
	private String faqContent;
	private String faqRegip;
	private int faqHit;
	private String faqRdate;
	
	private String cate1Name;
	private String cate2Name;
	
	
	
	public String getFaqRdate() {
		return faqRdate;
	}
	public void setFaqRdate(String faqRdate) {
		this.faqRdate = faqRdate;
	}
	public int getFaqHit() {
		return faqHit;
	}
	public void setFaqHit(int faqHit) {
		this.faqHit = faqHit;
	}
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
	public int getFaqNo() {
		return faqNo;
	}
	public void setFaqNo(int faqNo) {
		this.faqNo = faqNo;
	}
	public void setFaqNo(String faqNo) {
		this.faqNo = Integer.parseInt(faqNo);
	}
	public int getFaqCate1() {
		return faqCate1;
	}
	public void setFaqCate1(int faqCate1) {
		this.faqCate1 = faqCate1;
	}
	public void setFaqCate1(String faqCate1) {
		this.faqCate1 = Integer.parseInt(faqCate1);
	}
	public int getFaqCate2() {
		return faqCate2;
	}
	public void setFaqCate2(int faqCate2) {
		this.faqCate2 = faqCate2;
	}
	public void setFaqCate2(String faqCate2) {
		this.faqCate2 = Integer.parseInt(faqCate2);
	}
	public String getFaqTitle() {
		return faqTitle;
	}
	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}
	public String getFaqContent() {
		return faqContent;
	}
	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}
	public String getFaqRegip() {
		return faqRegip;
	}
	public void setFaqRegip(String faqRegip) {
		this.faqRegip = faqRegip;
	}
}
