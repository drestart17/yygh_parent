package cn.srt.bigdata.yygh.hosp.controller;

import cn.srt.bigdata.yygh.hosp.service.HospitalSetService;
import cn.srt.bigdata.yygh.model.hosp.HospitalSet;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @create 2021-04-26 23:30
 */

@RestController
@RequestMapping("/admin/hosp/hospitalSet")
public class HospitalSetController {

    //service注入

    @Autowired
    private HospitalSetService hospitalSetService;

    @GetMapping("findAll")
    public HospitalSet findAll() {

        //查询所有数据
        HospitalSet list = hospitalSetService.getById(2);
        return list;
    }

    @DeleteMapping("{id}")
    public boolean deleteById(@PathVariable Long id) {

        //根据ID删除记录
        boolean flag = hospitalSetService.removeById(id);
        return flag;
    }
}
