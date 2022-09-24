package com.example.bfa;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class DatumCardList {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("phone_no")
        @Expose
        private String phoneNo;
        @SerializedName("user")
        @Expose
        private Integer user;
        @SerializedName("logo")
        @Expose
        private Object logo;

        public int getId(){
            return id;
        }

        public void setId(int id){
            this.id = id;

        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
        }

        public Integer getUser() {
            return user;
        }

        public void setUser(Integer user) {
            this.user = user;
        }

        public Object getLogo() {
            return logo;
        }

        public void setLogo(Object logo) {
            this.logo = logo;
        }


    }


