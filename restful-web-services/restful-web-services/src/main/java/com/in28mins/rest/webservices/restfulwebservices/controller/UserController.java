package com.in28mins.rest.webservices.restfulwebservices.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28mins.rest.webservices.restfulwebservices.bean.User;
import com.in28mins.rest.webservices.restfulwebservices.exception.USerNotFoundException;
import com.in28mins.rest.webservices.restfulwebservices.service.UserDaoService;

/*
 * we need to add dependency and from postman pass accept as xml to receive the response in xml in postman
 */
@RestController
public class UserController {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private UserDaoService daoService;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return daoService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable("id") Integer id) {
		User user = daoService.findone(id);
		
		if(user == null) {
			throw new USerNotFoundException("user with id:" + id + " is not found");
		}
		
		//HATEOAS implementation
		EntityModel<User> model = EntityModel.of(user);
		
		WebMvcLinkBuilder linktousers = 
				linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		model.add(linktousers.withRel("all-users"));
		return model;
	}
	
	//validation of incoming parameters
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = daoService.save(user);
		
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedUser.getId()).toUri();
		
		//location will be returned in header
		return ResponseEntity.created(location).build();
	}
	
	//we need to pass accept-language as header while calling this endpoint and value should be like en, fr etc
	@GetMapping("/hello-world-international")
	public String helloworldinternationalized(
			//@RequestHeader(name = "Accept-Language", required = false) Locale locale
			) {
		return messageSource.getMessage(
				"good.morning.message", 
				null,
				"Default Message", 
				//locale
				LocaleContextHolder.getLocale());
	}
	
	
}
