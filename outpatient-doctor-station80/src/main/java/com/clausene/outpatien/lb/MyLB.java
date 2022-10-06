package com.clausene.outpatien.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: Clausene
 * @Title: MyLB
 * @ProjectName: barefoot-doctor-master
 * @Description:
 * @date: 2022/10/4 0:35
 */
@Component
public class MyLB implements MyLoadBalancer{

    // 声明原子计数对象[下一个服务器循环计数器]
    private AtomicInteger nextServerCyclicCounter = new AtomicInteger(0);

    public int incrementAndGetModulo(int modulo){
        // 自旋锁
        for (;;){
            // 获取当前计数
            int current = nextServerCyclicCounter.get();
            int next = current >= Integer.MAX_VALUE ? 0 : (current + 1) % modulo;
            if (nextServerCyclicCounter.compareAndSet(current,next)){
                return next;
            }
        }
    }
    @Override
    public ServiceInstance getServiceInstance(List<ServiceInstance> serviceInstanceList) {
        int serverCount = serviceInstanceList.size();
        int nextServerIndex = incrementAndGetModulo(serverCount);
        return serviceInstanceList.get(nextServerIndex);
    }
}
