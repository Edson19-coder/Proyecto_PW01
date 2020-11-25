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
public class AnswerModel {
    
    private int idanswer;
    private String answerContent;
    private int answerNews;
    private int answerUser;
    private int answerCommentary;
    private int answerCountLike;
    private String answerDate;

    public AnswerModel(int idanswer, String answerContent, int answerNews, int answerUser, int answerCommentary, int answerCountLike, String answerDate) {
        this.idanswer = idanswer;
        this.answerContent = answerContent;
        this.answerNews = answerNews;
        this.answerUser = answerUser;
        this.answerCommentary = answerCommentary;
        this.answerCountLike = answerCountLike;
        this.answerDate = answerDate;
    }

    public AnswerModel(String answerContent, int answerNews, int answerUser, int answerCommentary, int answerCountLike, String answerDate) {
        this.answerContent = answerContent;
        this.answerNews = answerNews;
        this.answerUser = answerUser;
        this.answerCommentary = answerCommentary;
        this.answerCountLike = answerCountLike;
        this.answerDate = answerDate;
    }

    public int getIdanswer() {
        return idanswer;
    }

    public void setIdanswer(int idanswer) {
        this.idanswer = idanswer;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public int getAnswerNews() {
        return answerNews;
    }

    public void setAnswerNews(int answerNews) {
        this.answerNews = answerNews;
    }

    public int getAnswerUser() {
        return answerUser;
    }

    public void setAnswerUser(int answerUser) {
        this.answerUser = answerUser;
    }

    public int getAnswerCommentary() {
        return answerCommentary;
    }

    public void setAnswerCommentary(int answerCommentary) {
        this.answerCommentary = answerCommentary;
    }

    public int getAnswerCountLike() {
        return answerCountLike;
    }

    public void setAnswerCountLike(int answerCountLike) {
        this.answerCountLike = answerCountLike;
    }

    public String getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(String answerDate) {
        this.answerDate = answerDate;
    }
    
    
    
}
