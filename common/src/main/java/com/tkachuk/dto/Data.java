package com.tkachuk.dto;

import java.io.Serializable;

/**
 * This class represents dto which will be transferred from one microservice to Kafka so second microservice will read it.
 * @author Svitlana Tkachuk
 */
public class Data implements Serializable {
    private String email;
    private final static long serialVersionUID = -2207191129831240421L;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Data{" +
                "email = '" + email + '}';
    }
}
