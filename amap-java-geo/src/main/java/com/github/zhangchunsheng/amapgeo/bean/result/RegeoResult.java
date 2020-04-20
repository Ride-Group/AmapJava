package com.github.zhangchunsheng.amapgeo.bean.result;

import com.github.zhangchunsheng.amapgeo.util.json.AmapGsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RegeoResult extends BaseAmapGeoResult {
    private static final long serialVersionUID = 5408678833978707228L;

    @SerializedName("regeocode")
    private Regeocode regeocode;

    public static RegeoResult fromJson(String json) {
        return AmapGsonBuilder.create().fromJson(json, RegeoResult.class);
    }

    @Override
    public String toString() {
        return AmapGsonBuilder.create().toJson(this);
    }
}
