package Influencer.Influencerspring.repository.temp;

import Influencer.Influencerspring.domain.Member;
import Influencer.Influencerspring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JdbcTemplateMemberRepository implements MemberRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired  //(생성자가 하나만 있으면 Autowired 생략해도 됨.)
    public JdbcTemplateMemberRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Member save(Member member) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("memberno");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", member.getName());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        member.setMemberno(key.longValue());
        return member;
    }

    @Override
    public Optional<Member> findByMemberno(Long memberno) {
        List<Member> result = jdbcTemplate.query("select * from member where memberno = ?", memberRowMapper(), memberno);
        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = jdbcTemplate.query("select * from member where name = ?", memberRowMapper(), name);
        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findByMemberid(String memberid) {
        List<Member> result = jdbcTemplate.query("select * from member where memberid = ?", memberRowMapper(), memberid);
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return jdbcTemplate.query("select * from member", memberRowMapper());
    }

    private RowMapper<Member> memberRowMapper(){
        return (rs, rowNum) -> {
            Member member = new Member();
            member.setMemberno(rs.getLong("memberno"));
//            member.setMemberid(rs.getString("memberid"));
            member.setName(rs.getString("name"));
//            member.setNickname(rs.getString("password"));
//            member.setEmail(rs.getString("email"));
//            member.setBirthday(rs.getString("birthday"));
//            member.setMem_sex(rs.getString("mem_sex"));
//            member.setPhoneno(rs.getString("phoneno"));
            return member;
        };
    }
}