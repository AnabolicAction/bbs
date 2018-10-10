package com.bbs.repository;

import com.bbs.domain.Comment;
import com.bbs.domain.Post;
import com.bbs.domain.QComment;
import com.bbs.domain.QPost;
import com.mysema.query.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


public class CommentRepositoryImpl extends QueryDslRepositorySupport implements CommentRepositoryCustom {

    public CommentRepositoryImpl() {
        super(Post.class);
    }

    @PersistenceContext
    private EntityManager em;

    public List<Comment> getList() {
        QComment comment = QComment.comment;
        JPQLQuery query = from(comment);
        query.orderBy(comment.regDate.desc());
        List<Comment> comments = query.list(comment);
        return comments;
    }


    public List<Comment> getCommentBno(int bno) { //해당되는 bno를 가져와서 담는다
        QComment comment = QComment.comment;
        JPQLQuery query = from(comment).where(comment.post.bno.eq(bno));
        List<Comment> result = query.list(comment);
        return result;
    }


}
