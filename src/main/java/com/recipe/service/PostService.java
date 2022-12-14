package com.recipe.service;


import com.recipe.vo.*;

import java.util.List;

public interface PostService {
    List<CategoryVO> getPost(int post_no);

    void insertBookmark(BookmarkVO bookmarkVO);

    void deleteBookmark(BookmarkVO bookmarkVO);

    void insertReport(ReportVO reportVO);

    void deleteReport(ReportVO reportVO);

    void insertSubscribe(SubscribeVO subscribeVO);

    void deleteSubscribe(SubscribeVO subscribeVO);

    void insertPost(RecipeUploadDTO recipeContent, List<RecipeContentDTO> contentlist);

    int getNextNo();

    void deletePost(int post_no);

    List<CategoryVO> getPost2(int post_no);

    void editPost(RecipeUploadDTO recipeContent, List<RecipeContentDTO> contentlist);
}
