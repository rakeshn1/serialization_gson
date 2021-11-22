
package com.serialization.json.model;

public class HomeAddress {

    private String streetName;
    private String city;
    private int zipcode;

    public String getStreetName() {

        return streetName;
    }
    public void setStreetName(String streetName) {

        this.streetName = streetName;
    }
    public String getCity() {

        return city;
    }
    public void setCity(String city) {

        this.city = city;
    }
    public int getZipcode() {

        return zipcode;
    }
    public void setZipcode(int zipcode) {

        this.zipcode = zipcode;
    }

    @Override
    public String toString(){
        return getStreetName() + ", "+getCity()+", "+getZipcode();
    }
}
