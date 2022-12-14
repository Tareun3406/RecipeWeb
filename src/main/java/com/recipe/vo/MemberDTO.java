package com.recipe.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MemberDTO {

    private String userid;
    private String userpw;
    private String nickname;
    private String email;

    // 권한 정보
    private List<AuthDTO> authList;


    /* mypage 불러올 리스트들 */
    private List<SubscribeVO> subList; //구독테이블
    private List<BookmarkVO> bookList; //북마크테이블
    private List<RecipepostVO> recipeList;//레시피본문 테이블
    private List<RecipereplyVO> recipereplyList; //댓글테이블
    private List<MessageVO> messageList;  //메세지테이블(보낸사람)
    private List<MessageVO> messageList2; //메세지테이블(받은사람)

    //셰프 순위
    private int rNum;

    // 관리자 페이지.
    private int rowMin; // 레코드 시작번호
    private int rowMax; // 레코드 끝 번호
    private String search;// 검색어

}
