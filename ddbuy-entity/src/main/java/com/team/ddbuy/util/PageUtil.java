package com.team.ddbuy.util;

import java.io.Serializable;

/**
 * @author 王建兵
 * @Classname PageUtil
 * @Description TODO
 * @Date 2019/10/14 8:35
 * @Created by Administrator
 */
//分页的工具类
public class PageUtil implements Serializable {
    private Integer page=1;  //接收页码
    private Integer rows=5;  //页大小

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
