package com.example.demo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.dto.TestDto;

public interface ITestService {

	public List<TestDto> getList(HttpServletRequest request);
}
