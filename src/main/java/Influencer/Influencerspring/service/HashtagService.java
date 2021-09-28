package Influencer.Influencerspring.service;

import Influencer.Influencerspring.domain.Hashtag;
import Influencer.Influencerspring.repository.HashtagRepository;

import java.util.List;

public class HashtagService {

    private final HashtagRepository hashtagRepository;

    public HashtagService(HashtagRepository hashtagRepository) {
        this.hashtagRepository = hashtagRepository;
    }

    /* 해시태그 조회 */
    public List<Hashtag> findHashtag(String keyword){
        return hashtagRepository.findByKeyword(keyword);
    }
}
