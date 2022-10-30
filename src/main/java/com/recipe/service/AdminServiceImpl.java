package com.recipe.service;

import com.recipe.dao.AdminDAO;
import com.recipe.vo.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminDAO adminDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 회원 리스트
    @Override
    public List<MemberDTO> getMemberList() {
        return adminDAO.getMemberList();
    }

    // 회원 정보
    @Override
    public MemberDTO getMemberInfo(String userid) {
        return adminDAO.getMemberInfo(userid);
    }

    // 수정된 회원 정보 업데이트
    @Override
    public void memberUpdate(MemberDTO member) {
        member.setUserpw(passwordEncoder.encode(member.getUserpw()));
        adminDAO.updateMember(member);
    }
}
