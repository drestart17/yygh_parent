package cn.srt.bigdata.yygh.hosp.controller;

import cn.srt.bigdata.common.exception.YyghException;
import cn.srt.bigdata.common.result.Result;
import cn.srt.bigdata.common.utils.MD5;
import cn.srt.bigdata.yygh.hosp.service.HospitalSetService;
import cn.srt.bigdata.yygh.model.hosp.HospitalSet;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

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

    //3.条件查询带分页@ApiOperation(value = "根据医院名称和ID分页查询医院设置")@PostMapping("findPageHospSet/{current}/{limit}")public Result findPageHospSet(@PathVariable Long current,                              @PathVariable Long limit,                              @RequestBody(required = false) HospitalSetQueryVo hospitalSetQueryVo) {    //3.1创建条件查询对象    QueryWrapper<HospitalSet> hospitalSetWrapper = new QueryWrapper<>();    //3.2如果非required条件需要判断条件是否为空    String hosname = hospitalSetQueryVo.getHosname();    String hoscode = hospitalSetQueryVo.getHoscode();    if(!StringUtils.isEmpty(hosname)) {        hospitalSetWrapper.like("hosname",hospitalSetQueryVo.getHosname());    }    if(!StringUtils.isEmpty(hoscode)) {        hospitalSetWrapper.eq("hoscode", hospitalSetQueryVo.getHoscode());    }    //创建分页对象    Page<HospitalSet> hospitalSetPage = new Page<>(current,limit);    Page<HospitalSet> resultPage = hospitalSetService.page(hospitalSetPage, hospitalSetWrapper);    return Result.ok(resultPage);}


//4.添加医院设置
    @PostMapping("saveHospitalSet")
    public Result saveHospitalSet(@RequestBody HospitalSet hospitalSet) {


        //1.设置默认状态 1：使用 0：不能使用
        hospitalSet.setStatus(1);


        //2.设置签名密钥：随机数 + 当前时间 + MD5加密
        //2.1 生成一个随机数
        Random random = new Random();
        int randInt = random.nextInt(1000);
        //2.2 获取系统当前时间
        long curTimeStamp = System.currentTimeMillis();
        //2.3 MD5加密
        String encrypt = MD5.encrypt(curTimeStamp + "" + randInt);
        //2.4 给signKey赋值
        hospitalSet.setSignKey(encrypt);


        //调用service层
        boolean saveFlag = hospitalSetService.save(hospitalSet);


        if(saveFlag) {
            return Result.ok();
        }else {
            return Result.fail();
        }

    }


//修改：5.1 根据ID查询医院设置


    @GetMapping("getHospSet/{id}")
    public Result getHospSet(@PathVariable Long id) {

        //模拟异常
        try {
            int a = 1/0;
        }catch (Exception e) {
            throw new YyghException("/zero 失败",201);
        }

        HospitalSet hospitalSet = hospitalSetService.getById(id);


        return Result.ok(hospitalSet);
    }


    //5.2 修改医院设置
    @PostMapping("updateHospitalSet")
    public Result updateHospitalSet(@RequestBody HospitalSet hospitalSet) {


        boolean flag = hospitalSetService.updateById(hospitalSet);


        if(flag) {
            return Result.ok();
        }else {
            return Result.fail();
        }
    }


    //6.批量删除医院设置接口
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> ids ) {


        boolean flag = hospitalSetService.removeByIds(ids);
        return Result.ok();
    }

    //7.医院设置锁定和解锁
    @PutMapping("localHospitalSet/{id}/{status}")
    public Result localHospitalSet(@PathVariable Long id,
                                   @PathVariable Integer status) {

        HospitalSet hospitalSet = hospitalSetService.getById(id);

        hospitalSet.setStatus(status);
        boolean flag = hospitalSetService.updateById(hospitalSet);
        if(flag) {
            return Result.ok();
        }else {
            return Result.fail();
        }
    }

    //8.发送签名密钥
    @PutMapping("sendKey/{id}")
    public Result sendKey(@PathVariable Long id) {

        HospitalSet hospitalSet = hospitalSetService.getById(id);

        String signKey = hospitalSet.getSignKey();
        String hoscode = hospitalSet.getHoscode();

        //TODO 发送短信
        return Result.ok();
    }
}
