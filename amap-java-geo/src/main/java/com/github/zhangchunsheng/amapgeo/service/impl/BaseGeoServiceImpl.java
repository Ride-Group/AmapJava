package com.github.zhangchunsheng.amapgeo.service.impl;

import com.github.zhangchunsheng.amapgeo.bean.AmapGeoApiData;
import com.github.zhangchunsheng.amapgeo.bean.result.GeoResult;
import com.github.zhangchunsheng.amapgeo.bean.result.RegeoResult;
import com.github.zhangchunsheng.amapgeo.config.AmapGeoConfig;
import com.github.zhangchunsheng.amapgeo.constant.AmapGeoConstants;
import com.github.zhangchunsheng.amapgeo.exception.AmapGeoException;
import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import jodd.io.ZipUtil;
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
public abstract class BaseGeoServiceImpl implements com.github.zhangchunsheng.amapgeo.service.GeoService {
    /**
     * The Log.
     */
    final Logger log = LoggerFactory.getLogger(this.getClass());
    /**
     * The constant amapApiData.
     */
    static ThreadLocal<AmapGeoApiData> amapApiData = new ThreadLocal<>();

    /**
     * The Config.
     */
    protected AmapGeoConfig config;

    @Override
    public AmapGeoConfig getConfig() {
        return this.config;
    }

    @Override
    public void setConfig(AmapGeoConfig config) {
        this.config = config;
    }

    @Override
    public String getGeoBaseUrl() {
        return this.getConfig().getGeoBaseUrl();
    }

    @Override
    public GeoResult geo(String address, String city) throws AmapGeoException {
        String responseContent = this.get(String.format(this.getConfig().getGeoBaseUrl() + AmapGeoConstants.Url.GEO, address, city, this.getConfig().getKey()));
        return GeoResult.fromJson(responseContent);
    }

    @Override
    public RegeoResult regeo(String location) throws AmapGeoException {
        String responseContent = this.get(String.format(this.getConfig().getGeoBaseUrl() + AmapGeoConstants.Url.REGEO, location, this.getConfig().getKey()));
        return RegeoResult.fromJson(responseContent);
    }
}
