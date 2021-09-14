package Influencer.Influencerspring.controller;

import Influencer.Influencerspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //스프링 컨테이너가 MemberController 객체를 생성해서 스프링이 관리를 해줌.
public class MemberController {

    private final MemberService memberService;

    @Autowired  //MemberService를 스프링이 스프링컨테이너에 있는 MemberService에다가 연결시켜줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMembersForm";
    }
}
