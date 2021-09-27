package Influencer.Influencerspring.repository;

import Influencer.Influencerspring.domain.Hashtag;
import Influencer.Influencerspring.domain.InfFolRate;
import Influencer.Influencerspring.domain.InfProfile;
import Influencer.Influencerspring.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.HateoasPageableHandlerMethodArgumentResolver;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class JpaInfluencerRepository implements InfluencerRepository{

    public JpaInfluencerRepository(EntityManager em) {
        this.em = em;
    }
    private final EntityManager em;

    @Override
    public List<InfProfile> findByInf_username(String inf_username) {
//        List<InfProfile> result = null;
//        List<InfProfile> result = em.createQuery("select i.inf_username, i.pic_url, i.fol_count, i.folwing_count, i.real_fol_count from InfProfile i where i.inf_username = :inf_username", InfProfile.class)
//                .setParameter("inf_username", inf_username)
//                .getResultList();
//        TypedQuery typedQuery = em.createQuery("select i.inf_username, i.pic_url, i.fol_count, i.folwing_count, i.real_fol_count from InfProfile i where i.inf_username = :inf_username", InfProfile.class);

//        typedQuery.setParameter("inf_username", inf_username);
//        List<InfProfile> resultList = typedQuery.getResultList();

        List<InfProfile> resultList = em.createQuery("select i from InfProfile i where i.inf_username = :inf_username", InfProfile.class)
                .setParameter("inf_username",inf_username)
                .getResultList();

//        System.out.println(resultList.get(0));
//        List<InfProfile> result = query.getResultList();
//        System.out.println(result.get(0).getClass());
        return resultList;//result;//.stream().findAny();
    }

    @Override
    public Optional<Hashtag> findByKeyword(String keyword) {
        List<Hashtag> result = em.createQuery(
                "SELECT h " +
                        "FROM   Hashtag h " +
                        "WHERE  h.keyword LIKE CONCAT ( '%',:keyword, '%') ", Hashtag.class)
                .setParameter("keyword",keyword)
                .getResultList();
        System.out.println(result.stream().findAny());
        //System.out.println(result.get(0).getClass());
        return result.stream().findAny();
    }

    @Override
    public List<InfProfile> findAll() {
        List<InfProfile> result = em.createQuery("select m from InfProfile m", InfProfile.class)
                .getResultList();
        return result;
    }
}
