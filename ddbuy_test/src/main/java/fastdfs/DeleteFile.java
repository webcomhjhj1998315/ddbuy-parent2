package fastdfs;


import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

import java.io.IOException;

/**
 * @author 王建兵
 * @Classname UploadFile
 * @Description TODO
 * @Date 2019/11/14 10:38
 * @Created by Administrator
 */
public class DeleteFile {
    public static void main(String[] args) {
        //使用java操作FastDfs删除文件的步骤
        //1.导入依赖
        //2.编写配置
        //3.实现上传的步骤
        try {
            //3.1 加载配置
            ClientGlobal.init("fastdfs.properties");
            //3.2创建TrackerClient对象
            TrackerClient client=new TrackerClient();
            //3.2获取TrackServer对象
            TrackerServer trackerServer=client.getConnection();
            //3.3获取StorageClient对象
            StorageClient storageClient=new StorageClient(trackerServer,null);
            //3.4使用StorageClient进行删除

            storageClient.delete_file("group1","M00/00/00/wKgBHl3NOROANZfKAAIDIjmRqwU925.jpg");
            //3.5关闭资源
            storageClient=null;
            trackerServer.close();
            client=null;
            System.out.println("成功删除");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
    //投简历->人事邀请->笔试——技术面试（真实性）-->复试
}
