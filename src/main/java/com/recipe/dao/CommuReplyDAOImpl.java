package com.recipe.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.recipe.vo.CommuReplyVO;

@Repository
public class CommuReplyDAOImpl implements CommuReplyDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void insertReaply(CommuReplyVO vo) {
		this.sqlSession.insert("reply_in",vo);
		//insert()메서드는 레코드 저장, reply_in은 reply.xml에서 설정할 유일 아이디명
	}//댓글저장

	@Override
	public List<CommuReplyVO> listReply(int comu_no) {
		return sqlSession.selectList("reply_list",comu_no);//selectList()메서드는 하나이상의 레코드 목록을 반환하고,reply_list
		//는 reply.xml에서 설정한 유일한 아이디 명이다.
	}//댓글 목록

	@Override
	public void updateReply(CommuReplyVO vo) {
		sqlSession.update("reply_edit",vo);//update()로 레코드 수정,reply_edit는 reply.xml에서 설정할 유일한 아이디
	}//댓글수정

	@Override
	public void deleteReply(int reply_no) {
		sqlSession.delete("reply_del",reply_no);//delete()메서드로 레코드를 삭제,reply_del은 유일한 아이디명이다.
	}//댓글 삭제

	@Override
	public int getComu_no(int reply_no) {
		return this.sqlSession.selectOne("reply_comuno",reply_no);//selectOne()메서드로 단한개의 레코드 반환
	}//댓글 번호에 해당하는 게시판 번호 구하기


}
