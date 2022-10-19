package com.recipe.dao;

import java.util.List;

import com.recipe.vo.CommuVO;

public interface CommuDAO {
    // 01. 게시글 작성
    public void create(CommuVO vo) throws Exception;
    // 02. 게시글 상세보기
    public CommuVO read(int comu_no) throws Exception;
    // 03. 게시글 수정
    public void update(CommuVO vo) throws Exception;
    // 04. 게시글 삭제
    public void delete(int comu_no) throws Exception;
    // 05. 게시글 전체 목록
    public List<CommuVO> listAll() throws Exception;
    // 06. 게시글 조회 증가
    public void increaseViewcnt(int comu_no) throws Exception;

}
