package cn.java.controller.front;

import org.omg.CORBA.Request;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.java.entity.User;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Scope("prototype")
public class HomeController {
	
	@RequestMapping(value="test1")
	public void test1(User user) {
		System.out.println("test1");
		System.out.println(user);
	}
	
	@RequestMapping(value="test2")
	public void test2(@RequestParam(name = "user",defaultValue="zhansan",required=false) String username,@RequestParam(name = "pwd") String password,@RequestParam(name = "nianlin") Integer age) {
		System.out.println("test2");
		System.out.println(username);
		System.out.println(password);
		System.out.println(age);
	}
	
	@RequestMapping(value="submitAdvise")
	public void submitYijian(@RequestParam(required=true)String content,@RequestParam(required=false)String phoneNum, @RequestParam(required=false) String email) {
		
	}
	
	@RequestMapping(value = "test3")
	public void test3(String user, String pwd, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if("admin".equals(user) && "123".equals(pwd)) {//登录成功
			//request.getRequestDispatcher("/pages/front/success.jsp").forward(request,  response);
			String basePath = request.getContextPath();// dt48_springMVC2
			response.sendRedirect("/dt48_springMVC2/page/front/success.jsp");
		}else{
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}
	
	@RequestMapping(value = "test4")
	public String test4(String user, String pwd)  {
		if("admin".equals(user) && "123".equals(pwd)) {//登录成功
			return "redirect:/page/front/success.jsp";
		}else{
			return "forward:/index.jsp";
		}
	}
	
	@RequestMapping(value = "test5")
	public String test5(String user, String pwd)  {
		return "/page/front/success.jsp";
	}
	
	@RequestMapping(value = "test6")
	public String test6(String user, String pwd,HttpServletRequest request,Model model, Map<String, Object>map){
		/*request.setCharacterEndcoding("utf-8");
		response.setCharacterEndcoding("utf-8");
		response.setContentType("text/html;charset=utf-8");*/
		System.out.println("user"+user);
		System.out.println("pwd"+pwd);
		//request.setAttribute("user", user);
		//model.addAttribute("username",user);
		if("admin".equals(user) && "123".equals(pwd)) {//登录成功
			return "front/success.jsp";
		}else{
			return "forward:/index.jsp";
		}
	}
	
	@RequestMapping(value = "test7")
	public String test7(String user, String pwd,Map<String, Object>map){
		map.put("aaa", "wangermai");
		return "front/success.jsp";
	}
	
	@RequestMapping(value="test8")
	public void test8() {
		int i = 10/0;
	}
	
	//只能处理当前class
	//异常处理注解
	@ExceptionHandler(Exception.class)
	public String exceptionHand(Exception ex) {
		ex.printStackTrace();
		//System.out.println("haha,恭喜你出错了");
		return "front/error.jsp";
	}
	
	//异常处理注解 精确匹配
		@ExceptionHandler(ArithmeticException.class)
		public String exceptionHand2(ArithmeticException ex) {
			ex.printStackTrace();
			//System.out.println("haha,恭喜你出错了");
			return "front/error.jsp";
		}
}
