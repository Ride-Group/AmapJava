package com.github.zhangchunsheng.amapdirection.bean.result;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import me.zhangchunsheng.amap.common.util.json.AmapGsonBuilder;

import java.io.Serializable;
import java.util.List;

@Data
public class Distance implements Serializable {
    private static final long serialVersionUID = -1070939403132276555L;
    @SerializedName("origin_id")
    private String originId;

    @SerializedName("dest_id")
    private String destId;

    @SerializedName("distance")
    private String distance;

    @SerializedName("duration")
    private String duration;

    @Override
    public String toString() {
        return AmapGsonBuilder.create().toJson(this);
    }
}