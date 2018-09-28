package com.bbs.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name="member")
public class Member {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "member_id", length = 10)
    private String memberId;

    @Column(name = "username")
    private String userName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "gender")
    private String gender;

    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name="user_id", nullable=false) //FK
    private User user;

//    @OneToMany //(mappedBy = "member")
//    @JoinColumn(name="post_id", nullable=false) //FK 맴버가 여러개 게시물 작성
//    private List<Post> post;
}