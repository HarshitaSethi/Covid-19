/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.covid.daoImpl;

import com.wander.covid.Model.ChartModel;
import com.wander.covid.Model.MythsModel;
import com.wander.covid.Util.DBQuery;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author harshita.sethi
 */
@Repository
public class MythsDaoImpl {

    @Autowired
    DBQuery dbQuery;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<MythsModel> getMythsList() {
        return jdbcTemplate.query(dbQuery.getMythsList(), new RowMapper<MythsModel>() {
            @Override
            public MythsModel mapRow(ResultSet rs, int i) throws SQLException {
                return new MythsModel(rs.getInt("ID") - 1, rs.getString("MYTHS"), rs.getString("DETAIL"), rs.getString("IMAGE_FILE_NAME"));
            }
        });
    }

}
