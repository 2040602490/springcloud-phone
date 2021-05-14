package com.jk.controller;

import com.jk.entity.Phone;
import com.jk.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("phone")
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    /**
    * @Author: rkm
    * @Description:
    * @Date: 2021/5/13 19:05
    * @Param:[page, rows, phone]
    * @Return: java.util.Map
     * 条查批删
    **/
    @GetMapping("/")
    public Map queryAll(Integer page, Integer rows, Phone phone){
        System.out.println();
        return phoneService.queryAll(page, rows, phone);
    }

    /**
    * @Author: rkm
    * @Description:
    * @Date: 2021/5/13 19:06
    * @Param:[phone]
    * @Return: void
     * 新增或修改
    **/
    @PostMapping("/")
    public void insertOrUpdate(Phone phone){
        phoneService.insertOrUpdate(phone);
    }

    /**
    * @Author: rkm
    * @Description:
    * @Date: 2021/5/13 19:08
    * @Param:[ids]
    * @Return: void
     * 单删批删
    **/
    @DeleteMapping("{ids}")
    public void deleteAll(@PathVariable("ids") Integer[] ids){
        phoneService.deleteAll(ids);
    }

    /**
    * @Author: rkm
    * @Description:
    * @Date: 2021/5/13 19:41
    * @Param:[id]
    * @Return: com.jk.entity.Phone
     * 回显
    **/
    @GetMapping("{id}")
    public Phone findById(@PathVariable("id") Integer id){
        return phoneService.findById(id);
    }
}
