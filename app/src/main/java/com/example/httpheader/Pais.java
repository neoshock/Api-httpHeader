package com.example.httpheader;

public class Pais {
    private String name, alpha2code,alpha3code;
    private double latitude, longitude;

    public Pais(String name, String alpha2code, String alpha3code, double latitude, double longitude) {
        this.name = name;
        this.alpha2code = alpha2code;
        this.alpha3code = alpha3code;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Pais() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlpha2code() {
        return alpha2code;
    }

    public void setAlpha2code(String alpha2code) {
        this.alpha2code = alpha2code;
    }

    public String getAlpha3code() {
        return alpha3code;
    }

    public void setAlpha3code(String alpha3code) {
        this.alpha3code = alpha3code;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
