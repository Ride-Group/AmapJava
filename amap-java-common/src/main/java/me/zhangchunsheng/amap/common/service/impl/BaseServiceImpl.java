package me.zhangchunsheng.amap.common.service.impl;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import jodd.io.ZipUtil;
import me.zhangchunsheng.amap.common.bean.AmapApiData;
import me.zhangchunsheng.amap.common.config.AmapConfig;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipException;

/**
 * <pre>
 *  高德地图接口请求抽象实现类
 *  Created by Chunsheng Zhang on 2020/4/20.
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
public abstract class BaseServiceImpl implements me.zhangchunsheng.amap.common.service.AmapService {
    /**
     * The Log.
     */
    final Logger log = LoggerFactory.getLogger(this.getClass());
    /**
     * The constant wxApiData.
     */
    static ThreadLocal<AmapApiData> amapApiData = new ThreadLocal<>();

    /**
     * The Config.
     */
    protected AmapConfig config;

    @Override
    public AmapConfig getConfig() {
        return this.config;
    }

    @Override
    public void setConfig(AmapConfig config) {
        this.config = config;
    }

    @Override
    public String getBaseUrl() {
        return this.getConfig().getBaseUrl();
    }
}
