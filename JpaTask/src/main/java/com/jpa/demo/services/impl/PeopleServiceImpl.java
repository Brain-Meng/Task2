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

    /**
     * 想service层中注入PeopleDao
     */
    @Resource
    PeopleDao peopleDao;

    /**
     * 根据id查询
     * @param id
     * @return People
     */
    @Override
    public People selectById(Integer id) {
        People people = peopleDao.getById(id);
        return people;
    }
    /**
     * 查询所有的信息
     * @return  List
     */
    @Override
    public List<People> selectAll() {
        return (List<People>) peopleDao.findAll();
    }
    /**
     * 根据id进行删除
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        peopleDao.deleteById(id);
    }
    /**
     * 更新信息
     * @param people
     */
    @Override
    public void update(People people) {

        peopleDao.save(people);
    }
    /**
     * 添加新人
     * @param people
     */
    @Override
    public void addNew(People people) {
        peopleDao.save(people);
    }
}
