package Influencer.Influencerspring.service;

import Influencer.Influencerspring.domain.InfProEngTex;
import Influencer.Influencerspring.mapper.InfluencerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilteringListService {
    @Autowired
    public InfluencerMapper mapper;

    public List<InfProEngTex> filteringList(InfProEngTex ipet){
        return mapper.filteringList(ipet);
    }
}
