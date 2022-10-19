package com.recipe.service;

import com.recipe.vo.ReplyVO;

import java.util.List;

public interface ReplyService {
    void insertReply(ReplyVO r);

    List<ReplyVO> getReplyList(int post_no);
}
