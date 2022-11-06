package com.recipe.dao;


import com.recipe.vo.*;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PostDAOImpl implements PostDAO{

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<PostVO> getPost(int post_no) {
        return sqlSession.selectList("post_getList", post_no);
    }

    @Override
    public void updateHit(int post_no) {
        sqlSession.update("post_upHit", post_no);
    }

    @Override
    public void inserBookmark(BookmarkVO bookmarkVO) {
        sqlSession.insert("bookmark_insert", bookmarkVO);
    }

    @Override
    public void updateBookmark(int post_no) {
        sqlSession.update("bookmark_updatePlus", post_no);
    }

    @Override
    public List<BookmarkVO> getBookmarkList(int post_no) {
        return sqlSession.selectList("bookmark_getList", post_no);
    }

    @Override
    public void deleteBookmark(BookmarkVO bookmarkVO) {
        sqlSession.delete("bookmark_delete", bookmarkVO);
    }

    @Override
    public void minusBookmark(int post_no) {
        sqlSession.update("bookmark_updateMinus", post_no);
    }

    @Override
    public List<ReportVO> getReportList(int post_no) {
        return sqlSession.selectList("report_getList", post_no);
    }

    @Override
    public void insertReport(ReportVO reportVO) {
        sqlSession.insert("report_insert", reportVO);
    }

    @Override
    public void updateReport(int post_no) {
        sqlSession.update("report_updatePlus", post_no);
    }

    @Override
    public void deleteReport(ReportVO reportVO) {
        sqlSession.delete("report_delete", reportVO);
    }

    @Override
    public void minusReport(int post_no) {
        sqlSession.update("report_updateMinus", post_no);
    }

    @Override
    public void insertSubscribe(SubscribeVO subscribeVO) {
        sqlSession.insert("subscribe_insert", subscribeVO);
    }

    @Override
    public void updateSubscribe(String target_id) {
        sqlSession.update("subscribe_updatePlus", target_id);
    }

    @Override
    public void deleteSubscribe(SubscribeVO subscribeVO) {
        sqlSession.delete("subscribe_delete", subscribeVO);
    }

    @Override
    public void minusSubscribe(String target_id) {
        sqlSession.update("subscribe_updateMinus", target_id);
    }

    @Override
    public List<SubscribeVO> getSubscriberList(String target_id) {
        return sqlSession.selectList("subscribe_getList", target_id);
    }

    @Override
    public int getNextNo() {
        return sqlSession.selectOne("selectPostNextVal");
    }

    @Override
    public void insertPost(RecipeUploadDTO recipeContent) {
        sqlSession.insert("insertPost",recipeContent);
    }

    @Override
    public void insertPostContent(Map<String, Object> map) {
        sqlSession.insert("insertPostContent",map);
    }
}
