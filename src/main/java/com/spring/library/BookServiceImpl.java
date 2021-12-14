package com.spring.library;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{ 
	@Autowired
	LibraryDAO LibraryDAO;
	
	@Override
	public int insertBook(LibraryVO vo) { 
		return LibraryDAO.insertBook(vo);
	}
	
	@Override
	public int deleteBook(int id) { 
		return LibraryDAO.deleteBook(id);
	}
	
	@Override
	public int updateBook(LibraryVO vo) { 
		return LibraryDAO.updateBook(vo);
	}

	@Override
	public LibraryVO getBook(int seq) { 
		return LibraryDAO.getBook(seq);
	}
	
	@Override
	public List<LibraryVO> getBookList(){ 
		return LibraryDAO.getBookList();
	}
}
