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
        return replyDAO.getReply(post_no);
    }

}
