package com.github.zhangchunsheng.amapplace.bean.result;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import me.zhangchunsheng.amap.common.util.json.AmapGsonBuilder;

import java.io.Serializable;
import java.util.List;

@Data
public class Tips implements Serializable {
    private static final long serialVersionUID = -1070939403109776555L;
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("district")
    private String district;

    @SerializedName("adcode")
    private String adcode;

    @SerializedName("location")
    private String location;

    @SerializedName("address")
    private Object address;

    @SerializedName("typecode")
    private String typecode;

    @SerializedName("city")
    private Object city;

    @Override
    public String toString() {
        return AmapGsonBuilder.create().toJson(this);
    }
}