package com.jk.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.jk.dao.PhoneMapper;
import com.jk.entity.Phone;
import com.jk.service.PhoneService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PhoneServiceImpl implements PhoneService{

    @Resource
    private PhoneMapper phoneMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return phoneMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Phone record) {
        return phoneMapper.insert(record);
    }

    @Override
    public int insertSelective(Phone record) {
        return phoneMapper.insertSelective(record);
    }

    @Override
    public Phone selectByPrimaryKey(Integer id) {
        return phoneMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Phone record) {
        return phoneMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Phone record) {
        return phoneMapper.updateByPrimaryKey(record);
    }

    @Override
    public Map queryAll(Integer page, Integer rows, Phone phone) {
        //查询总条数
        int total = phoneMapper.queryCount(phone);
        //查询展示的数据：开始位置、每页条数、limit
        int start = (page-1)*rows;
        List<Phone> list = phoneMapper.queryUserPage(start,rows,phone);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

}
