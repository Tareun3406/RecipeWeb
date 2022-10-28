package com.recipe.service;

import com.recipe.vo.CategoryVO;
import com.recipe.vo.MemberVO;

import java.util.List;

public interface CategoryService {

    int getListCount(CategoryVO b); //게시글 갯수 불러오는

    List<CategoryVO> getcategoryList(CategoryVO b); // 게시글 내용 불러오는

    List<CategoryVO> getnickname(CategoryVO recipe); //게시글에 작성자 아이디로 유저 닉네임 불러오는

    List<CategoryVO> getscore(CategoryVO recipe); //게시글 번호로 댓글에 점수를 평균내서 가져오는
}
