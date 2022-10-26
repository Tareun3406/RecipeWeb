package com.recipe.dao;
import com.recipe.vo.MemberVO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MypageDAOImpl implements MypageDAO{
    @Autowired
    private SqlSession sqlSession;


    @Override
    public MemberVO getmylist(String b) {
        return this.sqlSession.selectOne("my_list",b);
    }
}