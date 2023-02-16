package com.m2i.HelloWorld.console;

import com.m2i.HelloWorld.controller.AnnonceController;

public class Main {
	
	public static void main(String[] args) {

		System.out.println(AnnonceController.getAll());
		System.out.println(AnnonceController.getById(1));
		
	}

}
