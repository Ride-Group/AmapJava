package com.github.zhangchunsheng.amapplace.service;

import com.github.zhangchunsheng.amapplace.bean.result.InputTips;
import com.github.zhangchunsheng.amapplace.bean.result.PoiSearchResult;
import me.zhangchunsheng.amap.common.exception.AmapException;
import me.zhangchunsheng.amap.common.service.AmapService;

/**
 * <pre>
 * 搜索API
 * Created by Chunsheng Zhang on 2020/4/20.
 *
 * https://lbs.amap.com/api/webservice/guide/api/search/
 *
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
public interface PlaceService extends AmapService {

    public InputTips inputTips(String city, String keywords) throws AmapException;

    public PoiSearchResult placeText(String city, String keywords, String page, String offset) throws AmapException;

}
