package com.jk.controller;

import com.jk.entity.Phone;
import com.jk.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("phone")
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    /**
    * @Author: rkm
    * @Description:
    * @Date: 2021/5/13 17:39
    * @Param:[page, rows, phone]
    * @Return: java.util.Map
     * 条查分页
    **/
    @RequestMapping("queryAll")
    public Map queryAll(Integer page, Integer rows,@RequestBody Phone phone){
        System.out.println();
        return phoneService.queryAll(page, rows, phone);
    }

    /**
    * @Author: rkm
    * @Description:
    * @Date: 2021/5/13 17:50
    * @Param:[phone]
    * @Return: void
     *新增Or修改
    **/
    @RequestMapping("insertOrUpdate")
    public void insertOrUpdate(@RequestBody Phone phone){
        if (phone.getId() == null) {//没id走新增
            phoneService.insert(phone);
        } else {
            phoneService.updateByPrimaryKey(phone);
        }
    }

    /**
    * @Author: rkm
    * @Description:
    * @Date: 2021/5/13 17:52
    * @Param:[id]
    * @Return: com.jk.entity.Phone
     * 回显
    **/
    @RequestMapping("findById")
    public Phone findById(Integer id){
        return phoneService.selectByPrimaryKey(id);
    }

    /**
    * @Author: rkm
    * @Description:
    * @Date: 2021/5/13 17:53
    * @Param:[ids]
    * @Return: void
     * 单删批删
    **/
    @RequestMapping("deleteAll")
    public void deleteAll(Integer[] ids){
        for (int i = 0; i < ids.length; i++) {
            phoneService.deleteByPrimaryKey(ids[i]);
        }
    }

}
