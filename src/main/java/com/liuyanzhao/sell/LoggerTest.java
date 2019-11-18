package com.liuyanzhao.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Anthor: chen
 * Date: 2019/11/16
 * Time: 13:44
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j//使用注解不用使用变量
public class LoggerTest {

//    private final Logger logger= LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1(){
        log.debug("debug..");
        log.info("info...");
        log.error("error..");
    }
}
