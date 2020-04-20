package com.github.zhangchunsheng.amapgeo.constant;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.time.FastDateFormat;

import java.text.Format;
import java.util.List;

/**
 * <pre>
 * 高德地图常量类
 * Created by Chunsheng Zhang on 2020/4/20.
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
public class AmapGeoConstants {
    /**
     * 结果代码.
     */
    public static class ResultStatus {
        /**
         * 成功.
         */
        public static final String SUCCESS = "1";

        /**
         * 失败.
         */
        public static final String FAIL = "0";
    }

    public static class Url {
        public static final String GEO = "/v3/geocode/geo?address=%s&output=json&key=%s";
        public static final String REGEO = "/v3/geocode/regeo?output=json&location=%s&key=%s&radius=1000&extensions=all";
    }
}
