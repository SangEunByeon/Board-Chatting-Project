package com.example.demo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ITestDao;
import com.example.demo.dto.TestDto;

@Service
public class TestService implements ITestService {

	@Autowired
	ITestDao dao;
	
	@Override
	public List<TestDto> getList(HttpServletRequest request) {
		return dao.getList();
	}

}
