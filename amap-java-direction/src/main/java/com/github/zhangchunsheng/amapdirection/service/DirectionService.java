package com.github.zhangchunsheng.amapdirection.service;

import com.github.zhangchunsheng.amapdirection.bean.result.DistanceResult;
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
public interface DirectionService extends AmapService {

    public DistanceResult distance(String origins, String destination, int type) throws AmapException;

}
