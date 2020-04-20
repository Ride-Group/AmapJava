package com.github.zhangchunsheng.amapplace.bean.result;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import me.zhangchunsheng.amap.common.bean.result.BaseAmapResult;
import me.zhangchunsheng.amap.common.util.json.AmapGsonBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
public class RegeoResult extends BaseAmapResult {
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
