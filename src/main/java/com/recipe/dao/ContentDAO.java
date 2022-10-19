package com.recipe.dao;

import com.recipe.vo.ContentVO;

import java.util.List;

public interface ContentDAO {
    List<ContentVO> getContentList(int post_no);
}
