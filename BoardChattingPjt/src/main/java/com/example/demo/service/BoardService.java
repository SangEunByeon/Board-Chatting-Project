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
		dto.setHit(0);
		dto.setReg(new Date());
		List<MultipartFile> fileList = mtfRequest.getFiles("files");
		List<String> saveFileNames=fileUploadService.restore(fileList);
		
		if(saveFileNames.size()>=1) {
			dto.setFile1("upload/"+saveFileNames.get(0));
		}
		if(saveFileNames.size()>=2) {
			dto.setFile2("upload/"+saveFileNames.get(1));	
		}
		if(saveFileNames.size()>=3) {
			dto.setFile3("upload/"+saveFileNames.get(2));	
		}
		if(saveFileNames.size()>=4) {
			dto.setFile4("upload/"+saveFileNames.get(3));	
		}
		if(saveFileNames.size()>=5) {
			dto.setFile5("upload/"+saveFileNames.get(4));	
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

	@Override
	public List<BoardDto> getList() {
		List<BoardDto> list=dao.getListDao();
		return list;
	}

	@Override
	public BoardDto getWritting() {
		// TODO Auto-generated method stub
		return null;
	}

}
