package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.TestDto;

@Mapper
public interface ITestDao {
	public List<TestDto> getList();
}
