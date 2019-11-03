package com.anandnkhl.blog_rest_API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.anandnkhl.blog_rest_API.entity.User;

@RepositoryRestResource(exported = false)
public interface UserRepository extends JpaRepository<User, String> {

}