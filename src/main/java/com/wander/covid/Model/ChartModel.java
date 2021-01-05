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
public class ChartModel {

    private String name;
    private int y;
    private int y2;
    private int y3;

    public ChartModel(String name, int y) {
        this.name = name;
        this.y = y;
    }

    public ChartModel(String name, int y, int y2) {
        this.name = name;
        this.y = y;
        this.y2 = y2;
    }

    public ChartModel(String name, int y, int y2, int y3) {
        this.name = name;
        this.y = y;
        this.y2 = y2;
        this.y3 = y3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getY3() {
        return y3;
    }

    public void setY3(int y3) {
        this.y3 = y3;
    }

}
