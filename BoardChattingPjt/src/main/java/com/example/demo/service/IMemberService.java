package com.example.demo.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.dto.MemberDto;

public interface IMemberService {

	public int loginAction(HttpServletRequest request);
	public int joinAction(HttpServletRequest request);
	public int idCheck(HttpServletRequest request, HttpServletResponse response) throws IOException;

	public MemberDto getMemInfo(String id);
}
