package com.recipe.service;

import com.recipe.dao.RankingDAO;
import com.recipe.vo.RankingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingServiceImpl implements RankingService {

    @Autowired
    private RankingDAO rankingDAO;

    @Override
    public int getListCount(RankingVO r) {
        return this.rankingDAO.getListCount(r);
    }

    @Override
    public List<RankingVO> getrankList(RankingVO r) {
        return this.rankingDAO.getrankList(r);
    }


}
