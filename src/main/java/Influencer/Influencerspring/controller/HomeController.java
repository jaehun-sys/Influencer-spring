package Influencer.Influencerspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //localhost:8080으로 들어오면 바로 뜨는 창
    @GetMapping("/")
    public String home(){   //우선 지금은 로그인창을 홈 화면으로 했음 2021-09-14
        return "login";
    }
}
