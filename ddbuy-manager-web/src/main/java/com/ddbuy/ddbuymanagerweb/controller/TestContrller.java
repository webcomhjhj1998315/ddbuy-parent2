package com.ddbuy.ddbuymanagerweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.common.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 王建兵
 * @Classname TestContrller
 * @Description TODO
 * @Date 2019/11/11 11:57
 * @Created by Administrator
 */
@Controller
public class TestContrller {
    @Reference(interfaceClass = TestService.class)
   private TestService testService;

  @RequestMapping("/getHw")
  @ResponseBody
  public String getHw(){
    return testService.getHw();
  }
}
