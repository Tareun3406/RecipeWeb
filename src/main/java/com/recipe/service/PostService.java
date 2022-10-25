package com.recipe.service;

import com.recipe.vo.PostVO;

import java.util.List;

public interface PostService {
    List<PostVO> getPost(int post_no);

}
