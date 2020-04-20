package com.github.zhangchunsheng.amapplace.service;

import com.github.zhangchunsheng.amapplace.bean.result.GeoResult;
import com.github.zhangchunsheng.amapplace.bean.result.RegeoResult;
import me.zhangchunsheng.amap.common.config.AmapConfig;
import me.zhangchunsheng.amap.common.exception.AmapException;

import java.io.File;
import java.util.Date;
import java.util.Map;

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
public interface PlaceService {

    public void setConfig(AmapConfig config);
    
    public GeoResult geo(String address) throws AmapException;

    public RegeoResult regeo(String location) throws AmapException;

}
