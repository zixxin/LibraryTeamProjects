package com.spring.library;

import java.util.List;

public interface BookService {
	public int insertBook(LibraryVO vo); 
	public int deleteBook(int id);
	public int updateBook(LibraryVO vo); 
	public LibraryVO getBook(int seq); 
	public List<LibraryVO> getBookList();
}