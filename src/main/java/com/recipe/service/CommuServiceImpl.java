package com.recipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
