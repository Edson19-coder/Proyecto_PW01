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
public class MediaModel {
    private int idmedia;
    private String mediaUrl;
    private int mediNoticia;

    public MediaModel(int idmedia, String mediaUrl, int mediNoticia) {
        this.idmedia = idmedia;
        this.mediaUrl = mediaUrl;
        this.mediNoticia = mediNoticia;
    }

    public MediaModel(String mediaUrl, int mediNoticia) {
        this.mediaUrl = mediaUrl;
        this.mediNoticia = mediNoticia;
    }

    public MediaModel(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public int getIdmedia() {
        return idmedia;
    }

    public void setIdmedia(int idmedia) {
        this.idmedia = idmedia;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public int getMediNoticia() {
        return mediNoticia;
    }

    public void setMediNoticia(int mediNoticia) {
        this.mediNoticia = mediNoticia;
    }
}
