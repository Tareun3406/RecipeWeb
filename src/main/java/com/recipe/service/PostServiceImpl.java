package com.recipe.service;

import com.recipe.dao.PostDAO;
import com.recipe.vo.PostVO;
import com.recipe.vo.Recipe_PostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostDAO postDAO;

    @Override
    public List<PostVO> getPost(int post_no) {
        postDAO.updateHit(post_no);
        return postDAO.getPost(post_no);
    }

    @Override
    public void insertRp(Recipe_PostDTO rpd) {
        postDAO.insertRp(rpd);
    }
}
