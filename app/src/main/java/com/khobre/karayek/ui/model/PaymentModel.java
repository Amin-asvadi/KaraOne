package com.khobre.karayek.ui.model;

public class PaymentModel {
    private String name;
    private String phone;
    private String personid;
    private int id;

    public PaymentModel(String name, String phone, String personid) {
        this.name = name;
        this.phone = phone;
        this.personid = personid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PaymentModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }
}
