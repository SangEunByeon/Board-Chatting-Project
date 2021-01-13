package com.example.demo.dto;

import lombok.Data;

@Data
public class Pagination {

	private int page; // 현재 페이지 숫자  pageNum
	private int contentNum = 5; // 한 페이지에 나올 게시물 수
	private int totalContents; // 전체 게시글 갯수
	
	private int totalPages; // 전체 페이지 갯수
	
	private int startIdx = 0; // 한 페이지 시작 게시글, 0부터 시작
	
	private int blockSize=5; // 페이징된 버튼의 블럭당 최대갯수
	private int totalBlocks; // 총 블록 갯수
	private int block; // 현재블록
	
	private int startPage =1; // 블럭 시작 페이지
	private int endPage =1; // 블럭 마지막 페이지
	
	/** 11. 이전 블럭의 마지막 페이지 **/
	private int prevBlock;

	/** 12. 다음 블럭의 시작 페이지 **/
	private int nextBlock;
	
	
	public Pagination(int pageNum, int totalContent){ 
						// 현재 페이지, 토탈 게시물 수
		this.page = pageNum;
		this.totalContents = totalContent;
		
		/** 총 페이지 수  **/
		this.totalPages = (int)Math.ceil(totalContents * 1.0/contentNum);
		
		/** 총 블럭의 수  **/
		this.totalBlocks = (int)Math.ceil(totalPages * 1.0/blockSize);
		
		/** 현재 블럭 수  **/
		this.block = (int)Math.ceil(page * 1.0 / blockSize); 
		
		/** 8. 블럭 시작 페이지 
		 * << "1" 2 3 4 5 >>  
		 * << "6" 7 8 9 10 >>**/
		this.startPage=((block - 1) * blockSize + 1);
		
		/** 9. 블럭 마지막 페이지 **/
		this.endPage = (startPage + blockSize - 1);
		
		if(endPage > totalPages){this.endPage = totalPages;}
		
		this.prevBlock=(block * blockSize) - blockSize; // o	
		if(prevBlock < 1) {this.prevBlock = 1;}
		
		/** 12. 다음 블럭(클릭 시, 다음 블럭 첫번째 페이지) **/
		this.nextBlock = (block * blockSize) + 1;
		if(nextBlock > totalPages) {nextBlock = totalPages;}
	
		this.startIdx =((pageNum-1)*contentNum);
	}
	
	
	// 전체 페이지 계산
	public int calTotalPage(int totalContent, int contentNum) {
		int totalPage = (int) Math.ceil((totalContent*1.0 / contentNum)); // 올림
		return this.totalPages = totalPage;
	}
	


	
	
	
	
	
}

    
  
