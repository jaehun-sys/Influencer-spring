package Influencer.Influencerspring.repository;

import Influencer.Influencerspring.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

//@Repository
public class JpaMemberRepository implements MemberRepository{

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    private final EntityManager em;


    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findByMemberno(Long memberno) {
        Member member = em.find(Member.class, memberno);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name",name)
                .getResultList();
        return result.stream().findAny();   //findby를 하나만 하기로 했으니까.
    }

    @Override
    public Optional<Member> findByMemberid(String memberid){
        List<Member> result = em.createQuery("select m from Member m where m.memberid = :memberid", Member.class)
                .setParameter("memberid", memberid)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        List<Member> result = em.createQuery("select m from Member m", Member.class)
                .getResultList();
        return result;
    }
}
