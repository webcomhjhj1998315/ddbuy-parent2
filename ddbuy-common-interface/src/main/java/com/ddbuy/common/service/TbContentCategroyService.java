package com.ddbuy.common.service;

import com.github.pagehelper.PageInfo;
import com.team.ddbuy.entity.TbContentCategory;
import com.team.ddbuy.util.PageUtil;

import java.util.List;

/**
 * @author 王建兵
 * @Classname TbContentCategroyService
 * @Description TODO
 * @Date 2019/11/12 10:45
 * @Created by Administrator
 */
public interface TbContentCategroyService {

    //查询所有分类  带分页
    PageInfo<TbContentCategory> getContentCategoryByPage(PageUtil page);

    //查询所有内容分类
    List<TbContentCategory> getAllContent();
}
