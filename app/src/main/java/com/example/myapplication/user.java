package com.example.myapplication;

public class user {
    String fullname,phoneno,address,city,pincode,tiffinservice,rent,pgfor;
            int usertype;

    public user(String fullname, String phoneno, String address, String city, String pincode, String tiffinservice, String rent, String pgfor) {
        this.fullname = fullname;
        this.phoneno = phoneno;
        this.address = address;
        this.city = city;
        this.pincode = pincode;

        this.tiffinservice = tiffinservice;
        this.rent = rent;
        this.pgfor = pgfor;
    }

    public int getUsertype() {
        return usertype;
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
