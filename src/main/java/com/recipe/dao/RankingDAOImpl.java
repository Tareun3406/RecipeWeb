package com.recipe.dao;

import com.recipe.vo.RankingVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RankingDAOImpl implements RankingDAO{

    @Autowired
    private SqlSession sqlSession;


    @Override
    public int getListCount(RankingVO r) {
        return this.sqlSession.selectOne("rank_count",r);
    }

    @Override
    public List<RankingVO> getrankList(RankingVO r) {
        return this.sqlSession.selectList("rank_list",r);
    }

}
