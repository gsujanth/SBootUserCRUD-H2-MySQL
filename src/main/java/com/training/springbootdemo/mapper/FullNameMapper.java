package com.training.springbootdemo.mapper;

import com.training.springbootdemo.model.FullName;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FullNameMapper implements RowMapper<FullName> {
    @Override
    public FullName mapRow(ResultSet rs, int rowNum) throws SQLException {
        FullName fullName = new FullName();
        fullName.setFullName(rs.getString("FIRST_NAME") + " " + rs.getString("LAST_NAME"));
        return fullName;
    }
}
