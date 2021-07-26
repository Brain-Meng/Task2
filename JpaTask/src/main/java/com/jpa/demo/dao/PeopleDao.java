package com.jpa.demo.dao;

import com.jpa.demo.pojo.People;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Topic
 * @Date 2021/07/21 17:16
 */
public interface PeopleDao extends JpaRepository<People,Integer> {

}
