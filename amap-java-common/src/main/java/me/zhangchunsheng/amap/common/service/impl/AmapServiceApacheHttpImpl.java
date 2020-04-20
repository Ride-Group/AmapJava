package me.zhangchunsheng.amap.common.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.net.ssl.SSLContext;

import jodd.util.Base64;
import me.zhangchunsheng.amap.common.bean.AmapApiData;
import me.zhangchunsheng.amap.common.exception.AmapException;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import jodd.util.Base64;

/**
 * <pre>
 * 高德地图请求实现类，apache httpclient实现.
 * Created by Chunsheng Zhang on 2020/4/20.
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
public class AmapServiceApacheHttpImpl extends BaseServiceImpl {
    @Override
    public byte[] postForBytes(String url, String requestStr) throws AmapException {
        try {
            HttpClientBuilder httpClientBuilder = createHttpClientBuilder();
            HttpPost httpPost = this.createHttpPost(url, requestStr);
            try (CloseableHttpClient httpClient = httpClientBuilder.build()) {
                try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                    final byte[] bytes = EntityUtils.toByteArray(response.getEntity());
                    final String responseData = Base64.encodeToString(bytes);
                    this.log.info("\n【请求地址】：{}\n【请求数据】：{}\n【响应数据(Base64编码后)】：{}", url, requestStr, responseData);
                    amapApiData.set(new AmapApiData(url, requestStr, responseData, null));
                    return bytes;
                }
            } finally {
                httpPost.releaseConnection();
            }
        } catch (Exception e) {
            this.log.error("\n【请求地址】：{}\n【请求数据】：{}\n【异常信息】：{}", url, requestStr, e.getMessage());
            amapApiData.set(new AmapApiData(url, requestStr, null, e.getMessage()));
            throw new AmapException(e.getMessage(), e);
        }
    }

    @Override
    public String get(String url) throws AmapException {
        try {
            HttpClientBuilder httpClientBuilder = this.createHttpClientBuilder();
            HttpGet httpGet = this.createHttpGet(url);
            try (CloseableHttpClient httpClient = httpClientBuilder.build()) {
                try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                    String responseString = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                    this.log.info("\n【请求地址】：{}\n【请求数据】：{}\n【响应数据】：{}", url, "", responseString);
                    if (this.getConfig().isIfSaveApiData()) {
                        amapApiData.set(new AmapApiData(url, "", responseString, null));
                    }
                    return responseString;
                }
            } finally {
                httpGet.releaseConnection();
            }
        } catch (Exception e) {
            this.log.error("\n【请求地址】：{}\n【请求数据】：{}\n【异常信息】：{}", url, "", e.getMessage());
            if (this.getConfig().isIfSaveApiData()) {
                amapApiData.set(new AmapApiData(url, "", null, e.getMessage()));
            }
            throw new AmapException(e.getMessage(), e);
        }
    }

    @Override
    public String post(String url, String requestStr) throws AmapException {
        try {
            HttpClientBuilder httpClientBuilder = this.createHttpClientBuilder();
            HttpPost httpPost = this.createHttpPost(url, requestStr);
            try (CloseableHttpClient httpClient = httpClientBuilder.build()) {
                try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                    String responseString = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                    this.log.info("\n【请求地址】：{}\n【请求数据】：{}\n【响应数据】：{}", url, requestStr, responseString);
                    if (this.getConfig().isIfSaveApiData()) {
                        amapApiData.set(new AmapApiData(url, requestStr, responseString, null));
                    }
                    return responseString;
                }
            } finally {
                httpPost.releaseConnection();
            }
        } catch (Exception e) {
            this.log.error("\n【请求地址】：{}\n【请求数据】：{}\n【异常信息】：{}", url, requestStr, e.getMessage());
            if (this.getConfig().isIfSaveApiData()) {
                amapApiData.set(new AmapApiData(url, requestStr, null, e.getMessage()));
            }
            throw new AmapException(e.getMessage(), e);
        }
    }

    private StringEntity createEntry(String requestStr) {
        try {
            return new StringEntity(new String(requestStr.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
        } catch (UnsupportedEncodingException e) {
            //cannot happen
            this.log.error(e.getMessage(), e);
            return null;
        }
    }

    private HttpClientBuilder createHttpClientBuilder() throws AmapException {
        HttpClientBuilder httpClientBuilder = HttpClients.custom();

        if (StringUtils.isNotBlank(this.getConfig().getHttpProxyHost()) && this.getConfig().getHttpProxyPort() > 0) {
            if (StringUtils.isEmpty(this.getConfig().getHttpProxyUsername())) {
                this.getConfig().setHttpProxyUsername("whatever");
            }

            // 使用代理服务器 需要用户认证的代理服务器
            CredentialsProvider provider = new BasicCredentialsProvider();
            provider.setCredentials(new AuthScope(this.getConfig().getHttpProxyHost(), this.getConfig().getHttpProxyPort()),
                    new UsernamePasswordCredentials(this.getConfig().getHttpProxyUsername(), this.getConfig().getHttpProxyPassword()));
            httpClientBuilder.setDefaultCredentialsProvider(provider);
            httpClientBuilder.setProxy(new HttpHost(this.getConfig().getHttpProxyHost(), this.getConfig().getHttpProxyPort()));
        }
        return httpClientBuilder;
    }

    private HttpPost createHttpPost(String url, String requestStr) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(this.createEntry(requestStr));

        httpPost.setConfig(RequestConfig.custom()
                .setConnectionRequestTimeout(this.getConfig().getHttpConnectionTimeout())
                .setConnectTimeout(this.getConfig().getHttpConnectionTimeout())
                .setSocketTimeout(this.getConfig().getHttpTimeout())
                .build());

        return httpPost;
    }

    private HttpGet createHttpGet(String url) {
        HttpGet httpGet = new HttpGet(url);

        httpGet.setConfig(RequestConfig.custom()
                .setConnectionRequestTimeout(this.getConfig().getHttpConnectionTimeout())
                .setConnectTimeout(this.getConfig().getHttpConnectionTimeout())
                .setSocketTimeout(this.getConfig().getHttpTimeout())
                .build());

        return httpGet;
    }
}
