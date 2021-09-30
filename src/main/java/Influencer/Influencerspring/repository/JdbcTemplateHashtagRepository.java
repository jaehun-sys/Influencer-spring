package Influencer.Influencerspring.repository;

import Influencer.Influencerspring.domain.Hashtag;
import Influencer.Influencerspring.domain.InfProfile;
import Influencer.Influencerspring.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class JdbcTemplateHashtagRepository implements HashtagRepository{

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public JdbcTemplateHashtagRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Hashtag> findByKeyword(String keyword) {
        List<Hashtag> resultList = jdbcTemplate.query("select keyword, related_hash, avg_liked, related_username " +
                "from hashtag " +
                "where keyword like ? " +
                "order by related_rank ", hashtagRowMapper(), keyword);
        return resultList;
    }

    private RowMapper<Hashtag> hashtagRowMapper(){
        return (rs, rowNum) -> {
            Hashtag hashtag = new Hashtag();
            hashtag.setKeyword(rs.getString("keyword"));
            hashtag.setRelated_hash(rs.getString("related_hash"));
            hashtag.setAvg_liked(rs.getString("avg_liked"));
            hashtag.setRelated_username(rs.getString("related_username"));
//            hashtag.setRelated_rank(rs.getString("related_rank"));
            return hashtag;
        };
    }
}
