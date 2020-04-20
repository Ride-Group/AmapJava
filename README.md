# AmapJava
Amap java

### 使用SDK
```java
// spring boot, inject geoService
GeoResult result = this.geoService.geo("北京市朝阳区阜通东大街6号");
```

### maven
### Maven 引用方式
```xml
<dependency>
    <groupId>com.github.zhangchunsheng</groupId>
    <artifactId>amap-java</artifactId>
    <version>1.0.0</version>
</dependency>
<dependency>
    <groupId>com.github.zhangchunsheng</groupId>
    <artifactId>amap-java-geo</artifactId>
    <version>1.0.0</version>
</dependency>
```

### 高德geo
```json
{
    "status" : "1",
    "info" : "OK",
    "infocode" : "10000",
    "count" : "1",
    "geocodes" :
    [
        {
        "formatted_address" : "北京市朝阳区阜通东大街|6号",
        "country" : "中国",
        "province" : "北京市",
        "citycode" : "010",
        "city" : "北京市",
        "district" : "朝阳区",
        "township" : [ ],
        "neighborhood" :{},
        "building" :{},
        "adcode" : "110105",
        "street" : "阜通东大街",
        "number" : "6号",
        "location" : "116.483038,39.990633",
        "level" : "门牌号"
        }
    ]
}
```

## 捐助 donate

支付宝

![alipay](https://wx4.sinaimg.cn/mw690/46b94231ly1ge0okee0fej20ec0e6gp3.jpg)

微信

![wechat](https://wx4.sinaimg.cn/mw690/46b94231ly1ge0okecldyj20e80e8n0c.jpg)