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

        System.out.println("username: " + username);
        for(int i=0; i<inf_profile.size(); i++){
            System.out.println("result"+i+": "+ inf_profile.get(i));
        }

        model.addAttribute("inf_profile", inf_profile);
        return "temp/true_false";
    }

    @GetMapping("/hashtag_search")
    public String hashtagSearch(@RequestParam(value="keyword", required=false) String keyword, Model model) throws Exception{
        List<Hashtag> hashtags = hashtagService.findHashtag(keyword);

        System.out.println("해시태그 키워드: " + keyword);
        for (int i=0; i<hashtags.size(); i++){
            System.out.println("result"+i+": "+hashtags.get(i));
        }
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





}
