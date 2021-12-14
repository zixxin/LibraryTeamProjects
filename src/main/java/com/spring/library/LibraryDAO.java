package com.spring.library;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.session.SqlSession;

@Repository
public class LibraryDAO {

	SqlSession sqlSession;
	
	public int insertBook(LibraryVO vo) {
		int result = sqlSession.insert("Book.insertBook", vo); 
		return result;
	}
	
	// 정확하지 않은 코드 !!
	public int deleteBook(int id) {
		int result = sqlSession.delete("Book.deleteBook", id); 
		return result;
	}

	// 정확하지 않은 코드 !!
	public int updateBook(LibraryVO vo) {
		int result = sqlSession.update("Book.updateBook", vo); 
		return result;
	}
	
	public LibraryVO getBook(int seq) {
		LibraryVO one = sqlSession.selectOne("Book.getBook", seq); 
		return one;
	}
	
	public List<LibraryVO> getBookList() {
		List<LibraryVO> list = sqlSession.selectList("Book.getBookList"); 
		return list;
	}
	
}
