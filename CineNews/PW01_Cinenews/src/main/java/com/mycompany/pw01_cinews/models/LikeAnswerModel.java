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
public class LikeAnswerModel {
    private int idlikeanswer;
    private int likeanswerUser;
    private int likeanswerAnswer;
    private int likeanswerNew;

    public LikeAnswerModel(int idlikeanswer, int likeanswerUser, int likeanswerAnswer, int likeanswerNew) {
        this.idlikeanswer = idlikeanswer;
        this.likeanswerUser = likeanswerUser;
        this.likeanswerAnswer = likeanswerAnswer;
        this.likeanswerNew = likeanswerNew;
    }

    public LikeAnswerModel(int likeanswerUser, int likeanswerAnswer, int likeanswerNew) {
        this.likeanswerUser = likeanswerUser;
        this.likeanswerAnswer = likeanswerAnswer;
        this.likeanswerNew = likeanswerNew;
    }

    public int getIdlikeanswer() {
        return idlikeanswer;
    }

    public void setIdlikeanswer(int idlikeanswer) {
        this.idlikeanswer = idlikeanswer;
    }

    public int getLikeanswerUser() {
        return likeanswerUser;
    }

    public void setLikeanswerUser(int likeanswerUser) {
        this.likeanswerUser = likeanswerUser;
    }

    public int getLikeanswerAnswer() {
        return likeanswerAnswer;
    }

    public void setLikeanswerAnswer(int likeanswerAnswer) {
        this.likeanswerAnswer = likeanswerAnswer;
    }

    public int getLikeanswerNew() {
        return likeanswerNew;
    }

    public void setLikeanswerNew(int likeanswerNew) {
        this.likeanswerNew = likeanswerNew;
    }

     
}
