package Influencer.Influencerspring.service;

import Influencer.Influencerspring.repository.MemberRepository;
import Influencer.Influencerspring.repository.MemoryMemberRespository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Controller, @Service, @Repository 으로 의존관계(컴포넌트 스캔 방식) 넣어주는게 아니라
//직접 코드로 Bean 생성해주는것.
@Configuration
public class SpringConfig {

//    @Bean
//    public MemberService memberService(){
//        return new MemberService(memberRepository());
//    }

//    @Bean
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRespository();
//    }
}
