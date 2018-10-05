package com.bbs.controller;

import com.bbs.domain.Post;
import com.bbs.domain.User;
import com.bbs.service.PostManagerImpl;
import com.bbs.vo.UserVO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Slf4j
@Controller
public class BoardController {


    @Autowired
    private PostManagerImpl postManager; //이렇게 쓰면 스프링 모름


    //초기화면
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView init(Post post) {
        List<Post> list = postManager.boardList();
        System.out.println("로그인완료되면 초기페이지 호출");
        System.out.println(list);
        return new ModelAndView("index", "list", list);
    }


    //글작성 페이지
    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public ModelAndView post() {
        System.out.println("post페이지 호출");
        return new ModelAndView("post");
    }

    //글작성 저장
    @RequestMapping(value = "/writePost", method = RequestMethod.POST) //새로운 게시물 DB에 저장
    public String writePost(@ModelAttribute("WritePost") Post post)  {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();//현재 사용자인증세션 가지고온다
        post.setUser((User)auth.getPrincipal()); //가져온 인증을 유저객체로 변환해서 post에 셋한다
        postManager.postInsert(post);
        return "redirect:/index";
    }

    //디텔일하게 글보기
    @RequestMapping(value = "/post/{bno}", method = RequestMethod.GET)
    public ModelAndView postView(@PathVariable("bno") int bno)  {
        Post post = postManager.postView(bno);
        System.out.println("글디테일하게 보기");
        return new ModelAndView("postView", "post", post);
    }


    //글 수정 페이지
    @RequestMapping(value = "/post/modify/{bno}", method = RequestMethod.GET)
    public ModelAndView modifyView(@PathVariable("bno") int bno)  {
        Post post = postManager.modifyView(bno);
        System.out.println("modify페이지 호출");
        return new ModelAndView("postModify", "modify", post);
    }

    //글수정 저장
    @RequestMapping(value = "/post/modify/{bno}", method = RequestMethod.PUT) //수정 put 사용
    public String postModify(@ModelAttribute("Post") Post post,@PathVariable("bno") int bno){
        log.info("글수정시작");
        postManager.postModify(post,bno);
        log.info("수정 끝");
        return "redirect:/post/{bno}";
    }

    //글 삭제
    @RequestMapping(value = "/post/{bno}", method = RequestMethod.DELETE)
    public String postDelete( @ModelAttribute("Post") Post post){ // @PathVariable("bno") int bno
        System.out.println(post);
        postManager.postDelete(post);
        System.out.println("글삭제");
        return "redirect:/index";
    }


    @RequestMapping(value = "/login/form", method = RequestMethod.GET)
    public String loginForm() {
        System.out.println("로그인인증");

        return "login";
    }
}
