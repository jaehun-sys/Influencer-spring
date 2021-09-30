package Influencer.Influencerspring.mapper;

import Influencer.Influencerspring.domain.FilterForm;
import Influencer.Influencerspring.domain.FilterResult;
import Influencer.Influencerspring.domain.InfProEngTex;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface InfluencerMapper {
    List<InfProEngTex> filteringList(InfProEngTex ipet);


    //List<FilterResult> filterResults(FilterForm filter, FilterResult result);

    List<InfProEngTex> filterResults(InfProEngTex ipet);

}
