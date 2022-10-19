package com.recipe.service;

import com.recipe.vo.ContentVO;

import java.util.List;

public interface ContentService {
    List<ContentVO> getContentList(int post_no);
}
