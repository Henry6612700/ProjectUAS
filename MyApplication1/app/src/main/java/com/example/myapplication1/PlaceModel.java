package com.example.myapplication1;

public class PlaceModel {
    String image;
    String nama,detail;

    public PlaceModel() {
    }

    public PlaceModel(String image, String nama, String detail) {
        this.image = image;
        this.nama = nama;
        this.detail = detail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
