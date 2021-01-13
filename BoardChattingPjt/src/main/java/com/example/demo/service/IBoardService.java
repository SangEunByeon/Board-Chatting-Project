package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.demo.dto.BoardDto;
import com.example.demo.dto.Pagination;

public interface IBoardService {
	public void write(HttpServletRequest request, 
			MultipartHttpServletRequest fileList, Model model) throws IOException, Exception;
	public void modify();
	public void delete();
	
	// 페이징
	public List<BoardDto> getList(Pagination paging);
	public Integer[] getPageList(Integer pageNum);
	
	
	public BoardDto getWritting(int idx);
	public void hit(int idx);
	public int countContents();  // 전체 게시물 수
	
}
