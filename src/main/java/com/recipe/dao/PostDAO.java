package com.recipe.dao;

import com.recipe.vo.PostVO;

import java.util.List;

public interface PostDAO {
    List<PostVO> getPost(int post_no);

    void updateHit(int post_no);
}
