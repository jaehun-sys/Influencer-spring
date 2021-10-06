package Influencer.Influencerspring.service;

import Influencer.Influencerspring.domain.InfEngPro;
import Influencer.Influencerspring.domain.InfProEngTex;
import Influencer.Influencerspring.domain.Term;
import Influencer.Influencerspring.mapper.InfluencerMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class FilteringListService {
    @Autowired
    private final InfluencerMapper influencerMapper;

    public FilteringListService(InfluencerMapper influencerMapper) {
        this.influencerMapper = influencerMapper;
    }

    /* 인플루언서 추천 필터링 */
    public List<InfProEngTex> filterResults(InfProEngTex ipet){
        return influencerMapper.filterResults(ipet);
    }

    /* 상세 페이지 */
    public List<InfEngPro> details(String username){
        return influencerMapper.details(username);
    }

    /* 키워드 연관 키워드 */
    public List<Term> relatedKeyterms(Term tForm){
        return influencerMapper.relatedKeyterms(tForm);
    }
}
