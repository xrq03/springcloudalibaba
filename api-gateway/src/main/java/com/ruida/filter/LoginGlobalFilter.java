package com.ruida.filter;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.client.utils.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import java.util.HashMap;
import java.util.Map;
//@Component
public class LoginGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token=exchange.getRequest().getQueryParams().getFirst("token");
        ServerHttpResponse response=exchange.getResponse();
        if (token==null){
            Map<String,Object> map=new HashMap<>();
            map.put("code",100);
            map.put("message","请先登录");
            try {
                byte[] datas = JSON.toJSONString(map).getBytes("utf-8");
                DataBuffer buffer = response.bufferFactory().wrap(datas);
                response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
                return response.writeWith(Mono.just(buffer));
            }catch (Exception e){}
        }
        // 这里假设 token 的值是 ”admin“
        if(!StringUtils.equals(token,"admin")){
            Map<String,Object> map=new HashMap<>();
            map.put("code",101);
            map.put("message","登陆失效");
            try {
                byte[] datas = JSON.toJSONString(map).getBytes("utf-8");
                DataBuffer buffer = response.bufferFactory().wrap(datas);
                response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
                return response.writeWith(Mono.just(buffer));
            }catch (Exception e){
            }
        }
        return chain.filter(exchange);//放行
        }


    @Override
    public int getOrder() {
        return 0;
    }
}
