package cn.java.constroller.front;

import java.awt.geom.GeneralPath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.java.entity.Person;
import cn.java.service.PersonService;

@Controller
@RequestMapping(value="/front/")
public class FrontController {
	@Autowired
	private PersonService ps;
	
	
	@RequestMapping("hello")
	@ResponseBody
	public String getHello() {
		return "hello sb";
	}
	
	@RequestMapping("getPersonById")
	@ResponseBody
	public Person getPersonById(Long id) {
		return ps.selectByPrimaryKey(id); 
	}
	
	@RequestMapping("zhuangMoney")
	@ResponseBody
	public int zhuangMoney(String bankNo1, String bankNo2, Integer money) {
		return ps.zhuangMoney(bankNo1, bankNo2, money);
	}
}
