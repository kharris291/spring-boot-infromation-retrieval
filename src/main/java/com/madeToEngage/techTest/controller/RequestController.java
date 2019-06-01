package com.madeToEngage.techTest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

import com.madeToEngage.techTest.model.*;

@RestController
@RequestMapping("/api")
class RequestController {
	private ItemRepository itemRepo;
	
    public RequestController(ItemRepository itemRepo) {
        this.itemRepo = itemRepo;
    }

    @GetMapping("/items")
    @CrossOrigin(origins = "http://localhost:3000")
    Collection<Items> items() {
        return itemRepo.findAll();
    }
}