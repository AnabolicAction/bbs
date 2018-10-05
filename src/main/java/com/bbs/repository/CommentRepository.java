package com.bbs.repository;

import com.bbs.domain.Comment;
import com.bbs.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
