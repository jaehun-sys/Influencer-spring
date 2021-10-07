package Influencer.Influencerspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    //localhost:8080으로 들어오면 바로 뜨는 창
    @GetMapping("/home")
    public String main(){ return "main";}

    @GetMapping("/home1")
    public String main1(){ return "main1";}

    @GetMapping("/")
    public String home(){   //우선 지금은 로그인창을 홈 화면으로 했음 2021-09-14
        return "temp/home";
    }

    @GetMapping("/1")
    public String index1(){
        return "index";
    }


    @GetMapping("/accordion")
    public String accordion(){
        return "accordion";
    }
    @GetMapping("/button")
    public String button(){
        return "button";
    }
    @GetMapping("/label-badge")
    public String labelbadge(){
        return "label-badge";
    }
    @GetMapping("/grid-system")
    public String gridsystem(){
        return "bootstrap-ui";
    }
    @GetMapping("/box-shadow")
    public String boxshadow(){
        return "box-shadow";
    }
    @GetMapping("/color")
    public String color(){
        return "color";
    }
    @GetMapping("/light-box")
    public String lightbox(){
        return "light-box";
    }
    @GetMapping("/notification")
    public String notification(){
        return "notification";
    }
    @GetMapping("/panels-wells")
    public String panelswells(){
        return "panels-wells";
    }
    @GetMapping("/tabs")
    public String tabs(){
        return "tabs";
    }
    @GetMapping("/tooltips")
    public String tooltips(){
        return "tooltips";
    }
    @GetMapping("/typography")
    public String typography(){
        return "typography";
    }
    @GetMapping("/float-chart")
    public String floatchart(){
        return "float-chart";
    }
    @GetMapping("/morris-chart")
    public String morrischart(){
        return "morris-chart";
    }
    @GetMapping("/form-elements-bootstrap")
    public String formElementsBootstrap(){
        return "form-elements-bootstrap";
    }
    @GetMapping("/form-elements-advance")
    public String formElementsAdvance(){
        return "form-elements-advance";
    }
    @GetMapping("/basic-table")
    public String basictable(){
        return "basic-table";
    }
    @GetMapping("/login1")
    public String login1(){
        return "login1";
    }
    @GetMapping("register1")
    public String register1(){
        return "register1";
    }
    @GetMapping("/forgot-password")
    public String forgotPassword(){
        return "forgot-password";
    }
    @GetMapping("/404")
    public String fourZeroFour(){
        return "404";
    }
    @GetMapping("/sample-page")
    public String samplePage(){
        return "sample-page";
    }
}
