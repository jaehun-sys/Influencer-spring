package Influencer.Influencerspring.repository;

import Influencer.Influencerspring.domain.Hashtag;

import java.util.List;

public interface HashtagRepository {

    List<Hashtag> findByKeyword(String keyword);
}
