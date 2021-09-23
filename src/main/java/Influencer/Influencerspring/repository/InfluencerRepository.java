package Influencer.Influencerspring.repository;

import Influencer.Influencerspring.domain.InfProfile;
import Influencer.Influencerspring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface InfluencerRepository {

    Optional<InfProfile> findByInf_username(String inf_username);

    List<InfProfile> findAll();
}
