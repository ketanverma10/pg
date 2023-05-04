package com.example.myapplication;

public class user {
    String fullname,phoneno,address,city,pincode,gender,tiffinservice,rent,pgfor;

    public user(String fullname, String phoneno, String address, String city, String pincode, String gender, String tiffinservice, String rent, String pgfor) {
        this.fullname = fullname;
        this.phoneno = phoneno;
        this.address = address;
        this.city = city;
        this.pincode = pincode;
        this.gender = gender;
        this.tiffinservice = tiffinservice;
        this.rent = rent;
        this.pgfor = pgfor;
    }

    public user() {
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

    public String getGender() {
        return gender;
    }

    public String getTiffinservice() {
        return tiffinservice;
    }

    public String getRent() {
        return rent;
    }

    public String getPgfor() {
        return pgfor;
    }
}
