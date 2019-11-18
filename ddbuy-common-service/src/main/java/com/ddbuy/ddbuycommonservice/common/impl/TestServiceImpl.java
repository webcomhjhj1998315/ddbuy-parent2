package com.ddbuy.ddbuycommonservice.common.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ddbuy.common.service.TestService;
import org.junit.Test;
import org.springframework.stereotype.Component;

/**
 * @author 王建兵
 * @Classname TestServiceImpl
 * @Description TODO
 * @Date 2019/11/11 11:55
 * @Created by Administrator
 */
@Component
@Service(interfaceClass = TestService.class)
public class TestServiceImpl implements TestService {
    @Override
    public String getHw() {
        return "helloword";
    }
}
