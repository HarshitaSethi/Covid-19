/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.covid.Service;

import com.wander.covid.Model.DoDontModel;
import com.wander.covid.Model.SectionContent;
import com.wander.covid.daoImpl.DosDontsDaoImpl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author harshita.sethi
 */
@Service
public class DosDontsService {

    @Autowired
    DosDontsDaoImpl dosDontsDaoImpl;

    public List<DoDontModel> getDosDontsList() {
        return dosDontsDaoImpl.getDosDontsList();
    }

    public List<SectionContent> getSectionContent() {
        List<SectionContent> sectionContent = dosDontsDaoImpl.getSectionContent();

        List<SectionContent> mergedContent = new ArrayList<>();

        SectionContent dosContent = new SectionContent();
        SectionContent dontContent = new SectionContent();

        for (SectionContent section : sectionContent) {
            switch (section.getSectionName()) {
                case "DD_DO":
                    if (section.getFooter() != null) {
                        dosContent.setFooter(section.getFooter());
                    }
                    if (section.getHeader() != null) {
                        dosContent.setHeader(section.getHeader());
                    }
                    break;
                case "DD_DONT":
                    if (section.getFooter() != null) {
                        dontContent.setFooter(section.getFooter());
                    }
                    if (section.getHeader() != null) {
                        dontContent.setHeader(section.getHeader());
                    }
                    break;
            }
        }

        mergedContent.add(dosContent);
        mergedContent.add(dontContent);
        return mergedContent;
    }
}
