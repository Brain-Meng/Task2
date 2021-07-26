package com.jpa.demo;

import com.jpa.demo.dao.PeopleDao;
import com.jpa.demo.pojo.People;
import com.jpa.demo.services.PeopleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    PeopleDao peopleDao;

    @Autowired
    PeopleService peopleService;

    @Test
    void contextLoads() {
    }


    @Test
    void getTest(){
        People people = new People();
        people.setPeople_name("铁山靠");
        people.setPeople_sex("男");
        people.setPeople_age(32);
        people.setPeople_subject("靠子成功学");
        People save = peopleDao.save(people);

        System.out.println(save);
    }



    @Test
    void serviceTest(){
        List<People> people = peopleService.selectAll();
        System.out.println(people);

    }
}
