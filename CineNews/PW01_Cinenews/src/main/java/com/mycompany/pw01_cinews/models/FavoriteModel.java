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
public class FavoriteModel {
    public int idfavoritenews;
    public NewsModel favNews;
    public UserModel user;

    public FavoriteModel(int idfavoritenews, NewsModel favNews, UserModel user) {
        this.idfavoritenews = idfavoritenews;
        this.favNews = favNews;
        this.user = user;
    }
    
    public int getIdfavoritenews() {
        return idfavoritenews;
    }

    public void setIdfavoritenews(int idfavoritenews) {
        this.idfavoritenews = idfavoritenews;
    }

    public NewsModel getFavNews() {
        return favNews;
    }

    public void setFavNews(NewsModel favNews) {
        this.favNews = favNews;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
    
    
}
