package com.web.fitizenproject;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class UserDAO
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static User mapRow(ResultSet rs, int i) {
        User user = new User();
        user.setName(rs.getString("NAME"));
        user.setEmail(rs.getString("EMAIL"));
        user.setBirth(rs.getString("BIRTH"));
        user.setRegDate(rs.getString("REG_DATE"));
        user.setUpDate(rs.getString("UP_DATE"));
        return user;
    }

    public List<User> userList()
    {
        String sql = "SELECT * FROM users";
        List<User> user = jdbcTemplate.query(sql, UserDAO::mapRow);
        return list;
    }
}
