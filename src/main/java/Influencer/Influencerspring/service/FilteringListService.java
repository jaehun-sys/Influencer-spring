package Influencer.Influencerspring.service;

import Influencer.Influencerspring.domain.FilterForm;
import Influencer.Influencerspring.domain.FilterResult;
import Influencer.Influencerspring.domain.InfProEngTex;
import Influencer.Influencerspring.mapper.InfluencerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilteringListService {
    @Autowired
    private final InfluencerMapper influencerMapper;

    public FilteringListService(InfluencerMapper influencerMapper) {
        this.influencerMapper = influencerMapper;
    }

    public List<InfProEngTex> filteringList(InfProEngTex ipet){
        return influencerMapper.filteringList(ipet);
    }

    public List<InfProEngTex> filterResults(InfProEngTex ipet){
        return influencerMapper.filterResults(ipet);
    }
}
