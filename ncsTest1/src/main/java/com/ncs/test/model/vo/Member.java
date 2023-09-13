package com.ncs.test.model.vo;

import java.util.Date;


public class Member {
	
	private String memberId;
	private String memberPwd;
	private String memberNm;
	private Date memberEnrollDate;
	
	public Member() {}

	public Member(String memberId, String memberPwd, String memberNm, Date memberEnrollDate) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberNm = memberNm;
		this.memberEnrollDate = memberEnrollDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberNm() {
		return memberNm;
	}

	public void setMemberNm(String memberNm) {
		this.memberNm = memberNm;
	}

	public Date getMemberEnrollDate() {
		return memberEnrollDate;
	}

	public void setMemberEnrollDate(Date memberEnrollDate) {
		this.memberEnrollDate = memberEnrollDate;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberNm=" + memberNm
				+ ", memberEnrollDate=" + memberEnrollDate + "]";
	}
	
}
