package com.recipe.service;

import com.recipe.vo.*;

import java.util.List;

public interface PostService {
    List<CategoryVO> getPost(int post_no);

    void insertRp(Recipe_PostDTO rpd);

    void insertBookmark(BookmarkVO bookmarkVO);

    void deleteBookmark(BookmarkVO bookmarkVO);

    void insertReport(ReportVO reportVO);

    void deleteReport(ReportVO reportVO);

    void insertSubscribe(SubscribeVO subscribeVO);

    void deleteSubscribe(SubscribeVO subscribeVO);

    void deletePost(int post_no);
}
