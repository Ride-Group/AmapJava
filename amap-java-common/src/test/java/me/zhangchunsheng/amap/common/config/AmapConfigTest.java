package me.zhangchunsheng.amap.common.config;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * <pre>
 *  Created by Chunsheng Zhang on 2020/4/20.
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
public class AmapConfigTest {
    private AmapConfig geoConfig = new AmapConfig();

    @Test
    public void test1() throws Exception {
        geoConfig.setKey("1");
    }
}
