package com.jk.dao;

import com.jk.entity.Phone;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PhoneMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Phone record);

    int insertSelective(Phone record);

    Phone selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Phone record);

    int updateByPrimaryKey(Phone record);

    int queryCount(@Param("phone") Phone phone);

    List<Phone> queryUserPage(@Param("start") int start, @Param("rows") Integer rows, @Param("phone") Phone phone);
}