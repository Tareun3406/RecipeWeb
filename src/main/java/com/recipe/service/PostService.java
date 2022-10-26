package com.recipe.service;

import com.recipe.vo.PostVO;
import com.recipe.vo.Recipe_PostDTO;

import java.util.List;

public interface PostService {
    List<PostVO> getPost(int post_no);

    void insertRp(Recipe_PostDTO rpd);

}
