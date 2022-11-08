package com.recipe.service;

import com.recipe.dao.PostDAO;
import com.recipe.vo.*;
import com.recipe.vo.ContentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostDAO postDAO;

    @Override
    public List<CategoryVO> getPost(int post_no) {
        postDAO.updateHit(post_no);

        List<CategoryVO> postVOList = postDAO.getPost(post_no);

        // 팁, 레시피, 댓글 줄바꾸기
        try{
            for (CategoryVO postVO : postVOList){
                postVO.setTip(postVO.getTip().replace("\n", "</br>"));
            }
        }catch (Exception e){
            for (CategoryVO postVO : postVOList){
                for (ContentVO contentVO : postVO.getContentVOList()) {
                    contentVO.setManual(contentVO.getManual().replace("\n", "</br>"));
                }
                for(ReplyVO replyVO : postVO.getReplyVOList()) {
                    replyVO.setContent(replyVO.getContent().replace("\n", "</br>"));
                }
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

    @Transactional
    @Override
    public void deleteBookmark(BookmarkVO bookmarkVO) {
        postDAO.deleteBookmark(bookmarkVO);
        postDAO.minusBookmark(bookmarkVO.getPost_no());
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
    public void deletePost(int post_no) {
        postDAO.deletePost(post_no);
    }

    @Transactional
    @Override
    public void insertPost(RecipeUploadDTO recipeContent, List<RecipeContentDTO> contentlist) {
        postDAO.insertPost(recipeContent);

        Map<String, Object> map = new HashMap<>();
        map.put("contentlist",contentlist);

        postDAO.insertPostContent(map);
    }

    @Override
    public int getNextNo() {
        return postDAO.getNextNo();
    }

}
