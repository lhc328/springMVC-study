package cn.java.controller.app;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping(value="/upload/")
public class TestController2 {
	
	@RequestMapping("singleFileUpload")
	public void singleFileUpload(@RequestParam(name="bigHeadImage") MultipartFile file,HttpServletRequest request) throws Exception {
		//1.getOriginFilename():获取上传文件的文件名
		String originalFilename = file.getOriginalFilename();
		//2.getName()：获取file控件name的属性值-->bigHeadImage
		String name  = file.getName();
		System.out.println(originalFilename+"---"+name);
		//3.将上传文件保存到目录下
		//path = E:\\eclipse\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\wtpwebapps\\dt48_springMVC3\\upload
		String uuid = UUID.randomUUID().toString();
		String path =  request.getServletContext().getRealPath("/upload");
		File filePath = new File(path + "\\" + uuid + originalFilename);
		file.transferTo(filePath);
	}
	
	@RequestMapping(value="getUploadPath")
	public void getUploadPath(HttpServletRequest request) {
//		String path = request.getRealPath("/upload");
//		System.out.println(path);
		ServletContext sc = request.getServletContext();
		String path =  sc.getRealPath("/upload");
		System.out.println(path);
	}
	
	//UUID可以生成不重复的序列号
	@Test
	public void testUUID() {
		//网卡号加上时间戳
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);
	}
}
