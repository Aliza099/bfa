package com.example.bfa;

public class UserDetail {

    private Integer id;
    private String email;
    private String first_name;
    private String last_name;
    private Object username;
    private Boolean account_type;
    private Boolean is_superuser;
    private Boolean is_staff;
    private Boolean user_profile;

    public UserDetail(Integer id, String email, String first_name, String last_name, Object username, Boolean account_type, Boolean is_superuser, Boolean is_staff, Boolean user_profile) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Object getUsername() {
        return username;
    }

    public void setUsername(Object username) {
        this.username = username;
    }

    public Boolean getAccount_type() {
        return account_type;
    }

    public void setAccount_type(Boolean account_type) {
        this.account_type = account_type;
    }

    public Boolean getIs_superuser() {
        return is_superuser;
    }

    public void setIs_superuser(Boolean is_superuser) {
        this.is_superuser = is_superuser;
    }

    public Boolean getIs_staff() {
        return is_staff;
    }

    public void setIs_staff(Boolean is_staff) {
        this.is_staff = is_staff;
    }

    public Boolean getUser_profile() {
        return user_profile;
    }

    public void setUser_profile(Boolean user_profile) {
        this.user_profile = user_profile;
    }
}
