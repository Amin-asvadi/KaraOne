package com.khobre.karayek.ui.model;

public class FInalPaymentModel {
    private String name,number,id_number,status;
  int  id;

    public FInalPaymentModel(String name, String number, String id_number, String status) {
        this.name = name;
        this.number = number;
        this.id_number = id_number;
        this.status = status;
    }

    public FInalPaymentModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
