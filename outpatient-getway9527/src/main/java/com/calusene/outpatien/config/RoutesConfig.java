package com.calusene.outpatien.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Clausene
 * @Title: RoutesConfig
 * @ProjectName: barefoot-doctor-master
 * @Description:
 * @date: 2022/10/5 17:23
 */
@Configuration
public class RoutesConfig {

    /***
     * @author Clausene
     * @date 2022/10/5 17:30
     * @Description: 通过java 类配置路由规则信息
     * @param: routeLocatorBuilder
     * @return org.springframework.cloud.gateway.route.RouteLocator
    */
    @Bean
    public RouteLocator customRouteLocatorBulder(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes= routeLocatorBuilder.routes();
        routes.route("path_route_baidu",r->r.path("/guoji")
                .uri("http://news.baidu.com/guonji"))
                .build();
        return routes.build();
    }
}
