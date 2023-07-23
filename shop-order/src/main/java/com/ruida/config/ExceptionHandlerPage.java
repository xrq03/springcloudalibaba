package com.ruida.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.adapter.spring.webflux.exception.SentinelBlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Component
public class ExceptionHandlerPage  implements UrlBlockHandler {
    @Override
    public void blocked(HttpServletRequest request, HttpServletResponse response, BlockException e) throws IOException {
    //blocked 方法用于处理被限流的请求。根据不同的 BlockException 类型，生成相应的 ResultData 对象，并通过 response 输出 JSON 格式的响应数据。
        //
        //ResultData 是一个简单的数据对象，有两个字段：code 表示异常类型的代码，message 表示异常的描述信息。
        response.setContentType("application/json;charset=utf-8");
        ResultData data = null;
        if (e instanceof FlowException) {
            data = new ResultData(-1, "接口被限流了");
        } else if (e instanceof DegradeException) {
            data = new ResultData(-2, "接口被降级了");
        } else if (e instanceof ParamFlowException) {
            data = new ResultData(-3, "参数限流异常");
        } else if (e instanceof AuthorityException) {
            data = new ResultData(-4, "授权异常");
        } else if (e instanceof SystemBlockException) {
            data = new ResultData(-5, "接口被降级了...");
        }
        response.getWriter().write(JSON.toJSONString(data));
    }

    @Data
    @AllArgsConstructor//全参构造
    @NoArgsConstructor//无参构造
    class ResultData {
        private int code;
        private String message;
    }
}
