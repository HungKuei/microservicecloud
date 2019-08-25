package com.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * 自定义负载均衡规则算法 ==>> 每个微服务调用5次换下一个微服务
 * @author hungkuei
 */
public class CustomRule extends AbstractLoadBalancerRule {

    private int total = 0;
    private int currentIndex = 0;

    public Server choose(ILoadBalancer lb, Object key){

        if (lb == null){
            return null;
        }

        Server server = null;
        while (server == null){
            if (Thread.interrupted()){
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0){
                return null;
            }

            if (total < 5){
                server = upList.get(currentIndex);
                total++;
            }else {
                total = 0;
                currentIndex++;
                if (currentIndex >= upList.size()){
                    currentIndex = 0;
                }
            }

            if (server == null){
                Thread.yield();
                continue;
            }

            if (server.isAlive()){
                return (server);
            }

            server = null;
            Thread.yield();
        }
        return server;
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }
}
