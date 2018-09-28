package com.bbs.controller;

import com.bbs.service.MemberManager;
import com.bbs.service.MemberManagerImpl;
import com.bbs.service.PostManager;
import com.bbs.vo.PostVO;
import com.bbs.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller

public class BoardController {

  @Autowired
  private MemberManagerImpl memberManager;

  @Autowired
  private PostManager postManager;

//초기화면
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView init(PostVO postVO) throws Exception {

    List<PostVO> list = postManager.boardList();

      System.out.println("로그인완료되면 초기페이지 호출");
      return new ModelAndView("index", "list", list);

  }
//리스트보기
  @RequestMapping(value = "/index", method = RequestMethod.GET)
  public ModelAndView list(PostVO postVO) throws Exception {
    // memberVO = getMemberVO(memberVO);
    // postVO= getPostVO(postVO);
    List<PostVO> list=postManager.boardList();
    System.out.println("로그인완료되면 index페이지 호출");
    return new ModelAndView("index","list",list);
  }


 //글작성 페이지
  @RequestMapping(value = "/post", method = RequestMethod.GET)
  public ModelAndView post(@ModelAttribute("PostVO") PostVO postVO) throws Exception {
    //postManager.postInsert(postVO);
    System.out.println("post페이지 호출");
    return new ModelAndView("post");
  }


  @RequestMapping(value = "/login/form", method = RequestMethod.GET)
  public String loginForm(UserVO userVo) {
    System.out.println("로그인인증");

    return "login";
  }
}
