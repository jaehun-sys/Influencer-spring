package Influencer.Influencerspring.controller;

import org.apache.tomcat.util.net.TLSClientHelloExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InfluencerController {

    @GetMapping("true-false")
    public String validateTrueFalse(){
        return "true-false";
    }

    @GetMapping("hello") //웹 어플리케이션에서 "/influencer"라고 들어오면 influencer 메소드를 호출
    public String influencer(Model model){
        //data를 influencer로 넘기겠다는 뜻(key는 data,  value는 influencer)
        model.addAttribute("data", "influencer!!");
        //templates에 있는 influencer.html로 data 가지고 넘어가라.
        return "hello";
    }

    //MVC template 엔진
    //외부에서 데이터 입력
    @GetMapping("hello-mvc")
    public String mvcTest(@RequestParam(value = "name", required = true) String name, Model model){
        model.addAttribute("name", name);
        return "sample-template";
    }

    //API 연습1
    //template 엔진과의 차이 : view 가 없다.
    @GetMapping("hello-string")
    //html에 나오는 body가 아님. http에서 header부와 body부가 있는데 그 body부에 name을 직접 넣어주겠다는 뜻. 원래는 view한테 그냥 넘김.
    //view에 주고 그런거 없이 문자 그대로 감. ex) "localhost:8080/hello-string?name=spring!!!!"
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; //-> "hello spring"
    }
    
    //API 연습2
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;   //기존의 문자열이 아니고 객체네? json 형식으로 들어감(name:spring)
    }

    static class Hello{
        private String name;    //key가 name

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
