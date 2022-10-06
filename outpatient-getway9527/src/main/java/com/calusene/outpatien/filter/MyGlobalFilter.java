package com.calusene.outpatien.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author: Clausene
 * @Title: GlobalFilter
 * @ProjectName: barefoot-doctor-master
 * @Description:
 * @date: 2022/10/5 17:44
 */
@Component
@Slf4j
public class MyGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("网关进入自定义全局过滤器");
        String token = exchange.getRequest().getHeaders().getFirst("token");
        if (!"Clausene".equals(token)){
            log.info("token 不符合规则，不能访问");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
//            return exchange.getResponse().setComplete();
        }
        // 进入到下一个过滤器
        return chain.filter(exchange);
    }
    /***
     * @author Clausene
     * @date 2022/10/5 17:45
     * @Description: 返回值越小优先级越高
     * @param:
     * @return int
    */
    @Override
    public int getOrder() {
        return 0;
    }
}
