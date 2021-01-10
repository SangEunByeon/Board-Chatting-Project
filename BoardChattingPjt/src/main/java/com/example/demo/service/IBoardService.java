package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.demo.dto.BoardDto;

public interface IBoardService {
	public void write(HttpServletRequest request, 
			MultipartHttpServletRequest fileList, Model model) throws IOException, Exception;
	public void modify();
	public void delete();
	public List<BoardDto> getList();
	public BoardDto getWritting();
}
