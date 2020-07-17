package com.github.zhangchunsheng.amapgeo.testbase;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * The type Xml amap geo config.
 */
@XStreamAlias("xml")
public class XmlAmapGeoConfig extends com.github.zhangchunsheng.amapgeo.config.AmapGeoConfig {
    private String key;

    /**
     * Gets openid.
     *
     * @return the openid
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets openid.
     *
     * @param openid the openid
     */
    public void setKey(String openid) {
        this.key = key;
    }

}
