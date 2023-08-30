package com.kh.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.mvc.model.vo.Board;

@Repository
public class BoardDAO {

	@Autowired
	public SqlSessionTemplate sqlSession;
	
	public int insert(Board board) {
		return sqlSession.insert("board.insert", board);
	}
	
	public List<Board> selectAllBoard() {
		return sqlSession.selectList("board.selectAll");
	}
	
//	public List<Board> select(String keyword){
//		return sqlSession.selectList("Board.select", keyword);
//	}
//	
//	public int update(Board board) {
//		return sqlSession.update("Board.update", board);
//	}
//	
//	public int delete(Board board) {
//		return sqlSession.delete("Board.delete", board);
//	}
	
}
