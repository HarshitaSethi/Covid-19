/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.covid.Service;

import com.wander.covid.Model.UserModel;
import com.wander.covid.daoImpl.UserDaoImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author harshita.sethi
 */
@Service
public class UserService {
    
    @Autowired
    UserDaoImpl userDaoImpl;
    
    public List<UserModel> getUserDetails(String mobile) {
        return userDaoImpl.getUserDetails(mobile);
        
    }
    
    public void insertUserData(UserModel userModel) {
        userDaoImpl.insertUserData(userModel);
    }
    
}
