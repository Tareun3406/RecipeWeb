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

	@Override
	public void updateHit(int comu_no) {
		this.sqlSession.update("commu_hit",comu_no);
		
	}

	@Override
	public CommuVO getCommu_cont(int comu_no) {
		return this.sqlSession.selectOne("commu_cont",comu_no);
	}

	@Override
	public void updateLevel(CommuVO rc) {
		this.sqlSession.update("commu_levelUp",rc);
		
	}

	@Override
	public void replyCommu(CommuVO rc) {
		this.sqlSession.insert("reply_in", rc);		
	}
	
	
}
