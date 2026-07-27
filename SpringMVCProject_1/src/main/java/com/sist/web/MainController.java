package com.sist.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.vo.BoardVO;

/*
 * Spring6 으로 넘어가면서 RequestMapping() 없어짐 => GetMapping(), PostMapping() 으로 사용
 * */

@Controller
@RequestMapping("board/") // 앞에 붙여주는 부분 board/~
public class MainController {

//	@RequestMapping("insert.do")
//	public String board_insert(HttpServletRequest request, HttpServletResponse response) {
//		return "board/insert";	//   /board/insert.jsp 로 변환됨
//	}
	
	@GetMapping("insert.do")
	public String board_insert() {
		return "board/insert";
	}
	
	@PostMapping("insert_ok.do")
	public String board_insert_ok(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String pwd = request.getParameter("pwd");
		
		BoardVO vo = new BoardVO();
		vo.setName(name);
		vo.setContent(content);
		vo.setSubject(subject);
		vo.setPwd(pwd);
		
		request.setAttribute("vo", vo);
		
		return "board/list";
	}
	
	@PostMapping("insert_ok2.do")
	public String board_insert_ok2(String name, String content, String subject, String pwd, Model model) { // 넘어오는 값을 매개변수로 받을 수 있음
		
		BoardVO vo = new BoardVO();
		vo.setName(name);
		vo.setContent(content);
		vo.setSubject(subject);
		vo.setPwd(pwd);
		
		// Model model : 값을 전송하는 객체
		model.addAttribute("vo", vo);

		return "board/list";
	}
	
	@PostMapping("insert_ok3.do")
	public String board_insert_ok3(BoardVO vo, Model model) { // 넘어오는 값을 매개변수로 받을 수 있음
		
		// Model model : 값을 전송하는 객체
		model.addAttribute("vo", vo);
		
		return "board/list";
	}
	
}
