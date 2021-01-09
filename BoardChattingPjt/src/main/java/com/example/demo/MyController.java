package com.example.demo;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.TestDto;
import com.example.demo.service.IMemberService;
import com.example.demo.service.ITestService;

@Controller
public class MyController {
	
	@Autowired
	ITestService info;
	@Autowired
	IMemberService mem;
	
	//메인폼
	@RequestMapping("/")
	public String root() {
		String springVersion = org.springframework.core.SpringVersion.getVersion();
		System.out.println("스프링 프레임워크 버전 : " + springVersion);
		return "MainForm";}
	@RequestMapping("MainForm")
	public String MainForm() {return "MainForm";}
	
	//로그인
	@RequestMapping("loginAction")
	public String loginAction(HttpServletRequest request, Model model) {
		int result = mem.loginAction(request);
		if(result==1) {
			model.addAttribute("msg","로그인 되었습니다.");
			model.addAttribute("url","MainForm");
		}else {
			model.addAttribute("msg","아이디와 비밀번호를 확인해주세요.");
			model.addAttribute("url","MainForm");
		}
		return "redirect";
	}
	
	@RequestMapping("joinForm")
	public String joinForm() {
		return "JoinForm";
	}
	
	@RequestMapping("joinAction")
	public String joinAction(HttpServletRequest request, Model model) {
		mem.joinAction(request);
		model.addAttribute("msg","회원가입이 완료되었습니다.");
		model.addAttribute("url","MainForm");
		return "redirect";
	}
	
	@RequestMapping("idCheck")
	public void idCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
		mem.idCheck(request,response);
	}
	
	@RequestMapping("logoutAction")
	public String logoutAction(HttpServletRequest request,Model model) {
		request.getSession().invalidate();
		model.addAttribute("msg","로그아웃 되었습니다.");
		model.addAttribute("url","MainForm");
		return "redirect";
	}
	

	
}
