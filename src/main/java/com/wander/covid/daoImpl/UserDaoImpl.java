/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.covid.daoImpl;

import com.wander.covid.Model.CaseStats;
import com.wander.covid.Model.ChartModel;
import com.wander.covid.Model.UserModel;
import com.wander.covid.Util.DBQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author harshita.sethi
 */
@Repository
public class UserDaoImpl {

    @Autowired
    DBQuery dbQuery;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<UserModel> getUserDetails(String mobile) {

        return jdbcTemplate.query(dbQuery.getUserDetails(), (PreparedStatement ps) -> {
            ps.setString(1, mobile);
        }, (ResultSet rs, int i) -> new UserModel(rs.getString("NAME"), rs.getString("ADDRESS"), rs.getString("PHONE")));

    }

    public void insertUserData(UserModel userModel) {

        jdbcTemplate.update(dbQuery.insertUser(), new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, userModel.getName());
                ps.setString(2, userModel.getAddress());
                ps.setString(3, userModel.getMobile());
            }
        });

    }

}
