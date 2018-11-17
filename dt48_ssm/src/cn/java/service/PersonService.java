package cn.java.service;

import cn.java.entity.Person;

public interface PersonService {
    int deleteByPrimaryKey(Long id);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);
    
    int zhuangMoney(String bankNo1, String bankNo2, Integer money);
}