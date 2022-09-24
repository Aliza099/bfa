package PojoModels;

import com.example.bfa.DatumBookList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LibList {

        @SerializedName("code")
        @Expose
        private Integer code;
        @SerializedName("success")
        @Expose
        private Boolean success;
        @SerializedName("data")
        @Expose
        private List<DatumBookList> data = null;

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

        public List<DatumBookList> getData() {
            return data;
        }

        public void setData(List<DatumBookList> data) {
            this.data = data;
        }

    }

