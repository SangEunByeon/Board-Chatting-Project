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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.demo.dto.BoardDto;
import com.example.demo.dto.MemberDto;
import com.example.demo.dto.Pagination;
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
	public String BoardForm(Model model, HttpServletRequest request,
			@RequestParam(value="page", defaultValue = "1") int pageNum) {
			// page 이름으로 넘어오면 값을 받고, 없을 경우에는 1로 설정
		
		int totalContent = bs.countContents();  // 전체 게시글 수
		String s_pageNum = request.getParameter("page");
		int i_pageNum;
		HttpSession session=request.getSession();
		String sessionID=(String)session.getAttribute("sessionID");
		
		if(s_pageNum==null) { // 1page
			i_pageNum = 1;
		} else { // 2page 이상	
			i_pageNum = Integer.parseInt(s_pageNum);
		} 
		
		Pagination paging = new Pagination(i_pageNum, totalContent);
		List<BoardDto> list = bs.getList(paging);
		MemberDto memberInfo= mem.getMemInfo(sessionID);
		System.out.println("page정보:"+paging.toString());
		
		model.addAttribute("boardList",list);
		model.addAttribute("pagination",paging);
		model.addAttribute("member",memberInfo);
			
		return "thymeleaf/BoardForm";
	}
	
	// 프로필 폼
	@RequestMapping("Profile")
	public String Profile() { return "Profile"; }
	
	// 글쓰기 폼
	@RequestMapping("WriteForm")
	public String writeForm(HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		String id =(String)session.getAttribute("sessionID");
		model.addAttribute("id",id);
		return "WriteForm"; }
	
	// 글쓰기 로직
	@RequestMapping(value="WriteAction", method=RequestMethod.POST)
	public String WriteAction(HttpServletRequest request, 
				MultipartHttpServletRequest fileList, Model model) throws Exception {
		bs.write(request, fileList, model);
		model.addAttribute("msg","글이 등록되었습니다.");
		model.addAttribute("url","BoardForm");
		return "redirect";
	}
	
	// 글보기 폼
	@RequestMapping("BoardDetail")
	public String BoardDetail(HttpServletRequest request, Model model) {
		String s_idx = request.getParameter("idx");
		int idx = Integer.parseInt(s_idx);
		bs.hit(idx);  // 조회수 올리기
		BoardDto dto=bs.getWritting(idx);
		model.addAttribute("dto",dto);
		return "BoardDetail";
	}
	


	
}
/*@RequestMapping("BoardForm")
public String BoardForm(Model model, HttpServletRequest request,
	@RequestParam(value="page", defaultValue = "1") int pageNum) { 
	// page 이름으로 넘어오면 값을 받고, 없을 경우에는 1로 설정
	int totalContent = bs.countContents();  // 전체 게시글 수
	String s_pageNum = request.getParameter("page");
	int i_pageNum;
	
	if(s_pageNum==null) {i_pageNum = 1;} // 1page
	else { i_pageNum = Integer.parseInt(s_pageNum);} // 2page 이상	
	Pagination paging = new Pagination(i_pageNum, totalContent);
	
	//System.out.println("전체 게시물: "+totalContent+", 현재 페이지: "+i_pageNum);
	//System.out.println("전체 페이지수 :"+ paging.calTotalPage(totalContent, 5));
	
	List<BoardDto> list = bs.getList(paging);
	Integer pageList[] = {1,2};
	model.addAttribute("list",list);
	model.addAttribute("pagination",paging);
			
	
	return "BoardForm"; 
	}*/
