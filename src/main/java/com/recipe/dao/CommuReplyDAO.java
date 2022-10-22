package com.recipe.dao;

import java.util.List;

import com.recipe.vo.CommuReplyVO;

public interface CommuReplyDAO {

	void insertReaply(CommuReplyVO vo);

	List<CommuReplyVO> listReply(int comu_no);

	void updateReply(CommuReplyVO vo);

	void deleteReply(int reply_no);

	int getComu_no(int reply_no);

}
