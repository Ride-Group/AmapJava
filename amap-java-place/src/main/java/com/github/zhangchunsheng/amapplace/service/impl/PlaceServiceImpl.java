package com.github.zhangchunsheng.amapplace.service.impl;

import com.github.zhangchunsheng.amapplace.bean.result.GeoResult;
import com.github.zhangchunsheng.amapplace.bean.result.RegeoResult;
import com.github.zhangchunsheng.amapplace.service.PlaceService;
import me.zhangchunsheng.amap.common.constant.AmapConstants;
import me.zhangchunsheng.amap.common.exception.AmapException;
import me.zhangchunsheng.amap.common.service.AmapService;
import me.zhangchunsheng.amap.common.service.impl.AmapServiceApacheHttpImpl;

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
    public GeoResult geo(String address) throws AmapException {
        String responseContent = this.get(String.format(this.getConfig().getBaseUrl() + AmapConstants.Url.GEO, address, this.getConfig().getKey()));
        return GeoResult.fromJson(responseContent);
    }

    @Override
    public RegeoResult regeo(String location) throws AmapException {
        String responseContent = this.get(String.format(this.getConfig().getBaseUrl() + AmapConstants.Url.REGEO, location, this.getConfig().getKey()));
        return RegeoResult.fromJson(responseContent);
    }
}
