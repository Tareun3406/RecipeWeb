package com.recipe.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.recipe.vo.CommuVO;
import com.recipe.vo.MemberDTO;

public interface CommuService {
	// 01. 게시글 작성
    public void create(CommuVO vo) throws Exception;
    // 02. 게시글 상세보기
    public CommuVO read(int comu_no) throws Exception;
    // 03. 게시글 수정
    public void update(CommuVO vo) throws Exception;
    // 04. 게시글 삭제
    public void delete(int comu_no) throws Exception;
    // 06. 게시글 조회
    public void increaseViewcnt(int comu_no, HttpSession session) throws Exception;
	public int getListCount(CommuVO vo);
	// 게시글 전체 목록
	public List<CommuVO> getComuList(CommuVO vo);
	public MemberDTO getmynickname(String c);


    
}
