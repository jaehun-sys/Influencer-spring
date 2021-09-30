package Influencer.Influencerspring.controller;

import Influencer.Influencerspring.domain.*;
import Influencer.Influencerspring.service.FilteringListService;
import Influencer.Influencerspring.service.HashtagService;
import Influencer.Influencerspring.service.InfluencerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InfluencerController {

    private InfluencerService influencerService;
    private HashtagService hashtagService;
    private FilteringListService filteringListService;

    @Autowired
    public InfluencerController(InfluencerService influencerService, HashtagService hashtagService, FilteringListService filteringListService) {
        this.influencerService = influencerService;
        this.hashtagService = hashtagService;
        this.filteringListService = filteringListService;

    }

    @GetMapping("/fake-real")
    public String trueFalseResult1(){//@RequestParam(value="username", required=false) String username, Model model) throws Exception{
//        List<InfProfile> inf_profile = influencerService.findTrueFalse(username);
//        model.addAttribute("inf_profile", inf_profile);
        return "fake-real";
    }

    @GetMapping("/true_false")
    public String trueFalseResult(@RequestParam(value="username", required=false) String username, Model model) throws Exception{
        List<InfProfile> inf_profile = influencerService.findTrueFalse(username);
        model.addAttribute("inf_profile", inf_profile);
        return "temp/true_false";
    }

    @GetMapping("/hashtag_search")
    public String hashtagSearch(@RequestParam(value="keyword", required=false) String keyword, Model model) throws Exception{
        List<Hashtag> hashtags = hashtagService.findHashtag(keyword);
        model.addAttribute("hashtags", hashtags);
        return "temp/hashtag_search";
    }

    @GetMapping("/influencer_recommend")
    public String influencerRe(){
        return "temp/influencer_recommend";
    }

    @GetMapping("/2")
    public String influencerRecommend(@ModelAttribute InfProEngTex form, Model model){


        System.out.println("인프성별: " + form.getInputAudSex());
        System.out.println("인프캠페인: " + form.getInputCat());
        System.out.println("인프연령: " + form.getInputInfAge());
        System.out.println("오디성별: " + form.getInputAudSex());
        System.out.println("오디연령: " + form.getInputAudAge());

        FilterResult result = new FilterResult();
        List<InfProEngTex> filterResults = filteringListService.filterResults(form);
        for(int i=0; i<filterResults.size(); i++){
            System.out.println(String.valueOf(filterResults.get(i)));
        }

        model.addAttribute("List",filteringListService.filterResults(form));

        return "temp/influencer_recommend";
    }

    @GetMapping("/Detail")
    public String Detail(@RequestParam("username") String username, Model model){
        System.out.println("상세페이지로 갈 username: " + username);

        return "temp/Detail";
    }






/* 연습한거 */
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
