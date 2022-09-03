package com.example.bfa;

public class model {

    int id;
    String email,first_name,last_name,username,account_type,is_superuser,is_staff,user_profile;

    public model(int id, String email, String first_name, String last_name, String username, String account_type, String is_superuser, String is_staff, String user_profile) {
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.account_type = account_type;
        this.is_superuser = is_superuser;
        this.is_staff = is_staff;
        this.user_profile = user_profile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public String getIs_superuser() {
        return is_superuser;
    }

    public void setIs_superuser(String is_superuser) {
        this.is_superuser = is_superuser;
    }

    public String getIs_staff() {
        return is_staff;
    }

    public void setIs_staff(String is_staff) {
        this.is_staff = is_staff;
    }

    public String getUser_profile() {
        return user_profile;
    }

    public void setUser_profile(String user_profile) {
        this.user_profile = user_profile;
    }
}

