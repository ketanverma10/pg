package com.example.myapplication;

public class user2 {
    String   fullname,phoneno,address,city,pincode,fees;
    int usertype;

    public user2(String fullname, String phoneno, String address, String city, String pincode, String fees, int usertype) {
        this.fullname = fullname;
        this.phoneno = phoneno;
        this.address = address;
        this.city = city;
        this.pincode = pincode;
        this.fees = fees;
        this.usertype = usertype;
    }

    public user2() {
    }

    public String getFullname() {
        return fullname;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPincode() {
        return pincode;
    }

    public String getFees() {
        return fees;
    }

    public int getUsertype() {
        return usertype;
    }
}
