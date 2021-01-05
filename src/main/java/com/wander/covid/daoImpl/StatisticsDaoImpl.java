/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.covid.daoImpl;

import com.wander.covid.Model.CaseStats;
import com.wander.covid.Model.ChartModel;
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
public class StatisticsDaoImpl {

    @Autowired
    DBQuery dbQuery;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public CaseStats getOverallCovidStats() {

        return jdbcTemplate.query(dbQuery.getQueryOverallStats(),
                (ResultSet rs) -> {
                    rs.next();
                    return new CaseStats(rs.getInt("TOTAL_CASES"), rs.getInt("TOTAL_ACTIVE"), rs.getInt("TOTAL_RECOVERIES"), rs.getInt("TOTAL_DEATHS"));
                });
    }

    public CaseStats getCurrentDateCovidStats() {
        return jdbcTemplate.query(dbQuery.getQueryCurrentDayStats(),
                (ResultSet rs) -> {
                    rs.next();
                    return new CaseStats(rs.getInt("NEW_CASES"), rs.getInt("RECOVERIES"), rs.getInt("DEATHS"));
                });
    }

    public List<ChartModel> getNewVsRecoveriesBarData() {
        return jdbcTemplate.query(dbQuery.getQueryNewVsRecoveriesVsDeaths(), new RowMapper<ChartModel>() {
            @Override
            public ChartModel mapRow(ResultSet rs, int i) throws SQLException {
                return new ChartModel(rs.getString("DATE"), rs.getInt("NEW_CASES"), rs.getInt("RECOVERIES"), rs.getInt("DEATHS"));
            }
        });
    }

    public List<ChartModel> getTotalVsActiveBarData() {
        return jdbcTemplate.query(dbQuery.getQueryTotalVsActive(), new RowMapper<ChartModel>() {
            @Override
            public ChartModel mapRow(ResultSet rs, int i) throws SQLException {
                return new ChartModel(rs.getString("DATE"), rs.getInt("TOTAL_CASES"), rs.getInt("ACTIVE_CASES"));
            }
        });
    }

}
