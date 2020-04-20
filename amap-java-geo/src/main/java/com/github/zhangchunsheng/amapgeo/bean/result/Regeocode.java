package com.github.zhangchunsheng.amapgeo.bean.result;

import com.github.zhangchunsheng.amapgeo.util.json.AmapGsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class Regeocode implements Serializable {
    private static final long serialVersionUID = -7966682379048446567L;

    @SerializedName("formatted_address")
    private String formattedAddress;

    @SerializedName("addressComponent")
    private AddressComponent addressComponent;

    @Data
    public static class AddressComponent implements Serializable {
        private static final long serialVersionUID = -8847603245514017839L;
        @SerializedName("country")
        private String country;
        @SerializedName("province")
        private String province;
        @SerializedName("city")
        private Object city;
        @SerializedName("citycode")
        private String citycode;
        @SerializedName("district")
        private String district;
        @SerializedName("adcode")
        private String adcode;
        @SerializedName("township")
        private String township;
        @SerializedName("towncode")
        private String towncode;

        @Override
        public String toString() {
            return AmapGsonBuilder.create().toJson(this);
        }
    }
}
