package com.recipe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.dao.Recipe_PostDAO;
import com.recipe.vo.Recipe_PostDTO;

@Service
public class Recipe_PostServiceImpl implements Recipe_PostService {

	@Autowired
	private Recipe_PostDAO recipe_PostDao;

	@Override
	public void insertRp(Recipe_PostDTO rpd) {
		this.recipe_PostDao.insertRp(rpd);
	}
}
