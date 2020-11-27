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
public class LikeCommentaryModel {
    private int pidlikecomments;
    private int plikecommentsUser;
    private int plikecommentsCommentary;
    private int plikecommentsNew;

    public LikeCommentaryModel(int pidlikecomments, int plikecommentsUser, int plikecommentsCommentary, int plikecommentsNew) {
        this.pidlikecomments = pidlikecomments;
        this.plikecommentsUser = plikecommentsUser;
        this.plikecommentsCommentary = plikecommentsCommentary;
        this.plikecommentsNew = plikecommentsNew;
    }

    public LikeCommentaryModel(int plikecommentsUser, int plikecommentsCommentary, int plikecommentsNew) {
        this.plikecommentsUser = plikecommentsUser;
        this.plikecommentsCommentary = plikecommentsCommentary;
        this.plikecommentsNew = plikecommentsNew;
    }

    public int getPidlikecomments() {
        return pidlikecomments;
    }

    public void setPidlikecomments(int pidlikecomments) {
        this.pidlikecomments = pidlikecomments;
    }

    public int getPlikecommentsUser() {
        return plikecommentsUser;
    }

    public void setPlikecommentsUser(int plikecommentsUser) {
        this.plikecommentsUser = plikecommentsUser;
    }

    public int getPlikecommentsCommentary() {
        return plikecommentsCommentary;
    }

    public void setPlikecommentsCommentary(int plikecommentsCommentary) {
        this.plikecommentsCommentary = plikecommentsCommentary;
    }

    public int getPlikecommentsNew() {
        return plikecommentsNew;
    }

    public void setPlikecommentsNew(int plikecommentsNew) {
        this.plikecommentsNew = plikecommentsNew;
    }
    
    
}
