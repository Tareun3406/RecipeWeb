package com.recipe.service;
import com.recipe.dao.MypageDAO;
import com.recipe.vo.BookmarkVO;
import com.recipe.vo.MypageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MypageServiceImpl implements MypageService {
    @Autowired
    private MypageDAO mypageDAO;


    @Override
    public MypageVO getmylist(String b) {
        return this.mypageDAO.getmylist(b);
    }

}