package Influencer.Influencerspring.service;

import Influencer.Influencerspring.repository.JdbcTemplateMemberRepository;
import Influencer.Influencerspring.repository.JpaMemberRepository;
import Influencer.Influencerspring.repository.MemberRepository;
import Influencer.Influencerspring.repository.MemoryMemberRepository;
import Influencer.Influencerspring.service.MemberService;
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

//@Controller, @Service, @Repository 으로 의존관계(컴포넌트 스캔 방식) 넣어주는게 아니라
//직접 코드로 Bean 생성해주는것.
@Configuration
public class SpringConfig {

    private EntityManager em;

//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    private final DataSource dataSource;
    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
//    @Bean
//    public DataSource getDataSource() {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("org.mariadb.jdbc.Driver");
//        dataSourceBuilder.url("jdbc:mariadb://ec2-54-180-157-48.ap-northeast-2.compute.amazonaws.com:3306/INFDB_AWS");
//        dataSourceBuilder.username("INFLUENCER");
//        dataSourceBuilder.password("INSTAGRAM12#$");
//        return dataSourceBuilder.build();
//    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(getDataSource());
        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
    }
}
