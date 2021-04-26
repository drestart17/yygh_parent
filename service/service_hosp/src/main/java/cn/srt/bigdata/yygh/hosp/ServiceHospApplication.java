package cn.srt.bigdata.yygh.hosp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

/**
 * @author shkstart
 * @create 2021-04-25 23:20
 */

@SpringBootApplication
@MapperScan("cn.srt.bigdata.yygh.hosp.mapper")
public class ServiceHospApplication {

    public static void main(String[] args) {

        SpringApplication.run(ServiceHospApplication.class, args);
    }
}
