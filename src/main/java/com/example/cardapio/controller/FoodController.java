package com.example.cardapio.controller;

import com.example.cardapio.food.Food;
import com.example.cardapio.food.FoodRepository;
import com.example.cardapio.food.FoodRequestDTO;
import com.example.cardapio.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@RestController
@RequestMapping("food")
public class FoodController {


    @Autowired
    private FoodRepository repository;

    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data) {
        Food foodData = new Food(data);
        repository.save(data);
        return;
    }

    @GetMapping
    public List<FoodResponseDTO> getAll(){


        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
}
}
