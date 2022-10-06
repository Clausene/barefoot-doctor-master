package com.clausene.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Clausene
 * @Title: MyRule
 * @ProjectName: barefoot-doctor-master
 * @Description:
 * @date: 2022/10/4 0:17
 */
@Configuration
public class MyselfRule {

    /**
     * @author Clausene
     * @date 2022/10/4 0:19
     * @Description: 声明为随机负载规则
     * @param:
     * @return com.netflix.loadbalancer.IRule
    */
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
