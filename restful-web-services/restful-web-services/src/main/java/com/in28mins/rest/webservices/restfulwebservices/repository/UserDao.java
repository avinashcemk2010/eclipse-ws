package com.in28mins.rest.webservices.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28mins.rest.webservices.restfulwebservices.bean.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

}
