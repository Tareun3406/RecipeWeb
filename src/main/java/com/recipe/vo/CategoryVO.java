package com.recipe.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.List;


@Setter
@Getter
@ToString
public class CategoryVO {

    //recipe_post 테이블 변수
    private String post_no;
    private String title;
    private int hit;
    private Date regdate;
    private Date updatedate;
    private String thumnail;
    private String ingredient;
    private int bookmark;
    private String post_tag;
    private String tip;
    private String writer;
    private int report;

    //검색어
    private String find_name;
    private String find_field;

    //페이징 관련변수
    private int startrow; //시작행 번호
    private int endrow; //끝행번호

    private String nickname; //member테이블의 닉네임

    
    private String score; //댓글에 점수

    // 메인페이지 순위체크용
    private int rNum;

    List<ContentVO> contentVOList;
    List<ReportVO> reportVOList;
    List<BookmarkVO> bookmarkVOList;
    List<SubscribeVO> subscribeVOList;
    List<ReplyVO> replyVOList;
    List<MemberDTO> memberDTOList;


}
