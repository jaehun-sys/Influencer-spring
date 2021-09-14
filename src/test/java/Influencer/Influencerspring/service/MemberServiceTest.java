package Influencer.Influencerspring.service;

import Influencer.Influencerspring.domain.Member;
import Influencer.Influencerspring.repository.MemoryMemberRespository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRespository memberRespository;

    @BeforeEach
    public void beforeEach(){
        memberRespository = new MemoryMemberRespository();
        memberService = new MemberService(memberRespository);
    }

    @AfterEach
    public void afterEach(){
        memberRespository.clearStore();
    }

    @Test
    void join() {   //회원가입 테스트
        //given
        Member member = new Member();
        member.setName("Kim");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("Kim");

        Member member2 = new Member();
        member2.setName("Kim");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));   // ,기준 오른쪽 로직이 실행할건데 왼쪽 예외가 실행이 되어야 함.

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        //방법론1
//        try{
//            memberService.join(member2);
//            fail();
//        } catch(IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }


        //then
    }

    @Test
    void findMembers() {

    }

    @Test
    void findOne() {

    }
}