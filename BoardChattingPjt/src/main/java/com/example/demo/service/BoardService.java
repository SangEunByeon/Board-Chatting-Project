package com.example.demo.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.demo.FileUploadService;
import com.example.demo.dao.IBoardDao;
import com.example.demo.dto.BoardDto;

@Service
public class BoardService implements IBoardService {
	
	@Autowired
	FileUploadService fileUploadService;
	
	@Autowired
	IBoardDao dao;
	
	@Override
	public void write(HttpServletRequest request, 
			MultipartHttpServletRequest mtfRequest, Model model) throws IOException, Exception {
		BoardDto dto = new BoardDto();
		dto.setTitle(request.getParameter("title"));
		dto.setWriter(request.getParameter("writer"));
		dto.setCategory(request.getParameter("category"));
		dto.setContents(request.getParameter("contents"));
		dto.setReg(new Date());
		List<MultipartFile> fileList = mtfRequest.getFiles("files");
		fileUploadService.restore(fileList);
		
		if(fileList.size()==1) {
			dto.setFile1("upload/"+fileList.get(0).getOriginalFilename());
			System.out.println("file1경로:"+"upload/"+fileList.get(0).getOriginalFilename());
		}else if(fileList.size()==2) {
			dto.setFile1("upload/"+fileList.get(0).getOriginalFilename());
			dto.setFile2("upload/"+fileList.get(1).getOriginalFilename());	
		}else if(fileList.size()==3) {
			dto.setFile1("upload/"+fileList.get(0).getOriginalFilename());
			dto.setFile2("upload/"+fileList.get(1).getOriginalFilename());	
			dto.setFile3("upload/"+fileList.get(2).getOriginalFilename());		
		}else if(fileList.size()==4) {
			dto.setFile1("upload/"+fileList.get(0).getOriginalFilename());
			dto.setFile2("upload/"+fileList.get(1).getOriginalFilename());	
			dto.setFile3("upload/"+fileList.get(2).getOriginalFilename());		
			dto.setFile4("upload/"+fileList.get(3).getOriginalFilename());		
		}else if(fileList.size()==5) {
			dto.setFile1("upload/"+fileList.get(0).getOriginalFilename());
			dto.setFile2("upload/"+fileList.get(1).getOriginalFilename());	
			dto.setFile3("upload/"+fileList.get(2).getOriginalFilename());		
			dto.setFile4("upload/"+fileList.get(3).getOriginalFilename());	
			dto.setFile5("upload/"+fileList.get(4).getOriginalFilename());	
		}
		dao.writeDao(dto);	
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
