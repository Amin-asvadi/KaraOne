package com.khobre.karayek.ui.model;

import com.google.gson.annotations.SerializedName;

public class Users {
    String id;
    @SerializedName("name")
    String name;
    @SerializedName("phone_number")
    String phone_number;
    @SerializedName("national_number")
    String national_number;

    public Users() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getNational_number() {
        return national_number;
    }

    public void setNational_number(String national_number) {
        this.national_number = national_number;
    }
}
