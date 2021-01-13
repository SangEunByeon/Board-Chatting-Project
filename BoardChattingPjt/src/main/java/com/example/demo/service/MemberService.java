package com.example.demo.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IMemberDao;
import com.example.demo.dto.MemberDto;

@Service
public class MemberService implements IMemberService{
	@Autowired
	IMemberDao dao;
	
	@Override
	public int loginAction(HttpServletRequest request) {
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		int result = dao.loginCheckDao(id, password);
		int nResult = 0;
		if(result==1) {
			System.out.println("로그인 성공");
			HttpSession session = request.getSession();
			session.setAttribute("sessionID", id);
			nResult =1;
		}else {
			System.out.println("로그인 실패");
			nResult = 0;
		}
		return nResult;
	}

	@Override
	public int joinAction(HttpServletRequest request) {
		MemberDto dto = new MemberDto(
		request.getParameter("id"),
		request.getParameter("pw"),
		request.getParameter("name"),
		request.getParameter("mail1"),
		request.getParameter("mail2"),
		request.getParameter("phone"),
		request.getParameter("address1"),
		request.getParameter("address2"),
		request.getParameter("address3"),
		request.getParameter("address4")
		);
		dao.joinActionDao(dto);
		return 0;
	}

	@Override
	public int idCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		System.out.println(id);
		int result = dao.idCheckDao(id);
		System.out.println("id check result:"+result);
		if(result == 0) {
			response.getWriter().print("0");
		}else {
			response.getWriter().print("1");
		}
		return result;
	}

	@Override
	public MemberDto getMemInfo(String id) {
		return dao.getMemInfoDao(id);
	}

}
