package Influencer.Influencerspring.controller;

import Influencer.Influencerspring.domain.Member;
import Influencer.Influencerspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller //스프링 컨테이너가 MemberController 객체를 생성해서 스프링이 관리를 해줌. new로 생성해버리면 여러 컨트롤러에서 다 쓸수 있기 때문
public class MemberController {

    private final MemberService memberService;

    //생성자 주입
    @Autowired  //MemberService를 스프링이 스프링컨테이너에 있는 MemberService에다가 연결시켜줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String login(){
        return "temp/login";
    }

    @PostMapping("/login")
    public String isRightMember(@ModelAttribute Member member, Model model) throws Exception{
        System.out.println("입력한 ID: " + member.getMemberid());
        System.out.println("입력한 PW: " + member.getPassword());

        Optional<Member> result = memberService.findMemberId(member.getMemberid());
        System.out.println("저장된 ID: " + result.get().getMemberid());
        System.out.println("저장된 PW: " + result.get().getPassword());
        if(member.getMemberid().equals(result.get().getMemberid())){
            if(member.getPassword().equals(result.get().getPassword())){
                System.out.println("로그인 성공!");
                return "redirect:/";
            }
            else{
                System.out.println("패스워드 실패!");
            }
        }
        else{
            System.out.println("로그인 실패!");
            return "temp/loginFailure";
        }
        return "temp/loginFailure";
    }

    @GetMapping("/members/new") //회원가입창
    public String createForm(){
        return "members/createMembersForm";
    }

    @PostMapping("/members/new")    //회원가입 창에서 항목들 텍스트 입력받으면 처음 화면으로 돌아가게 했음
    public String create(MemberForm form){
        Member member = new Member();

        member.setMemberno(form.getMemberno()); //얘는 시스템이 부여하는 값인데..
        member.setMemberid(form.getMemberid());
        member.setName(form.getName());
        member.setNickname(form.getNickname());
        member.setPassword(form.getPassword());
        member.setEmail(form.getEmail());
        member.setBirthday((form.getYy()+form.getMm()+form.getDd()));   //년월일 합치기
        member.setMem_sex(form.getMem_sex());
        member.setPhoneno(form.getPhoneno());

        System.out.println("member: " + member);
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")         //회원 조회
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members); // 왼쪽(초록색) 키에 있는 members에 오른쪽(value) members는 리스트로 싹 들어있다.
        return "members/memberList";
    }
}
