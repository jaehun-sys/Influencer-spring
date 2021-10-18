package Influencer.Influencerspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class,
						//			DataSourceTransactionManagerAutoConfiguration.class,
						//			HibernateJpaAutoConfiguration.class})
						//          ↑ 이 친구들은 죽어도 안까먹겠다. (Database 관련 auto configuration 비활성화)
public class InfluencerSpringApplication {

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "false");
		System.setProperty("spring.devtools.livereload.enabled", "true");

		SpringApplication.run(InfluencerSpringApplication.class, args);
	}

}
