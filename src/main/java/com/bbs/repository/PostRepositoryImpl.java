package com.bbs.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.mysema.query.jpa.impl.JPADeleteClause;
import com.mysema.query.jpa.impl.JPAUpdateClause;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import com.bbs.domain.Post;
import com.bbs.domain.QPost;
import com.mysema.query.jpa.JPQLQuery;


public class PostRepositoryImpl extends QueryDslRepositorySupport implements PostRepositoryCustom {

  public PostRepositoryImpl() {
    super(Post.class);
  }
  @PersistenceContext
  private EntityManager em;

  public List<Post> getList() {

    QPost post = QPost.post1;
    JPQLQuery query = from(post);

    query.orderBy(post.regDate.desc());

    List<Post> postList = query.list(post);
    return postList;
  }

  public Post getPostById(int bno){ //해당되는 bno를 가져와서 담는다
    QPost post=QPost.post1;
    JPQLQuery query = from(post).where(post.bno.eq(bno));
    Post result=query.list(post).get(0);
    return result;
  }

  public void deletePost(int bno){
    System.out.println("삭제시작");
	  QPost post = QPost.post1;
	  JPADeleteClause deleteClause = new JPADeleteClause(em,post);
	  System.out.println("ing"+bno);
	  long count=deleteClause.where(post.bno.eq(bno)).execute();
	  //Post result=query.list(post).get(0);
	 System.out.println("삭제끝");

  }
  public void modifyPost(int bno){
    QPost post= QPost.post1;
    JPAUpdateClause updateClause= new JPAUpdateClause(em,post);
    long count =updateClause.where(post.bno.eq(bno)).set(post.title,post.post).execute();
    //updateClause.set(post.bno,post.bno);
  }

}
