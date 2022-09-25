package PojoModels;

import com.example.bfa.Data;
import com.example.bfa.DatumCardList;
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
        private List<Data> data;

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

        public List<Data> getData() {
            return  data;
        }

        public void setData(List<Data> data) {

            this.data = data;
        }

    }

