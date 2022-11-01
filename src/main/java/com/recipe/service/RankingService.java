package com.recipe.service;

import com.recipe.vo.RankingVO;

import java.util.List;

public interface RankingService {
    int getListCount(RankingVO r);

    List<RankingVO> getrankList(RankingVO r);

}
