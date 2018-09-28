package com.bbs.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class CommentVO {

    @JsonProperty("comment_id")
    private int commentId;

    @JsonProperty("comment")
    private  String commnet;

    @JsonProperty("reg_date")
    private Timestamp regDate;
}
