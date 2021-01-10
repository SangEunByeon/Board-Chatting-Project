package com.example.demo.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BoardDto {
	private int idx;
	private String title;
	private String writer;
	private String category;
	private String contents;
	private String file1;
	private String file2;
	private String file3;
	private String file4;
	private String file5;
	private int hit;
	private Date reg;

	

}
