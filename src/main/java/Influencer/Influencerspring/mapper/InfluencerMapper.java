package Influencer.Influencerspring.mapper;

import Influencer.Influencerspring.domain.InfEngPro;
import Influencer.Influencerspring.domain.InfProEngTex;
import Influencer.Influencerspring.domain.Term;
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
    List<InfEngPro> details(String username);

    /* 키워드 연관 키워드 */
    List<Term> relatedKeyterms(Term tForm);

    int getTotalRow(String search);
}
