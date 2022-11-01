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
    public List<MemberDTO> getMemberList(String search, String page,int listNum)
    {
        int pageNum =  0;  // 현재 페이지

        try {   // 페이지 번호 예외처리
            pageNum += Integer.parseInt(page);
        }catch (NumberFormatException e){
            pageNum = 1;
        }
        if(search == null){
            search = "";
        }

        MemberDTO dto = new MemberDTO();
        dto.setRowMin((pageNum-1)*listNum+1);
        dto.setRowMax(pageNum*listNum);
        dto.setSearch(search);

        return adminDAO.getMemberList(dto);
    }

    @Override
    public int getMemberListCount(String search,int listNum) {
        if (search == null) search = "";
        int listCount = adminDAO.getMemberListCount(search);
        int totalPage = listCount/listNum;
        if(listCount%listNum == 0){
            return totalPage;
        }
        return totalPage+1;
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

    @Override
    public void deleteMember(String userid) {
        adminDAO.deleteMember(userid);
    }


}
