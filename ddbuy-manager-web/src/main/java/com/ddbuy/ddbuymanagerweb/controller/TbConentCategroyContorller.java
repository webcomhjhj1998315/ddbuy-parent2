package com.ddbuy.ddbuymanagerweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.common.service.TbContentCategroyService;
import com.github.pagehelper.PageInfo;
import com.team.ddbuy.entity.TbContentCategory;
import com.team.ddbuy.util.PageUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 王建兵
 * @Classname TbConentCategroyContorller
 * @Description TODO
 * @Date 2019/11/12 11:24
 * @Created by Administrator
 */
@RestController  //服务
public class TbConentCategroyContorller {

    @Reference(interfaceClass = TbContentCategroyService.class,check = false)
    private TbContentCategroyService tbContentCategroyService;

    @RequestMapping("/getTbConentCategroy")
    public Map<String,Object> getTbConentCategroy(PageUtil pageUtil){
        //调用dubbo的服务
        PageInfo<TbContentCategory> pageInfo=tbContentCategroyService.getContentCategoryByPage(pageUtil);

        //返回数据
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }


    @RequestMapping("/getAllConent")
    public List<TbContentCategory> getAllConent(){
       return this.tbContentCategroyService.getAllContent();
    }

}
