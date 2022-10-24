package com.recipe.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SubscribeVO {

    //구독 테이블
    private String subscriber_id; //구독한 사람
    private String target_id; //구독받은 사람


}
