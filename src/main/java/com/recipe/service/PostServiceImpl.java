package com.recipe.service;

import com.recipe.dao.PostDAO;
import com.recipe.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostDAO postDAO;

    @Override
    public PostVO getPost(int post_no) {
        return postDAO.getPost(post_no);
    }
}
