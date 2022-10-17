package com.recipe.dao;

import java.util.List;

import com.recipe.vo.CommuVO;

public interface CommuDAO {

	void insertCommu(CommuVO c);

	int getTotalCount(CommuVO c);

	List<CommuVO> getCommuList(CommuVO c);

}
