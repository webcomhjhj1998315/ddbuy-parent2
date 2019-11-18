package com.ddbuy.ddbuymanagerweb.util;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author 王建兵
 * @Classname FastDfsUtil
 * @Description TODO
 * @Date 2019/11/15 9:52
 * @Created by Administrator
 */
public class FastDfsUtil {
    /**
     * 上传文件的方法
     * @param file  表示文件的二进制数据
     * @param extName 文件的扩展名
     * @return 数组对象  包含两个元素
     * 第一个元素:组名  第二个元素存储的节点位置
     */
    public static String[] upload_file(byte [] file,String extName){
        TrackerClient client=null;
        TrackerServer trackerServer=null;
        StorageClient storageClient=null;
        try {
            //3.1 加载配置
            ClientGlobal.init("fastdfs.properties");
            //3.2创建TrackerClient对象
            client=new TrackerClient();
            //3.2获取TrackServer对象
            trackerServer=client.getConnection();
            //3.3获取StorageClient对象
            storageClient=new StorageClient(trackerServer,null);
            //3.4使用StorageClient进行上传
            String infos[]=storageClient.upload_file(file,extName,null);
            return infos;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }finally{
            try {
                //3.5关闭资源
                storageClient=null;
                trackerServer.close();
                client=null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //封装下载

    //封装删除
}
