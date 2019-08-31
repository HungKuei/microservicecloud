package com.hungkuei.service;

import com.hungkuei.model.TUser;
import com.hungkuei.service.impl.UserClientServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "MICROSERVICECLOUD-PROVIDER-HYSTRIX", fallbackFactory = UserClientServiceFallbackFactory.class)
public interface UserClientService {

    @GetMapping(value = "/provider/user/get/{userId}")
    TUser getByUserId(@PathVariable("userId") Integer userId);

    @GetMapping(value = "/provider/user/get/list")
    List<TUser> getAll();

}
