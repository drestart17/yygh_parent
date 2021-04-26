package cn.srt.bigdata.yygh.hosp.controller;

import cn.srt.bigdata.yygh.hosp.service.HospitalSetService;
import cn.srt.bigdata.yygh.model.hosp.HospitalSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-04-26 23:30
 */

@RestController
@RequestMapping("/admin/hosp/hospitalSet")
public class HospitalSetController {

    //service注入

    @Autowired
    private HospitalSetService hospitalSetService;

    @GetMapping("findAll")
    public List<HospitalSet> findAll() {

        List<HospitalSet> list = hospitalSetService.list();
        return list;
    }
}
