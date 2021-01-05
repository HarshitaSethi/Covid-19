/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.covid.Service;

import com.wander.covid.Model.MythsModel;
import com.wander.covid.daoImpl.MythsDaoImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author harshita.sethi
 */
@Service
public class MythsService {

    @Autowired
    MythsDaoImpl mythsDaoImpl;

    public List<MythsModel> getMythsList() {
        return mythsDaoImpl.getMythsList();
    }

}
