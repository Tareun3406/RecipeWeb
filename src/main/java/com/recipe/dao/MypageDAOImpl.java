package com.recipe.dao;
import com.recipe.vo.mypageVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MypageDAOImpl implements MypageDAO{
    @Autowired
    private SqlSession sqlSession;
    @Override
    public mypageVO getuser(String v2) {
        return this.sqlSession.selectOne("user_info",v2);
    }
}