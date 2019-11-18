package com.ddbuy.ddbuycommonservice;


import com.ddbuy.common.service.TbContentCategroyService;
import com.team.ddbuy.entity.TbContentCategory;
import com.team.ddbuy.util.PageUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DdbuyCommonServiceApplicationTests {

    @Autowired
    private TbContentCategroyService tbContentCategroyService;

    @Test
   public void contextLoads() {
        PageUtil page=new PageUtil();
        page.setPage(1);
        page.setPage(4);
        System.out.println("total:"+tbContentCategroyService.getContentCategoryByPage(page).getTotal());
    }
}
