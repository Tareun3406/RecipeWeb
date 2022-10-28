package com.recipe.service;

import com.recipe.dao.AdminDAO;
import com.recipe.vo.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminDAO adminDAO;

    @Override
    public List<MemberDTO> getMemberList() {
        return adminDAO.getMemberList();
    }
}
