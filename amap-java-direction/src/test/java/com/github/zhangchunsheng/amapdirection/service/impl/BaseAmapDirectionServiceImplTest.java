package com.github.zhangchunsheng.amapdirection.service.impl;

import com.github.zhangchunsheng.amapdirection.bean.result.DistanceResult;
import com.github.zhangchunsheng.amapdirection.testbase.ApiTestModule;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import me.zhangchunsheng.amap.common.exception.AmapException;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

/**
 * 测试GEO相关接口
 * Created by Chunsheng Zhang on 2020/4/20.
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
@Slf4j
@Test
@Guice(modules = ApiTestModule.class)
public class BaseAmapDirectionServiceImplTest {

    @Inject
    private com.github.zhangchunsheng.amapdirection.service.DirectionService directionService;

    @Test
    public void testDistance() throws AmapException {
        DistanceResult result = this.directionService.distance("116.481028,39.989643", "114.465302,40.004717", 1);
        assertEquals("1", result.getStatus());
    }
}
