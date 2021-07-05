package com.tkachuk.dto;

/**
 * This class represents dto for transferring and reading.
 */
public class Mail {

    private String mail;
    private String isbn;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Mail(String bookName, String isbn) {
        this.mail = bookName;
        this.isbn = isbn;
    }

    public Mail() {
    }
}
