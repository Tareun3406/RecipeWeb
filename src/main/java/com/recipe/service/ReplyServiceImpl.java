package com.recipe.service;

import com.recipe.dao.ReplyDAO;
import com.recipe.vo.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService{

    @Autowired
    private ReplyDAO replyDAO;

    @Override
    public void insertReply(ReplyVO r) {
        replyDAO.insertReply(r);
    }

    @Override
    public List<ReplyVO> getReply(int post_no) {

        List<ReplyVO> replyVOList = replyDAO.getReply(post_no);
        // 리뷰 줄 바꾸기
        for(ReplyVO replyVO : replyVOList) {
            replyVO.setContent(replyVO.getContent().replace("\n", "</br>"));
        }
        return replyDAO.getReply(post_no);
    }

    @Override
    public void deleteReply(ReplyVO replyVO) {
        replyDAO.deleteReply(replyVO);
    }

    @Override
    public int getReplyState(ReplyVO replyVO) {
        return replyDAO.getReplyState(replyVO);
    }

}
