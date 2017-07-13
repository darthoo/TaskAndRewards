package com.yolotasker.yolotasker.model;

/**
 * Created by AndroidDev on 11.07.2017.
 */

public class User {

    private Integer id;

    private String login;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
