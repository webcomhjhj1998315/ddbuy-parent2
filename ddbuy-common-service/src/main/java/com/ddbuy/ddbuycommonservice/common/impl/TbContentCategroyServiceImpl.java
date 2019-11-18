package com.ddbuy.ddbuycommonservice.common.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ddbuy.common.service.TbContentCategroyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.ddbuy.entity.TbContentCategory;
import com.team.ddbuy.entity.TbContentCategoryExample;
import com.team.ddbuy.entity.TbContentExample;
import com.team.ddbuy.mapper.TbContentCategoryMapper;
import com.team.ddbuy.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 王建兵
 * @Classname TbContentCategroyServiceImpl
 * @Description TODO
 * @Date 2019/11/12 10:53
 * @Created by Administrator
 */
@Service(interfaceClass = TbContentCategroyService.class)
@Component
public class TbContentCategroyServiceImpl implements TbContentCategroyService {
    @Autowired(required = false)
    private TbContentCategoryMapper tbContentCategoryMapper;

    @Override
    public PageInfo<TbContentCategory> getContentCategoryByPage(PageUtil page) {
        //开启分页支持
        PageHelper.startPage(page.getPage(),page.getRows());
        //查询所有分类
        TbContentCategoryExample example=new TbContentCategoryExample();
        List<TbContentCategory> list=tbContentCategoryMapper.selectByExample(example);
        return new PageInfo<>(list);
    }

    @Override
    public List<TbContentCategory> getAllContent() {
        return tbContentCategoryMapper.selectByExample(new TbContentCategoryExample());
    }
}
