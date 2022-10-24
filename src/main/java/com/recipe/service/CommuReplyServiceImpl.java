package com.recipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recipe.dao.CommuDAO;
import com.recipe.dao.CommuReplyDAO;
import com.recipe.vo.CommuReplyVO;

@Service
public class CommuReplyServiceImpl implements CommuReplyService {

	@Autowired
	private CommuReplyDAO replyDao;

	
	@Transactional //스프링aop를 통한 트랜잭션 적용
	@Override
	public void insertReply(CommuReplyVO vo) {
		this.replyDao.insertReaply(vo);
	}//댓글이 추가되면 댓글 카운터 1증가

	@Override
	public List<CommuReplyVO> listReply(int comu_no) {
		return this.replyDao.listReply(comu_no);
	}

	@Override
	public void updateReply(CommuReplyVO vo) {
		replyDao.updateReply(vo);
	}

	@Transactional//트랜잭션적용
	@Override
	public void deleteReply(int reply_no) {
		this.replyDao.getComu_no(reply_no);//삭제되기전 댓글 번호에 해당하는 게시판 번호 구하기
		replyDao.deleteReply(reply_no);//댓글 삭제
	}//댓글이 삭제되면 댓글 수 1감소
	

}
