package com.recipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recipe.dao.CommuDAO;
import com.recipe.vo.CommuVO;

@Service
public class CommuServiceImpl implements CommuService {

	@Autowired
	private CommuDAO commuDao;

	@Override
	public void insertCommu(CommuVO c) {
		this.commuDao.insertCommu(c);
	}

	@Override
	public int getListCount(CommuVO c) {
		return this.commuDao.getTotalCount(c);
	}

	@Override
	public List<CommuVO> getCommuList(CommuVO c) {
		return this.commuDao.getCommuList(c);
	}
	
	@Transactional
	@Override
	public CommuVO getCommuCont(int comu_no) {
		this.commuDao.updateHit(comu_no);//조회수 증가
		return this.commuDao.getCommu_cont(comu_no);
	}

	@Override
	public CommuVO getCommuCont2(int comu_no) {
		return this.commuDao.getCommu_cont(comu_no);
	}

	@Override
	public void replyCommu(CommuVO rc) {
		this.commuDao.updateLevel(rc);//답변레벨 증가
		this.commuDao.replyCommu(rc);//답변저장
		
	}
}
