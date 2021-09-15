package Influencer.Influencerspring.service;

import Influencer.Influencerspring.domain.Member;
import Influencer.Influencerspring.repository.MemberRepository;
import Influencer.Influencerspring.repository.MemoryMemberRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Controller 처럼 얘가 서비스라는 것을 스프링에 알려줌. 스프링이 컨테이너에 등록해줌.
@Service
public class MemberService {

    //회원 서비스를 만들려면 회원 리포지토리가 있어야 함.
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /* 회원 가입 */
    public Long join(Member member){
        //같은 이름이 있는 중복 회원X
        validateDuplicateMember(member);

        memberRepository.save(member);
       return member.getId();
    }

    //같은 이름이 있는 중복 회원X
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> { //m에 값이 있으면,
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /* 전체 회원 조회 */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
