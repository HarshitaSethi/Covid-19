/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.covid.daoImpl;

import com.wander.covid.Model.DoDontModel;
import com.wander.covid.Model.SectionContent;
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
public class DosDontsDaoImpl {

    @Autowired
    DBQuery dbQuery;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<DoDontModel> getDosDontsList() {
        return jdbcTemplate.query(dbQuery.getDosDontsList(), new RowMapper<DoDontModel>() {
            @Override
            public DoDontModel mapRow(ResultSet rs, int i) throws SQLException {
                return new DoDontModel(rs.getString("CATEGORY"), rs.getString("INSTRUCTIONS"), rs.getInt("ID"), rs.getString("SUMMARY"), rs.getString("IMAGE_FILE_NAME"));
            }
        });
    }

    public List<SectionContent> getSectionContent() {
        return jdbcTemplate.query(dbQuery.getDosDontsHeaderFooter(), new RowMapper<SectionContent>() {
            @Override
            public SectionContent mapRow(ResultSet rs, int i) throws SQLException {
                SectionContent sectionContent = new SectionContent();

                switch (rs.getString("CATEGORY")) {
                    case "HEADER":
                        sectionContent.setHeader(rs.getString("COMMENT"));
                        break;
                    case "FOOTER":
                        sectionContent.setFooter(rs.getString("COMMENT"));
                        break;
                }

                sectionContent.setSectionName(rs.getString("SECTION_NAME"));

                return sectionContent;

            }
        });
    }

}
