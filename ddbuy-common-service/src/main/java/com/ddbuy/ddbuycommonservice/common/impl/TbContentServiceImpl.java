package com.ddbuy.ddbuycommonservice.common.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ddbuy.common.service.TbContentService;
import com.team.ddbuy.entity.TbContent;
import com.team.ddbuy.mapper.TbContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 王建兵
 * @Classname TbContentServiceImpl
 * @Description TODO
 * @Date 2019/11/15 9:29
 * @Created by Administrator
 */
@Service(interfaceClass = TbContentService.class)
@Component
public class TbContentServiceImpl implements TbContentService {

    @Autowired(required =false)
    private TbContentMapper tbContentMapper;

    @Override
    public int addTbContent(TbContent tbContent) {
        return tbContentMapper.insertSelective(tbContent);
    }
}
