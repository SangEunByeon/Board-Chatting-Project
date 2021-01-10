package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.BoardDto;

@Mapper
public interface IBoardDao {
	public int writeDao(BoardDto dto);

}
