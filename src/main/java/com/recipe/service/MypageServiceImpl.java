package com.recipe.service;
import com.recipe.dao.MypageDAO;

import com.recipe.vo.MemberDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MypageServiceImpl implements MypageService {
    @Autowired
    private MypageDAO mypageDAO;


    @Override
    public MemberDTO getmylist(String b) {
        return this.mypageDAO.getmylist(b);
    }

}