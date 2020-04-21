package com.github.zhangchunsheng.amapplace.bean.result;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import me.zhangchunsheng.amap.common.bean.result.BaseAmapResult;
import me.zhangchunsheng.amap.common.util.json.AmapGsonBuilder;

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
public class InputTips extends BaseAmapResult {
    private static final long serialVersionUID = -7083914585539687746L;

    @SerializedName("tips")
    private List<Tips> tips;

    public static InputTips fromJson(String json) {
        return AmapGsonBuilder.create().fromJson(json, InputTips.class);
    }

    @Override
    public String toString() {
        return AmapGsonBuilder.create().toJson(this);
    }

}
