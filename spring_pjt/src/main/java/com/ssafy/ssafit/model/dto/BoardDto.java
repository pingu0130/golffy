package com.ssafy.ssafit.model.dto;

public class BoardDto {
	private int BoardId;
	private int UserId;
	private String BoardTitle;
	private String BoardContent;
	private int BoardViewCnt;
	private int BoardLike;
	private int BoardDeleted;
	
	public BoardDto(int boardId, int userId, String boardTitle, String boardContent, int boardViewCnt, int boardLike, int boarddeleted) {
		super();
		BoardId = boardId;
		UserId = userId;
		BoardTitle = boardTitle;
		BoardContent = boardContent;
		BoardViewCnt = boardViewCnt;
		BoardLike = boardLike;
		BoardDeleted=boarddeleted;
	}

	public int getBoardId() {
		return BoardId;
	}

	public void setBoardId(int boardId) {
		BoardId = boardId;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getBoardTitle() {
		return BoardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		BoardTitle = boardTitle;
	}

	public String getBoardContent() {
		return BoardContent;
	}

	public void setBoardContent(String boardContent) {
		BoardContent = boardContent;
	}

	public int getBoardViewCnt() {
		return BoardViewCnt;
	}

	public void setBoardViewCnt(int boardViewCnt) {
		BoardViewCnt = boardViewCnt;
	}

	public int getBoardLike() {
		return BoardLike;
	}

	public void setBoardLike(int boardLike) {
		BoardLike = boardLike;
	}

	public int isBoardDeleted() {
		return BoardDeleted;
	}

	public void setBoardDeleted(int boardDeleted) {
		BoardDeleted = boardDeleted;
	}

	@Override
	public String toString() {
		return "BoardDto [BoardId=" + BoardId + ", UserId=" + UserId + ", BoardTitle=" + BoardTitle + ", BoardContent="
				+ BoardContent + ", BoardViewCnt=" + BoardViewCnt + ", BoardLike=" + BoardLike + ", BoardDeleted="
				+ BoardDeleted + "]";
	}
	
}
