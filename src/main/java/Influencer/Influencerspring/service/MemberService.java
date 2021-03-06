package Influencer.Influencerspring.service;

import Influencer.Influencerspring.domain.Member;
import Influencer.Influencerspring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Controller처럼 얘가 서비스라는 것을 스프링에 알려줌. 스프링이 컨테이너에 등록해줌.
//@Service //: SpringConfig.java에서 @Bean 등록이 아닌 컴포넌트 스캔방식
@Transactional
public class MemberService {

    //회원 서비스를 만들려면 회원 리포지토리가 있어야 함.
    private final MemberRepository memberRepository;

    //@Autowired // 얘도 컴포넌트 스캔 방식
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /* 로그인 */
    public Optional<Member> findMemberId(String memberid){
        return memberRepository.findByMemberid(memberid);
    }

    /* 회원 가입 */
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원X
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getMemberno();
    }

    //같은 아이디가 있는 중복 회원X
    private void validateDuplicateMember(Member member) {
        memberRepository.findByMemberid(member.getMemberid())
                .ifPresent(m -> { //m에 값이 있으면,
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /* 전체 회원 조회 */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberNo){
        return memberRepository.findByMemberno(memberNo);
    }
}
