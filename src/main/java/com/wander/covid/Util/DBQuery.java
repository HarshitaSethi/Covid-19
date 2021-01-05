/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.covid.Util;

import org.springframework.stereotype.Component;

/**
 *
 * @author harshita.sethi
 */
@Component
public class DBQuery {

    //Statistics
    public String getQueryOverallStats() {
        return "SELECT SUM(NEW_CASES) TOTAL_CASES, SUM(RECOVERIES) TOTAL_RECOVERIES, SUM(DEATHS) TOTAL_DEATHS, "
                + "(SUM(NEW_CASES) - (SUM(RECOVERIES) + SUM(DEATHS))) TOTAL_ACTIVE FROM COV_CASE_STATISTICS_TBL WHERE DATE <= NOW()";
    }

    public String getQueryCurrentDayStats() {
        return "SELECT NEW_CASES, RECOVERIES, DEATHS FROM cov_case_statistics_tbl WHERE DATE = CURDATE()";
    }

    public String getQueryTotalVsActive() {
        return "SELECT DATE, (SELECT sum(b.NEW_CASES) FROM cov_case_statistics_tbl as b WHERE b.DATE <= a.DATE) TOTAL_CASES ,"
                + " (SELECT (SUM(c.NEW_CASES) - (SUM(c.RECOVERIES) + SUM(c.DEATHS))) "
                + " FROM cov_case_statistics_tbl as c WHERE c.DATE <= a.DATE) ACTIVE_CASES"
                + " FROM cov_case_statistics_tbl as a WHERE DATE <=NOW() order by DATE DESC LIMIT 10";
    }

    public String getQueryNewVsRecoveriesVsDeaths() {
        return "SELECT DATE, NEW_CASES, RECOVERIES, DEATHS FROM cov_case_statistics_tbl as a WHERE DATE <=NOW() order by DATE DESC LIMIT 10";
    }

    //Symptoms
    public String getSymptomsHeaderFooter() {
        return "SELECT CATEGORY, COMMENT FROM cov_section_head_conclusion_tbl WHERE SECTION_NAME = 'SYMPTOM'";
    }

    public String getSymptomsList() {
        return "SELECT SYMPTOM, CATEGORY FROM cov_symptoms_tbl";
    }

    //Myths
    public String getMythsList() {
        return "SELECT * FROM cov_myths_tbl";
    }

    //Dos and Donts
    public String getDosDontsList() {
        return "SELECT * FROM cov_dos_donts_tbl";
    }

    public String getDosDontsHeaderFooter() {
        return "SELECT SECTION_NAME, CATEGORY, COMMENT  FROM `cov_section_head_conclusion_tbl` WHERE `SECTION_NAME` like 'DD%'";
    }

    //FAQs
    public String getFaqList() {
        return "SELECT * FROM cov_faqs_tbl";
    }

    public String getFaqHeaderFooter() {
        return "SELECT CATEGORY, COMMENT FROM cov_section_head_conclusion_tbl WHERE SECTION_NAME = 'FAQ'";
    }

    //User
    public String getUserDetails() {
        return "SELECT * FROM cov_registered_citizens_tbl WHERE PHONE = ?";
    }

    public String insertUser() {
        return "INSERT INTO `cov_registered_citizens_tbl`(`NAME`, `ADDRESS`, `PHONE`) "
                + "VALUES (?,?,?)";
    }
}
