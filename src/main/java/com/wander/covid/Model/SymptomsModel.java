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
public class SymptomsModel {

    private String category;
    private String symptom;

    public SymptomsModel(String category, String symptom) {
        this.category = category;
        this.symptom = symptom;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

}
