package Influencer.Influencerspring.controller;

import Influencer.Influencerspring.domain.*;
import Influencer.Influencerspring.service.FilteringListService;
import Influencer.Influencerspring.service.HashtagService;
import Influencer.Influencerspring.service.InfluencerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public String fakeRealRe(@RequestParam(value="username", required=false) String username, Model model) throws Exception{
        List<InfProfile> inf_profile = influencerService.findTrueFalse(username);

        System.out.println("username: " + username);
        for(int i=0; i<inf_profile.size(); i++){
            System.out.println("result"+i+": "+ inf_profile.get(i));
        }

        model.addAttribute("inf_profile", inf_profile);
        return "fake-real";
    }

    @GetMapping("/search-hash")
    public String searchHashRe(@RequestParam(value="keyword", required=false) String keyword, Model model) throws Exception{
        List<Hashtag> hashtags = hashtagService.findHashtag(keyword);

        System.out.println("해시태그 키워드: " + keyword);
        for (int i=0; i<hashtags.size(); i++){
            System.out.println("result"+i+": "+hashtags.get(i));
        }

//        List<String> relatedDatas = new ArrayList<>();
//        relatedDatas.add(hashtags.get(0).getKeyword());
//        relatedDatas.add(hashtags.get(0).getAvg_liked());
//        relatedDatas.add(hashtags.get(0).getRelated_username());
//        for (int i=0; i<hashtags.size(); i++){
//            System.out.println(relatedDatas.get(i));
//        }

        model.addAttribute("hashtags", hashtags);
//        model.addAttribute("relatedDatas",relatedDatas);

        return "search-hash";
    }


    /* ↓ 샘플링 ↓ */

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

//        List<String> relatedDatas = new ArrayList<>();
//        relatedDatas.add(hashtags.get(0).getKeyword());
//        relatedDatas.add(hashtags.get(0).getAvg_liked());
//        relatedDatas.add(hashtags.get(0).getRelated_username());
//        for (int i=0; i<hashtags.size(); i++){
//            System.out.println(relatedDatas.get(i));
//        }

        model.addAttribute("hashtags", hashtags);
//        model.addAttribute("relatedDatas",relatedDatas);

        return "temp/hashtag_search";
    }

    @GetMapping("/influencer_recommend")
    public String influencerRe(){
        return "temp/influencer_recommend";
    }

    @GetMapping("/influencer_recommend/results")
    public String influencerRecommend(@ModelAttribute InfProEngTex form, Model model){


        System.out.println("인프성별: " + form.getInputAudSex());
        System.out.println("인프캠페인: " + form.getInputCat());
        System.out.println("인프연령: " + form.getInputInfAge());
        System.out.println("오디성별: " + form.getInputAudSex());
        System.out.println("오디연령: " + form.getInputAudAge());
        System.out.println("RF가중치: " + form.getRf_weight());
        System.out.println("RE가중치: " + form.getRe_weight());
        System.out.println("AC가중치: " + form.getAc_weight());

        List<InfProEngTex> filterResults = filteringListService.filterResults(form);
        for(int i=0; i<filterResults.size(); i++){
            System.out.println("순위: "+String.valueOf(filterResults.get(i).getRankno()));
            System.out.println("계정명: "+String.valueOf(filterResults.get(i).getUsername()));
            System.out.println("진짜영향력: "+String.valueOf(filterResults.get(i).getRealInf()));
            System.out.println("바이오: "+String.valueOf(filterResults.get(i).getBio()));
            System.out.println("카테고리: "+String.valueOf(filterResults.get(i).getCat()));
            System.out.println("팔로워수: "+String.valueOf(filterResults.get(i).getFollowers()));
            System.out.println("활성도: "+String.valueOf(filterResults.get(i).getActivity()));
            System.out.println("반응도: "+String.valueOf(filterResults.get(i).getReaction()));
        }

        model.addAttribute("List",filteringListService.filterResults(form));

        return "temp/influencer_recommend";
    }

    @GetMapping("/Detail")
    public String Detail(@RequestParam("username") String username, Model model){
        System.out.println("상세페이지로 갈 username: " + username);

        List<InfEngPro> result = filteringListService.details(username);
        for(int i=0; i<result.size(); i++){
            System.out.println(i+"계정명: "+result.get(i).getUsername());
            System.out.println(i+"오디성별: "+result.get(i).getAud_sex());
            System.out.println(i+"활성도: "+result.get(i).getActivity());
            System.out.println(i+"바이오: "+result.get(i).getBio());
            System.out.println(i+"오디연령: "+result.get(i).getAvg_age());
            System.out.println(i+"카테고리: "+result.get(i).getCategory());
            System.out.println(i+"피드수: "+result.get(i).getFeeds());
            System.out.println(i+"팔로워수: "+result.get(i).getFollowers());
            System.out.println(i+"팔로윙수: "+result.get(i).getFollowings());
            System.out.println(i+"반응도: "+result.get(i).getReaction());
            System.out.println(i+"진짜최소: "+result.get(i).getReal_min());
            System.out.println(i+"진짜최대: "+result.get(i).getReal_max());
        }
        model.addAttribute("userinfo", filteringListService.details(username));

        return "temp/Detail";
    }





}
