package Influencer.Influencerspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InfluencerController {

    @GetMapping("influencer") //웹 어플리케이션에서 "/influencer"라고 들어오면 influencer 메소드를 호출
    public String influencer(Model model){
        //data를 influencer로 넘기겠다는 뜻(key는 data,  value는 influencer)
        model.addAttribute("data", "influencer!!");
        //templates에 있는 influencer.html로 data 가지고 넘어가라.
        return "influencer";
    }

    //MVC template 엔진
    //외부에서 데이터 입력
    @GetMapping("hello-mvc")
    public String mvcTest(@RequestParam(value = "name", required = true) String name, Model model){
        model.addAttribute("name", name);
        return "sample-template";
    }

    //API
    //template 엔진과의 차이 : view 가 없다.
    @GetMapping("hello-string")
    //html에 나오는 body가 아님. http에서 head부와 body부가 있는데 그 body부에 name을 직접 넣어주겠다는 뜻
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello"; // hello spring
    }

}
