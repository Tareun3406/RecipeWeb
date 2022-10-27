package com.recipe.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import com.recipe.vo.AuthDTO;
import com.recipe.vo.MemberDTO;


@Repository
public class MemberDAOImpl implements MemberDAO{

    @Autowired
    private SqlSession sqlSession;


    //id로 회원정보+권한정보 가져오기
    @Override
    public MemberDTO readMemberInfo(String userid) {
       return sqlSession.selectOne("memberSelectAll",userid);
    }

    // 회원정보 넣기
    @Override
    public void insertMember(MemberDTO vo) {
        sqlSession.insert("memberInsert", vo);
    }

    // 권한정보 넣기
    @Override
    public void insertAuth(AuthDTO auth) {
        sqlSession.insert("authInsert", auth);
    }

    // 이메일로 가입한 아이디 목록 가져오기
    @Override
    public List<MemberDTO> findIdList(String email) {
        return sqlSession.selectList("findID",email);
    }

    // 아이디로 회원정보 가져오기
    @Override
    public MemberDTO checkId(String id) {
        return sqlSession.selectOne("memberSelect",id);
    }

    // 아이디, 이메일을 기준으로 모두 같을시 비밀번호 변경
    @Override
    public int updateFindPw(MemberDTO member) {
        return sqlSession.update("memberUpdatePw",member);
    }


}
