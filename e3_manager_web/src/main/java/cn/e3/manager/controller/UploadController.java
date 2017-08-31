package cn.e3.manager.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.e3.manager.utils.FastDFSClient;
import cn.e3.utils.JsonUtils;
import cn.e3.utils.PicResult;

@Controller
public class UploadController {
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	
	@RequestMapping("pic/upload")
	@ResponseBody
	public String upload(MultipartFile
			uploadFile){
		//获取文件名称
		String filename = uploadFile.getOriginalFilename();
		String ext = filename.substring(filename.lastIndexOf(".")+1);
		try {
			//设置图片服务器的地址 这个是带端口号的
			FastDFSClient fClient = new FastDFSClient("classpath:client.conf");
			//设置文件名称以及扩展名
			String url = fClient.uploadFile(uploadFile.getBytes(),ext);
			url=IMAGE_SERVER_URL+url;
			System.out.println(url);
			PicResult result = new PicResult();
			result.setUrl(url);
			result.setError(0);
			//把他设置成json字符串格式 解决浏览器兼容
			String json = JsonUtils.objectToJson(result);
			return json;
			
		} catch (Exception e) {
			e.printStackTrace();
			PicResult result = new PicResult();
			result.setError(1);
			result.setMessage("上传失败");
			String json = JsonUtils.objectToJson(result);
			return json;
		}
	}
}
