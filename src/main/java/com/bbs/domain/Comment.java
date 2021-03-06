package com.bbs.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id") //코드에서 객체비교 등의 용도로 사용 equals(),hashCode() 메소드의 코드를 생성??
@Entity
@Table(name="comment")
public class Comment {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cno", length = 10)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cno;

    @Column(name = "content")
    private String content;

    public String getContent() {
        return content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name="bno", nullable=false) //FK
    private Post post;

    @Column(name = "reg_date")
    @CreationTimestamp
    private Timestamp regDate;

    @Column(name = "up_date")
    @UpdateTimestamp
    private Timestamp upDate;

//    @CreationTimestamp
//    private Timestamp regDate;
}