package Influencer.Influencerspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class,
						//			DataSourceTransactionManagerAutoConfiguration.class,
						//			HibernateJpaAutoConfiguration.class})
						//          ↑ 이 시바롬들은 죽어도 안까먹겠다 개새기들
public class InfluencerSpringApplication {

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "false");
		System.setProperty("spring.devtools.livereload.enabled", "true");

		SpringApplication.run(InfluencerSpringApplication.class, args);
	}

}
