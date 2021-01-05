/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.covid.Service;

import com.wander.covid.Model.SectionContent;
import com.wander.covid.Model.SymptomsModel;
import com.wander.covid.daoImpl.SymptomsDaoImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author harshita.sethi
 */
@Service
public class SymptomsService {

    @Autowired
    SymptomsDaoImpl symptomsDaoImpl;

    public SectionContent getSectionContent() {
        return symptomsDaoImpl.getSectionContent();
    }

    public List<SymptomsModel> getSymptomsData() {
        return symptomsDaoImpl.getSymptomsData();
    }
}
