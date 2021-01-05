/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.covid.Model;

/**
 *
 * @author harshita.sethi
 */
public class CaseStats {

    private int noOfCases;
    private int noOfActiveCases;
    private int noOfRecoveries;
    private int noOfDeaths;

    public CaseStats(int noOfCases, int noOfActiveCases, int noOfRecoveries, int noOfDeaths) {
        this.noOfCases = noOfCases;
        this.noOfActiveCases = noOfActiveCases;
        this.noOfRecoveries = noOfRecoveries;
        this.noOfDeaths = noOfDeaths;
    }

    public CaseStats(int noOfCases, int noOfRecoveries, int noOfDeaths) {
        this.noOfCases = noOfCases;
        this.noOfRecoveries = noOfRecoveries;
        this.noOfDeaths = noOfDeaths;
    }

    public int getNoOfCases() {
        return noOfCases;
    }

    public void setNoOfCases(int noOfCases) {
        this.noOfCases = noOfCases;
    }

    public int getNoOfActiveCases() {
        return noOfActiveCases;
    }

    public void setNoOfActiveCases(int noOfActiveCases) {
        this.noOfActiveCases = noOfActiveCases;
    }

    public int getNoOfRecoveries() {
        return noOfRecoveries;
    }

    public void setNoOfRecoveries(int noOfRecoveries) {
        this.noOfRecoveries = noOfRecoveries;
    }

    public int getNoOfDeaths() {
        return noOfDeaths;
    }

    public void setNoOfDeaths(int noOfDeaths) {
        this.noOfDeaths = noOfDeaths;
    }

}
