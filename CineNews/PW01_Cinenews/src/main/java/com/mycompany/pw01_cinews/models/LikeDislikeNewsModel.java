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
public class LikeDislikeNewsModel {
    private int idlikedislikenews;
    private int plikedislikenewsIdUser;
    private int plikedislikenewsIdNew;
    private int plikedislikenewsType;

    public LikeDislikeNewsModel(int idlikedislikenews, int plikedislikenewsIdUser, int plikedislikenewsIdNew, int plikedislikenewsType) {
        this.idlikedislikenews = idlikedislikenews;
        this.plikedislikenewsIdUser = plikedislikenewsIdUser;
        this.plikedislikenewsIdNew = plikedislikenewsIdNew;
        this.plikedislikenewsType = plikedislikenewsType;
    }

    public LikeDislikeNewsModel(int plikedislikenewsIdUser, int plikedislikenewsIdNew, int plikedislikenewsType) {
        this.plikedislikenewsIdUser = plikedislikenewsIdUser;
        this.plikedislikenewsIdNew = plikedislikenewsIdNew;
        this.plikedislikenewsType = plikedislikenewsType;
    }

    public int getIdlikedislikenews() {
        return idlikedislikenews;
    }

    public void setIdlikedislikenews(int idlikedislikenews) {
        this.idlikedislikenews = idlikedislikenews;
    }

    public int getPlikedislikenewsIdUser() {
        return plikedislikenewsIdUser;
    }

    public void setPlikedislikenewsIdUser(int plikedislikenewsIdUser) {
        this.plikedislikenewsIdUser = plikedislikenewsIdUser;
    }

    public int getPlikedislikenewsIdNew() {
        return plikedislikenewsIdNew;
    }

    public void setPlikedislikenewsIdNew(int plikedislikenewsIdNew) {
        this.plikedislikenewsIdNew = plikedislikenewsIdNew;
    }

    public int getPlikedislikenewsType() {
        return plikedislikenewsType;
    }

    public void setPlikedislikenewsType(int plikedislikenewsType) {
        this.plikedislikenewsType = plikedislikenewsType;
    }
}
