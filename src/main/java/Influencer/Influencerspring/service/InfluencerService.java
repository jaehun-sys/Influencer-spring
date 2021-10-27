package Influencer.Influencerspring.service;

import Influencer.Influencerspring.domain.Hashtag;
import Influencer.Influencerspring.domain.InfProfile;

import Influencer.Influencerspring.repository.HashtagRepository;
import Influencer.Influencerspring.repository.InfluencerRepository;
import Influencer.Influencerspring.repository.JpaInfluencerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class InfluencerService {

    private final InfluencerRepository influencerRepository;

    public InfluencerService(InfluencerRepository influencerRepository) {
        this.influencerRepository = influencerRepository;
    }

    public List<InfProfile> findInfluencers(){
        return influencerRepository.findAll();
    }

    /* 진짜 가짜 조회 */
    public List<InfProfile> findTrueFalse(String inf_username){
        return influencerRepository.findByInf_username(inf_username);
    }

    /* 페이징 */
/*    public Page<InfProfile> getCompanyPage(Pageable pageable) {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "id"));
        return influencerRepository.findAll(pageable);
    }*/

}
