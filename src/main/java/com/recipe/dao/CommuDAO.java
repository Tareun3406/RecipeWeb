package com.recipe.dao;

import java.util.List;

import com.recipe.vo.CommuVO;

public interface CommuDAO {

	void insertCommu(CommuVO c);

	int getTotalCount(CommuVO c);

	List<CommuVO> getCommuList(CommuVO c);

	void updateHit(int comu_no);

	CommuVO getCommu_cont(int comu_no);

	void updateLevel(CommuVO rc);

	void replyCommu(CommuVO rc);

}
