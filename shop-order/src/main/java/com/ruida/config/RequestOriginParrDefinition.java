package com.ruida.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.RequestOriginParser;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
//@Component
public class RequestOriginParrDefinition implements RequestOriginParser {
    //RequestOriginParrDefinition 类使用 @Component 注解将其标记为一个 Spring 组件，用于自动进行扫描和注册。
    //parseOrigin 方法用于解析请求的来源。在该方法中，通过 httpServletRequest.getParameter("serviceName")
    // 获取请求中名为 “serviceName” 的参数值，并将其作为请求的来源。
    //解析请求来源的目的是为了在 Sentinel 中根据来源对请求进行流控、降级等限制策略。
    // 通过自定义的 RequestOriginParser，你可以根据具体的业务需求来定义和解析请求来源，从而实现更加细粒度的限流和流量控制策略。
    //需要注意的是，在实际使用中，你需要将 RequestOriginParrDefinition 注册到 Spring 容器中，以便 Sentinel 能够自动发现和调用它。
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        String serviceName=httpServletRequest.getParameter("serviceName");
        return serviceName;
    }
}
