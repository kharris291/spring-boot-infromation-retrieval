package com.madeToEngage.techTest.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Items, Long> {
    Items findByName(String name);
}