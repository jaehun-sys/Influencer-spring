package Influencer.Influencerspring.repository;

import Influencer.Influencerspring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRespository implements MemberRepository{

    //save를 할 때 저장을 할 곳
    private static Map<Long, Member> store = new HashMap<>();   //실무에서는 동시성 문제를 고려해야 함. 지금은 그냥 예제.
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setMemberno(++sequence);   //save할 때마다 sequence 값을 1씩 올려줌.
        store.put(member.getMemberno(),member);   //save하기 전에 name은 넘어온 상태.
        return member;
    }

    @Override
    public Optional<Member> findByMemberno(Long memberno) {
        return Optional.ofNullable(store.get(memberno));   //stord에서 꺼내는 방식. 결과가 없으면 null을 반환(Optional)
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()                              //java8의 람다를 사용. loop를 돌면서
                .filter(member -> member.getName().equals(name))    //member.getName()이 인자로 넘어온 name과 같으면 filter를 하고
                .findAny();                                         //찾으면 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //values가 member들.
    }

    //Test해볼 때 사용될 것
    public void clearStore(){
        store.clear();  //store 쫙 비움. AfterEach를 위해.
    }
}
