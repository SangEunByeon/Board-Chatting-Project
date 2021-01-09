package com.example.demo.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface IBoardService {
	public void write(HttpServletRequest request, 
			MultipartHttpServletRequest fileList, Model model);
	public void modify();
	public void delete();
}
