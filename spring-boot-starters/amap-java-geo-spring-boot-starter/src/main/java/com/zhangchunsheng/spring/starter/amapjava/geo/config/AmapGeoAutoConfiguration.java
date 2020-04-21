package com.zhangchunsheng.spring.starter.amapjava.geo.config;

import com.github.zhangchunsheng.amapgeo.config.AmapGeoConfig;
import com.github.zhangchunsheng.amapgeo.service.GeoService;
import com.github.zhangchunsheng.amapgeo.service.impl.GeoServiceImpl;
import com.zhangchunsheng.spring.starter.amapjava.geo.properties.AmapGeoProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <pre>
 *  高德地图自动配置
 *  Created by Chunsheng Zhang on 2020/4/20.
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
@Configuration
@EnableConfigurationProperties(AmapGeoProperties.class)
@ConditionalOnClass(GeoService.class)
@ConditionalOnProperty(prefix = "amap", value = "enabled", matchIfMissing = true)
public class AmapGeoAutoConfiguration {
    private AmapGeoProperties properties;

    @Autowired
    public AmapGeoAutoConfiguration(AmapGeoProperties properties) {
        this.properties = properties;
    }

    /**
     * 构造高德地图地理服务对象.
     *
     * @return 高德地图地理service
     */
    @Bean
    @ConditionalOnMissingBean(GeoService.class)
    public GeoService geoService() {
        final GeoServiceImpl geoService = new GeoServiceImpl();
        AmapGeoConfig geoConfig = new AmapGeoConfig();
        geoConfig.setKey(StringUtils.trimToNull(this.properties.getKey()));

        geoService.setConfig(geoConfig);
        return geoService;
    }
}
