package com.github.zhangchunsheng.amapplace.service.impl;

import com.github.zhangchunsheng.amapplace.bean.result.InputTips;
import com.github.zhangchunsheng.amapplace.bean.result.PoiSearchResult;
import com.github.zhangchunsheng.amapplace.service.PlaceService;
import me.zhangchunsheng.amap.common.constant.AmapConstants;
import me.zhangchunsheng.amap.common.exception.AmapException;
import me.zhangchunsheng.amap.common.service.impl.AmapServiceApacheHttpImpl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * <pre>
 * 高德地图接口请求实现类，默认使用Apache HttpClient实现
 * Created by Chunsheng Zhang on 2020/4/20.
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
public class PlaceServiceImpl extends AmapServiceApacheHttpImpl implements PlaceService {
    @Override
    public InputTips inputTips(String city, String keywords) throws AmapException {
        try {
            // URL 编码
            keywords = URLEncoder.encode(keywords, "utf-8");
        } catch (UnsupportedEncodingException e) {
            // do nothing
        }

        String responseContent = this.get(String.format(this.getConfig().getBaseUrl() + AmapConstants.Url.INPUTTIPS, city, keywords, this.getConfig().getKey()));
        return InputTips.fromJson(responseContent);
    }

    @Override
    public PoiSearchResult placeText(String city, String keywords, String page, String offset) throws AmapException {
        try {
            // URL 编码
            keywords = URLEncoder.encode(keywords, "utf-8");
        } catch (UnsupportedEncodingException e) {
            // do nothing
        }
        String responseContent = this.get(String.format(this.getConfig().getBaseUrl() + AmapConstants.Url.PLACE_TEXT, city, keywords, page, offset, this.getConfig().getKey()));
        return PoiSearchResult.fromJson(responseContent);
    }
}
