package com.recipe.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.dao.CommuDAO;
import com.recipe.vo.CommuVO;
import com.recipe.vo.MemberDTO;

@Service
public class CommuServiceImpl implements CommuService {
    @Autowired
    CommuDAO commuDao;
    
    // 01. 게시글쓰기
    @Override
    public void create(CommuVO vo) throws Exception {
        String title = vo.getTitle();
        String content = vo.getContent();
        String writer = vo.getWriter();
        // *태그문자 처리 (< ==> &lt; > ==> &gt;)
        // replace(A, B) A를 B로 변경
        title = title.replace("<", "&lt;");
        title = title.replace("<", "&gt;");

        // *공백문자 처리
        title = title.replace("  ",    "&nbsp;&nbsp;");

        // *줄바꿈 문자처리
        content = content.replace("\n", "<br>");
        vo.setTitle(title);
        vo.setContent(content);

        commuDao.create(vo);
    }
    // 02. 게시글 상세보기
    @Override
    public CommuVO read(int comu_no) throws Exception {
        return commuDao.read(comu_no);
    }
    // 03. 게시글 수정
    @Override
    public void update(CommuVO vo) throws Exception {
    	String title = vo.getTitle();
        String content = vo.getContent();
        String writer = vo.getWriter();
        // *태그문자 처리 (< ==> &lt; > ==> &gt;)
        // replace(A, B) A를 B로 변경
        title = title.replace("<", "&lt;");
        title = title.replace("<", "&gt;");

        // *공백문자 처리
        title = title.replace("  ",    "&nbsp;&nbsp;");

        // *줄바꿈 문자처리
        content = content.replace("\n", "<br>");
        vo.setTitle(title);
        vo.setContent(content);

    	commuDao.update(vo);
    }
    // 04. 게시글 삭제
    @Override
    public void delete(int comu_no) throws Exception {
        commuDao.delete(comu_no);
    }
 
    
    // 06. 게시글 조회수 증가
    @Override
    public void increaseViewcnt(int comu_no, HttpSession session) throws Exception {
        long update_time = 0;
        // 세션에 저장된 조회시간 검색
        // 최초로 조회할 경우 세션에 저장된 값이 없기 때문에 if문은 실행X
        if(session.getAttribute("update_time_"+comu_no) != null){
                                // 세션에서 읽어오기
            update_time = (long)session.getAttribute("update_time_"+comu_no);
        }
        // 시스템의 현재시간을 current_time에 저장
        long current_time = System.currentTimeMillis();
        // 일정시간이 경과 후 조회수 증가 처리 24*60*60*1000(24시간)
        // 시스템현재시간 - 열람시간 > 일정시간(조회수 증가가 가능하도록 지정한 시간)
        if(current_time - update_time > 5*1000){
            commuDao.increaseViewcnt(comu_no);
            // 세션에 시간을 저장 : "update_time_"+bno는 다른변수와 중복되지 않게 명명한 것
            session.setAttribute("update_time_"+comu_no, current_time);
            
        }
    }
	@Override
	public int getListCount(CommuVO vo) {
		return this.commuDao.getTotalCount(vo);
	}
	// 게시글 전체 목록
	@Override
	public List<CommuVO> getComuList(CommuVO vo) {
		return this.commuDao.getCommuList(vo);
	}
	//닉네임 가져오기
	@Override
	public MemberDTO getmynickname(String c) {
		return this.commuDao.getMynickname(c);
	}

	
	


} 