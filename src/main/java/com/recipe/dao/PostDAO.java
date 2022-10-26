package com.recipe.dao;

import com.recipe.vo.PostVO;
import com.recipe.vo.Recipe_PostDTO;

import java.util.List;

public interface PostDAO {
    List<PostVO> getPost(int post_no);
    void insertRp(Recipe_PostDTO rpd);
    void updateHit(int post_no);
}
