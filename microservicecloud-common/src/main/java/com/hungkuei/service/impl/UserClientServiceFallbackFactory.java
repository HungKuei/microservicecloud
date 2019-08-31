package com.hungkuei.service.impl;

import com.hungkuei.model.TUser;
import com.hungkuei.service.UserClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component //一定要添加该注解，否则不起作用
public class UserClientServiceFallbackFactory implements FallbackFactory<UserClientService> {

    @Override
    public UserClientService create(Throwable throwable) {
        return new UserClientService() {

            @Override
            public TUser getByUserId(Integer userId) {
                return new TUser(userId,"该ID：" + userId + "没有对应的信息，Consumer客户端提供的降级信息，此刻服务Provider已经关闭", 0);
            }

            @Override
            public List<TUser> getAll() {
                return null;
            }
        };
    }
}
