package cn.java.controller.app;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.java.entity.User;

@Controller
@RequestMapping("/app/")
public class TestController {
	@RequestMapping("test1")
	@ResponseBody
	public String test1() {
		System.out.println("test1constroller-----------test1");
		return "front/success.jsp";
	}
	
	@RequestMapping("test2")
	@ResponseBody
	public boolean test2() {
		System.out.println("test1constroller-----------test2");
		return true;
	}
	
	@RequestMapping("beanToJson")
	@ResponseBody
	public User beanToJson() {
		User user = new User();
		user.setUsername("王二麻子");
		user.setAge(20);
		user.setPassword("123");
		return user;
	}
	
	@RequestMapping("mapToJson")
	@ResponseBody
	public Map<String, Object> mapToJson() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("java", 80f);
		map.put("springmvc", 100f);
		return map;
	}
	
	@RequestMapping("listToJson")
	@ResponseBody
	public List<Map<String,Object>> listToJson() {
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("java", 80f);
		map1.put("springmvc", 100f);
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("java", 80f);
		map2.put("springmvc", 100f);
		
		List<Map<String,Object>> maplist = new ArrayList<Map<String, Object>>();
		maplist.add(map1);
		maplist.add(map2);
		return maplist;
	}
}
