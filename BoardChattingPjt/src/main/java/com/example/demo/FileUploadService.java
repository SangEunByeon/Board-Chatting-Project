package com.example.demo;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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
	
	public List<String> restore(List<MultipartFile> multipartFile) throws Exception, IOException{
		String savepath = ResourceUtils.getFile("classpath:static/upload/").toPath().toString();
		System.out.println("savepath1 : "+savepath);
		savepath = savepath.replace("\\", "/");
		System.out.println("savepath2 : "+savepath);
		savepath = savepath.replace("/bin/main/static", "/src/main/resources/static");
		System.out.println("savepath(last) : "+savepath);
		String filePath = null;
		
		List<String> saveFileNames = new ArrayList<>();
		
		for(MultipartFile file : multipartFile) {
			String originFileName = file.getOriginalFilename();
			Long size = file.getSize();
			String saveFileName=""+System.currentTimeMillis()+originFileName;
			filePath = savepath + "/" + saveFileName;
			System.out.println("filePath : "+filePath);
			File savefile = new File(filePath);
			file.transferTo(savefile);
			saveFileNames.add(saveFileName);
		}
		return saveFileNames;
	}

	
	
}
