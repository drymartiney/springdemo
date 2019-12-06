package com.liuyanzhao.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Anthor: chen
 * Date: 2019/12/3
 * Time: 16:01
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    private String mpAppId;

    private String mpAppSecret;

    //商户号
    private String mchId;
    //商户密钥
    private String mchKey;
    //商户证书路径
    private String keyPath;

    private String notifyUrl;
}
