package com.recipe.dao;
import com.recipe.vo.MemberDTO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MypageDAOImpl implements MypageDAO{
    @Autowired
    private SqlSession sqlSession;


    @Override
    public MemberDTO getmylist(String b) {
        return this.sqlSession.selectOne("my_list",b);
    }
}