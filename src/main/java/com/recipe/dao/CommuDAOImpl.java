package com.recipe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.recipe.vo.CommuVO;
import com.recipe.vo.MemberDTO;

@Repository
public class CommuDAOImpl implements CommuDAO {
    @Autowired
    SqlSession SqlSession;
    // 01. 게시글 작성
    @Override
    public void create(CommuVO vo) throws Exception {
        SqlSession.insert("insert", vo);
    }
    // 02. 게시글 상세보기
    @Override
    public CommuVO read(int comu_no) throws Exception {
        return SqlSession.selectOne("view", comu_no);
    }
    // 03. 게시글 수정
    @Override
    public void update(CommuVO vo) throws Exception {
        SqlSession.update("updateArticle", vo);
 
    }
    // 04. 게시글 삭제
    @Override
    public void delete(int comu_no) throws Exception {
        SqlSession.delete("deleteArticle",comu_no);
 
    }

    // 게시글 조회수 증가
    @Override
    public  void increaseViewcnt(int comu_no) throws Exception {
        SqlSession.update("increaseViewcnt", comu_no);
    }
    //게시글 총 개수
	@Override
	public int getTotalCount(CommuVO vo) {
		return this.SqlSession.selectOne("comu_count",vo);
	}
	//게시글 목록
	@Override
	public List<CommuVO> getCommuList(CommuVO vo) {
		return this.SqlSession.selectList("comu_list",vo);
	}
	//닉네임 가져오기
	@Override
	public MemberDTO getMynickname(String c) {
		return this.SqlSession.selectOne("my_nickname",c);
	}


}
