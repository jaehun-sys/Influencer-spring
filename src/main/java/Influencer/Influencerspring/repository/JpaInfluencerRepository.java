package Influencer.Influencerspring.repository;

import Influencer.Influencerspring.domain.InfProfile;

import javax.persistence.EntityManager;
import java.util.List;

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

/*        List<InfProfile> resultList = em.createQuery("select i from InfProfile i where i.inf_username = :inf_username", InfProfile.class)
                .setParameter("inf_username",inf_username)
                .getResultList();*/
        List<InfProfile> resultList = em.createQuery("select i from InfProfile i where i.inf_username LIKE CONCAT ( '%',:inf_username, '%')", InfProfile.class)
                .setParameter("inf_username",inf_username)
                .getResultList();

//        System.out.println(resultList.get(0));
//        List<InfProfile> result = query.getResultList();
//        System.out.println(result.get(0).getClass());
        return resultList;//result;//.stream().findAny();
    }

/*    @Override
    public List<Hashtag> findByKeyword(String keyword) {
        List<Hashtag> resultList = em.createQuery(
                "SELECT h " +
                        "FROM   Hashtag h " +
                        "WHERE  h.keyword LIKE CONCAT ( '%',:keyword, '%') " +
//                        "WHERE  h.keyword LIKE '%:keyword%' " +
                        "ORDER BY h.related_rank", Hashtag.class)
                .setParameter("keyword",keyword)
                .getResultList();
        for (int i=0; i<resultList.size(); i++){
            System.out.println(resultList.get(i).getKeyword());
            System.out.println(resultList.get(i).getRelated_hash());
        }
        return resultList;//.stream().findAny();
    }*/

    @Override
    public List<InfProfile> findAll() {
        List<InfProfile> result = em.createQuery("select m from InfProfile m", InfProfile.class)
                .getResultList();
        return result;
    }
}
