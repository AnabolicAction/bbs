package com.bbs.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name="post")
public class Post {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "bno", length = 10) //Pk
    private int bno;


    @Column(name = "title")
    private String title;

    @Column(name = "post")
    private String post;

    @Column(name = "hit")
    private String hit;

    @Column(name = "reg_date")
    @CreationTimestamp
    private Timestamp regDate;

    @ManyToOne
    @JoinColumn(name="member_id", nullable=false) //FK
    private Member member;

//    @OneToMany
//    @JoinColumn(name="comment_id", nullable=false) //FK
//    private List<Comment> comment;
}