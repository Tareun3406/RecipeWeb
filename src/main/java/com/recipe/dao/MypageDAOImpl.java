package com.recipe.dao;
import com.recipe.vo.mypageVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MypageDAOImpl implements MypageDAO{
    @Autowired
    private SqlSession sqlSession;
    @Override
    public mypageVO getuser(String v2) {
        return this.sqlSession.selectOne("user_info",v2);
    }

    @Override
    public List<mypageVO> getmylist(String b) {
        return this.sqlSession.selectList("my_list",b);
    }
}