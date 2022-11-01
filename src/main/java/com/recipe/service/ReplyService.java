package com.recipe.service;

import com.recipe.vo.ReplyVO;

import java.util.List;

public interface ReplyService {
    void insertReply(ReplyVO r);

    List<ReplyVO> getReply(int post_no);

    void deleteReply(ReplyVO replyVO);

    int getReplyState(ReplyVO replyVO);
}
