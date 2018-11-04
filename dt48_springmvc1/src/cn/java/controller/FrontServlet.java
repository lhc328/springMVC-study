package cn.java.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.java.entity.User;

@Controller//如果一个类被它注解，则普通类变成一个servlet
public class FrontServlet {
	
	@RequestMapping(value= {"/login.htm","a.htm","c.htm"})//为当前方法配置一个对外访问的虚拟路径
	public void Login(User user) {
		System.out.println("登录成功");
		System.out.println(user);
	}
	
	@RequestMapping(value="/register.htm",method=RequestMethod.POST)
	public String register(User user) {
		//System.out.println("注册成功");
		System.out.println(user);
		return "/success.jsp";
	}
}
