package com.recipe.dao;


import com.recipe.vo.*;

import java.util.List;
import java.util.Map;

public interface PostDAO {

    List<CategoryVO> getPost(int post_no);

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

    int getNextNo();

    void insertPost(RecipeUploadDTO recipeContent);

    void insertPostContent(Map<String, Object> map);

    void deletePost(int post_no);

}
