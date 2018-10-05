package com.bbs.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Time;
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
    @GeneratedValue(strategy = GenerationType.AUTO) //자동 유니크하게 increase
    private int bno;


    @Column(name = "title")
    private String title;

    @Column(name = "post")
    private String post;

    @Column(name = "hit")
    private int hit;

    @Column(name = "reg_date")
    @CreationTimestamp
    private Timestamp regDate;

    @Column(name = "up_date")
    @UpdateTimestamp
    private Timestamp upDate;

    @ManyToOne
    @JoinColumn(name="user_id") //FK
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public int getHit() {
        return this.hit;
    }

    public void setHit(int i) {
        this.hit=i;
    }

//    @OneToMany
//    @JoinColumn(name="comment_id", nullable=false) //FK
//    private List<Comment> comment;
}