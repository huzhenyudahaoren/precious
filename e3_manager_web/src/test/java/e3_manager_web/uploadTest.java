package e3_manager_web;

import org.junit.Test;

import cn.e3.manager.utils.FastDFSClient;

public class uploadTest {
	@Test
public void upload() throws Exception{
		//图片地址
	String path="D:\\我的文档\\图片收藏\\jay.jpg";
		//client地址
	String clientPath="D:\\e3\\e3_manager_web\\src\\main\\resources\\client.conf";
	FastDFSClient fastDFSClient = new FastDFSClient(clientPath);
	String string = fastDFSClient.uploadFile(path);
	System.out.println(string);
	
	//上传图片 ,
	//传递的参数   MultipartFile uploadFile
	//url  /pic/upload
	//返回类型  封装类型,还得转换为json字符串 返回json字符串类型,这样能解决服务器兼容问题
}
}
