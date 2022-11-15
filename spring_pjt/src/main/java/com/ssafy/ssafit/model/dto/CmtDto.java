package com.ssafy.ssafit.model.dto;

public class CmtDto {
	private int cmt_id;
	private String cmt;
	private boolean cmt_deleted;
	public CmtDto(int comment_id, String cmt, boolean cmt_deleted) {
		super();
		this.cmt_id = comment_id;
		this.cmt = cmt;
		this.cmt_deleted = cmt_deleted;
	}
	public int getComment_id() {
		return cmt_id;
	}
	public void setComment_id(int comment_id) {
		this.cmt_id = comment_id;
	}
	public String getCmt() {
		return cmt;
	}
	public void setCmt(String cmt) {
		this.cmt = cmt;
	}
	public boolean isCmt_deleted() {
		return cmt_deleted;
	}
	public void setCmt_deleted(boolean cmt_deleted) {
		this.cmt_deleted = cmt_deleted;
	}
	@Override
	public String toString() {
		return "CmtDto [cmt_id=" + cmt_id + ", cmt=" + cmt + ", cmt_deleted=" + cmt_deleted + "]";
	}
}
