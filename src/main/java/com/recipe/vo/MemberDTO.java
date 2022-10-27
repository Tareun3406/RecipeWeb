package com.recipe.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
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
    private List<MessageVO> messageList; //메세지테이블

    

    // 기타 정보

    public void addAuthList(AuthDTO authDTO){
        authList.add(authDTO);
    }


}
