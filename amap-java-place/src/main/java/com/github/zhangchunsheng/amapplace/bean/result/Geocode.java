package com.github.zhangchunsheng.amapplace.bean.result;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Geocode implements Serializable {
    private static final long serialVersionUID = -1194154790100866123L;
    @SerializedName("formatted_address")
    private String formattedAddress;

    @SerializedName("country")
    private String country;

    @SerializedName("province")
    private String province;

    @SerializedName("citycode")
    private String citycode;

    @SerializedName("city")
    private String city;

    @SerializedName("district")
    private String district;

    @SerializedName("adcode")
    private String adcode;

    @SerializedName("street")
    private String street;

    @SerializedName("number")
    private String number;

    @SerializedName("location")
    private String location;

    @SerializedName("level")
    private String level;
}