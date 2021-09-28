package Influencer.Influencerspring.service;

import Influencer.Influencerspring.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

//@Controller, @Service, @Repository 으로 의존관계(컴포넌트 스캔 방식) 넣어주는게 아니라
//직접 코드로 Bean 생성해주는것.
@Configuration
public class SpringConfig {

    private EntityManager em;
    private DataSource dataSource;

    @Autowired
    public SpringConfig(EntityManager em, DataSource dataSource) {
        this.em = em;
        this.dataSource = dataSource;
    }


    /* 서비스 빈 */
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public InfluencerService influencerService(){
        return new InfluencerService(influencerRepository());
    }
    @Bean
    public HashtagService hashtagService(){
        return new HashtagService(hashtagRepository());
    }


    /* 리포지토리 빈 */
    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(getDataSource());
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
    @Bean
    public InfluencerRepository influencerRepository(){
        return new JpaInfluencerRepository(em);
    }
    @Bean
    public HashtagRepository hashtagRepository(){
        return new JdbcTemplateHashtagRepository(dataSource);
    }
}
