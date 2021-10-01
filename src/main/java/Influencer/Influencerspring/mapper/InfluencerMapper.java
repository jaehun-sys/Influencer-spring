package Influencer.Influencerspring.mapper;

import Influencer.Influencerspring.domain.InfEngPro;
import Influencer.Influencerspring.domain.InfProEngTex;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface InfluencerMapper {

    //List<FilterResult> filterResults(FilterForm filter, FilterResult result);

    /* 인플루언서 추천 필터링 */
    List<InfProEngTex> filterResults(InfProEngTex ipet);

    /* 상세 페이지 */
    List<InfEngPro> details(InfEngPro iep);

}
