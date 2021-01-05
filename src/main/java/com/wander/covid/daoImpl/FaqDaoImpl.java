/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.covid.daoImpl;

import com.wander.covid.Model.SectionContent;
import com.wander.covid.Model.FaqModel;
import com.wander.covid.Util.DBQuery;
import java.sql.ResultSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author harshita.sethi
 */
@Repository
public class FaqDaoImpl {

    @Autowired
    DBQuery dbQuery;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public SectionContent getSectionContent() {

        return jdbcTemplate.query(dbQuery.getFaqHeaderFooter(),
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

    public List<FaqModel> getFaqList() {
        return jdbcTemplate.query(dbQuery.getFaqList(), (ResultSet rs, int i) -> new FaqModel(rs.getString("QUESTION"), rs.getString("ANSWER"), rs.getInt("ID") - 1));
    }

}
