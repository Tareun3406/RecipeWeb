package com.recipe.dao;

import com.recipe.vo.ReplyVO;

import java.util.List;

public interface ReplyDAO {
    void insertReply(ReplyVO r);

    List<ReplyVO> getReplyList(int post_no);
}
