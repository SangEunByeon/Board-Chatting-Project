package com.example.demo.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.demo.FileUploadService;

@Service
public class BoardService implements IBoardService {
	
	@Autowired
	FileUploadService fileUploadService;
	
	@Override
	public void write(HttpServletRequest request, 
			MultipartHttpServletRequest fileList, Model model) {
		
		
	}

	@Override
	public void modify() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}
