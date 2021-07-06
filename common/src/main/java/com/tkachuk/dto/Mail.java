package com.tkachuk.dto;

/**
 * This class represents mail dto with the only one field.
 */
public class Mail {

    private String mail;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Mail(String mail) {
        this.mail = mail;
    }

    public Mail() {}
}
