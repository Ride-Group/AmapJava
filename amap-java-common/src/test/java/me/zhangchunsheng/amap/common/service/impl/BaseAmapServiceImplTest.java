package me.zhangchunsheng.amap.common.service.impl;

import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import me.zhangchunsheng.amap.common.exception.AmapException;
import me.zhangchunsheng.amap.common.testbase.ApiTestModule;
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
public class BaseAmapServiceImplTest {

    @Inject
    private me.zhangchunsheng.amap.common.service.AmapService amapService;

    @Test
    public void testGeo() throws AmapException {
        String key = this.amapService.getConfig().getKey();
        assertNotNull(key);
    }
}
