package com.recipe.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.recipe.vo.Recipe_PostDTO;

@Repository
public class Recipe_PostDAOImpl implements Recipe_PostDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertRp(Recipe_PostDTO rpd) {
		this.sqlSession.insert("rp_in",rpd);
	}
}
