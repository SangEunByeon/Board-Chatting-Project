package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.BoardDto;
import com.example.demo.dto.Pagination;

@Mapper
public interface IBoardDao {
	public int writeDao(BoardDto dto);
	public List<BoardDto> getListDao(Pagination paging);
	public BoardDto getWrittingDao(int idx);
	public int countListDao();
	public void hitDao(@RequestParam("idx")int idx);
}

