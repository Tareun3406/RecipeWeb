package com.recipe.dao;

import com.recipe.vo.*;

import java.util.List;

public interface PostDAO {

    List<CategoryVO> getPost(int post_no);

    void insertRp(Recipe_PostDTO rpd);

    void updateHit(int post_no);

    void inserBookmark(BookmarkVO bookmarkVO);

    void updateBookmark(int post_no);

    void deleteBookmark(BookmarkVO bookmarkVO);

    void minusBookmark(int post_no);

    void insertReport(ReportVO reportVO);

    void updateReport(int post_no);

    void deleteReport(ReportVO reportVO);

    void minusReport(int post_no);

    void insertSubscribe(SubscribeVO subscribeVO);

    void updateSubscribe(String target_id);

    void deleteSubscribe(SubscribeVO subscribeVO);

    void minusSubscribe(String target_id);

    void deletePost(int post_no);
}
