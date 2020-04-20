package com.github.zhangchunsheng.amapgeo.config;

import com.github.zhangchunsheng.amapgeo.config.AmapGeoConfig;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * <pre>
 *  Created by Chunsheng Zhang on 2020/4/20.
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
public class AmapGeoConfigTest {
    private AmapGeoConfig geoConfig = new AmapGeoConfig();

    @Test
    public void test1() throws Exception {
        geoConfig.setKey("1");
    }
}
