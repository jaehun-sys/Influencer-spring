package Influencer.Influencerspring.service;


import Influencer.Influencerspring.repository.JdbcTemplateMemberRepository;
import Influencer.Influencerspring.repository.JpaMemberRepository;
import Influencer.Influencerspring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

//@Controller, @Service, @Repository 으로 의존관계(컴포넌트 스캔 방식) 넣어주는게 아니라
//직접 코드로 Bean 생성해주는것.
@Configuration
public class SpringConfig {

/*    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }*/

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRespository();
        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
    }
}
