package com.jk.service;

import com.jk.entity.Phone;

import java.util.Map;

public interface PhoneService{


    int deleteByPrimaryKey(Integer id);

    int insert(Phone record);

    int insertSelective(Phone record);

    Phone selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Phone record);

    int updateByPrimaryKey(Phone record);

    Map queryAll(Integer page, Integer rows, Phone phone);
}
