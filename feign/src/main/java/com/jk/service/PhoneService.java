package com.jk.service;

import com.jk.entity.Phone;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(value = "provider")
public interface PhoneService {

    @RequestMapping("phone/queryAll")
    Map queryAll(@RequestParam Integer page,@RequestParam Integer rows,@RequestBody Phone phone);

    @RequestMapping(value = "phone/insertOrUpdate", method = RequestMethod.POST)
    void insertOrUpdate(@RequestBody Phone phone);

    @RequestMapping("phone/deleteAll")
    void deleteAll(@RequestParam Integer[] ids);

    @RequestMapping("phone/findById")
    Phone findById(@RequestParam Integer id);
}
