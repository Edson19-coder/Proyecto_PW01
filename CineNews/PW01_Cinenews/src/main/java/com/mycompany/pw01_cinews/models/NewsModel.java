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
public class NewsModel {
    private int idnews;
    private String newsTitle;
    private String newsDescription;
    private String newsContent;
    private int newsCategory;
    private int newsAuthor;
    private int newsStatus;
    private String newDate;
    private String newsMotivo;
    private int newsLikeCount;
    private int newsDislikeCount;

    public NewsModel(int idnews, String newsTitle, String newsDescription, String newsContent, int newsCategory, int newsAuthor, int newsStatus, String newDate, int newsLikeCount, int newsDislikeCount) {
        this.idnews = idnews;
        this.newsTitle = newsTitle;
        this.newsDescription = newsDescription;
        this.newsContent = newsContent;
        this.newsCategory = newsCategory;
        this.newsAuthor = newsAuthor;
        this.newsStatus = newsStatus;
        this.newDate = newDate;
        this.newsMotivo = newsMotivo;
        this.newsLikeCount = newsLikeCount;
        this.newsDislikeCount = newsDislikeCount;
    }
    
    public NewsModel(int idnews, String newsTitle, String newsDescription, String newsContent, int newsCategory, int newsAuthor, int newsStatus, String newDate) {
        this.idnews = idnews;
        this.newsTitle = newsTitle;
        this.newsDescription = newsDescription;
        this.newsContent = newsContent;
        this.newsCategory = newsCategory;
        this.newsAuthor = newsAuthor;
        this.newsStatus = newsStatus;
        this.newDate = newDate;
    }
    
    public NewsModel(String newsTitle, String newsDescription, String newsContent, int newsCategory, int newsAuthor, int newsStatus, String newDate) {
        this.newsTitle = newsTitle;
        this.newsDescription = newsDescription;
        this.newsContent = newsContent;
        this.newsCategory = newsCategory;
        this.newsAuthor = newsAuthor;
        this.newsStatus = newsStatus;
        this.newDate = newDate;
    }

    public NewsModel(int idnews, String newsTitle, String newsDescription, String newsContent, int newsCategory, int newsAuthor, int newsStatus, String newDate, String newsMotivo) {
        this.idnews = idnews;
        this.newsTitle = newsTitle;
        this.newsDescription = newsDescription;
        this.newsContent = newsContent;
        this.newsCategory = newsCategory;
        this.newsAuthor = newsAuthor;
        this.newsStatus = newsStatus;
        this.newDate = newDate;
        this.newsMotivo = newsMotivo;
    }

    

    public int getIdnews() {
        return idnews;
    }

    public void setIdnews(int idnews) {
        this.idnews = idnews;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsDescription() {
        return newsDescription;
    }

    public void setNewsDescription(String newsDescription) {
        this.newsDescription = newsDescription;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public int getNewsCategory() {
        return newsCategory;
    }

    public void setNewsCategory(int newsCategory) {
        this.newsCategory = newsCategory;
    }

    public int getNewsAuthor() {
        return newsAuthor;
    }

    public void setNewsAuthor(int newsAuthor) {
        this.newsAuthor = newsAuthor;
    }

    public int getNewsStatus() {
        return newsStatus;
    }

    public void setNewsStatus(int newsStatus) {
        this.newsStatus = newsStatus;
    }

    public String getNewDate() {
        return newDate;
    }

    public void setNewDate(String newDate) {
        this.newDate = newDate;
    }
    
    public String getNewsMotivo() {
        return newsMotivo;
    }

    public void setNewsMotivo(String newsMotivo) {
        this.newsMotivo = newsMotivo;
    }

    public int getNewsLikeCount() {
        return newsLikeCount;
    }

    public void setNewsLikeCount(int newsLikeCount) {
        this.newsLikeCount = newsLikeCount;
    }

    public int getNewsDislikeCount() {
        return newsDislikeCount;
    }

    public void setNewsDislikeCount(int newsDislikeCount) {
        this.newsDislikeCount = newsDislikeCount;
    }
    
}
