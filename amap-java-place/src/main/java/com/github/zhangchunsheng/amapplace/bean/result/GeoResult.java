package com.github.zhangchunsheng.amapplace.bean.result;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.zhangchunsheng.amap.common.bean.result.BaseAmapResult;
import me.zhangchunsheng.amap.common.util.json.AmapGsonBuilder;
import org.w3c.dom.Document;

import java.util.List;

/**
 * <pre>
 * 转换短链接结果对象类
 * Created by Chunsheng Zhang on 2020/4/20.
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GeoResult extends BaseAmapResult {
    private static final long serialVersionUID = -5707576958339934210L;

    @SerializedName("geocodes")
    private List<Geocode> geocodes;

    public static GeoResult fromJson(String json) {
        return AmapGsonBuilder.create().fromJson(json, GeoResult.class);
    }

    @Override
    public String toString() {
        return AmapGsonBuilder.create().toJson(this);
    }

}
