package kr.co.Kmarket.vo.cs;

public class CsFaqVO {
	private int faqNo;
	private int faqCate1;
	private int faqCate2;
	private String faqTitle;
	private String faqContent;
	private String faqRegip;
	
	private String cate2Name;
	
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
	public int getFaqCate1() {
		return faqCate1;
	}
	public void setFaqCate1(int faqCate1) {
		this.faqCate1 = faqCate1;
	}
	public int getFaqCate2() {
		return faqCate2;
	}
	public void setFaqCate2(int faqCate2) {
		this.faqCate2 = faqCate2;
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
