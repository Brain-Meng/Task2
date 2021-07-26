package com.jpa.demo.services;

import com.jpa.demo.pojo.People;

import java.util.List;
import java.util.Optional;

/**
 * @Topic
 * @Date 2021/07/22 11:22
 */
public interface PeopleService {

    People selectById(Integer id);


    List<People> selectAll();


    void deleteById(Integer id);


    void update(People people);


    void addNew(People people);


}
