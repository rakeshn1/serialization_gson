
package com.serialization.json.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class Employee {

    @SerializedName("empID")
    private int id;
    private String name;
    private boolean permanentEmployee;
    private HomeAddress homeAddress;
    private long[] phoneNumbers;
    private String role;
    private List<String> locations;
    private Map<String, String> attributes;

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
    public boolean isPermanentEmployee() {
        return permanentEmployee;
    }
    public void setPermanentEmployee(boolean permanentEmployee) {
        this.permanentEmployee = permanentEmployee;
    }
    public HomeAddress getHomeAddress() {
        return homeAddress;
    }
    public void setHomeAddress(HomeAddress homeAddress) {
        this.homeAddress = homeAddress;
    }
    public long[] getPhoneNumbers() {
        return phoneNumbers;
    }
    public void setPhoneNumbers(long[] phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("############## Details of Employee ############\n");
        sb.append("ID="+getId()+"\n");
        sb.append("Name="+getName()+"\n");
        sb.append("PermanentEmployee="+ isPermanentEmployee()+"\n");
        sb.append("Role="+getRole()+"\n");
        sb.append("Phone Numbers="+Arrays.toString(getPhoneNumbers())+"\n");
        sb.append("Home Address="+ getHomeAddress()+"\n");
        sb.append("Locations="+Arrays.toString(getLocations().toArray())+"\n");
        sb.append("Attributes="+ getAttributes()+"\n");
        sb.append("#############################################");

        return sb.toString();
    }
    public List<String> getLocations() {
        return locations;
    }
    public void setLocations(List<String> locations) {
        this.locations = locations;
    }
    public Map<String, String> getAttributes() {
        return attributes;
    }
    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }
}
