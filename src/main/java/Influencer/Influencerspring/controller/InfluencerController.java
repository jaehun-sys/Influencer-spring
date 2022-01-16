package Influencer.Influencerspring.controller;

import Influencer.Influencerspring.domain.*;
import Influencer.Influencerspring.paging.Paging;
import Influencer.Influencerspring.service.FilteringListService;
import Influencer.Influencerspring.service.HashtagService;
import Influencer.Influencerspring.service.InfluencerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.util.List;

@Controller
public class InfluencerController {

    private final InfluencerService influencerService;
    private final HashtagService hashtagService;
    private final FilteringListService filteringListService;

    @Autowired
    public InfluencerController(InfluencerService influencerService, HashtagService hashtagService, FilteringListService filteringListService) {
        this.influencerService = influencerService;
        this.hashtagService = hashtagService;
        this.filteringListService = filteringListService;

    }

    @GetMapping("/fake-real")/* 기본적으로 전체 목록 출력 */
    public String fakeReal(String username, Model model, HttpServletRequest request) throws Exception{
        username="";
        List<InfProfile> inf_profile = influencerService.findTrueFalse(username);
        //PageRequest.of(1, 20)

        //숫자 콤마 표시
        DecimalFormat formatter = new DecimalFormat("###,###");
        for(int i=0; i<inf_profile.size(); i++){
            inf_profile.get(i).setFol_count(  formatter.format(Integer.parseInt(inf_profile.get(i).getFol_count()))  );
            inf_profile.get(i).setFolwing_count(   formatter.format(Integer.parseInt(inf_profile.get(i).getFolwing_count()))   );
            inf_profile.get(i).setReal_fol_count(   formatter.format(Integer.parseInt(inf_profile.get(i).getReal_fol_count()))   );
        }

        // 리스트 가져오기(페이징)
        int page = 1;

        if(request.getParameter("page")!=null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        Paging paging = new Paging();
        paging.setPage(page);
        paging.setTotalRow(dao.getTotalRow(search, kwd));
        paging.paging();

        model.addAttribute("inf_profile", inf_profile);
        return "fake-real";
    }

    @GetMapping("/fake-real-re")
    public String fakeRealRe(@RequestParam(value="username", required=false) String username, Model model) throws Exception{
        List<InfProfile> inf_profile = influencerService.findTrueFalse(username);

        //숫자 콤마 표시
        DecimalFormat formatter = new DecimalFormat("###,###");
        for(int i=0; i<inf_profile.size(); i++){
            inf_profile.get(i).setFol_count(  formatter.format(Integer.parseInt(inf_profile.get(i).getFol_count()))  );
            inf_profile.get(i).setFolwing_count(   formatter.format(Integer.parseInt(inf_profile.get(i).getFolwing_count()))   );
            inf_profile.get(i).setReal_fol_count(   formatter.format(Integer.parseInt(inf_profile.get(i).getReal_fol_count()))   );
        }

        System.out.println("username: " + username);
        for(int i=0; i<inf_profile.size(); i++){
            System.out.println("result"+i+": "+ inf_profile.get(i));
        }

        model.addAttribute("inf_profile", inf_profile);
        return "fake-real";
    }

    @GetMapping("/search-hash")/* 기본적으로 전체 목록 출력 */
    public String searchHash(String keyword, Model model) throws Exception{
        keyword="";
        List<Hashtag> hashtags = hashtagService.findHashtag(keyword);

        //숫자 콤마 표시. 하지말자. 소수점이 없어진다.
//        DecimalFormat formatter = new DecimalFormat("###,###");
//        for(int i=0; i<hashtags.size(); i++){
//            hashtags.get(i).setAvg_liked(  formatter.format(Double.parseDouble(hashtags.get(i).getAvg_liked()))  );
//        }

        model.addAttribute("hashtags", hashtags);
        return "search-hash";
    }

    @GetMapping("/search-hash/results")
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

    @GetMapping("/recommend-influencer")
    public String recommendInf(){
        return "recommend-influencer";
    }

//    @GetMapping("/3")
//    public String recommendTemp(){return "recommend-influencer-result";}

    @GetMapping("/recommend-influencer/results")
    public String recommendInfResults(@ModelAttribute InfProEngTex form,
                                      @RequestParam("keyTerm") String keyTerm, Model model, HttpSession session){
        form.setAc_weight(0.4);
        form.setRe_weight(0.4);
        form.setRf_weight(0.3);

        System.out.println("인프성별: " + form.getInputAudSex());
        System.out.println("인프캠페인: " + form.getInputCat());
        System.out.println("인프연령: " + form.getInputInfAge());
        System.out.println("오디성별: " + form.getInputAudSex());
        System.out.println("오디연령: " + form.getInputAudAge());
        System.out.println("RF가중치: " + form.getRf_weight());
        System.out.println("RE가중치: " + form.getRe_weight());
        System.out.println("AC가중치: " + form.getAc_weight());


        /* 다음 페이지에도 이어지기 위해 session에 저장 */
        session.setAttribute("inputInfAge", form.getInputAudSex() );
        session.setAttribute("inputCat", form.getInputCat() );
        session.setAttribute("inputInfAge", form.getInputInfAge() );
        session.setAttribute("inputAudSex", form.getInputAudSex() );
        session.setAttribute("inputAudAge", form.getInputAudAge() );
        session.setAttribute("keyterm",keyTerm);

        List<InfProEngTex> filterResults = filteringListService.filterResults(form);
        for(int i=0; i<filterResults.size(); i++){
            //숫자 콤마 표시
            DecimalFormat formatter = new DecimalFormat("###,###");
            filterResults.get(i).setFollowers(  formatter.format(Integer.parseInt(filterResults.get(i).getFollowers()))  );
            filterResults.get(i).setReaction(   formatter.format(Integer.parseInt(filterResults.get(i).getReaction()))   );

            System.out.println("=============================");
            System.out.println("순위: "+ filterResults.get(i).getRankno());
            System.out.println("계정명: "+ filterResults.get(i).getUsername());
            System.out.println("바이오: "+ filterResults.get(i).getBio());
            System.out.println("카테고리: "+ filterResults.get(i).getCat());
            System.out.println("팔로워수: "+ filterResults.get(i).getFollowers());
            System.out.println("활성도: "+ filterResults.get(i).getActivity());
            System.out.println("반응도: "+ filterResults.get(i).getReaction());
        }

        model.addAttribute("List", filterResults);

        return "recommend-influencer-result";
    }

    @RequestMapping(value = "/recommend-influencer/results2", method = RequestMethod.POST)
    public String result2(@RequestParam("redirect") String redirect,
                          @RequestParam("rf_weight") Double rf,
                          @RequestParam("re_weight") Double re,
                          @RequestParam("ac_weight") Double ac, Model model, HttpSession session){
        System.out.println(redirect);
        InfProEngTex form = new InfProEngTex();

        System.out.println("rf가중치: "+rf);
        System.out.println("re가중치: "+re);
        System.out.println("ac가중치: "+ac);

        /* session에서 가져온걸로 form에 넣기 */
        form.setInputCat((String)session.getAttribute("inputCat"));
        form.setInputInfSex((String)session.getAttribute("inputCat"));
        form.setInputInfAge((String)session.getAttribute("inputInfAge"));
        form.setInputAudSex((String)session.getAttribute("inputAudSex"));
        form.setInputAudAge((String)session.getAttribute("inputAudAge"));
        form.setRe_weight(re);
        form.setAc_weight(ac);
        form.setRf_weight(rf);
//        String age = (String) session.getAttribute("age") ;
//        System.out.println(age);

//        //카테고리, 인프성별, 인프나이, 오디성별
//        ArrayList<String> list = new ArrayList<String>();
//        Pattern pattern = Pattern.compile("[=](.*?)[&]");
//        Matcher matcher = pattern.matcher(redirect);
//        while(matcher.find()){
//            list.add(matcher.group(1));
//            if(matcher.group(1)==null)
//                break;
//        }
//        //오디나이
//        String piece = redirect.substring(redirect.indexOf("inputAudAge"));
//
//        System.out.println("in카테고리: " + list.get(0));
//        System.out.println("in인프성별: " + list.get(1));
//        System.out.println("in인프나이: " + list.get(2));
//        System.out.println("in오디성별: " + list.get(3));
//        System.out.println("in오디나이: " + piece.substring(12));

//        form.setInputCat(list.get(0));
//        form.setInputInfSex(list.get(1));
//        form.setInputInfAge(list.get(2));
//        form.setInputAudSex(list.get(3));
//        form.setInputAudAge(piece.substring(12));
//        form.setRe_weight(re);
//        form.setAc_weight(ac);
//        form.setRf_weight(rf);

        System.out.println("form에 들어간 cat: "+ form.getInputCat());
        System.out.println("form에 들어간 인프성별: "+ form.getInputInfSex());
        System.out.println("form에 들어간 in인프나이: "+ form.getInputInfAge());
        System.out.println("form에 들어간 in오디성별: "+ form.getInputAudSex());
        System.out.println("form에 들어간 in오디나이: "+ form.getInputAudAge());
        System.out.println("form에 들어간 re: "+ form.getRe_weight());
        System.out.println("form에 들어간 ac: "+ form.getAc_weight());
        System.out.println("form에 들어간 rf: "+ form.getRf_weight());
        System.out.println("--------- 결과 페이지 ---------");

        List<InfProEngTex> filterResults = filteringListService.filterResults(form);
        for(int i=0; i<filterResults.size(); i++){
            //숫자 콤마 표시
            DecimalFormat formatter = new DecimalFormat("###,###");
            filterResults.get(i).setFollowers(  formatter.format(Integer.parseInt(filterResults.get(i).getFollowers()))  );
            filterResults.get(i).setReaction(   formatter.format(Integer.parseInt(filterResults.get(i).getReaction()))   );

            System.out.println("=======================");
            System.out.println("순위: "+ filterResults.get(i).getRankno());
            System.out.println("계정명: "+ filterResults.get(i).getUsername());
            System.out.println("바이오: "+ filterResults.get(i).getBio());
            System.out.println("카테고리: "+ filterResults.get(i).getCat());
            System.out.println("팔로워수: "+ filterResults.get(i).getFollowers());
            System.out.println("활성도: "+ filterResults.get(i).getActivity());
            System.out.println("반응도: "+ filterResults.get(i).getReaction());
        }

        model.addAttribute("List", filterResults);
        return "recommend-influencer-result";
    }


    /* 인플루언서 세부 정보 */
//    @GetMapping("/5")
//    public String detailpage(){return "detail-page";}

    @GetMapping("/detail-page")
    public String detail(@ModelAttribute Term tForm, @RequestParam("username") String username, Model model, HttpSession session){

        String keyterm = (String)session.getAttribute("keyterm");
        System.out.println("상세페이지로 갈 keyterm: " + keyterm);
        tForm.setKeyterm(keyterm);
        List<Term> termResult = filteringListService.relatedKeyterms(tForm);

        System.out.println("상세페이지로 갈 username: " + username);
        System.out.println("---------상세 페이지---------");

        List<InfEngPro> result = filteringListService.details(username);
        for(int i=0; i<result.size(); i++){
            //숫자 콤마 표시
            DecimalFormat formatter = new DecimalFormat("###,###");
            result.get(i).setFeeds(  formatter.format(Integer.parseInt(result.get(i).getFeeds()))  );
            result.get(i).setFollowers(   formatter.format(Integer.parseInt(result.get(i).getFollowers()))   );
            result.get(i).setReal_max(   formatter.format(Integer.parseInt(result.get(i).getReal_max()))   );
            result.get(i).setReal_min(   formatter.format(Integer.parseInt(result.get(i).getReal_min()))   );
            result.get(i).setReaction(   formatter.format(Integer.parseInt(result.get(i).getReaction()))   );
            result.get(i).setFollowings(   formatter.format(Integer.parseInt(result.get(i).getFollowings()))   );

            System.out.println("===========================");
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
        model.addAttribute("userinfo", result);
        model.addAttribute("keyterms", termResult);

        return "detail-page";
    }



    /* ↓ 샘플링 ↓ */
//
//    @GetMapping("/true_false")
//    public String trueFalseResult(@RequestParam(value="username", required=false) String username, Model model) throws Exception{
//        List<InfProfile> inf_profile = influencerService.findTrueFalse(username);
//
//        System.out.println("username: " + username);
//        for(int i=0; i<inf_profile.size(); i++){
//            System.out.println("result"+i+": "+ inf_profile.get(i));
//        }
//
//        model.addAttribute("inf_profile", inf_profile);
//        return "temp/true_false";
//    }
//
//    @GetMapping("/hashtag_search")
//    public String hashtagSearch(@RequestParam(value="keyword", required=false) String keyword, Model model) throws Exception{
//        List<Hashtag> hashtags = hashtagService.findHashtag(keyword);
//
//        System.out.println("해시태그 키워드: " + keyword);
//        for (int i=0; i<hashtags.size(); i++){
//            System.out.println("result"+i+": "+hashtags.get(i));
//        }
//
////        List<String> relatedDatas = new ArrayList<>();
////        relatedDatas.add(hashtags.get(0).getKeyword());
////        relatedDatas.add(hashtags.get(0).getAvg_liked());
////        relatedDatas.add(hashtags.get(0).getRelated_username());
////        for (int i=0; i<hashtags.size(); i++){
////            System.out.println(relatedDatas.get(i));
////        }
//
//        model.addAttribute("hashtags", hashtags);
////        model.addAttribute("relatedDatas",relatedDatas);
//
//        return "temp/hashtag_search";
//    }
//
//    @GetMapping("/influencer_recommend")
//    public String influencerRe(){
//        return "temp/influencer_recommend";
//    }
//
//    @GetMapping("/influencer_recommend/results")
//    public String influencerRecommend(@ModelAttribute InfProEngTex form, Model model){
//
//
//        System.out.println("인프성별: " + form.getInputAudSex());
//        System.out.println("인프캠페인: " + form.getInputCat());
//        System.out.println("인프연령: " + form.getInputInfAge());
//        System.out.println("오디성별: " + form.getInputAudSex());
//        System.out.println("오디연령: " + form.getInputAudAge());
//        System.out.println("RF가중치: " + form.getRf_weight());
//        System.out.println("RE가중치: " + form.getRe_weight());
//        System.out.println("AC가중치: " + form.getAc_weight());
//
//        List<InfProEngTex> filterResults = filteringListService.filterResults(form);
//        for(int i=0; i<filterResults.size(); i++){
//            System.out.println("순위: "+ filterResults.get(i).getRankno());
//            System.out.println("계정명: "+ filterResults.get(i).getUsername());
//            System.out.println("진짜영향력: "+ filterResults.get(i).getRealInf());
//            System.out.println("바이오: "+ filterResults.get(i).getBio());
//            System.out.println("카테고리: "+ filterResults.get(i).getCat());
//            System.out.println("팔로워수: "+ filterResults.get(i).getFollowers());
//            System.out.println("활성도: "+ filterResults.get(i).getActivity());
//            System.out.println("반응도: "+ filterResults.get(i).getReaction());
//        }
//
//        model.addAttribute("List",filteringListService.filterResults(form));
//
//        return "temp/influencer_recommend";
//    }
//
//    @GetMapping("/Detail")
//    public String Detail(@RequestParam("username") String username, Model model){
//        System.out.println("상세페이지로 갈 username: " + username);
//
//        List<InfEngPro> result = filteringListService.details(username);
//        for(int i=0; i<result.size(); i++){
//            System.out.println(i+"계정명: "+result.get(i).getUsername());
//            System.out.println(i+"오디성별: "+result.get(i).getAud_sex());
//            System.out.println(i+"활성도: "+result.get(i).getActivity());
//            System.out.println(i+"바이오: "+result.get(i).getBio());
//            System.out.println(i+"오디연령: "+result.get(i).getAvg_age());
//            System.out.println(i+"카테고리: "+result.get(i).getCategory());
//            System.out.println(i+"피드수: "+result.get(i).getFeeds());
//            System.out.println(i+"팔로워수: "+result.get(i).getFollowers());
//            System.out.println(i+"팔로윙수: "+result.get(i).getFollowings());
//            System.out.println(i+"반응도: "+result.get(i).getReaction());
//            System.out.println(i+"진짜최소: "+result.get(i).getReal_min());
//            System.out.println(i+"진짜최대: "+result.get(i).getReal_max());
//        }
//        model.addAttribute("userinfo", filteringListService.details(username));
//
//        return "temp/Detail";
//    }

}
