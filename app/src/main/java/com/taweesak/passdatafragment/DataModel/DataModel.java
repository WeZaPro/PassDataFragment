package com.taweesak.passdatafragment.DataModel;

public class DataModel {
    double rates;
    String country;
    boolean isPromo,isChecked;

    public DataModel(double rates) {
        this.rates = rates;
    }

    public DataModel(String country, double rates ) {
        this.country = country;
        this.rates = rates;
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
}
