package com.sist.controller;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.sist.service.DataBoardService;
import com.sist.vo.DataBoardVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DataBoardController {
	
	private final DataBoardService dService;
	
	@GetMapping("databoard/list.do")
	public String board_list(String page, Model model) {
		
		if(page == null) {
			page = "1";
		}
		int curpage = Integer.parseInt(page);
		int start = (curpage-1)*12;
		
		List<DataBoardVO> list = dService.dataBoardListData(start);
		int totalpage = dService.dataBoardTotalPage();
		
		final int BLOCK = 10;
		
		int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
		int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage > totalpage) {
			endPage = totalpage;
		}
		
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		model.addAttribute("main_jsp", "../databoard/list.jsp");
		
		return "main/main";
	}
	
	// insert 화면 전환
	@GetMapping("databoard/insert.do")
	public String databoard_insert(Model model) {
		
		model.addAttribute("main_jsp", "../databoard/insert.jsp");
		return "main/main";
	}
	
	// insert
	@RequestMapping("databoard/insert_ok.do")
	public String databoard_insert_ok(DataBoardVO vo, Model model) { // DataBoardVO vo :: 커맨드 객체
		String path = "C:\\uploads";
		List<MultipartFile> list = vo.getFiles();
		if(list == null) {
			vo.setFilename("");
			vo.setFilesize("");
			vo.setFilecount(0);
		}
		else {
			try {
				String filename = "";
				String filesize = "";
				for(MultipartFile mf : list) {
					String oname = mf.getOriginalFilename();
					File file = new File(path+'\\'+oname);
					if(file.exists()) { // 같은 파일명이 있는 경우
						String name = oname.substring(0, oname.lastIndexOf("."));
						String ext = oname.substring(oname.lastIndexOf("."));
						int count = 1;
						while(file.exists()) {
							String newName = name+"("+count+")"+ext;
							file = new File(path+"\\"+newName);
							count++;
						}
						
					}
					mf.transferTo(file); // 업로드
					filename += file.getName()+",";
					filesize += file.length()+",";
				}
				filename = filename.substring(0, filename.lastIndexOf(","));
				filesize = filesize.substring(0, filesize.lastIndexOf(","));
				vo.setFilename(filename);
				vo.setFilesize(filesize);
				vo.setFilecount(list.size());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		dService.dataBoardInsert(vo);
		return "redirect:list.do";
	}

}
