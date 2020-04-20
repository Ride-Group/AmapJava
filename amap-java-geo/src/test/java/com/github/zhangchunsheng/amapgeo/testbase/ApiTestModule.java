package com.github.zhangchunsheng.amapgeo.testbase;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.thoughtworks.xstream.XStream;

/**
 * The type Api test module.
 */
public class ApiTestModule implements Module {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private static final String TEST_CONFIG_XML = "test-config.xml";

    @Override
    public void configure(Binder binder) {
        try (InputStream inputStream = ClassLoader.getSystemResourceAsStream(TEST_CONFIG_XML)) {
            if (inputStream == null) {
                throw new RuntimeException("测试配置文件【" + TEST_CONFIG_XML + "】未找到，请参照test-config-sample.xml文件生成");
            }

            XmlAmapGeoConfig config = this.fromXml(XmlAmapGeoConfig.class, inputStream);
            com.github.zhangchunsheng.amapgeo.service.GeoService geoService = new com.github.zhangchunsheng.amapgeo.service.impl.GeoServiceImpl();
            geoService.setConfig(config);

            binder.bind(com.github.zhangchunsheng.amapgeo.service.GeoService.class).toInstance(geoService);
            binder.bind(com.github.zhangchunsheng.amapgeo.config.AmapGeoConfig.class).toInstance(config);
        } catch (IOException e) {
            this.log.error(e.getMessage(), e);
        }

    }

    @SuppressWarnings("unchecked")
    private <T> T fromXml(Class<T> clazz, InputStream is) {
        XStream xstream = XStreamInitializer.getInstance();
        xstream.alias("xml", clazz);
        xstream.processAnnotations(clazz);
        return (T) xstream.fromXML(is);
    }

}
