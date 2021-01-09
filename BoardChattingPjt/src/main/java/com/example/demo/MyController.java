package com.example.demo;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.demo.service.IBoardService;
import com.example.demo.service.IMemberService;
import com.example.demo.service.ITestService;

@Controller
public class MyController {
	
	@Autowired
	ITestService info;
	@Autowired
	IMemberService mem;
	@Autowired
	IBoardService bs;
	
	//첫 접속 메인폼
	@RequestMapping("/")
	public String root() {
		String springVersion = org.springframework.core.SpringVersion.getVersion();
		System.out.println("스프링 프레임워크 버전 : " + springVersion);
		return "MainForm";}
	// 메인폼
	@RequestMapping("MainForm")
	public String MainForm() {return "MainForm";}
	
	// 로그인
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
	
	// 회원가입폼 
	@RequestMapping("joinForm")
	public String joinForm() { return "JoinForm"; }
	
	// 회원가입 로직
	@RequestMapping("joinAction")
	public String joinAction(HttpServletRequest request, Model model) {
		mem.joinAction(request);
		model.addAttribute("msg","회원가입이 완료되었습니다.");
		model.addAttribute("url","MainForm");
		return "redirect";
	}
	
	// id 중복체크 로직
	@RequestMapping("idCheck")
	public void idCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
		mem.idCheck(request,response);
	}
	
	// 로그아웃 로직
	@RequestMapping("logoutAction")
	public String logoutAction(HttpServletRequest request,Model model) {
		request.getSession().invalidate();
		model.addAttribute("msg","로그아웃 되었습니다.");
		model.addAttribute("url","MainForm");
		return "redirect";
	}
	
	// 아이디 찾기 로직
	// 비밀번호 찾기 로직
	
	// 게시판폼
	@RequestMapping("BoardForm")
	public String BoardForm() { return "BoardForm"; }
	
	// 프로필 폼
	@RequestMapping("Profile")
	public String Profile() { return "Profile"; }
	
	// 글쓰기 폼
	@RequestMapping("WriteForm")
	public String writeForm() { return "WriteForm"; }
	
	// 글쓰기 로직
	@RequestMapping(value="WriteAction", method=RequestMethod.POST)
	public String WriteAction(HttpServletRequest request, 
				MultipartHttpServletRequest fileList, Model model) {
		bs.write(request, fileList, model);
		
		return "";
	}

	
}
