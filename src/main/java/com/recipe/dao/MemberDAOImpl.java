package com.recipe.dao;

import com.recipe.vo.AuthVO;
import com.recipe.vo.MemberVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Queue;


@Repository
public class MemberDAOImpl implements MemberDAO{

    @Autowired
    private SqlSession sqlSession;


    @Override
    public MemberVO readMemberInfo(String userid) {
       return sqlSession.selectOne("memberSelectAll",userid);
    }

    @Override
    public void insertMember(MemberVO vo) {
        sqlSession.insert("memberInsert", vo);
    }

    @Override
    public void insertAuth(AuthVO auth) {
        sqlSession.insert("authInsert", auth);
    }

    @Override
    public List<MemberVO> findIdList(String email) {
        return sqlSession.selectList("findID",email);
    }

    @Override
    public MemberVO checkId(String id) {
        return sqlSession.selectOne("memberSelect",id);
    }

    // 아이디, 이메일을 기준으로 모두 같을시 비밀번호 변경
    @Override
    public int updateFindPw(MemberVO member) {
        return sqlSession.update("memberUpdatePw",member);
    }


}
