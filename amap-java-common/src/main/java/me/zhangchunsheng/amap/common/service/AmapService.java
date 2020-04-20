package me.zhangchunsheng.amap.common.service;

import me.zhangchunsheng.amap.common.config.AmapConfig;
import me.zhangchunsheng.amap.common.exception.AmapException;

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
public interface AmapService {

    /**
     * 获取高德地图请求url前缀
     *
     * @return the amap base url
     */
    String getBaseUrl();

    public AmapConfig getConfig();

    public void setConfig(AmapConfig config);

    public byte[] postForBytes(String url, String requestStr) throws AmapException;

    public String post(String url, String requestStr) throws AmapException;

    public String get(String url) throws AmapException;

}
