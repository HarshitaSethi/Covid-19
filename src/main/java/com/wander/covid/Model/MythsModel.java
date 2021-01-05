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
public class MythsModel {

    private int id;
    private String myths;
    private String details;
    private String imageFileName;

    public MythsModel(int id, String myths, String details, String imageFileName) {
        this.id = id;
        this.myths = myths;
        this.details = details;
        this.imageFileName = imageFileName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMyths() {
        return myths;
    }

    public void setMyths(String myths) {
        this.myths = myths;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

}
