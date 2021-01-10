package com.example.demo;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.filechooser.FileSystemView;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.demo.dto.BoardDto;

@Service
public class FileUploadService {
	private static String SAVE_PATH = "/upload/";
	
	/*public String restore1(MultipartHttpServletRequest mtfRequest) {
		// 여기 리스트는 util로 추가!
		List<MultipartFile> fileList = mtfRequest.getFiles("files");
		String url="";
		BoardDto dto = new BoardDto();
		for(MultipartFile file : fileList) {
			String originFileName = file.getOriginalFilename();
			long fileSize = file.getSize();
			System.out.println("originFileName : " + originFileName);
            System.out.println("fileSize : " + fileSize); 
            String saveFileName = SAVE_PATH + System.currentTimeMillis() + originFileName;

            url = SAVE_PATH + "/" + saveFileName;
            try {
            	file.transferTo(new File(saveFileName));
            }catch(Exception e) {
            	e.printStackTrace();
            }  
		}
		return url;
	}*/
	
	public String restore(List<MultipartFile> multipartFile) throws Exception, IOException{
		String savepath = ResourceUtils.getFile("classpath:static/upload/").toPath().toString();
		System.out.println("savepath1 : "+savepath);
		savepath = savepath.replace("\\", "/");
		System.out.println("savepath2 : "+savepath);
		savepath = savepath.replace("/bin/main/static", "/src/main/resources/static");
		System.out.println("savepath(last) : "+savepath);
		
		String filePath = null;
		for(MultipartFile file : multipartFile) {
			String originFileName = file.getOriginalFilename();
			Long size = file.getSize();
			filePath =  savepath + "/" + originFileName;
			System.out.println("filePath : "+filePath);
			File savefile = new File(filePath);
			file.transferTo(savefile);
		}
		return filePath;
	}

	
	
}
