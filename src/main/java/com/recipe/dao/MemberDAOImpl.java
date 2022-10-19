package com.recipe.dao;

import com.recipe.vo.AuthVO;
import com.recipe.vo.MemberVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO{

    @Autowired
    private SqlSession sqlSession;


    @Override
    public MemberVO readMemberInfo(String id) {
       return sqlSession.selectOne("memberSelectAll",id);
    }

    @Override
    public void insertMember(MemberVO vo) {
        sqlSession.insert("memberInsert", vo);
    }

    @Override
    public void insertAuth(AuthVO auth) {
        sqlSession.insert("authInsert", auth);
    }
}
