package com.anandnkhl.blog_rest_API.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anandnkhl.blog_rest_API.entity.User;
import com.anandnkhl.blog_rest_API.repository.UserRepository;

import javassist.tools.web.BadHttpRequest; 

@RestController
@RequestMapping(path = "/users")
public class UserController {
	 	@Autowired
	    private UserRepository repository;

	    @GetMapping
	    public Iterable<User> findAll() {
	        return repository.findAll();
	    }

	    @GetMapping(path = "/{username}")
	    public User find(@PathVariable("username") String username) {
	        return repository.findOne(username);
	    }

	    @PostMapping(consumes = "application/json")
	    public User create(@RequestBody User user) {
	        return repository.save(user);
	    }

	    @DeleteMapping(path = "/{username}/{password}")
	    public void delete(@PathVariable("username") String username, @PathVariable("password") String password) throws BadHttpRequest {
	    	if(repository.exists(username)) {
	    		User usr = new User();
	    		usr = repository.findOne(username);
	    		if(usr.givePassword().toString().equals(password)) {
	    			repository.delete(username);
	    		}
	    		else {
	    			 throw new BadHttpRequest();
	    		}
	    	} else {
	    		throw new BadHttpRequest();
	    	}
	        
	    }
	    
	    @PutMapping(path = "/{username}/{password}")
	    public User update(@PathVariable("username") String username,@PathVariable("password") String password, @RequestBody User user) throws BadHttpRequest {
	    	if(repository.exists(username)) {
	    		User usr = new User();
	    		usr = repository.findOne(username);
	    		if(usr.givePassword().toString().equals(password)) {
	    			return repository.save(user);
	    		}
	    		else {
	    			 throw new BadHttpRequest();
	    		}
	    	} else {
	    		throw new BadHttpRequest();
	    	}
	    }
}
