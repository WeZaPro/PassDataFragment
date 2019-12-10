package com.taweesak.passdatafragment.DataModel;

public class DataModel {
    double rates;
    String country;
    boolean isPromo,isChecked;
    int imageFlag;

    public DataModel(double rates) {
        this.rates = rates;
    }

    public DataModel(String country, double rates ) {
        this.country = country;
        this.rates = rates;
    }

    public DataModel(String country, double rates,int imageFlag ) {
        this.country = country;
        this.rates = rates;
        this.imageFlag = imageFlag;
    }

    public double getRates() {
        return rates;
    }

    public void setRates(double rates) {
        this.rates = rates;
    }

    public boolean isPromo() {
        return isPromo;
    }

    public void setPromo(boolean promo) {
        isPromo = promo;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getImageFlag() {
        return imageFlag;
    }

    public void setImageFlag(int imageFlag) {
        this.imageFlag = imageFlag;
    }
}
