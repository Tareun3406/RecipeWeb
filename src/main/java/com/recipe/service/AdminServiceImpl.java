package com.recipe.service;

import com.recipe.dao.AdminDAO;
import com.recipe.vo.CategoryVO;
import com.recipe.vo.CommuVO;
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


    @Override
    public List<CategoryVO> readRecipeList() {
        return adminDAO.getRecipeList();
    }

    // 커뮤니티 목록 가져오기
    @Override
    public List<CommuVO> readCommuList(String page, String search, int listNum) {
        CommuVO dto = new CommuVO();    // 인수로 보내질 값 저장

        int pageNum;    // 페이지 정수형
        pageNum = Integer.parseInt(page);

        dto.setStartrow((pageNum-1)*listNum+1);
        dto.setEndrow(pageNum*listNum);
        dto.setFind_name(search);

        return adminDAO.getCommuList(dto);
    }

    // 커뮤니티 페이지 수
    @Override
    public int readComuListCount(String search, int listNum) {
        int listCount = adminDAO.getCommuListCount(search);
        int totalPage = listCount/listNum;
        if(listCount%listNum == 0){
            return totalPage;
        }
        return totalPage+1;
    }
    // 회원 리스트
    @Override
    public List<MemberDTO> getMemberList(String search, String page,int listNum)
    {
        int pageNum =  0;  // 현재 페이지

        pageNum += Integer.parseInt(page);

        MemberDTO dto = new MemberDTO();
        dto.setRowMin((pageNum-1)*listNum+1);
        dto.setRowMax(pageNum*listNum);
        dto.setSearch(search);

        return adminDAO.getMemberList(dto);
    }

    // 회원 페이지수
    @Override
    public int getMemberListCount(String search,int listNum) {
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
