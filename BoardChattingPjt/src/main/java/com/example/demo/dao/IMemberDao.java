package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.MemberDto;

@Mapper
public interface IMemberDao {
	public int loginCheckDao(String id, String password);
	public int joinActionDao(MemberDto dto);
	public int idCheckDao(String id);
}
