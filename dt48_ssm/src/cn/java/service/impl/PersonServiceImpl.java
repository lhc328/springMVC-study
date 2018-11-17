package cn.java.service.impl;

import org.springframework.aop.aspectj.AspectJAdviceParameterNameDiscoverer.AmbiguousBindingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.java.entity.Person;
import cn.java.mapper.AccountMapper;
import cn.java.mapper.PersonMapper;
import cn.java.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonMapper pm;
	@Autowired
	private AccountMapper am;

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Person record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Person record) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 指定id查詢用戶
	@Override
	public Person selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return pm.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Person record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Person record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional(readOnly = false)
	public int zhuangMoney(String bankNo1, String bankNo2, Integer money) {
		// 1.宝强-200
		int result1 = am.updateMoney(-money, bankNo1);
		int i = 10/0;
		
		int result2 = 0;
		if (result1 >= 1) {
			// 2.马蓉+200
			result2 = am.updateMoney(money, bankNo2);
		}
		return result2 ;
	}

}
