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
public class CommentaryModel {

    private int idcommentary;
    private String commentaryContent;
    private int commentaryNews;
    private int commentaryUser;
    private int commentaryCountLikes;
    private String commentaryDate;

    public CommentaryModel(int idcommentary, String commentaryContent, int commentaryNews, int commentaryUser, int commentaryCountLikes, String commentaryDate) {
        this.idcommentary = idcommentary;
        this.commentaryContent = commentaryContent;
        this.commentaryNews = commentaryNews;
        this.commentaryUser = commentaryUser;
        this.commentaryCountLikes = commentaryCountLikes;
        this.commentaryDate = commentaryDate;
    }

    public CommentaryModel(String commentaryContent, int commentaryNews, int commentaryUser, int commentaryCountLikes, String commentaryDate) {
        this.commentaryContent = commentaryContent;
        this.commentaryNews = commentaryNews;
        this.commentaryUser = commentaryUser;
        this.commentaryCountLikes = commentaryCountLikes;
        this.commentaryDate = commentaryDate;
    }

    public int getIdcommentary() {
        return idcommentary;
    }

    public void setIdcommentary(int idcommentary) {
        this.idcommentary = idcommentary;
    }

    public String getCommentaryContent() {
        return commentaryContent;
    }

    public void setCommentaryContent(String commentaryContent) {
        this.commentaryContent = commentaryContent;
    }

    public int getCommentaryNews() {
        return commentaryNews;
    }

    public void setCommentaryNews(int commentaryNews) {
        this.commentaryNews = commentaryNews;
    }

    public int getCommentaryUser() {
        return commentaryUser;
    }

    public void setCommentaryUser(int commentaryUser) {
        this.commentaryUser = commentaryUser;
    }

    public int getCommentaryCountLikes() {
        return commentaryCountLikes;
    }

    public void setCommentaryCountLikes(int commentaryCountLikes) {
        this.commentaryCountLikes = commentaryCountLikes;
    }

    public String getCommentaryDate() {
        return commentaryDate;
    }

    public void setCommentaryDate(String commentaryDate) {
        this.commentaryDate = commentaryDate;
    }
    
    
}
