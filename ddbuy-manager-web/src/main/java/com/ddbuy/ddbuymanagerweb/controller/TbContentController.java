package com.ddbuy.ddbuymanagerweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.common.service.TbContentService;
import com.ddbuy.ddbuymanagerweb.util.FastDfsUtil;
import com.team.ddbuy.entity.TbContent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author 王建兵
 * @Classname TbContentController
 * @Description TODO
 * @Date 2019/11/15 9:41
 * @Created by Administrator
 */
@Controller
public class TbContentController {
    //注入远程服务
    @Reference(interfaceClass = TbContentService.class)
    private TbContentService tbContentService;

    //利用属性云获取属性文件的值
    @Value("${FastDfs_nginx_server_address}")
    private String FastDfs_nginx_server_address;

    //实现添加广告
    @RequestMapping("/addContent")
    @ResponseBody
    public String addContent(TbContent tbContent,@RequestParam(value = "pfile",required = false) MultipartFile pfile){
        //1.实现文件上传  2.调用服务将数据保存到数据库
        //1.实现文件上传：将上传文件保存到文件服务器 java操作fastdfs
        //调用FastDfs工具类实现上传
        try {
            //获取文件的扩展名  cdsfskdlf.jsdfs.jpg
            String fileName=pfile.getOriginalFilename();
            String extName=fileName.substring(fileName.lastIndexOf(".")+1);
            String [] info=FastDfsUtil.upload_file(pfile.getBytes(),extName);
            //System.out.println("上传成功"+info[0]+info[1]);

            //2.将数据添加数据库
            //将上传文件的路径设置到实体的属性
            String savePath="http://"+FastDfs_nginx_server_address+"/"+info[0]+"/"+info[1];
            tbContent.setPic(savePath);
            //调用服务
            this.tbContentService.addTbContent(tbContent);
            return "{\"result\":1}";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "{\"result\":-1}";
    }

}

