package PojoModels;

import com.example.bfa.BooksDetailResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class BooksResponse {

        @SerializedName("code")
        @Expose
        private Integer code;
        @SerializedName("success")
        @Expose
        private Boolean success;
        @SerializedName("data")
        @Expose
        private List<BooksDetailResponse> data;

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

        public List<BooksDetailResponse> getData() {
            return  data;
        }

        public void setData(List<BooksDetailResponse> data) {

            this.data = data;
        }

    }

