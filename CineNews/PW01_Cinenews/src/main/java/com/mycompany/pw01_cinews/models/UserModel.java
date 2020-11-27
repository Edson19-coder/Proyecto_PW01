/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.pw01_cinews.models;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class UserModel {
private Integer iduser;
    private String user_name;
    private String password;
    private Integer user_type;
    private String email;
    private String facebook;
    private String instragram;
    private String pathImage;
    private String SobreMi;

    public UserModel(Integer iduser, String user_name, String password, Integer user_type, String email, String facebook, String instragram, String pathImage, String SobreMi) {
        this.iduser = iduser;
        this.user_name = user_name;
        this.password = password;
        this.user_type = user_type;
        this.email = email;
        this.facebook = facebook;
        this.instragram = instragram;
        this.pathImage = pathImage;
        this.SobreMi = SobreMi;
    }

    public UserModel(Integer iduser, String user_name, String password, String email, String facebook, String instragram, String pathImage, String SobreMi) {
        this.iduser = iduser;
        this.user_name = user_name;
        this.password = password;
        this.email = email;
        this.facebook = facebook;
        this.instragram = instragram;
        this.pathImage = pathImage;
        this.SobreMi = SobreMi;
    }

    public UserModel(Integer iduser, String user_name, String password, Integer user_type, String email) {
        this.iduser = iduser;
        this.user_name = user_name;
        this.password = password;
        this.user_type = user_type;
        this.email = email;
    }
    
    public UserModel(Integer iduser, String user_name, Integer user_type, String email) {
        this.iduser = iduser;
        this.user_name = user_name;
        this.user_type = user_type;
        this.email = email;
    }
    
    public UserModel(String user_name, String password, Integer user_type, String email) {
        this.user_name = user_name;
        this.password = password;
        this.user_type = user_type;
        this.email = email;
    }

    public UserModel(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }

    public UserModel(Integer iduser, String user_name, Integer user_type, String email, String facebook, String instragram, String pathImage) {
        this.iduser = iduser;
        this.user_name = user_name;
        this.user_type = user_type;
        this.email = email;
        this.facebook = facebook;
        this.instragram = instragram;
        this.pathImage = pathImage;
    }

    public UserModel() {
    
    }

    public UserModel(Integer iduser, String user_name, String password) {
        this.iduser = iduser;
        this.user_name = user_name;
        this.password = password;
    }

    public UserModel(Integer iduser, String user_name, Integer user_type, String email, String facebook, String instragram, String pathImage, String SobreMi) {
        this.iduser = iduser;
        this.user_name = user_name;
        this.user_type = user_type;
        this.email = email;
        this.facebook = facebook;
        this.instragram = instragram;
        this.pathImage = pathImage;
        this.SobreMi = SobreMi;
    }
    
       public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUser_type() {
        return user_type;
    }

    public void setUser_type(Integer user_type) {
        this.user_type = user_type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstragram() {
        return instragram;
    }

    public void setInstragram(String instragram) {
        this.instragram = instragram;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public String getSobreMi() {
        return SobreMi;
    }

    public void setSobreMi(String SobreMi) {
        this.SobreMi = SobreMi;
    }
    
}
