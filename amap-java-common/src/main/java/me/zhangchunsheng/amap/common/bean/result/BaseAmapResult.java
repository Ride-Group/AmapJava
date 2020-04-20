package me.zhangchunsheng.amap.common.bean.result;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import me.zhangchunsheng.amap.common.util.json.AmapGsonBuilder;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import org.w3c.dom.*;

/**
 * <pre>
 * 高德地图结果共用属性类.
 * Created by Chunsheng Zhang on 2020/4/20.
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
@Data
public abstract class BaseAmapResult implements Serializable {
    private static final long serialVersionUID = 2101652152604850904L;
    protected String status;
    protected String info;
    protected String infoCode;
    protected String count;

    /**
     * 请求是否成功.
     */
    public boolean isSuccess() {
        return StringUtils.equalsIgnoreCase(status, "1");
    }

    public static BaseAmapResult fromJson(String json) {
        return AmapGsonBuilder.create().fromJson(json, BaseAmapResult.class);
    }

    @Override
    public String toString() {
        return AmapGsonBuilder.create().toJson(this);
    }
}
