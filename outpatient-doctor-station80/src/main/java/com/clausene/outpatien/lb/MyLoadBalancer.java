package com.clausene.outpatien.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author: Clausene
 * @Title: MyLoadBalancer
 * @ProjectName: barefoot-doctor-master
 * @Description: 自定义负载算法获取负载集群中的机器实例信息
 * @date: 2022/10/4 0:31
 */
public interface MyLoadBalancer {

    /***
     * @author Clausene
     * @date 2022/10/4 0:34
     * @Description: 获取负载服务实例
     * @param: serviceInstanceList
     * @return org.springframework.cloud.client.ServiceInstance
    */
    public ServiceInstance getServiceInstance(List<ServiceInstance> serviceInstanceList);
}
