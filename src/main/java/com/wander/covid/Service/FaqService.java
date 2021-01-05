/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.covid.Service;

import com.wander.covid.Model.FaqModel;
import com.wander.covid.Model.SectionContent;
import com.wander.covid.daoImpl.FaqDaoImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author harshita.sethi
 */
@Service
public class FaqService {

    @Autowired
    FaqDaoImpl faqDaoImpl;

    public SectionContent getSectionContent() {
        return faqDaoImpl.getSectionContent();
    }

    public List<FaqModel> getFaqList() {
        return faqDaoImpl.getFaqList();
    }

}
