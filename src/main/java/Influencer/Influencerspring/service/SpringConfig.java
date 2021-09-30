package Influencer.Influencerspring.service;

import Influencer.Influencerspring.repository.*;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

//@Controller, @Service, @Repository 으로 의존관계(컴포넌트 스캔 방식) 넣어주는게 아니라
//직접 코드로 Bean 생성해주는것.
@Configuration
@ComponentScan(basePackages = "Influencer.Influencerspring.*")
@MapperScan(basePackages = "Influencer.Influencerspring.mapper")
@EnableJpaRepositories("Influencer.Influencerspring.repository") // JPA 사용을 위한 패키지 탐색
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
