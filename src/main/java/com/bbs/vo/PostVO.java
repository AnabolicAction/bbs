package com.bbs.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class PostVO {

    @JsonProperty("bno")
    private int bno;

    @JsonProperty("title")
    private String title;

    @JsonProperty("post")
    private String post;

    @JsonProperty("reg_date")
    private Timestamp regDate;

}
