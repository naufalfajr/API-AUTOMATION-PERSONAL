package models;

import java.util.List;

public class ResponseApiV1CompaniesGET {
    public String status;
    public int code;
    public String locale;
    public String seed;
    public int total;
    public List<Data> data;

    public class Data {
        public int id;
        public String name;
        public String email;
        public String vat;
        public String phone;
        public String country;
        public List<Address> addresses;
        public String website;
        public String image;
        public Contact contact;
    }

    public class Address {
        public int id;
        public String street;
        public String streetName;
        public String buildingNumber;
        public String city;
        public String zipcode;
        public String country;
        public String countryCode;
        public double latitude;
        public double longitude;
    }

    public class Contact {
        public int id;
        public String firstname;
        public String lastname;
        public String email;
        public String phone;
        public String birthday;
        public String gender;
        public Address address;
        public String website;
        public String image;
    }
}
