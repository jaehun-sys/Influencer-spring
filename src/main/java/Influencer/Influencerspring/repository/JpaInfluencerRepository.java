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
    public Optional<InfProfile> findByInf_username(String inf_username) {
        List<InfProfile> result = em.createQuery("select m.inf_username, m.pic_url, " +
                        "m.fol_count, m.folwing_count, m.real_fol_count " +
                        "from InfProfile m where m.inf_username = :inf_username", InfProfile.class)
                .setParameter("inf_username", inf_username)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<InfProfile> findAll() {
        List<InfProfile> result = em.createQuery("select m from InfProfile m", InfProfile.class)
                .getResultList();
        return result;
    }

}
