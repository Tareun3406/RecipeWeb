package com.recipe.service;

import com.recipe.dao.PostDAO;
import com.recipe.vo.*;
import com.recipe.vo.ContentVO;
import com.recipe.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostDAO postDAO;

    @Override
    public List<PostVO> getPost(int post_no) {
        postDAO.updateHit(post_no);

        List<PostVO> postVOList = postDAO.getPost(post_no);

        // 팁, 레시피 텍스트 줄바꾸기
        for (PostVO postVO : postVOList){
            postVO.setTip(postVO.getTip().replace("\n", "</br>"));
            for (ContentVO contentVO : postVO.getContent()) {
                contentVO.setManual(contentVO.getManual().replace("\n", "</br>"));
            }
        }

        return postVOList;
    }

    

    @Transactional
    @Override
    public void insertBookmark(BookmarkVO bookmarkVO) {
        postDAO.inserBookmark(bookmarkVO);
        postDAO.updateBookmark(bookmarkVO.getPost_no());
    }

    @Override
    public List<BookmarkVO> getBookmarkList(int post_no) {
        return postDAO.getBookmarkList(post_no);
    }

    @Transactional
    @Override
    public void deleteBookmark(BookmarkVO bookmarkVO) {
        postDAO.deleteBookmark(bookmarkVO);
        postDAO.minusBookmark(bookmarkVO.getPost_no());
    }

    @Override
    public List<ReportVO> getReportList(int post_no) {
        return postDAO.getReportList(post_no);
    }

    @Transactional
    @Override
    public void insertReport(ReportVO reportVO) {
        postDAO.insertReport(reportVO);
        postDAO.updateReport(reportVO.getPost_no());
    }

    @Transactional
    @Override
    public void deleteReport(ReportVO reportVO) {
        postDAO.deleteReport(reportVO);
        postDAO.minusReport(reportVO.getPost_no());
    }

    @Transactional
    @Override
    public void insertSubscribe(SubscribeVO subscribeVO) {
        postDAO.insertSubscribe(subscribeVO);
        postDAO.updateSubscribe(subscribeVO.getTarget_id());
    }

    @Transactional
    @Override
    public void deleteSubscribe(SubscribeVO subscribeVO) {
        postDAO.deleteSubscribe(subscribeVO);
        postDAO.minusSubscribe(subscribeVO.getTarget_id());
    }

    @Override
    public List<SubscribeVO> getSubscriberList(String writer) {
        return postDAO.getSubscriberList(writer);
    }

	@Override
	public void insertRp(PostVO pv, ContentVO cv) {
		postDAO.insertRp(pv,cv);
	}
}
