package com.madeToEngage.techTest;

import com.madeToEngage.techTest.model.ItemRepository;
import com.madeToEngage.techTest.model.Items;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;


@Component
class Initializer implements CommandLineRunner {

    private final ItemRepository repository;

    public Initializer(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {
        Stream.of("Leather Jacket",
        		"Blue T-shirts", 
        		"Black Jeans",
                "Brown Shoes",
                "Blue Jeans",
				"Black Shoes",
				"Trainers",
				"Parka Jacket",
				"Bed Slippers",
				"Pink T-shirt",
				"Yellow T-shirt",
				"Red T-shirt").forEach(name ->
                repository.save(new Items(name))
        );
         
        
        addItemToRepo("Leather Jacket","Coats & Jackets", 54.99, 6);
        addItemToRepo("Blue T-shirts", "T-shirts", 8, 11);
        addItemToRepo("Black Jeans", "Jeans", 32.99, 8);
        addItemToRepo("Brown Shoes", "Shoes", 29.99, 7);
        addItemToRepo("Blue Jeans", "Jeans", 32.99, 2);
        addItemToRepo("Black Shoes", "Shoes", 25, 10);
        addItemToRepo("Trainers", "Shoes", 38.99, 9);
        addItemToRepo("Parka Jacket", "Coats & Jackets", 49.99, 8);
        addItemToRepo("Bed Slippers", "Shoes", 9.99, 20);
        addItemToRepo("Pink T-shirt", "T-shirts", 8, 5);
        addItemToRepo("Yellow T-shirt", "T-shirts", 8, 6);
        addItemToRepo("Red T-shirt", "T-shirts", 8, 6);

        repository.findAll().forEach(System.out::println);
    }
    
    public  void addItemToRepo(String name, String category, 
    		double d, int quantity) {
    	Items itemRepos = repository.findByName(name);
        itemRepos.setProductCategory(category);
        itemRepos.setProductPrice(d);
        itemRepos.setProductStock(quantity);
        repository.save(itemRepos);
    }
}