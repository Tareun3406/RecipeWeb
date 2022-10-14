package com.recipe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.dao.CommuDAO;
import com.recipe.vo.CommuVO;

@Service
public class CommuServiceImpl implements CommuService {

	@Autowired
	private CommuDAO commuDao;

	@Override
	public void insertCommu(CommuVO b) {
		this.commuDao.insertCommu(b);
	}
}
