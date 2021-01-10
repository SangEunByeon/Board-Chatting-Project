package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.BoardDto;

@Mapper
public interface IBoardDao {
	public int writeDao(BoardDto dto);
	public List<BoardDto> getListDao();

}
