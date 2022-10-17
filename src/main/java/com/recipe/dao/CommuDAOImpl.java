package com.recipe.dao;

import java.util.List;

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

	@Override
	public int getTotalCount(CommuVO c) {
		return this.sqlSession.selectOne("commu_count",c);
	}

	@Override
	public List<CommuVO> getCommuList(CommuVO c) {
		return this.sqlSession.selectList("commu_list",c);
	}
	
	
}
