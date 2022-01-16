package com.training.springbootdemo.repository;

import com.training.springbootdemo.mapper.FullNameMapper;
import com.training.springbootdemo.model.AdvancedUser;
import com.training.springbootdemo.model.FullName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class AdvancedUserJdbcRepository {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public AdvancedUserJdbcRepository(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<FullName> getAdvancedUsersFullNames() {
        String sql = "SELECT FIRST_NAME, LAST_NAME FROM ADVANCED_USER";
        return jdbcTemplate.query(sql, new FullNameMapper());
    }

    public AdvancedUser getAdvancedUserByFirstName(String firstName) {
        String sql = "SELECT * FROM ADVANCED_USER WHERE FIRST_NAME=:firstName";
        Map<String, String> params = new HashMap<>();
        params.put("firstName", firstName);
        return namedParameterJdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(AdvancedUser.class)).get(0);
    }
}
