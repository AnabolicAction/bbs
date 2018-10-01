package com.bbs.controller;

import com.bbs.domain.Member;
import com.bbs.domain.Post;
import com.bbs.domain.User;
import com.bbs.service.MemberManagerImpl;
import com.bbs.service.PostManager;
import com.bbs.service.PostManagerImpl;
import com.bbs.vo.PostVO;
import com.bbs.vo.UserVO;
import javafx.geometry.Pos;
import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.ws.rs.Path;
import java.util.List;

@Controller

public class BoardController {

    @Autowired
    private MemberManagerImpl memberManager;

    @Autowired
    private PostManagerImpl postManager;

    //초기화면
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView init(Post post) throws Exception {
        List<Post> list = postManager.boardList();
        System.out.println("로그인완료되면 초기페이지 호출");
        //return new ModelAndView("index", "list", list);
        System.out.println(list);
        return new ModelAndView("index", "list", list);
    }

    //리스트보기
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView list() throws Exception {
        List<Post> list = postManager.boardList();
        System.out.println("로그인완료되면 index페이지 호출");
        return new ModelAndView("index", "list", list);
    }


    //글작성 페이지
    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public ModelAndView post(@ModelAttribute("Post") Post post) {

        System.out.println("post페이지 호출");
        return new ModelAndView("post");
    }

    //글작성 저장
    @RequestMapping(value = "/writePost", method = RequestMethod.POST) //새로운 게시물 DB에 저장
    public String writePost(@ModelAttribute("Post") Post post) {
       //post.setMember();
        postManager.postInsert(post);
        System.out.println("글저장");
        return "redirect:/index";
    }

    //디텔일하게 글보기
    @RequestMapping(value = "/{bno}", method = RequestMethod.GET)
    public ModelAndView view(@PathVariable("bno") int bno)  {
        Post post = postManager.postView(bno);
        postManager.hitPlus(bno);
        System.out.println("글디테일하게 보기");
        return new ModelAndView("viewdetail", "post", post);
    }


    //글 수정 페이지
    @RequestMapping(value = "/post/{bno}", method = RequestMethod.GET)
    public ModelAndView modify(@PathVariable("bno") int bno)  {
        Post post = postManager.postView(bno);
        System.out.println("modify페이지 호출");
        return new ModelAndView("post", "modify", post);
    }

    //글수정 저장
    @RequestMapping(value = "/post", method = RequestMethod.PATCH) //새로운 게시물 DB에 저장
    public String writeModify(@ModelAttribute("Post") Post post, @PathVariable("bno") int bno){
        postManager.postModify(post);
        System.out.println("글저장");
        return "redirect://172.25.101.93:5009/modify" + bno;
    }


    @RequestMapping(value = "/login/form", method = RequestMethod.GET)
    public String loginForm(UserVO userVo) {
        System.out.println("로그인인증");

        return "login";
    }
}
