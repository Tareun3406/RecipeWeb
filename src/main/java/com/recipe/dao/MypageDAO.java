package com.recipe.dao;
import com.recipe.vo.mypageVO;

import java.util.List;

public interface MypageDAO {

    mypageVO getuser(String v2);

    List<mypageVO> getmylist(String b);
}