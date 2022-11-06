package com.recipe.dao;

import com.recipe.vo.TestVO;

public interface TestDAO {
    int getPostNo();

    void insertImage(TestVO testVO);
}
