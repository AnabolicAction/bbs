package com.bbs.controller;

import com.bbs.domain.Member;
import com.bbs.repository.MemberRepository;
import com.bbs.vo.MemberVO;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.awt.print.Pageable;

@Controller
@Log
public class WebBoardController {
    @Autowired
    private MemberRepository memberRepository;

//    @RequestMapping(value = "/index", method = RequestMethod.GET)
//    public String list(MemberVO memberVO, Model model){
//        log.info("list() called");
//        System.out.println("dd");
//        model.addAttribute("result" ,memberVO);
//    return "/index";
//    }
}
