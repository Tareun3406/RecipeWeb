package com.recipe.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.recipe.vo.CommuVO;

@Repository
public class CommuDAOImpl implements CommuDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertCommu(CommuVO c) {
		this.sqlSession.insert("commu_in", c);
	}
	
	
}
