package com.github.zhangchunsheng.amapplace.bean.result;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import me.zhangchunsheng.amap.common.util.json.AmapGsonBuilder;

import java.io.Serializable;

@Data
public class Poi implements Serializable {
    private static final long serialVersionUID = -330834334738622341L;

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("type")
    private String type;

    @SerializedName("typecode")
    private String typeCode;

    @SerializedName("address")
    private String address;

    @SerializedName("location")
    private String location;

    @SerializedName("tel")
    private Object tel;

    @SerializedName("website")
    private String website;

    @SerializedName("pcode")
    private String pcode;

    @SerializedName("pname")
    private String pname;

    @SerializedName("citycode")
    private String cityCode;

    @SerializedName("cityname")
    private String cityName;

    @SerializedName("adcode")
    private String adCode;

    @SerializedName("adname")
    private String adName;

    @SerializedName("shopinfo")
    private String shopInfo;

    @SerializedName("gridcode")
    private String gridCode;

    @SerializedName("navi_poiid")
    private String naviPoiid;

    @SerializedName("entr_location")
    private String entrLocation;

    @SerializedName("match")
    private String match;

    @SerializedName("recommend")
    private String recommend;

    @SerializedName("timestamp")
    private String timestamp;

    @SerializedName("alias")
    private String alias;

    @SerializedName("indoor_map")
    private String indoorMap;

    @SerializedName("groupbuy_num")
    private String groupbuyNum;

    @SerializedName("discount_num")
    private String discountNum;

    @Override
    public String toString() {
        return AmapGsonBuilder.create().toJson(this);
    }
}
