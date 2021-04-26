package cn.srt.bigdata.yygh.hosp.service.impl;


import cn.srt.bigdata.yygh.hosp.mapper.HostpitalSetMapper;
import cn.srt.bigdata.yygh.hosp.service.HospitalSetService;
import cn.srt.bigdata.yygh.model.hosp.HospitalSet;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author shkstart
 * @create 2021-04-26 23:09
 * Service实现类加上@Service注解，交给Spring管理
 */

@Service
public class HospitalSetServiceImpl extends ServiceImpl<HostpitalSetMapper,HospitalSet> implements HospitalSetService {

    //不需要注入Mapper了，可以直接调用
    
}
