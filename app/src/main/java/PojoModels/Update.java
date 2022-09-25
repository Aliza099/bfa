package PojoModels;


import com.example.bfa.ProfileResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class Update {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private ProfileResponse data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public ProfileResponse getData() {
        return data;
    }

    public void setData(ProfileResponse data) {
        this.data = data;
    }

}