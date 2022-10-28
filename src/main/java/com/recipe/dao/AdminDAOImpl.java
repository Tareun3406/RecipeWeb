package com.recipe.dao;

import com.recipe.vo.MemberDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminDAOImpl implements AdminDAO{

    @Autowired
    private SqlSession sqlSession;


    @Override
    public List<MemberDTO> getMemberList() {
        return sqlSession.selectList("memberList");
    }
}
