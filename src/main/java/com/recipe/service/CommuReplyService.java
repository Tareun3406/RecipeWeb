package com.recipe.service;

import java.util.List;

import com.recipe.vo.CommuReplyVO;

public interface CommuReplyService {

	void insertReply(CommuReplyVO vo);//추상메서드로 {}가없고, 호출이 불가능. 본문문장이없다. 해당 메서드 리턴타입 앞에 
	//public abstract 가 생략됨.

	List<CommuReplyVO> listReply(int comu_no);

	void updateReply(CommuReplyVO vo);

	void deleteReply(int reply_no);

}
