package com.xindong.springboottestfor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.xindong.springboottestfor.bean.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTestforApplicationTests {

    @Autowired
    Person person;

    @Test
    public void contextLoads() {
        System.out.println(person);

    }

}
