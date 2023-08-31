package com.kh.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.mvc.model.vo.Board;
import com.kh.mvc.model.vo.Criteria;

@Repository
public class BoardDAO {

	@Autowired
	public SqlSessionTemplate sqlSession;
	
	public int insert(Board board) {
		return sqlSession.insert("board.insert", board);
	}
	
	public List<Board> selectAllBoard(Criteria cri) {
		return sqlSession.selectList("board.selectAll", cri);
	}
	
	public int getTotal() {
		return sqlSession.selectOne("board.getTotal");
	}
	
	public Board selectBoard(int no){
		return sqlSession.selectOne("board.select", no);
	}
	
	public int updateBoard(Board board) {
		return sqlSession.update("board.update", board);
	}
	
	public int deleteBoard(int no) {
		return sqlSession.delete("board.delete", no);
	}
	
}
