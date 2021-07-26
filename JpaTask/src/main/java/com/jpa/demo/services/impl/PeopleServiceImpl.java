package com.jpa.demo.services.impl;

import com.jpa.demo.dao.PeopleDao;
import com.jpa.demo.pojo.People;
import com.jpa.demo.services.PeopleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @Topic
 * @Date 2021/07/22 11:22
 */

@Service
public class PeopleServiceImpl implements PeopleService {


    @Resource
    PeopleDao peopleDao;

    @Override
    public People selectById(Integer id) {
        People people = peopleDao.getById(id);
        return people;
    }

    @Override
    public List<People> selectAll() {
        return (List<People>) peopleDao.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        peopleDao.deleteById(id);
    }

    @Override
    public void update(People people) {

        peopleDao.save(people);
    }

    @Override
    public void addNew(People people) {
        peopleDao.save(people);
    }
}
