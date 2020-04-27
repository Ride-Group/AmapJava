package me.zhangchunsheng.amap.common.constant;

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
public class AmapConstants {
    /**
     * / 商务写字楼|住宅小区|培训机构|学校|知名企业|购物中心|综合酒楼|公园|地铁站
     "120201|120302|141400|141200|170100|060101|050101|110101|150500"
     */
    public static class PoiCode {

    }

    /**
     * 0：直线距离
     1：驾车导航距离（仅支持国内坐标）。
     必须指出，当为1时会考虑路况，故在不同时间请求返回结果可能不同。
     此策略和驾车路径规划接口的 strategy=4策略基本一致，策略为“ 躲避拥堵的路线，但是可能会存在绕路的情况，耗时可能较长 ”
     若需要实现高德地图客户端效果，可以考虑使用驾车路径规划接口
     3：步行规划距离（仅支持5km之间的距离）
     */
    public static class DistanceType {
        public static final int LINE = 0;
        public static final int DRIVE = 1;
        public static final int WALK = 2;
    }

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
        public static final String INPUTTIPS = "/v3/assistant/inputtips?output=json&city=%s&keywords=%s&key=%s&datatype=poi";
        public static final String PLACE_TEXT = "/v3/place/text?city=%s&keywords=%s&output=json&page=%s&offset=%s&key=%s&extensions=all";
        public static final String DISTANCE = "/v3/distance?origins=%s&destination=%s&type=%s&output=json&key=%s";
    }
}
