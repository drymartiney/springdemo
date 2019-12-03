package com.liuyanzhao.sell.controller;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;

/**
 * Anthor: chen
 * Date: 2019/12/3
 * Time: 15:52
 */
@RestController
@RequestMapping
@Slf4j
public class WechatController {
    @Autowired
    private WxMpService wxMpService;

    @GetMapping("/auth")
    public String authorize(@RequestParam("returnUrl")String returnUrl){
        //1.配置

        //2.调用方法
        String url="127.0.0.1";
        String redirectUrl=wxMpService.oauth2buildAuthorizationUrl(url,WxConsts.OAuth2Scope.SNSAPI_USERINFO, URLEncoder.encode(returnUrl));
        log.info("【微信网页授权】获取code，result={}",redirectUrl);

        return "redirect:"+redirectUrl;
    }
}
