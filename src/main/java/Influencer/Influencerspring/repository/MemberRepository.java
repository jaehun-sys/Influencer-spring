package Influencer.Influencerspring.repository;

import Influencer.Influencerspring.domain.Member;

import java.util.List;
import java.util.Optional;


public interface MemberRepository {
    Member save(Member member);
    //Optional: java8에 들어있는 기능. 없으면 null로 반환하는 방식.

    //중복 회원번호가 있으면 안된다
    Optional<Member> findByMemberno(Long memberno); //Member.java에서 만든 id로 찾겠다는 뜻

    //(예시)중복 이름이 있으면 안된다
    Optional<Member> findByName(String name);

//    //중복 아이디가 있으면 안된다
    Optional<Member> findByMemberid(String memberid);

    List<Member> findAll();
}
