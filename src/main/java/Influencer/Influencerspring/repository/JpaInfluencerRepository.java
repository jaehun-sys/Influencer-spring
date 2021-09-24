package Influencer.Influencerspring.repository;

import Influencer.Influencerspring.domain.InfFolRate;
import Influencer.Influencerspring.domain.InfProfile;
import Influencer.Influencerspring.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaInfluencerRepository implements InfluencerRepository{

    public JpaInfluencerRepository(EntityManager em) {
        this.em = em;
    }
    private final EntityManager em;

    @Override
    public List<InfProfile> findByInf_username(String inf_username) {
        List<InfProfile> result = em.createQuery("select i.inf_username, i.pic_url, i.fol_count, i.folwing_count, i.real_fol_count from InfProfile i where i.inf_username = :inf_username", InfProfile.class)
                .setParameter("inf_username", inf_username)
                .getResultList();
        System.out.println(result.get(0).getClass());
        return result;//.stream().findAny();
    }

    @Override
    public List<InfProfile> findAll() {
        List<InfProfile> result = em.createQuery("select m from InfProfile m", InfProfile.class)
                .getResultList();
        return result;
    }

}
