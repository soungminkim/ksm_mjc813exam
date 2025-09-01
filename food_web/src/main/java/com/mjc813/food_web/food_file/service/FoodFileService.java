package com.mjc813.food_web.food_file.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodFileService {
    @Autowired
    private FoodFileRepository foodFileRepository;
}
