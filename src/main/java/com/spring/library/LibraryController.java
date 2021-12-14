package com.spring.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LibraryController { 
	@Autowired
	BookService bookService;
	LibraryDAO LibraryDAO;
	
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public String boardlist(Model model) { 
		model.addAttribute("list", bookService.getBookList()); 
		return "posts";
	}
	
	@RequestMapping(value = "/board/add", method = RequestMethod.GET)
	public String addBook() { 
		return "addbookform";
	}
	
	// 수정하지 않았음 !!
	@RequestMapping(value = "/addok", method = RequestMethod.POST)
	public String addBookOK(LibraryVO vo) {
		int i = LibraryDAO.insertBook(vo);
		if (i == 0)
			System.out.println("독후감을 등록하지 못했습니다.");
		else
			System.out.println("독후감이 정상적으로 등록되었습니다.");
		return "redirect:list";
	}
	
	// 수정하지 않았음 !!
	@RequestMapping(value = "/editpost/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") int id, Model model) {
		LibraryVO LibraryVO = LibraryDAO.getBook(id);
		model.addAttribute("LibraryVO", LibraryVO);
		return "editform";
	}
	
	// 수정하지 않았음 !!
	@RequestMapping(value = "/editok", method = RequestMethod.POST)
	public String editBookOK(LibraryVO vo) {
		int i = LibraryDAO.updateBook(vo);
		if (i == 0)
			System.out.println("독후감을 수정하지 못했습니다.");
		else
			System.out.println("독후감이 정상적으로 수정되었습니다.");
		return "redirect:list";
	}
	
	// 수정하지 않았음 !!
	@RequestMapping(value = "/deleteok/{id}", method = RequestMethod.GET)
	public String deletePost(@PathVariable("id") int id, Model model) {
		int i = LibraryDAO.deleteBook(id);
		if (i==0) 
			System.out.println("독후감을 삭제하지 못했습니다.");
		else 
			System.out.println("독후감이 정상적으로 삭제되었습니다.");
		return "redirect:../list";
	}
}
