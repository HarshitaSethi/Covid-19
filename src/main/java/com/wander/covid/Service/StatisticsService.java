/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.covid.Service;

import com.wander.covid.Model.CaseStats;
import com.wander.covid.Model.ChartModel;
import com.wander.covid.daoImpl.StatisticsDaoImpl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author harshita.sethi
 */
@Service
public class StatisticsService {

    @Autowired
    StatisticsDaoImpl statisticsDaoImpl;

    public CaseStats getOverallCovidStats() {
        return statisticsDaoImpl.getOverallCovidStats();
    }

    public CaseStats getCurrentDateCovidStats() {
        return statisticsDaoImpl.getCurrentDateCovidStats();
    }

    public List<ChartModel> getNewVsRecoveriesBarData() {
        return statisticsDaoImpl.getNewVsRecoveriesBarData();
    }

    public List<ChartModel> getTotalVsActiveBarData() {
        return statisticsDaoImpl.getTotalVsActiveBarData();
    }
}
