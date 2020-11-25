/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.pw01_cinews.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Validaciones {
    public Boolean password_val(String pass1, String pass2){
            if(pass1.equals(pass2))
                return true;
            else
                return false;
        }
    
    public Boolean email_val(String email){
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
 
        if (mather.find() == true) {
            return true;
        } else {
            return false;
        }
    }
}
