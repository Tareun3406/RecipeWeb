package com.recipe.service;
import com.recipe.vo.mypageVO;

import java.util.List;

public interface MypageService {

    mypageVO getuser(String v2);

    List<mypageVO> getmylist(String b);
}