package com.github.zhangchunsheng.amapdirection.service.impl;

import com.github.zhangchunsheng.amapdirection.bean.result.DistanceResult;
import com.github.zhangchunsheng.amapdirection.service.DirectionService;
import me.zhangchunsheng.amap.common.constant.AmapConstants;
import me.zhangchunsheng.amap.common.exception.AmapException;
import me.zhangchunsheng.amap.common.service.impl.AmapServiceApacheHttpImpl;

/**
 * <pre>
 * 高德地图接口请求实现类，默认使用Apache HttpClient实现
 * Created by Chunsheng Zhang on 2020/4/20.
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
public class DirectionServiceImpl extends AmapServiceApacheHttpImpl implements DirectionService {
    @Override
    public DistanceResult distance(String origins, String destination, int type) throws AmapException {
        String responseContent = this.get(String.format(this.getConfig().getBaseUrl() + AmapConstants.Url.DISTANCE, origins, destination, type, this.getConfig().getKey()));
        return DistanceResult.fromJson(responseContent);
    }
}
