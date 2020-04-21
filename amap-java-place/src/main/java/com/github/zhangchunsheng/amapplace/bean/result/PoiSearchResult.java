package com.github.zhangchunsheng.amapplace.bean.result;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import me.zhangchunsheng.amap.common.bean.result.BaseAmapResult;
import me.zhangchunsheng.amap.common.util.json.AmapGsonBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
public class PoiSearchResult extends BaseAmapResult {
    private static final long serialVersionUID = 4587181819499286670L;

    @SerializedName("pois")
    private Poi pois;

    public static PoiSearchResult fromJson(String json) {
        return AmapGsonBuilder.create().fromJson(json, PoiSearchResult.class);
    }

    @Override
    public String toString() {
        return AmapGsonBuilder.create().toJson(this);
    }
}
