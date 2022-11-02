package com.recipe.dao;

import com.recipe.vo.RankingVO;

import java.util.List;

public interface RankingDAO {

    int getListCount(RankingVO r);

    List<RankingVO> getrankList(RankingVO r);

}
