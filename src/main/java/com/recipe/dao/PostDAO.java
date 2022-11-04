package com.recipe.dao;


import com.recipe.vo.*;
import com.recipe.vo.ContentVO;
import com.recipe.vo.PostVO;
import java.util.List;

public interface PostDAO {
    List<PostVO> getPost(int post_no);
    void updateHit(int post_no);

    void inserBookmark(BookmarkVO bookmarkVO);

    void updateBookmark(int post_no);

    List<BookmarkVO> getBookmarkList(int post_no);

    void deleteBookmark(BookmarkVO bookmarkVO);

    void minusBookmark(int post_no);

    List<ReportVO> getReportList(int post_no);

    void insertReport(ReportVO reportVO);

    void updateReport(int post_no);

    void deleteReport(ReportVO reportVO);

    void minusReport(int post_no);

    void insertSubscribe(SubscribeVO subscribeVO);

    void updateSubscribe(String target_id);

    void deleteSubscribe(SubscribeVO subscribeVO);

    void minusSubscribe(String target_id);

    List<SubscribeVO> getSubscriberList(String writer);

	void insertRp(PostVO pv, ContentVO cv);

}
