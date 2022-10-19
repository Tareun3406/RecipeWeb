package com.recipe.service;

import com.recipe.dao.ContentDAO;
import com.recipe.vo.ContentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService{

    @Autowired
    private ContentDAO contentDAO;

    @Override
    public List<ContentVO> getContentList(int post_no) {
        return contentDAO.getContentList(post_no);
    }
}
