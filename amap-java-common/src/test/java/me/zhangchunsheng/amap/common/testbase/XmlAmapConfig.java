package me.zhangchunsheng.amap.common.testbase;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * The type Xml Amap config.
 */
@XStreamAlias("xml")
public class XmlAmapConfig extends me.zhangchunsheng.amap.common.config.AmapConfig {
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
