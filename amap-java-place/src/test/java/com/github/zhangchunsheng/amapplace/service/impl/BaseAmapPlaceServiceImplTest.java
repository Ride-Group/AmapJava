package com.github.zhangchunsheng.amapplace.service.impl;

import com.github.zhangchunsheng.amapplace.bean.result.InputTips;
import com.github.zhangchunsheng.amapplace.bean.result.PoiSearchResult;
import com.github.zhangchunsheng.amapplace.testbase.ApiTestModule;
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
public class BaseAmapPlaceServiceImplTest {

    @Inject
    private com.github.zhangchunsheng.amapplace.service.PlaceService placeService;

    @Test
    public void testInputTips() throws AmapException {
        InputTips result = this.placeService.inputTips("北京", "交易大厦");
        assertEquals("1", result.getStatus());
    }

    @Test
    public void testPlaceText() throws AmapException {
        PoiSearchResult result = this.placeService.placeText("北京", "nss", "1", "20");
        assertEquals("1", result.getStatus());
    }
}
