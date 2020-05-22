package com.github.zhangchunsheng.spring.starter.amapjava.geo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <pre>
 *  高德地图属性配置类
 *  Created by Chunsheng Zhang on 2020/4/20.
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
@Data
@ConfigurationProperties(prefix = "amap")
public class AmapGeoProperties {
  /**
   * 高德地图key.
   */
  private String key;
}
