package com.recipe.service;

import com.recipe.dao.mypageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class mypageServiceImpl {

    @Autowired
    private com.recipe.dao.mypageDAO mypageDAO;

}
