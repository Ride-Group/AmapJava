package com.github.zhangchunsheng.amapgeo.service.impl;

import com.github.zhangchunsheng.amapgeo.bean.result.GeoResult;
import com.github.zhangchunsheng.amapgeo.bean.result.RegeoResult;
import com.github.zhangchunsheng.amapgeo.exception.AmapGeoException;
import com.github.zhangchunsheng.amapgeo.testbase.ApiTestModule;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Calendar;
import java.util.Date;

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
public class BaseAmapGeoServiceImplTest {

    @Inject
    private com.github.zhangchunsheng.amapgeo.service.GeoService geoService;

    @Test
    public void testGeo() throws AmapGeoException {
        GeoResult result = this.geoService.geo("北京市朝阳区阜通东大街6号");
        assertEquals("1", result.getStatus());
    }

    @Test
    public void testRego() throws AmapGeoException {
        RegeoResult result = this.geoService.regeo("116.310003,39.991957");
        assertEquals("1", result.getStatus());
    }
}
