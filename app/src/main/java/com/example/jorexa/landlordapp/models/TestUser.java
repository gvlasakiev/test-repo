package com.example.jorexa.landlordapp.models;

import java.io.Serializable;

public class TestUser implements Serializable {
    public String one;
    public String key;

    public TestUser() {

    }

    public TestUser(String one, String key) {
        this.one = one;
        this.key = key;
    }

    public String getOne() {
        return one;
    }

    public String getKey() {
        return key;
    }

}
