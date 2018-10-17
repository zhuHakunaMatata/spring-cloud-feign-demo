package com.exampel.spring.cloud.feign.client.ribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * Created by kyle on 2018/10/17.
 */
public class MyLoadBanlanceRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }

    @Override
    public Server choose(Object key) {

        List<Server> allServers = getLoadBalancer().getAllServers();
        return allServers.get(0);
    }
}
