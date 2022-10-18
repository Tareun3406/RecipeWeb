package com.recipe.service;

import java.util.List;

import com.recipe.vo.CommuVO;

public interface CommuService {

	void insertCommu(CommuVO c);

	int getListCount(CommuVO c);

	List<CommuVO> getCommuList(CommuVO c);

	CommuVO getCommuCont(int comu_no);

	CommuVO getCommuCont2(int comu_no);

	void replyCommu(CommuVO rc);

}
