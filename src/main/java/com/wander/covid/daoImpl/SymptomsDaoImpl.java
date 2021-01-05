/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.covid.daoImpl;

import com.wander.covid.Model.SectionContent;
import com.wander.covid.Model.SymptomsModel;
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
public class SymptomsDaoImpl {

    @Autowired
    DBQuery dbQuery;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public SectionContent getSectionContent() {

        return jdbcTemplate.query(dbQuery.getSymptomsHeaderFooter(),
                (ResultSet rs) -> {

                    SectionContent sectionContent = new SectionContent();

                    while (rs.next()) {
                        switch (rs.getString("CATEGORY")) {
                            case "HEADER":
                                sectionContent.setHeader(rs.getString("COMMENT"));
                                break;
                            case "FOOTER":
                                sectionContent.setFooter(rs.getString("COMMENT"));
                                break;
                        }
                    }
                    return sectionContent;
                });
    }

    public List<SymptomsModel> getSymptomsData() {
        return jdbcTemplate.query(dbQuery.getSymptomsList(), new RowMapper<SymptomsModel>() {
            @Override
            public SymptomsModel mapRow(ResultSet rs, int i) throws SQLException {
                return new SymptomsModel(rs.getString("CATEGORY"), rs.getString("SYMPTOM"));
            }
        });
    }

}
