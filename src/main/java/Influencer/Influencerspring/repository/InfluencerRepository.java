package Influencer.Influencerspring.repository;

import Influencer.Influencerspring.domain.Hashtag;
import Influencer.Influencerspring.domain.InfProfile;
import Influencer.Influencerspring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InfluencerRepository {

    List<InfProfile> findByInf_username(String inf_username);

    List<InfProfile> findAll();

    Optional<Hashtag> findByKeyword(String keyword);
}
