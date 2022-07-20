package com.in28mins.rest.webservices.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28mins.rest.webservices.restfulwebservices.bean.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
