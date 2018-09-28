package com.bbs.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVO {

    @JsonProperty("user_id") //JsonProperty는 DB를 자바클래스로 매핑하는데 DB의 컬럼명이 알기 어려울 경우등에 유용하게 사용한다, 가독성 증가
    private String id;

    @JsonProperty("password")
    private String password;

}
