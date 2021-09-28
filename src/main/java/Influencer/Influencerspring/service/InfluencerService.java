package Influencer.Influencerspring.service;

import Influencer.Influencerspring.domain.Hashtag;
import Influencer.Influencerspring.domain.InfProfile;

import Influencer.Influencerspring.repository.HashtagRepository;
import Influencer.Influencerspring.repository.InfluencerRepository;
import org.springframework.beans.factory.annotation.Autowired;
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


}
