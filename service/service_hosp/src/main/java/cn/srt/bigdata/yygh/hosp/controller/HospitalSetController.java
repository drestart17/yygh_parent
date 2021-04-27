package cn.srt.bigdata.yygh.hosp.controller;

import cn.srt.bigdata.common.result.Result;
import cn.srt.bigdata.yygh.hosp.service.HospitalSetService;
import cn.srt.bigdata.yygh.model.hosp.HospitalSet;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @create 2021-04-26 23:30
 */

@RestController
@RequestMapping("/admin/hosp/hospitalSet")
@Api(tags = "医院设置接口")
public class HospitalSetController {

    //service注入
    //http:localhost:8201/admin/hosp/hospitalSet/findAll
    @Autowired
    private HospitalSetService hospitalSetService;

    @GetMapping("findAll")
    @ApiOperation(value = "查询所有数据")
    public Result findAll() {

        //查询所有数据
        HospitalSet list = hospitalSetService.getById(2);
        return Result.ok(list);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "逻辑删除医院设置")
    public Result deleteById(@ApiParam(name = "idhhh",value = "删除的ID",required = true) @PathVariable Long id) {

        //根据ID删除记录
        boolean flag = hospitalSetService.removeById(id);
        if(flag = true) {
            return Result.ok();
        }else {
            return Result.fail();
        }
    }
}
