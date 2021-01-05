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
public class DoDontModel {

    private String category;
    private String instructions;
    private int id;
    private String summary;
    private String imageFileName;

    public DoDontModel(String category, String instructions, int id, String summary, String imageFileName) {
        this.category = category;
        this.instructions = instructions;
        this.id = id;
        this.summary = summary;
        this.imageFileName = imageFileName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

}
