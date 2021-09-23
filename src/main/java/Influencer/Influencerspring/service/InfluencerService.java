package Influencer.Influencerspring.service;

import Influencer.Influencerspring.domain.InfProfile;

import Influencer.Influencerspring.repository.InfluencerRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class InfluencerService {

    public InfluencerService(InfluencerRepository influencerRepository) {
        this.influencerRepository = influencerRepository;
    }

    private final InfluencerRepository influencerRepository;


    /* 전체 회원 조회 */
    public List<InfProfile> findMembers(){
        return influencerRepository.findAll();
    }

    public Optional<InfProfile> findOne(String inf_username){
        return influencerRepository.findByInf_username(inf_username);
    }

}
