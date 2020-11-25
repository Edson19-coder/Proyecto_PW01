/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.pw01_cinews.utils;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TypeClass {
    public static String GetUserType(int userType){
        switch(userType){
            case 0:{
                return "Registered";
            }
            case 1:{
                return "Moderator";
            }
            case 2:{
                return  "Content Creator";
            }
            case 3:{
                return "Editor";
            }
            case 4:{
                return "Administrator";
            }
            default:{
                return "Anonymous";
            }
        }
    }
    
    public static int GetUserTypeByString(String userType){
        switch(userType){
            case "Registered":{
                return 0;
            }
            case "Moderator":{
                return 1;
            }
            case "Content Creator":{
                return 2;
            }
            case "Editor":{
                return 3;
            }
            case "Administrator":{
                return 4;
            }
            default:{
                return 0;
            }
        }
    }
    
    public static String GetNewsState(int newsStatus){
        switch(newsStatus){
            case 0:{
                return "Draft";
            }
            case 1:{
                return "In check";
            }
            case 2:{
                return  "Accepted";
            }
            case 3:{
                return "Deny";
            }
            default:{
                return null;
            }
        }
    }
}
