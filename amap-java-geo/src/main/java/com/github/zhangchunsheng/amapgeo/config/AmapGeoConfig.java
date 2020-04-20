package com.github.zhangchunsheng.amapgeo.config;

import lombok.Data;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.ssl.SSLContexts;

import javax.net.ssl.SSLContext;
import java.io.*;
import java.net.URL;
import java.security.KeyStore;

/**
 * 高德地图配置
 *
 * @author Chunsheng Zhang (https://github.com/zhangchunsheng)
 */
@Data
public class AmapGeoConfig {
    private static final String DEFAULT_GEO_BASE_URL = "https://restapi.amap.com";

    /**
     * 高德地图接口请求地址域名部分.
     */
    private String geoBaseUrl = DEFAULT_GEO_BASE_URL;

    /**
     * http请求连接超时时间.
     */
    private int httpConnectionTimeout = 5000;

    /**
     * http请求数据读取等待时间.
     */
    private int httpTimeout = 10000;

    /**
     * 高德地图key.
     */
    private String key;

    /**
     * 是否将接口请求日志信息保存到threadLocal中.
     * 默认不保存
     */
    private boolean ifSaveApiData = false;

    private String httpProxyHost;
    private Integer httpProxyPort;
    private String httpProxyUsername;
    private String httpProxyPassword;

    /**
     * 返回所设置的高德地图接口请求地址域名.
     *
     * @return 高德地图接口请求地址域名
     */
    public String getGeoBaseUrl() {
        if (StringUtils.isEmpty(this.geoBaseUrl)) {
            return DEFAULT_GEO_BASE_URL;
        }

        return this.geoBaseUrl;
    }
}
