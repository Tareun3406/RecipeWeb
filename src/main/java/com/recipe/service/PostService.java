package com.recipe.service;

import com.recipe.vo.*;

import java.util.List;

public interface PostService {
    List<PostVO> getPost(int post_no);

    void insertRp(Recipe_PostDTO rpd);

    void insertBookmark(BookmarkVO bookmarkVO);

    List<BookmarkVO> getBookmarkList(int post_no);

    void deleteBookmark(BookmarkVO bookmarkVO);

    List<ReportVO> getReportList(int post_no);

    void insertReport(ReportVO reportVO);

    void deleteReport(ReportVO reportVO);

    void insertSubscribe(SubscribeVO subscribeVO);

    void deleteSubscribe(SubscribeVO subscribeVO);

    List<SubscribeVO> getSubscriberList(String writer);
}
