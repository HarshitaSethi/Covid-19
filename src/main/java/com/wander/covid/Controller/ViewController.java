/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.covid.Controller;

import com.wander.covid.Model.CaseStats;
import com.wander.covid.Model.ChartModel;
import com.wander.covid.Model.DoDontModel;
import com.wander.covid.Model.FaqModel;
import com.wander.covid.Model.MythsModel;
import com.wander.covid.Model.SectionContent;
import com.wander.covid.Model.SymptomsModel;
import com.wander.covid.Model.UserModel;
import com.wander.covid.Service.DosDontsService;
import com.wander.covid.Service.FaqService;
import com.wander.covid.Service.MythsService;
import com.wander.covid.Service.StatisticsService;
import com.wander.covid.Service.SymptomsService;
import com.wander.covid.Service.UserService;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

/**
 *
 * @author harshita.sethi
 */
@Controller
public class ViewController {

    @Autowired
    StatisticsService statisticsService;

    @Autowired
    SymptomsService symptomsService;

    @Autowired
    MythsService mythsService;

    @Autowired
    DosDontsService dosDontsService;

    @Autowired
    FaqService faqService;

    @Autowired
    UserService userService;

    @GetMapping(value = "/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @GetMapping(value = "/loadHome/{user_name}")
    public ModelAndView loadHome(@PathVariable String user_name) {

        String userID = new String(Base64.getDecoder().decode(user_name));
        List<UserModel> userDetails = userService.getUserDetails(userID);
        UserModel userData = new UserModel(userID, userID, userID);
        if (!userDetails.isEmpty()) {
            userData = userDetails.get(0);
        }

        CaseStats overallCovidStats = statisticsService.getOverallCovidStats();
        CaseStats currentDateCovidStats = statisticsService.getCurrentDateCovidStats();
        List<ChartModel> totalVsActiveBarData = statisticsService.getTotalVsActiveBarData();
        List<ChartModel> newVsRecoveriesBarData = statisticsService.getNewVsRecoveriesBarData();

        ModelAndView mv = new ModelAndView();
        mv.addObject("userDetails", userData);
        mv.addObject("overall", overallCovidStats);
        mv.addObject("todays", currentDateCovidStats);
        mv.addObject("TotalGlobalCases", "10+ M");
        mv.addObject("totalVsActiveBarData", totalVsActiveBarData);
        mv.addObject("newVsRecoveriesBarData", newVsRecoveriesBarData);

        mv.setViewName("home");
        return mv;
    }

    @GetMapping(value = "/covidSymptoms")
    public ModelAndView symptoms() {

        SectionContent sectionContent = symptomsService.getSectionContent();
        List<SymptomsModel> symptomsData = symptomsService.getSymptomsData();

        ModelAndView mv = new ModelAndView();
        mv.addObject("sectionContent", sectionContent);
        mv.addObject("symptomsData", symptomsData);

        mv.setViewName("symptoms");
        return mv;
    }

    @GetMapping(value = "/covidMyths")
    public ModelAndView myths() {

        List<MythsModel> mythsList = mythsService.getMythsList();

        ModelAndView mv = new ModelAndView();
        mv.addObject("mythsList", mythsList);

        mv.setViewName("myths");
        return mv;
    }

    @GetMapping(value = "/covidDosAndDonts")
    public ModelAndView dosAndDonts() {

        List<DoDontModel> dosDontsList = dosDontsService.getDosDontsList();
        List<SectionContent> sectionContent = dosDontsService.getSectionContent();

        ModelAndView mv = new ModelAndView();
        mv.addObject("dosSectionContent", sectionContent.get(0));
        mv.addObject("dontsSectionContent", sectionContent.get(1));
        mv.addObject("dosDontsList", dosDontsList);

        mv.setViewName("dosAndDonts");
        return mv;
    }

    @GetMapping(value = "/covidFaq")
    public ModelAndView faqs() {

        SectionContent sectionContent = faqService.getSectionContent();
        List<FaqModel> faqList = faqService.getFaqList();

        ModelAndView mv = new ModelAndView();
        mv.addObject("faqList", faqList);
        mv.addObject("faqSectionContent", sectionContent);

        mv.setViewName("faqs");
        return mv;
    }

    @PostMapping("/register")
    public ModelAndView register(@RequestParam String name, @RequestParam String address, @RequestParam String mobile, @RequestParam String symptomsRadio) throws KeyManagementException, NoSuchAlgorithmException, IOException, SAXException, ParserConfigurationException {

        System.out.println("Login Cred:" + name + ":" + address + " , " + mobile + ", " + symptomsRadio);

        List<UserModel> userDetails = userService.getUserDetails(mobile);

        UserModel userData;
        if (userDetails.isEmpty()) {
            userData = new UserModel(name, address, mobile);
            userService.insertUserData(userData);
        } else {
            userData = userDetails.get(0);

        }

        ModelAndView mv = new ModelAndView();

        if (symptomsRadio.equalsIgnoreCase("YES")) {
            mv = selfAssessment();
        } else {
            mv = loadHome(mobile);
        }

        mv.addObject("userDetails", userData);

        return mv;
    }

     @GetMapping(value = "/covidSelfAssessment")
    public ModelAndView selfAssessment() {

        List<SymptomsModel> symptomsData = symptomsService.getSymptomsData();

        ModelAndView mv = new ModelAndView();
        mv.addObject("symptomsData", symptomsData);

        mv.setViewName("selfAssessment");
        return mv;
    }
}
