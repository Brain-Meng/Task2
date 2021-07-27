package com.jpa.demo.services;

import com.jpa.demo.pojo.People;

import java.util.List;
import java.util.Optional;

/**
 * @Topic
 * @Date 2021/07/22 11:22
 */
public interface PeopleService {
    /**
     * 根据id查询
     * @param id
     * @return People
     */
    People selectById(Integer id);

    /**
     * 查询所有的信息
     * @return  List
     */
    List<People> selectAll();

    /**
     * 根据id进行删除
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 更新信息
     * @param people
     */
    void update(People people);

    /**
     * 添加新人
     * @param people
     */
    void addNew(People people);


}
