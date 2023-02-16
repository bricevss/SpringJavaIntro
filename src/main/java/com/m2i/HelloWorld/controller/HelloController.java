package com.m2i.HelloWorld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.HelloWorld.entity.Player;

@RestController
public class HelloController {
	
	@GetMapping("/all")
	public String Hello() {
		return "Hello";
	}
	
	@GetMapping("/rqparam")
	public String id(@RequestParam ("id") int id) {
		System.out.println(id);
		return "Request Param : " + id;
	}
	
	@GetMapping("/path/{id}")
	public String getById(@PathVariable int id) {
		System.out.println(id);
		return "Path Variable : " + id;
	}
	
	@GetMapping("/body")
	public String bodyVar(@RequestBody int id) {
		System.out.println(id);
		return "Request Body : " + id;
	}
	
	@GetMapping("/getPlayer")
	public Player fakePlayer() {
		return new Player("MVL", 3150);
	}
	
	@PostMapping("/postPlayer")
	public void addPlayer(@RequestBody Player p) {
		System.out.println(p);
	}

}
