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

    // 회원 리스트
    @Override
    public List<MemberDTO> getMemberList(MemberDTO dto) {
        return sqlSession.selectList("memberList", dto);
    }

    // 회원 정보
    @Override
    public MemberDTO getMemberInfo(String userid) {
        return sqlSession.selectOne("memberSelect",userid);
    }

    // 회원정보 업데이트
    @Override
    public void updateMember(MemberDTO member) {
        sqlSession.update("memberUpdate", member);
    }

    @Override
    public int getMemberListCount() {
        return sqlSession.selectOne("memberListCount");
    }
}
