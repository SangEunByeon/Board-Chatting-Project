package com.example.demo;



import java.io.File;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class FileUploadService {
	private static String SAVE_PATH = "/upload/";
	
	public String restore(MultipartHttpServletRequest mtfRequest) {
		// 여기 리스트는 util로 추가!
		List<MultipartFile> fileList = mtfRequest.getFiles("files");
		String url="";
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
	}
	
}
