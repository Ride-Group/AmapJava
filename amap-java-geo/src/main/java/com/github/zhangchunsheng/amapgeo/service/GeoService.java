package com.github.zhangchunsheng.amapgeo.service;

import com.github.zhangchunsheng.amapgeo.bean.result.GeoResult;
import com.github.zhangchunsheng.amapgeo.bean.result.RegeoResult;
import com.github.zhangchunsheng.amapgeo.config.AmapGeoConfig;
import com.github.zhangchunsheng.amapgeo.exception.AmapGeoException;

import java.io.File;
import java.util.Date;
import java.util.Map;

/**
 * <pre>
 * 地理/逆地理编码
 * Created by Chunsheng Zhang on 2020/4/20.
 *
 * https://lbs.amap.com/api/webservice/guide/api/georegeo/
 *
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
public interface GeoService {

    /**
     * 获取高德地图请求url前缀
     *
     * @return the pay base url
     */
    String getGeoBaseUrl();

    public AmapGeoConfig getConfig();

    public void setConfig(AmapGeoConfig config);

    public byte[] postForBytes(String url, String requestStr) throws AmapGeoException;

    public String post(String url, String requestStr) throws AmapGeoException;

    public String get(String url) throws AmapGeoException;

    public GeoResult geo(String address) throws AmapGeoException;

    public RegeoResult regeo(String location) throws AmapGeoException;

}
