package com.recipe.service;

import com.recipe.dao.TestDAO;
import com.recipe.vo.TestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private TestDAO testDAO;

    @Override
    public int getPostNo() {
        return testDAO.getPostNo();
    }

    @Override
    public void insertImage(TestVO testVO) {
        testDAO.insertImage(testVO);
    }
}
